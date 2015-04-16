package co.frakasoft.oraesb.db.client;

import co.frakasoft.oraesb.beans.util.BasicESBEntityInfo;
import co.frakasoft.oraesb.beans.util.BasicESBInstanceInfo;
import co.frakasoft.oraesb.beans.util.BasicESBOperationInstanceInfo;
import co.frakasoft.oraesb.beans.util.BasicMetadataInfo;
import co.frakasoft.oraesb.beans.util.BasicOperationInfo;
import co.frakasoft.oraesb.beans.util.BasicServiceGroupInfo;
import co.frakasoft.oraesb.beans.util.BasicServiceInfo;
import co.frakasoft.oraesb.beans.util.BasicSystemInfo;
import co.frakasoft.oraesb.beans.util.ESBUtil;
import co.frakasoft.oraesb.beans.util.OperationState;
import co.frakasoft.oraesb.util.comparators.BasicESBInstanceTimestampComparator;
import co.frakasoft.oraesb.util.comparators.BasicESBOperationInstanceTimestampComparator;
import co.frakasoft.util.TimeUtils;
import co.frakasoft.util.beans.XYPair;
import co.frakasoft.util.beans.DailyTimeSerieValue;
import co.frakasoft.util.beans.HourlyTimeSerieValue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;

/**
 *
 * @author esalaza
 */
public class ESBDBClient {

    static Logger logger = Logger.getLogger(ESBDBClient.class);
    
    public static final int ANY_STATUS = 0; // Incluye que la operacion no se haya ejecutado, aunque sea parte del flujo
    public static final int ERROR_STATUS = 1;
    public static final int FAULTED_STATUS = 2;
    public static final int RESUBMITABLE_STATUS = 3;
    public static final int OK_STATUS = 4;
    public static final int NOT_EXECUTED_OPERATION_STATUS = 5;
    public static final int EXECUTED_OPERATION_STATUS = 6;

    private String dbhost;
    private int dbport;
    private String database;
    private String user;
    private String pass;

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private PreparedStatement pstmt = null;

    private ESBDBClientSQL esbDBClientSQL = null;

    public ESBDBClient(String dbhost, int dbport, String database, String user, String password) throws Exception {
        this.dbhost = dbhost;
        this.dbport = dbport;
        this.database = database;
        this.user = user;
        this.pass = password;
        connect();
        esbDBClientSQL = new ESBDBClientSQL();
        esbDBClientSQL.setConnection(conn);
    }

