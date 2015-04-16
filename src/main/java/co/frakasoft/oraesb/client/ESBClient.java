package co.frakasoft.oraesb.client;

import java.util.HashMap;
import oracle.tip.esb.client.ConsoleClient;
import oracle.tip.esb.client.ConsoleClientFactory;
import org.apache.log4j.Logger;
import co.frakasoft.oraesb.beans.flows.InstanceFilter;
import co.frakasoft.oraesb.beans.instance.Instances;
import co.frakasoft.oraesb.beans.service.Metadata;
import co.frakasoft.util.xml.binding.JAXBUtil;
import co.frakasoft.util.xml.XMLUtil;

/**
 *
 * @author esalaza
 */
public class ESBClient {
    
    static Logger logger = Logger.getLogger(ESBClient.class);

    private String host;
    private int port;
    private String username;
    private String password;
    private ConsoleClient client;
    
    public ESBClient(String host, int port, String username, String password) throws Exception {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        connect();
    }
    
    public void connect() throws Exception {
        client = ConsoleClientFactory.getConsoleClient(host, port, username, password);
    }
    
    public String invokeArbitrary(String operation, HashMap<String,String> requestProps) throws Exception {
        return client.perform(operation, requestProps);
    }
    
    public Instances getInstances(InstanceFilter filter) throws Exception {
        Instances instances = null;
        HashMap<String,String> requestProps = new HashMap<String,String>();
        String filterXML = JAXBUtil.jaxbMarshal(filter);
        requestProps.put("filter", filterXML);
        String response = client.perform("GetInstances", requestProps);
        response = XMLUtil.dirtilyAddNamespaceForOracleESB("instances", response);
        String className = Instances.class.getPackage().getName();
        instances = (Instances)JAXBUtil.jaxbUnmarshal(className, response);
        return instances;
    }
    
    public Metadata exploreServices() throws Exception {
        Metadata metadata = null;
        HashMap<String,String> requestProps = new HashMap<String,String>();
        String response = client.perform("ExploreServices", requestProps);
        String className = Metadata.class.getPackage().getName();
        metadata = (Metadata)JAXBUtil.jaxbUnmarshal(className, response);
        return metadata;
    }

    public String resubmitInstanceById(String flowId, String systemGUID) throws Exception {
        String response = null;
        HashMap<String, String> requestProps = new HashMap<String, String>();
        requestProps.put("flowId", flowId);
        requestProps.put("systemId", systemGUID);
        response = client.perform("ResubmitInstanceById", requestProps);
        return response;
    }

}
