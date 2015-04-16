package co.frakasoft.oraesb.beans.util;

import java.util.ArrayList;

/**
 *
 * @author esalaza
 */
public class BasicESBInstanceInfo {
    
    private String  flowId       = null;
    private long    timestamp    = 0; // start
    private long    duration     = 0;
    private boolean hasErrors    = false;
    private boolean hasFaults    = false;
    private boolean resubmitable = false;
    private ArrayList<BasicESBOperationInstanceInfo> operations
            = new ArrayList<BasicESBOperationInstanceInfo>();
    
    public BasicESBInstanceInfo(String flowId) {
        this.flowId = flowId;
    }

    public BasicESBInstanceInfo(String flowId, long timestamp) {
        this.flowId = flowId;
        this.timestamp = timestamp;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    @Override
    public String toString() {
        return flowId + " - " + timestamp;
    }
    
    public void setHasFaults(boolean hasFaults) {
        this.hasFaults = hasFaults;
    }

    public boolean hasErrors() {
        return hasErrors;
    }

    public void setHasErrors(boolean hasErrors) {
        this.hasErrors = hasErrors;
    }

    public boolean hasFaults() {
        return hasFaults;
    }

    public boolean isResubmitable() {
        return resubmitable;
    }

    public void setResubmitable(boolean resubmitable) {
        this.resubmitable = resubmitable;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void setOperationInstances(ArrayList<BasicESBOperationInstanceInfo> operations) {
        this.operations = operations;
    }

    public ArrayList getOperationInstances() {
        return operations;
    }

    public void addOperationInstance(BasicESBOperationInstanceInfo operation) {
        operations.add(operation);
    }
}