    public void connect() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@" + dbhost + ":" + dbport + ":" + database, user, pass);
    }

    public void disconnect() throws Exception {
        conn.close();
    }

    public String getServiceGUIDByServiceName(String serviceName) throws Exception {
        logger.debug("getServiceGUIDByServiceName: " + serviceName);
        String guid = "";
        String sql = "Select GUID from oraesb.WF_EVENTS where NAME=? and TYPE='GROUP'";
        logger.debug(sql);
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, serviceName);
        rs = pstmt.executeQuery();
        rs.next();
        guid = rs.getString("GUID");
        return guid;
    }
    
    public ArrayList getOperationsGUIDsForService(String serviceGUID) throws SQLException {
        logger.debug("getOperationsGUIDsForService: " + serviceGUID);
        ArrayList<String> operationGUIDs = new ArrayList<String>();
        String sql = "select GUID from oraesb.WF_EVENTS where owner_guid=?";
        logger.debug(sql);
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, serviceGUID);
        rs = pstmt.executeQuery();
        while(rs.next()) {
            operationGUIDs.add(rs.getString("GUID"));
        }
        return operationGUIDs;
    }

    public int getInstanceCount(String serviceName, String startDate, String endDate) throws Exception {
        logger.debug("getInstanceCount: " + serviceName + ", " + startDate + ", " + endDate);
        int count = 0;
        long sd = TimeUtils.getTime(startDate);
        long ed = TimeUtils.getTime(endDate);
        String guid = getServiceGUIDByServiceName(serviceName);
        String sql =
                "SELECT COUNT(*) AS COUNT FROM (SELECT FLOW_ID, MIN(TIMESTAMP) FROM (" + "\n" +
                "SELECT FLOW_ID, TIMESTAMP " + "\n" +
                "FROM oraesb.ESB_ACTIVITY B " + "\n" +
                "WHERE TIMESTAMP>=? " + "\n" +
                "AND TIMESTAMP<=? " + "\n" +
                "AND (( SOURCE IN (?) OR OPERATION_GUID IN (?))) " + "\n" +
                "AND IS_STALE IS NULL " + "\n" +
                "ORDER BY TIMESTAMP DESC" + "\n" +
                ") " + "\n" +
                "GROUP BY FLOW_ID " + "\n" +
                "ORDER BY MIN(TIMESTAMP) DESC)";
        logger.debug(sql);
        pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, sd);
        pstmt.setLong(2, ed);
        pstmt.setString(3, guid);
        pstmt.setString(4, guid);
        rs = pstmt.executeQuery();
        rs.next();
        count = rs.getInt("COUNT");
        return count;
    }

    public ArrayList<XYPair> getInstanceCountReport(Date startDate, Date endDate) throws Exception {
        logger.debug("getInstanceCountReport: " + startDate + ", " + endDate);
        ArrayList<XYPair> result = new ArrayList<XYPair>();
        long sd = startDate.getTime();
        long ed = endDate.getTime();
        String sql =
                    "select " + "\n" +
                        "NAME AS SERVICE_NAME, OPERATION_NAME, count(*) AS NUM_INSTANCIAS " + "\n" +
                    "from ( " + "\n" +
                        "select " + "\n" +
                            "OPERATION_NAME, wf_events.OWNER_GUID AS OWNER " + "\n" +
                        "from ( " + "\n" +
                            "select " + "\n" +
                                "esb_activity.operation_guid AS OPERATION, " + "\n" +
                                "wf_events.name AS OPERATION_NAME " + "\n" +
                            "from " + "\n" +
                                "esb_activity, wf_events " + "\n" +
                            "where " + "\n" +
                                "esb_activity.operation_guid = wf_events.guid " + "\n" +
                                "and TIMESTAMP >= ? " + "\n" +
                                "and TIMESTAMP <= ? " + "\n" +
                            "group by " + "\n" +
                                "esb_activity.operation_guid, wf_events.name, esb_activity.flow_id " + "\n" +
                            "), wf_events " + "\n" +
                        "where " + "\n" +
                            "OPERATION = wf_events.GUID " + "\n" +
                        "), wf_events " + "\n" +
                    "where " + "\n" +
                        "OWNER = GUID " + "\n" +
                    "group by " + "\n" +
                        "NAME, OPERATION_NAME " + "\n" +
                    "order by " + "\n" +
                        "NUM_INSTANCIAS DESC";
        logger.debug(sql);
        pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, sd);
        pstmt.setLong(2, ed);
        rs = pstmt.executeQuery();
        int count = 0;
        while (rs.next()) {
            if(count++ > 20) break;
            XYPair xy = new XYPair();
            String category = rs.getString("SERVICE_NAME") + "." + rs.getString("OPERATION_NAME");
            String value = rs.getString("NUM_INSTANCIAS");
            xy.setX(category);
            xy.setY(value);
            result.add(xy);
        }
        return result;
    }

    /**
     *
     * Me tocó quitarle el ‘AND IS_STALE IS NULL’ porque tengo casos en los que al
     * reenviar errores, aunque los datos siguen quedando ok en la base de datos,
     * las actividades de los flujos reenviados que antes emparejaban en la consulta,
     * después de reenviarlos quedan como IS_STALE = ‘Y’ y no estaba quedando en el
     * resultado.
     *
     * Y me toco ponerle 'and source_name IS NULL' porque 
     * por cada falta en un flujo, aparecen dos registros en ESB_FAULTED_INSTANCE,
     * uno con TYPE = 6 y SOURCE NULL y otro con TYPE = 13 y SOURCE no NULL.
     *
     * :-(
     *
     *
        select
            exception
        from
            esb_faulted_instance, esb_activity
        where
            esb_faulted_instance.activity_id = esb_activity.id
            and esb_activity.type in (14,12,13,6,2)
            and esb_activity.is_stale is NULL
            and esb_activity.timestamp >= ?
            and esb_activity.timestamp <= ? ;
     *
     */
    public ArrayList<XYPair> getErrorsTypeReport(Date startDate, Date endDate) throws Exception {
        logger.debug("getErrorsTypeReport: " + startDate + ", " + endDate);
        ArrayList<XYPair> result = new ArrayList<XYPair>();
        long sd = startDate.getTime();
        long ed = endDate.getTime();

        String sql = "select" + "\n" +
                     "exception" + "\n" +
                     "from" + "\n" +
                     "esb_faulted_instance, esb_activity" + "\n" +
                     "where" + "\n" +
                     "esb_faulted_instance.activity_id = esb_activity.id" + "\n" +
                     "and esb_activity.type in (14,12,13,6,2)" + "\n" +
                     "/*and esb_activity.is_stale is NULL*/" + "\n" +
                     "and esb_activity.timestamp >= ? " + "\n" +
                     "and esb_activity.timestamp <= ? " + "\n" +
                     "and source_name IS NULL /* CUIDADO, VALIDAR DE NUEVO*/";
        logger.debug(sql);
        pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, sd);
        pstmt.setLong(2, ed);
        rs = pstmt.executeQuery();

        // TODO: Prueba de concepto. Mejorar mucho!
        HashMap<String, Integer> memory = new HashMap<String, Integer>();

        result: while (rs.next()) {
            String line = rs.getString(1);
            line = ESBUtil.resumeESBException(line);
            if(!memory.containsKey(line)) {
                memory.put(line, 1);
            } else {
                memory.put(line, memory.get(line) + 1);
            }
        }
        Set keySet = memory.keySet();

        for(Object o : keySet) {
            String s = (String)o;

            XYPair xy = new XYPair();
            String category = s;
            String value = memory.get(o).toString();
            if (Integer.parseInt(value) > 2) {
                xy.setX(category);
                xy.setY(value);
                result.add(xy);
            }
            System.out.println(xy);
        }

        return result;
    }

    public ArrayList<HourlyTimeSerieValue> hourlyOperationInstanceFromSummaryReport(String serviceName, String operationName, Date startDate, Date endDate) throws Exception {
        logger.debug("hourlyOperationInstanceFromSummaryReport: " + serviceName + ", " + operationName + ", " + startDate + ", " + endDate);
        ArrayList<HourlyTimeSerieValue> result = new ArrayList<HourlyTimeSerieValue>();
        return result;
    }
    
    // Aqui esta solo poer servicio. Tambien se puede/debe hacer por operacion
    // Opcion -> Instancias por dia para servicio
    public ArrayList<DailyTimeSerieValue> dailyServiceInstanceReport(String serviceName, Date startDate, Date endDate) throws Exception {
        logger.debug("dailyServiceInstanceReport: " + serviceName + ", " + startDate + ", " + endDate);
        ArrayList<DailyTimeSerieValue> result = new ArrayList<DailyTimeSerieValue>();
        long sd = startDate.getTime();
        long ed = endDate.getTime();
        String sql =
                "select " + "\n" +
                "service.name  AS Servicio, " + "\n" +
                "to_char(TO_DATE('01/01/1970','MM/DD/YYYY') + (TIMESTAMP / (24*60*60*1000) - 5/24), 'yyyy/mm/dd') as fecha,  " + "\n" +
                "count(distinct esb_activity.flow_id) as cantidad, " + "\n" +
                "max(id) " + "\n" +
                "from  " + "\n" +
                "esb_activity inner join wf_events operation on (esb_activity.operation_guid = operation.guid) " + "\n" +
                "inner join wf_events service on (operation.OWNER_GUID = service.GUID) " + "\n" +
                "where " + "\n" +
                "timestamp >= ? " + "\n" +
                "and timestamp <= ? " + "\n" +
                "and service.name = ? " + "\n" +
                "group by  " + "\n" +
                "service.name,  " + "\n" +
                "to_char(TO_DATE('01/01/1970','MM/DD/YYYY') + (TIMESTAMP / (24*60*60*1000) - 5/24), 'yyyy/mm/dd')";
        logger.debug(sql);
        pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, sd);
        pstmt.setLong(2, ed);
        pstmt.setString(3, serviceName);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            DailyTimeSerieValue value = new DailyTimeSerieValue();
            String[] dateParts = rs.getString(2).split("/");
            value.setDay(Integer.parseInt(dateParts[2]));
            value.setMonth(Integer.parseInt(dateParts[1]));
            value.setYear(Integer.parseInt(dateParts[0]));
            value.setValue(Float.parseFloat(rs.getString(3)));
            result.add(value);
        }
        return result;
    }

    // TO-DO: hacer configurable el TIMEZONE!!! (5/4)
    // Aqui esta solo poer servicio. Tambien se puede/debe hacer por operacion
    public ArrayList<DailyTimeSerieValue> dailyServiceOKInstanceReport(String serviceName, Date startDate, Date endDate) throws Exception {
        logger.debug("dailyServiceOKInstanceReport: " + serviceName + ", " + startDate + ", " + endDate);
        ArrayList<DailyTimeSerieValue> result = new ArrayList<DailyTimeSerieValue>();
        long sd = startDate.getTime();
        long ed = endDate.getTime();
        String sql =
                "select " + "\n" +
                "service.name  AS Servicio, " + "\n" +
                "to_char(TO_DATE('01/01/1970','MM/DD/YYYY') + (TIMESTAMP / (24*60*60*1000) - 5/24), 'yyyy/mm/dd') as fecha,  " + "\n" +
                "count(distinct esb_activity.flow_id) as cantidad, " + "\n" +
                "max(id) " + "\n" +
                "from  " + "\n" +
                "esb_activity inner join wf_events operation on (esb_activity.operation_guid = operation.guid) " + "\n" +
                "inner join wf_events service on (operation.OWNER_GUID = service.GUID) " + "\n" +
                "where " + "\n" +
                "timestamp >= ? " + "\n" +
                "and timestamp <= ? " + "\n" +
                "and service.name = ? " + "\n" +
                "group by  " + "\n" +
                "service.name,  " + "\n" +
                "to_char(TO_DATE('01/01/1970','MM/DD/YYYY') + (TIMESTAMP / (24*60*60*1000) - 5/24), 'yyyy/mm/dd')";
        logger.debug(sql);
        pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, sd);
        pstmt.setLong(2, ed);
        pstmt.setString(3, serviceName);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            DailyTimeSerieValue value = new DailyTimeSerieValue();
            String[] dateParts = rs.getString(2).split("/");
            value.setDay(Integer.parseInt(dateParts[2]));
            value.setMonth(Integer.parseInt(dateParts[1]));
            value.setYear(Integer.parseInt(dateParts[0]));
            value.setValue(Float.parseFloat(rs.getString(3)));
            result.add(value);
        }
        return result;
    }

    public ArrayList<DailyTimeSerieValue> dailyOperationInstanceReport(String operationGuid, OperationState status, Date startDate, Date endDate) throws Exception {
        logger.debug("dailyOperationInstanceReport: " + operationGuid + ", " + status + ", " + startDate + ", " + endDate);

        ArrayList<DailyTimeSerieValue> result = new ArrayList<DailyTimeSerieValue>();
        List<BasicESBOperationInstanceInfo> operationInstances = getOperationInstances(operationGuid, startDate, endDate);
        
        if(status != null && !status.equals(OperationState.ANY)) {
            operationInstances = ESBUtil.getOperationsByState(operationInstances, EnumSet.of(status), null);
        }

        int previousDay = -1;
        for(BasicESBOperationInstanceInfo instance : operationInstances) {
            //int actualDay = new GregorianCalendar
            
        }

        
        while (rs.next()) {
            DailyTimeSerieValue value = new DailyTimeSerieValue();
            String[] dateParts = rs.getString(2).split("/");
            value.setDay(Integer.parseInt(dateParts[2]));
            value.setMonth(Integer.parseInt(dateParts[1]));
            value.setYear(Integer.parseInt(dateParts[0]));
            value.setValue(Float.parseFloat(rs.getString(3)));
            result.add(value);
        }
        return result;
    }

    /**
     * 
     * Con esta consulta se obtiene una lista de identificadores de instancia
     * de flujo (flow_id) que cumplen con las condiciones dadas. Esto se traduce 
     * como una consulta sobre la tabla ESB_ACTIVITY del esquema de ORAESB. En 
     * esta tabla existe un registro por cada operacion que hace parte de una 
     * instancia de flujo. Es decir, en esta tabla se encuentran varios 
     * registros por cada instancia de flujo, todos con el mismo flow_id y cada 
     * uno representando un determinado "paso" del flujo. Los parametros 
     * serviceName y status entonces no tienen que corresponder con todos los 
     * "pasos" de un flujo, sino con cualquiera de ellos, es decir con 
     * cualquiera de los registros de ESB_ACTIVITY que corresponden con un 
     * flujo. Cuando alguno de estas condiciones empareja con un registro, 
     * entonces por transitividad termina emparejando con "todo el flujo".
     *
     * UPDATE: mirar UPDATE de la otra getInstances.
     * 
     * Consulta SQL:
     * 
     * SELECT FLOW_ID, MIN(TIMESTAMP) AS TIME FROM (
     *  SELECT FLOW_ID, TIMESTAMP 
     *  FROM oraesb.ESB_ACTIVITY B 
     *  WHERE 
     *  	TIMESTAMP>=? 
     *  	AND TIMESTAMP<=? 
     *  	AND TYPE IN(X, X, X)
     *  	AND (( SOURCE IN (?) OR OPERATION_GUID IN (?)))
     *  	AND IS_STALE IS NULL
     *  ORDER BY TIMESTAMP DESC
     *  )
     *  GROUP BY FLOW_ID
     *  ORDER BY MIN(TIMESTAMP) DESC
     * 
     * @param serviceName
     * @param status
     * @param startDate
     * @param endDate
     * @return
     * @throws java.lang.Exception
     */
    public List<BasicESBInstanceInfo> getInstances(String serviceName, int status, Date startDate, Date endDate) throws Exception {
        logger.debug("getInstances: " + serviceName + ", " + startDate + ", " + endDate);
        List<BasicESBInstanceInfo> instances = new ArrayList<BasicESBInstanceInfo>();
        String serviceGuid   = "";
        String operationGuid = "";
        String statusString  = "";
        boolean isFirstConditionInWhere = true;
        
        switch (status) {
            case ANY_STATUS:
                // nothing
                break;
            case ERROR_STATUS:
                statusString = "TYPE IN (6,13,12,14,2)";
                break;
            case FAULTED_STATUS:
                statusString = "TYPE IN (5,11)";
                break;
            case RESUBMITABLE_STATUS:
                statusString = "TYPE=13";
                break;
        }

        // Ojo, solo busca de la primera operacion, debe buscar por todas!
        if (serviceName != null && !serviceName.equals("")) {
            serviceGuid = getServiceGUIDByServiceName(serviceName);
            ArrayList<String> operationsGuids = getOperationsGUIDsForService(serviceGuid);
            if(operationsGuids != null && operationsGuids.size() != 0) {
                // OJO!!! Como hace el ESB cuando son varias operaciones? :-S
                operationGuid = operationsGuids.get(0);
            } else {
                serviceName = null;
            }
        }
        
        String sql =
                "SELECT FLOW_ID, MIN(TIMESTAMP) AS TIME FROM (" + "\n" +
                "SELECT FLOW_ID, TIMESTAMP " + "\n" +
                "FROM oraesb.ESB_ACTIVITY B " + "\n" + 
                "WHERE "  + "\n";
        if (startDate != null) {
            sql += " TIMESTAMP>=? " + "\n";
            isFirstConditionInWhere = false;
        }
        if(endDate != null) {
            if(isFirstConditionInWhere) sql += "TIMESTAMP<=? " + "\n";
            else sql += "AND TIMESTAMP<=? " + "\n";
            isFirstConditionInWhere = false;
        }
        if (!statusString.equals("")) {
            if(isFirstConditionInWhere) sql += statusString + " \n";
            else sql += "AND " + statusString + " \n";
            isFirstConditionInWhere = false;
        }
        // Parece que lo que debe ir en SOURCE no es el operationGuid que estoy usando en OPERATION_GUID!!! :-S
        if (serviceName != null && !serviceName.equals("")) {
            if(isFirstConditionInWhere) sql += "(( SOURCE IN (?) OR OPERATION_GUID IN (?))) " + "\n";
            else sql += "AND (( SOURCE IN (?) OR OPERATION_GUID IN (?))) " + "\n";
            isFirstConditionInWhere = false;
        }
        if(isFirstConditionInWhere) {
            sql += "IS_STALE IS NULL " + "\n";
        } else {
            sql += "AND IS_STALE IS NULL " + "\n";
        }
        sql += "ORDER BY TIMESTAMP DESC" + "\n" +
                ") " + "\n" +
                "GROUP BY FLOW_ID " + "\n" +
                "ORDER BY MIN(TIMESTAMP) DESC";

        logger.debug(sql);
        int index = 1;
        
        pstmt = conn.prepareStatement(sql);
        if (startDate != null) {
            pstmt.setLong(index++, startDate.getTime());
        }
        if(endDate != null) {
            pstmt.setLong(index++, endDate.getTime());
        }
        if (serviceName != null && !serviceName.equals("")) {
            pstmt.setString(index++, operationGuid);
            pstmt.setString(index++, operationGuid);
        }
        
        rs = pstmt.executeQuery();
        while (rs.next()) {
            // Este timestamp inicial esta mal!, porque es el de la primera invocacion de la operacion
            // buscada y no del flujo completo
            // instances.add(new BasicESBInstanceInfo(rs.getString("FLOW_ID"), rs.getLong("TIME")));
            instances.add(new BasicESBInstanceInfo(rs.getString("FLOW_ID")));
        }
        return instances;
    }

    public List<BasicESBInstanceInfo> getInstances(String[] operationsGuids, int status, Date startDate, Date endDate) throws Exception {
        logger.debug("getInstances: " + operationsGuids + ", " + status + ", " + startDate + ", " + endDate);
        List<BasicESBInstanceInfo> instances = new ArrayList<BasicESBInstanceInfo>();
        String statusString  = "";
        String operationsGuidsString = "";
        boolean isFirstConditionInWhere = true;

        switch (status) {
            case ANY_STATUS:
                // nothing
                break;
            case ERROR_STATUS:
                statusString = "TYPE IN (2,6,12,13,14)";
                break;
            case FAULTED_STATUS:
                statusString = "TYPE IN (5,11)";
                break;
            case RESUBMITABLE_STATUS:
                statusString = "TYPE=13";
                break;
            case OK_STATUS:
                statusString = "TYPE IN (4,10)";
                break;
            case NOT_EXECUTED_OPERATION_STATUS:
                statusString = "TYPE IN (8)";
                break;
            case EXECUTED_OPERATION_STATUS:
                statusString = "TYPE NOT IN (8)";
                break;
        }

        String sql =
                "SELECT FLOW_ID, MIN(TIMESTAMP) AS TIME FROM (" + "\n" +
                "SELECT FLOW_ID, TIMESTAMP " + "\n" +
                "FROM oraesb.ESB_ACTIVITY B " + "\n" +
                "WHERE "  + "\n";
        if (startDate != null) {
            sql += " TIMESTAMP>=? " + "\n";
            isFirstConditionInWhere = false;
        }
        if(endDate != null) {
            if(isFirstConditionInWhere) sql += "TIMESTAMP<=? " + "\n";
            else sql += "AND TIMESTAMP<=? " + "\n";
            isFirstConditionInWhere = false;
        }
        if (!statusString.equals("")) {
            if(isFirstConditionInWhere) sql += statusString + " \n";
            else sql += "AND " + statusString + " \n";
            isFirstConditionInWhere = false;
        }
        if (operationsGuids != null && operationsGuids.length != 0) {
            for (int i = 0; i < operationsGuids.length; i++) {
                if (i == (operationsGuids.length - 1)) {
                    operationsGuidsString += ("'" + operationsGuids[i] + "'");
                } else {
                    operationsGuidsString += ("'" + operationsGuids[i] + "'" + ",");
                }
            }
            if (isFirstConditionInWhere) {
                sql += "OPERATION_GUID IN (" + operationsGuidsString + ") " + "\n";
                isFirstConditionInWhere = false;
            } else {
                sql += "AND OPERATION_GUID IN (" + operationsGuidsString + ") " + "\n";
                isFirstConditionInWhere = false;
            }
        }
        if(isFirstConditionInWhere) {
            sql += "IS_STALE IS NULL " + "\n";
        } else {
            sql += "AND IS_STALE IS NULL " + "\n";
        }
        sql += "ORDER BY TIMESTAMP DESC" + "\n" +
                ") " + "\n" +
                "GROUP BY FLOW_ID " + "\n" +
                "ORDER BY MIN(TIMESTAMP) DESC";

        System.out.println("SQL = \n" + sql);
        logger.debug(sql);
        int index = 1;

        pstmt = conn.prepareStatement(sql);
        if (startDate != null) {
            pstmt.setLong(index++, startDate.getTime());
        }
        if(endDate != null) {
            pstmt.setLong(index++, endDate.getTime());
        }

        rs = pstmt.executeQuery();
        while (rs.next()) {
            instances.add(new BasicESBInstanceInfo(rs.getString("FLOW_ID"), rs.getLong("TIME")));
        }
        return instances;

    }

    public List<BasicESBOperationInstanceInfo> getOperationInstances(String operationGuid, Date startDate, Date endDate) throws Exception {
        logger.debug("getOperationInstances: " + operationGuid + ", " + startDate + ", " + endDate);
        
        List<BasicESBOperationInstanceInfo> instances = new ArrayList<BasicESBOperationInstanceInfo>();
        
        ResultSet resultset = esbDBClientSQL.getOperationInstancesResultSet(operationGuid, startDate, endDate);

        // ID, FLOW_ID, TIMESTAMP, TYPE
        String previousFlowid = "";
        BasicESBOperationInstanceInfo operationInstance = null;
        long lastTimestamp = 0;
        
        while (resultset.next()) {
            String flowId    = resultset.getString("FLOW_ID");
            String id        = resultset.getString("ID");
            int    type      = resultset.getInt("TYPE");
            long   timestamp = resultset.getLong("TIMESTAMP");

            if(!flowId.equals(previousFlowid)) {
                previousFlowid = flowId;
                if(operationInstance != null) { // Para el primero :-(
                    operationInstance.setDuration(lastTimestamp - operationInstance.getTimestamp());
                    instances.add(operationInstance);
                }
                operationInstance = new BasicESBOperationInstanceInfo(id, flowId, timestamp);
            }
            operationInstance.addState(type);
            lastTimestamp = timestamp;

        }
        if(!previousFlowid.equals("")) {
            operationInstance.setDuration(lastTimestamp - operationInstance.getTimestamp());
            instances.add(operationInstance);
        }

        // Toco ordenarla asi por ahora!
        Collections.sort(instances, new BasicESBOperationInstanceTimestampComparator());
        return instances;
    }

    public int getErrorInstanceCount(String serviceName, String startDate, String endDate) {
        logger.debug("getErrorInstanceCount: " + serviceName + ", " + startDate + ", " + endDate);
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 
     * Este metodo retorna un conjunto de instancias de "flujos" representados 
     * por BasicESBInstanceInfo que cumplen con las condiciones dadas. Para 
     * status, se marca al flujo como "Con errores" si alguna de sus operaciones 
     * tuvo errores, como "Con faltas" si alguna de sus operaciones tuvo faltas 
     * y como reintentable si las operaciones con error o faltas son 
     * reintentables (creo). Para serviceName, retorna las instancias de flujo 
     * en los cuales se involucro el servicio con nombre "serviceName". 
     * Primero se invoca el metodo getInstances para retornar los flow_ids de 
     * las instancias de flujo cuyos pasos u operaciones emparejan con las 
     * condiciones y en este se obtienen estos flow_ids y se retornan todos los 
     * registros de ESB_ACTIVITY correspondientes a esos flow_id. Se obtienen 
     * ordenados por flow_id para que esten todos los pasos de cada instancia de 
     * flujo seguidos y el metodo pueda realizar la sumarizacion de la 
     * informacion mas facilmente.
     *
     * UPDATE: incluso pueden haber varios registros para cada "operación" del
     * flujo. Esto porque se insertan registros por ejemplo para type = 9, 0,
     * 3, 4 y 10 (antes de ejecutar una regla de enrutamiento, al generar un
     * mensaje, antes de invocar un adaptador, etc...).
     * 
     * SELECT FLOW_ID, \/\*SUB_FLOW_ID, SOURCE, TIMESTAMP, \*\/ TYPE  
     * FROM ESB_ACTIVITY A 
     * WHERE 
     * 	FLOW_ID IN (x1, x2, x3,...xn)
     * 	AND IS_STALE IS NULL
     * ORDER BY FLOW_ID\/\*, SUB_FLOW_ID, SEQ\*\/";
     *
     * TYPE:
     * 0  – A message has been raised
     * 2  – Message has been rejected by the inbound adapter service
     * 3  – An outbound adapter service operation is about to be executed
     * 4  - An outbound adapter service operation has been executed successfully
     * 5  - An outbound adapter service operation has generated a fault message
     * 6  - An outbound adapter service operation has raised an exception
     * 8  – A routing rule did not get executed due to the following reasons:
     *       o Not Acceptable because it was raised on the same system
     *       o Filtered as the filter expression was evaluated to false
     *       o Not executed because the target service is disabled, or the system where the routing rule is to be executed, is disabled
     * 9  – A routing rule is about to be executed
     * 10 – A routing rule has been executed successfully
     *      This activity also ensures that if a response or fault was generated then the following activities were performed:
     *       o The response or fault has been sent to the caller
     *       o The response or fault has been sent to the response handler or the fault handler
     *       o The response has been ignored
     * 11 – A routing rule has generated a fault message
     * 12 – A routing rule has raised an exception
     * 13 – A retryable routing rule has raised an exception
     * 14 – The message raised has failed
     * 15 – The global transaction, in which the message was processed, has been committed
     * 16 – The global transaction has been rolled back due to an error
     * 
     * @param serviceName
     * @param status
     * @param startDate
     * @param endDate
     * @return
     * @throws java.lang.Exception
     */
    public List<BasicESBInstanceInfo> getInstancesWithStatusInfo(
            String serviceName, 
            int status, 
            Date startDate, 
            Date endDate) throws Exception {
        logger.debug("getInstancesWithStatusInfo: " + serviceName + ", " + status + ", " + startDate + ", " + endDate);
        
        List<BasicESBInstanceInfo> instances;
        instances = getInstances(serviceName, status, startDate, endDate);
        
        if(instances == null || instances.size() == 0) return null;

        String commaSeparatesListOfIds = getCommaSeparatedListOfInstanceIds(instances);
        
        String sql =
                "SELECT FLOW_ID, /*SUB_FLOW_ID, SOURCE, TIMESTAMP, */ TYPE, TIMESTAMP " + "\n" +
                "FROM ESB_ACTIVITY A " + "\n" +
                "WHERE FLOW_ID IN (" +
                commaSeparatesListOfIds + ")" + "\n" +
                "AND IS_STALE IS NULL " + "\n" +
                "ORDER BY FLOW_ID/*, SUB_FLOW_ID, SEQ*/, TIMESTAMP ASC";
        logger.debug(sql);
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);

        long maxTimestamp = 0;

        if (rs.next()) {
            String currentFlowId = rs.getString("FLOW_ID");
            BasicESBInstanceInfo instance = getBasicESBInstanceByFlowID(instances, currentFlowId);
            //---
            // El timestamp (de inicio) no venia correcto de getInstances()!!!
            //---
            long initTimestamp = rs.getLong("TIMESTAMP");
            instance.setTimestamp(initTimestamp);
            maxTimestamp = instance.getTimestamp();
            do {
                long currentTimestamp = rs.getLong("TIMESTAMP");
                currentFlowId = rs.getString("FLOW_ID");
                
                if (!currentFlowId.equals(instance.getFlowId())) {
                    // optimizar...
                    long duration = maxTimestamp - instance.getTimestamp();
                    instance.setDuration(duration);
                    instance = getBasicESBInstanceByFlowID(instances, currentFlowId);
                    instance.setTimestamp(currentTimestamp);
                    maxTimestamp = instance.getTimestamp();
                }
                
                if(currentTimestamp > maxTimestamp) maxTimestamp = currentTimestamp;

                int type = rs.getInt("TYPE");
                switch (type) {
                    // Error
                    case 2:
                    case 6:
                    case 12:
                    case 14:
                        instance.setHasErrors(true);
                        break;

                    // RetryableError
                    case 13:
                        instance.setHasErrors(true);
                        instance.setResubmitable(true);
                        break;

                    // Faulted
                    case 5:
                    case 11:
                        instance.setHasFaults(true);
                        break;
                }
            } while (rs.next());
            // Falta procesar el ultimo...esto hay que reescribirlo bien!
            long duration = maxTimestamp - instance.getTimestamp();
            instance.setDuration(duration);
        }
        // Toco ordenarla asi por ahora
        Collections.sort(instances, new BasicESBInstanceTimestampComparator());
        return instances;
    }

        
    /* Combinar con la otra
     */
    public List<BasicESBInstanceInfo> getInstancesWithStatusInfo(
            String[] operationsGuids, 
            int status, 
            Date startDate, 
            Date endDate) throws Exception {
        logger.debug("getInstancesWithStatusInfo: " + operationsGuids + ", " + status + ", " + startDate + ", " + endDate);
        
        List<BasicESBInstanceInfo> instances;
        instances = getInstances(operationsGuids, status, startDate, endDate);
        
        if(instances == null || instances.size() == 0) return null;

        String commaSeparatesListOfIds = getCommaSeparatedListOfInstanceIds(instances);
        
        String sql =
                "SELECT FLOW_ID, ID, TYPE, TIMESTAMP " + "\n" +
                "FROM ESB_ACTIVITY A " + "\n" +
                "WHERE FLOW_ID IN (" +
                commaSeparatesListOfIds + ")" + "\n" +
                "AND IS_STALE IS NULL " + "\n" +
                "ORDER BY FLOW_ID, ID, TIMESTAMP";
        logger.debug(sql);
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);

        long maxTimestamp = 0;

        if (rs.next()) {
            String currentFlowId = rs.getString("FLOW_ID");
            String currentActivityId = rs.getString("ID");
            BasicESBInstanceInfo instance = getBasicESBInstanceByFlowID(instances, currentFlowId);
            maxTimestamp = instance.getTimestamp();
            do {
                long currentTimestamp = rs.getLong("TIMESTAMP");
                currentFlowId = rs.getString("FLOW_ID");
                currentActivityId = rs.getString("ID");
                
                if (!currentFlowId.equals(instance.getFlowId())) {
                    // :-S optimizar...
                    long duration = maxTimestamp - instance.getTimestamp();
                    instance.setDuration(duration);
                    instance = getBasicESBInstanceByFlowID(instances, currentFlowId);
                    maxTimestamp = instance.getTimestamp();
                }
                
                if(currentTimestamp > maxTimestamp) maxTimestamp = currentTimestamp;

                int type = rs.getInt("TYPE");
                switch (type) {
                    // Error
                    case 2:
                    case 6:
                    case 12:
                    case 14:
                        instance.setHasErrors(true);
                        break;

                    // RetryableError
                    case 13:
                        instance.setHasErrors(true);
                        instance.setResubmitable(true);
                        break;

                    // Faulted
                    case 5:
                    case 11:
                        instance.setHasFaults(true);
                        break;
                }
            } while (rs.next());
        }
        return instances;
    }

    private String getCommaSeparatedListOfInstanceIds(List<BasicESBInstanceInfo> instances) {
        StringBuilder commaSeparatedList = new StringBuilder();
        for (BasicESBInstanceInfo instance : instances) {
            commaSeparatedList.append("'");
            commaSeparatedList.append(instance.getFlowId());
            commaSeparatedList.append("'");
            commaSeparatedList.append(",");
        }
        commaSeparatedList.delete(commaSeparatedList.length() - 1, commaSeparatedList.length());
        return commaSeparatedList.toString();
    }

    private BasicESBInstanceInfo getBasicESBInstanceByFlowID(List<BasicESBInstanceInfo> instances, String flowId) {
        // :-S
        for (BasicESBInstanceInfo instance : instances) {
            if (instance.getFlowId().equals(flowId)) {
                return instance;
            }
        }
        return null;
    }

    /**
     * El HashMap contiene: guid (clave) - BasicSystemInfo (valor)
     */
    private HashMap<String, BasicSystemInfo> getSystemsMap() throws Exception {
        logger.debug("getSystemsMap");

        HashMap<String, BasicSystemInfo> systems = new HashMap<String, BasicSystemInfo>();

        String sql = "Select GUID, NAME, DESCRIPTION from oraesb.WF_SYSTEMS";
        logger.debug(sql);

        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        while(rs.next()) {
            BasicSystemInfo system = new BasicSystemInfo();
            system.setId(rs.getString("GUID"));
            system.setName(rs.getString("NAME"));
            system.setDescription(rs.getString("DESCRIPTION"));
            systems.put(system.getId(), system);
        }

        return systems;
    }


    // como larguito el metodo...
    public BasicMetadataInfo exploreServices() throws Exception {
        logger.debug("exploreServices");

        BasicMetadataInfo metadata = new BasicMetadataInfo();
        HashMap<String, BasicSystemInfo> systemsMap = getSystemsMap();
        ArrayList<BasicSystemInfo> systemsList = new ArrayList<BasicSystemInfo>();
        HashMap<String, BasicESBEntityInfo> esbEntitiesTable = new HashMap<String, BasicESBEntityInfo>();
        HashMap<String, String> recheckMap = new HashMap<String, String>(); // key -> guid, value -> ownerGuid

        for(BasicSystemInfo system : systemsMap.values()) {
            systemsList.add(system);
        }
        metadata.setSystems(systemsList);

        // Busqueda de Grupos de Servicios, Servicios y Operaciones ------------
        String sql = "Select DISTINCT GUID, NAME, TYPE, DESCRIPTION, SYSTEM_GUID, OWNER_GUID from oraesb.WF_EVENTS order by TYPE desc, name asc";
        logger.debug(sql);
        // order by TYPE desc -> SERVICEGROUP, GROUP, EVENT
        // DISTINCT??? :-( ...si, me encontre casos de registros totalmente duplicados en WF_EVENTS
        
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        while(rs.next()) {
            BasicESBEntityInfo esbEntity = null;
            
            String id = rs.getString("GUID");
            String systemGuid = rs.getString("SYSTEM_GUID");
            String ownerGuid = rs.getString("OWNER_GUID");
            String type = rs.getString("TYPE");

            BasicSystemInfo system = (BasicSystemInfo)systemsMap.get(systemGuid);
            BasicESBEntityInfo owner = esbEntitiesTable.get(ownerGuid);
            
            if ("SERVICEGROUP".equals(type)) {
                // el OWNER_GUID de un SERVICEGROUP puede hacer referencia a otro SERVICEGROUP o ser NULL (no es el guid del system)
                BasicServiceGroupInfo serviceGroup = new BasicServiceGroupInfo();
                esbEntity = serviceGroup;
                esbEntitiesTable.put(id, serviceGroup);
                if(ownerGuid != null && !"".equals(ownerGuid)) {
                    if(owner == null) {
                        recheckMap.put(id, ownerGuid);
                    } else {
                        ((BasicServiceGroupInfo)owner).addServiceGroup(serviceGroup);
                    }
                } else {
                    system.addServiceGroup(serviceGroup);
                }
            } else if ("GROUP".equals(type)) {
                BasicServiceInfo service = new BasicServiceInfo();
                esbEntity = service;
                esbEntitiesTable.put(id, service);
                if(ownerGuid != null && !"".equals(ownerGuid)) {
                    ((BasicServiceGroupInfo)owner).addService(service);
                } else {
                    system.addService(service);
                }
            } else if ("EVENT".equals(type)) {
                BasicOperationInfo operation = new BasicOperationInfo();
                esbEntity = operation;
                esbEntitiesTable.put(id, operation);
                ((BasicServiceInfo)owner).addOperation(operation);
            }

            esbEntity.setName(rs.getString("NAME"));
            esbEntity.setDescription(rs.getString("DESCRIPTION"));
            esbEntity.setId(id);
            esbEntity.setSystem(system);
            esbEntity.setOwner(owner);
        }
        //----------------------------------------------------------------------

        for(String guid : recheckMap.keySet()) {
            String ownerGuid = recheckMap.get(guid);
            BasicServiceGroupInfo serviceGroup = (BasicServiceGroupInfo)esbEntitiesTable.get(guid);
            BasicServiceGroupInfo owner = (BasicServiceGroupInfo)esbEntitiesTable.get(ownerGuid);
            if(owner != null) {
                serviceGroup.setOwner(owner);
                owner.addServiceGroup(serviceGroup);
            } else {
                System.out.println("==> OWNER NO encontrado :-( ");
            }
        }

        return metadata;
    }

}
