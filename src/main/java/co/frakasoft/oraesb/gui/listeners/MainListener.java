package co.frakasoft.oraesb.gui.listeners;

import co.frakasoft.oraesb.beans.util.BasicESBEntityInfo;
import co.frakasoft.oraesb.beans.util.BasicESBInstanceInfo;
import co.frakasoft.oraesb.beans.util.BasicESBOperationInstanceInfo;
import co.frakasoft.oraesb.beans.util.BasicOperationInfo;
import co.frakasoft.oraesb.beans.util.BasicServiceInfo;
import co.frakasoft.oraesb.beans.util.ESBUtil;
import co.frakasoft.oraesb.beans.util.OperationState;
import co.frakasoft.oraesb.client.ESBClient;
import co.frakasoft.oraesb.db.client.ESBDBClient;
import co.frakasoft.oraesb.gui.InstanceSearchByOperationPanel;
import co.frakasoft.oraesb.gui.InstanceSearchPanel;
import co.frakasoft.oraesb.gui.MainTabbedWindow;
import co.frakasoft.oraesb.gui.ReportsByOperationPanel;
import co.frakasoft.oraesb.gui.ReportsPanel;
import co.frakasoft.oraesb.gui.TextAreaDialog;
import co.frakasoft.util.TimeUtils;
import co.frakasoft.util.beans.DailyTimeSerieValue;
import co.frakasoft.util.beans.HourlyTimeSerieValue;
import co.frakasoft.util.beans.XYPair;
import co.frakasoft.util.charts.CategoryBarChart;
import co.frakasoft.util.charts.DailyTimeSerieChart;
import co.frakasoft.util.charts.HourlyTimeSerieChart;
import co.frakasoft.util.charts.PieChart;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import org.apache.log4j.Logger;

/**
 *
 * @author esalaza
 */
public class MainListener implements ActionListener, TreeSelectionListener {

    static Logger logger = Logger.getLogger(MainListener.class);

    private ESBClient client;
    private ESBDBClient dbClient;
    private InstanceSearchPanel instanceSearchPanel;
    private InstanceSearchByOperationPanel instanceSearchByOperationPanel;
    private ReportsPanel reportsPanel;
    private ReportsByOperationPanel reportsByOperationPanel;
    private MainTabbedWindow mainTabbedWindow;
    private TextAreaDialog textAreaDialog;

    private long initExecutionTime = 0;
    private long endExecutionTime  = 0;

    public MainListener() {
    }

    public void actionPerformed(ActionEvent e) {
        try {

            //--- Buscar instancias --------------------------------------------
            if (e.getSource() == instanceSearchPanel.getSearchButton()) {
                searchAction();
            //------------------------------------------------------------------
            } //- Buscar instancias (operacion)
            else if (e.getSource() == instanceSearchByOperationPanel.getSearchButton()) {
                searchByOperationAction();
            //------------------------------------------------------------------
            } //- Reintentar instancias ----------------------------------------
            else if (e.getSource() == instanceSearchPanel.getRetryButton()) {
                retryAction();
            //------------------------------------------------------------------
            } //- Acerca de ----------------------------------------------------
            else if (e.getSource() == mainTabbedWindow.getItmMnuHelpAbout()) {
                aboutAction();
            //------------------------------------------------------------------
            } //- Imprimir identificadores de flujo a archivo ------------------
            else if (e.getSource() == mainTabbedWindow.getItmMnuToolsFlowIdsToFile()) {
                printFlowIdsToFileAction();
            //------------------------------------------------------------------
            } //- Cancelar reenvio masivo --------------------------------------
            else if (e.getSource() == textAreaDialog.getCancelButton()) {
                textAreaDialog.setVisible(false);
            //------------------------------------------------------------------
            } //- Reportes por servicio ----------------------------------------
            else if (e.getSource() == reportsPanel.getGenerateButton()) {
                reportAction(reportsPanel.getReportType());
            //------------------------------------------------------------------
            } //- Reportes por operacion ---------------------------------------
            else if (e.getSource() == reportsByOperationPanel.getGenerateButton()) {
                reportByOperationAction(reportsByOperationPanel.getReportType());
            //------------------------------------------------------------------
            }
        // ---------------------------------------------------------------------
        } catch (Exception ex) {
            instanceSearchPanel.showErrorDialog("Error: \n" + ex);
            ex.printStackTrace();
        }
    }

