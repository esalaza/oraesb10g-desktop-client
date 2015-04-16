package co.frakasoft.oraesb.beans.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author esalaza
 */
public class FlowErrorReport {

    HashMap<String, HashMap<String, Integer>> report = new HashMap<String, HashMap<String, Integer>>();

    private void addFlow(String flowName) {
        report.put(flowName, new HashMap<String, Integer>());
    }

    public void addError(String flowName, String error) {
        if(!report.containsKey(flowName)) {
            addFlow(flowName);
        }
        if(report.get(flowName).containsKey(error)) {
            report.get(flowName).put(error, report.get(flowName).get(error) + 1);
        } else {
            report.get(flowName).put(error, 1);
        }
    }
    
    public List<String> getFlows() {
        return new ArrayList<String>(report.keySet());
    }

    public List<String> getErrors(String flowName) {
        List<String> errorList = null;
        if(report.containsKey(flowName)) {
            errorList = new ArrayList<String>(report.get(flowName).keySet());
        }
        return errorList;
    }

    public int getErrorCount(String flowName, String error) {
        int total = 0;
        if(report.containsKey(flowName)) {
            if(report.get(flowName).containsKey(error)) {
                total = report.get(flowName).get(error);
            }
        }
        return total;
    }

    public int getErrorCount(String flowName) {
        int total = 0;
        if(report.containsKey(flowName)) {
            
        }
        return total;
    }

}