    private void reportByOperationAction(int reporType) throws Exception {
        String operationGuid = "";
        Date startDate = null;
        Date endDate = null;
        long startTime = 0;
        long endTime = 0;

        if (!reportsByOperationPanel.validateForGenerate()) {
            return;
        }

        startDate = reportsByOperationPanel.getStartDate();
        endDate = reportsByOperationPanel.getEndDate();

        if (reportsByOperationPanel.getStartDate() != null) {
            startTime = reportsByOperationPanel.getStartTime();
            startDate = new Date(reportsByOperationPanel.getStartDate().getTime() + startTime);
        }

        if (reportsByOperationPanel.getEndDate() != null) {
            endTime = reportsByOperationPanel.getEndTime();
            endDate = new Date(reportsByOperationPanel.getEndDate().getTime() + endTime);
        }

        if (reportsByOperationPanel.isServiceElectionEnabled()) {
            BasicESBEntityInfo entity = reportsByOperationPanel.getSelectedESBEntity();
            if(entity instanceof BasicOperationInfo) {
                operationGuid = ((BasicOperationInfo)entity).getId();
            }
        }

        switch (reporType) {
            case ReportsByOperationPanel.DAILY_OPERATION_ERROR_INSTANCES:
                mainTabbedWindow.showInformationDialog("Not implemented");
                break;
            case ReportsByOperationPanel.DAILY_OPERATION_INSTANCES:
                mainTabbedWindow.showInformationDialog("Not implemented");
                break;
            case ReportsByOperationPanel.ERROR_TYPE_COUNT:
                mainTabbedWindow.showInformationDialog("Not implemented");
                break;
            case ReportsByOperationPanel.OPERATION_TOTAL_ERROR_INSTANCES:
                mainTabbedWindow.showInformationDialog("Not implemented");
                break;
            case ReportsByOperationPanel.OPERATION_TOTAL_INSTANCES:
                mainTabbedWindow.showInformationDialog("Not implemented");
                break;
            case ReportsByOperationPanel.ERROR_TYPE_XXX_COUNT:
                mainTabbedWindow.showInformationDialog("Not implemented");
                break;
            case ReportsByOperationPanel.DAILY_OPERATION_OK_INSTANCES:
                mainTabbedWindow.showInformationDialog("Not implemented");
                break;
            case ReportsByOperationPanel.DAILY_OPERATION_INSTANCES_FROM_SUMMARY:
                mainTabbedWindow.showInformationDialog("Not implemented");
                break;
            case ReportsByOperationPanel.HOURLY_OPERATION_INSTANCES_FROM_SUMMARY:
                mainTabbedWindow.showInformationDialog("Not implemented");
                break;
            default:
                mainTabbedWindow.showInformationDialog("Invalid report type");
                break;
        }
    }

    private void reportAction(int reporType) throws Exception {
        String serviceName = "";
        Date startDate = null;
        Date endDate = null;
        long startTime = 0;
        long endTime = 0;

        if (!reportsPanel.validateForGenerate()) {
            return;
        }

        startDate = reportsPanel.getStartDate();
        endDate = reportsPanel.getEndDate();

        if (reportsPanel.getStartDate() != null) {
            startTime = reportsPanel.getStartTime();
            startDate = new Date(reportsPanel.getStartDate().getTime() + startTime);
        }

        if (reportsPanel.getEndDate() != null) {
            endTime = reportsPanel.getEndTime();
            endDate = new Date(reportsPanel.getEndDate().getTime() + endTime);
        }

        if (reportsPanel.isServiceElectionEnabled()) {
            BasicServiceInfo service = reportsPanel.getSelectedService();
            serviceName = service.getName();
        }

        switch (reporType) {
            case ReportsPanel.DAILY_OPERATION_ERROR_INSTANCES:
                mainTabbedWindow.showInformationDialog("No implementado");
                break;
            case ReportsPanel.DAILY_OPERATION_INSTANCES:
                dailyServiceInstanceReportAction(serviceName, startDate, endDate);
                break;
            case ReportsPanel.ERROR_TYPE_COUNT:
                errorsTypeReportAction(startDate, endDate);
                break;
            case ReportsPanel.OPERATION_TOTAL_ERROR_INSTANCES:
                mainTabbedWindow.showInformationDialog("No implementado");
                break;
            case ReportsPanel.OPERATION_TOTAL_INSTANCES:
                operationTotalInstancesReportAction(startDate, endDate);
                break;
            default:
                System.out.println("NINGUNO!");
                break;
        }
    }

    private void dailyServiceInstanceReportAction(String serviceName, Date startDate, Date endDate) throws Exception {
        System.out.println("dailyServiceInstanceReportAction: " + serviceName + startDate + endDate);
        ArrayList<DailyTimeSerieValue> values = dbClient.dailyServiceInstanceReport(serviceName, startDate, endDate);
        DailyTimeSerieChart chart = new DailyTimeSerieChart("Instancias por d\u00EDa", "Instancias de servicio por d\u00EDa", "Fecha", "Instancias");
        chart.setSerieColor(Color.BLUE);
        chart.setValues(values);
        JPanel chartPanel = chart.getChartPanel();
        reportsPanel.setChartPanel(chartPanel);
        mainTabbedWindow.repaint();
    }
    
    private void hourlyOperationInstanceFromSummaryReportAction(String serviceName, String operationName, Date startDate, Date endDate) throws Exception {
        System.out.println("hourlyOperationInstanceFromSummaryReportAction: " + serviceName + ", " + operationName + ", " + startDate + ", " + endDate);
        ArrayList<HourlyTimeSerieValue> values = dbClient.hourlyOperationInstanceFromSummaryReport(serviceName, operationName, startDate, endDate);
        HourlyTimeSerieChart chart = new HourlyTimeSerieChart("Instancias por hora", "Instancias de operacion por hora", "Hora", "Instancias");
        chart.setSerieColor(Color.BLUE);
        chart.setValues(values);
        JPanel chartPanel = chart.getChartPanel();
        reportsPanel.setChartPanel(chartPanel);
        mainTabbedWindow.repaint();
    }

    private void dailyServiceOKInstanceReportAction(String serviceName, Date startDate, Date endDate) throws Exception {
        System.out.println("dailyServiceOKInstanceReportAction: " + serviceName + startDate + endDate);
        ArrayList<DailyTimeSerieValue> values = dbClient.dailyServiceOKInstanceReport(serviceName, startDate, endDate);
        DailyTimeSerieChart chart = new DailyTimeSerieChart("Instancias por d\u00EDa", "Instancias de servicio por d\u00EDa", "Fecha", "Instancias");
        chart.setSerieColor(Color.BLUE);
        chart.setValues(values);
        JPanel chartPanel = chart.getChartPanel();
        reportsPanel.setChartPanel(chartPanel);
        mainTabbedWindow.repaint();
    }

    private void errorsTypeReportAction(Date startDate, Date endDate) throws Exception {
        ArrayList<XYPair> values = dbClient.getErrorsTypeReport(startDate, endDate);
        PieChart chart = new PieChart("Tipos de errores");
        chart.setValues(values);
        JPanel chartPanel = chart.getChartPanel();
        reportsPanel.setChartPanel(chartPanel);
        mainTabbedWindow.repaint();
    }

    private void operationTotalInstancesReportAction(Date startDate, Date endDate) throws Exception {
        ArrayList<XYPair> values = dbClient.getInstanceCountReport(startDate, endDate);
        CategoryBarChart chart = new CategoryBarChart("N\u00FAmero de instancias por operaci\u00F3n (Top 20)", "Operaciones", "N\u00FAmero de instancias");
        chart.setBarsColor(Color.GREEN);
        chart.setValues(values);
        JPanel chartPanel = chart.getChartPanel();
        reportsPanel.setChartPanel(chartPanel);
        mainTabbedWindow.repaint();
    }

    public void valueChanged(TreeSelectionEvent e) {
        TreePath path = e.getNewLeadSelectionPath();
        if (path == null) {
            return;
        }
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) path.getLastPathComponent();
        if (selectedNode != null) {
            Object node = selectedNode.getUserObject();
            if (node instanceof BasicESBEntityInfo) {
                BasicESBEntityInfo esbEntity = (BasicESBEntityInfo) node;
                mainTabbedWindow.setStatusText("Id = " + esbEntity.getId());
            }
            instanceSearchPanel.disableRetryControls();
        }
    }

    private void printFlowIdsToFileAction() {
        File file = null;
        if ((file = instanceSearchPanel.showFileSaveDialog()) != null) {
            try {
                String[] flowIds = instanceSearchPanel.getFlowIds();
                PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
                for (String flowId : flowIds) {
                    pw.println(flowId);
                }
                pw.close();
                instanceSearchPanel.showInformationDialog("Listo!");
            } catch (Exception e) {
                instanceSearchPanel.showErrorDialog("Error al escribir archivo: \n" + e);
                e.printStackTrace();
            }
        }

    }

    private void aboutAction() {
        mainTabbedWindow.showAboutDialog();
    }

    private void retryAction() throws Exception {
        textAreaDialog.setVisible(true);
    }

    private void searchAction() throws Exception {
        Long init = System.currentTimeMillis();
        Long end = 0L;
        String serviceName = null;
        Date startDate = null;
        Date endDate = null;
        long startTime = 0;
        long endTime = 0;
        int status = 0;

        if (!instanceSearchPanel.validateForSearch()) {
            return;
        }

        status = instanceSearchPanel.getSearchMode();

        if (instanceSearchPanel.getStartDate() != null) {
            startTime = instanceSearchPanel.getStartTime();
            startDate = new Date(instanceSearchPanel.getStartDate().getTime() + startTime);
            logger.debug("searchAction: start time (long) = " + instanceSearchPanel.getStartDate().getTime() + startTime);
        }

        if (instanceSearchPanel.getEndDate() != null) {
            endTime = instanceSearchPanel.getEndTime();
            endDate = new Date(instanceSearchPanel.getEndDate().getTime() + endTime);
            logger.debug("searchAction: end time (long) = " + instanceSearchPanel.getEndDate().getTime() + endTime);
        }

        if (instanceSearchPanel.isServiceElectionEnabled()) {
            BasicServiceInfo service = instanceSearchPanel.getSelectedService();
            serviceName = service.getName();
        }

        // Mejorar
        try {
            long average = 0;
            String averageString = "";

            List<BasicESBInstanceInfo> instancias =
                    dbClient.getInstancesWithStatusInfo(serviceName, status, startDate, endDate);

            if (instancias == null) {
                instancias = new ArrayList<BasicESBInstanceInfo>();
            }
            if (instancias.size() == 0) {
                instanceSearchPanel.showInformationDialog("No results");
            } else {
                    average = ESBUtil.getFlowDurationAverage(instancias);
                    averageString = TimeUtils.longDuration2TimeDurationString(average);
            }

            instanceSearchPanel.setInstances(instancias);

            end = System.currentTimeMillis();
            mainTabbedWindow.setStatusText(
                    "Total results: " + instancias.size() + ", " +
                    "Query execution time (ms): " + (end - init) + ", " +
                    "Instances average duration: " + averageString + " (" + average + "ms)");

            if (instanceSearchPanel.isServiceElectionEnabled() &&
                    (status == ESBDBClient.ERROR_STATUS || status == ESBDBClient.FAULTED_STATUS || status == ESBDBClient.RESUBMITABLE_STATUS)) {
                instanceSearchPanel.enableRetryControls();
            }

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            ex.printStackTrace();
            instanceSearchPanel.showErrorDialog("Query error: \n" + ex);
            end = System.currentTimeMillis();
            mainTabbedWindow.setStatusText("Total time (ms): " + (end - init));
        }
    }

    private void searchByOperationAction() throws Exception {
        long init = System.currentTimeMillis();
        long end  = 0;
        String operationGuid = null;
        Date startDate = null;
        Date endDate = null;
        long startTime = 0;
        long endTime = 0;
        OperationState status = null;

        if (!instanceSearchByOperationPanel.validateForSearch()) {
            return;
        }

        status = instanceSearchByOperationPanel.getSearchMode();

        if (instanceSearchByOperationPanel.getStartDate() != null) {
            startTime = instanceSearchByOperationPanel.getStartTime();
            startDate = new Date(instanceSearchByOperationPanel.getStartDate().getTime() + startTime);
        }

        if (instanceSearchByOperationPanel.getEndDate() != null) {
            endTime = instanceSearchByOperationPanel.getEndTime();
            endDate = new Date(instanceSearchByOperationPanel.getEndDate().getTime() + endTime);
        }

        if (instanceSearchByOperationPanel.isServiceElectionEnabled()) {
            BasicESBEntityInfo entity = instanceSearchByOperationPanel.getSelectedESBEntity();
            if (entity instanceof BasicOperationInfo) {
                operationGuid = ((BasicOperationInfo) entity).getId();
            }
        }
        
        // Mejorar
        try {
            long average = 0;
            String averageString = "";

            List<BasicESBOperationInstanceInfo> instancias =
                    dbClient.getOperationInstances(operationGuid, startDate, endDate);

            if (instancias == null || instancias.size() == 0) {
                instanceSearchByOperationPanel.setInstances(new ArrayList<BasicESBOperationInstanceInfo>());
                instanceSearchByOperationPanel.showInformationDialog("La consulta no tuvo resultados");
            } else {
                if (!status.equals(OperationState.ANY)) {
                    mainTabbedWindow.setStatusText("Filtrando resultados...");
                    instancias = ESBUtil.getOperationsByState(instancias, EnumSet.of(status), null);
                }
                instanceSearchByOperationPanel.setInstances(instancias);
                if (instancias.size() != 0) {
                    average = ESBUtil.getOperationDurationAverage(instancias);
                    averageString = TimeUtils.longDuration2TimeDurationString(average);
                }
            }

            end = System.currentTimeMillis();
            mainTabbedWindow.setStatusText(
                    "N\u00FAmero de resultados: " + instancias.size() + ", " +
                    "Tiempo total ejecucion consulta (ms): " + (end - init) + ", " +
                    "Promedio duracion instancias: " + averageString + " (" + average + "ms)");

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            ex.printStackTrace();
            instanceSearchByOperationPanel.showErrorDialog("Error en la consulta: \n" + ex);
            end = System.currentTimeMillis();
            mainTabbedWindow.setStatusText("Tiempo total (ms): " + (end - init));
            mainTabbedWindow.getInstanceSearchByOperationPanel().stopProgressBar();
        }
    }

    public void finishSearchByOperationAction(List<BasicESBOperationInstanceInfo> instances) {
            if (instances == null) {
                instances = new ArrayList<BasicESBOperationInstanceInfo>();
            }
            if (instances.size() == 0) {
                instanceSearchByOperationPanel.showInformationDialog("La consulta no tuvo resultados");
            }

            instanceSearchByOperationPanel.setInstances(instances);

            endExecutionTime = System.currentTimeMillis();
            mainTabbedWindow.setStatusText(
                    "N\u00FAmero de resultados: " + instances.size() + ", " +
                    "Tiempo total (ms): " + (endExecutionTime - initExecutionTime));
            mainTabbedWindow.getInstanceSearchByOperationPanel().enableForm();
            mainTabbedWindow.getInstanceSearchByOperationPanel().stopProgressBar();
    }

    public void setInstanceSearchPane(InstanceSearchPanel instanceSearchPane) {
        this.instanceSearchPanel = instanceSearchPane;
    }

    public void setInstanceSearchByOperationPane(InstanceSearchByOperationPanel instanceSearchByOperationPanel) {
        this.instanceSearchByOperationPanel = instanceSearchByOperationPanel;
    }

    public void setMainTabbedWindow(MainTabbedWindow mainTabbedWindow) {
        this.mainTabbedWindow = mainTabbedWindow;
        instanceSearchPanel = mainTabbedWindow.getInstanceSearchPanel();
        instanceSearchByOperationPanel = mainTabbedWindow.getInstanceSearchByOperationPanel();
        reportsPanel = mainTabbedWindow.getReportsPanel();
        reportsByOperationPanel = mainTabbedWindow.getReportsByOperationPanel();
    }

    public void setESBClient(ESBClient client) {
        this.client = client;
    }

    public void setESBDBClient(ESBDBClient dbClient) {
        this.dbClient = dbClient;
    }

    public TextAreaDialog getTextAreaDialog() {
        return textAreaDialog;
    }

    public void setTextAreaDialog(TextAreaDialog textAreaDialog) {
        this.textAreaDialog = textAreaDialog;
    }

    public ReportsPanel getReportsPanel() {
        return reportsPanel;
    }

    public void setReportsPanel(ReportsPanel reportsPanel) {
        this.reportsPanel = reportsPanel;
    }
}
