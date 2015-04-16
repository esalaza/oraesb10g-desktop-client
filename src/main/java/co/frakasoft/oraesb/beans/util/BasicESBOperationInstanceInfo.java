package co.frakasoft.oraesb.beans.util;

import java.util.EnumSet;
import static co.frakasoft.oraesb.beans.util.ESBStates._00_MESSAGE_RAISED;
import static co.frakasoft.oraesb.beans.util.ESBStates._02_MESSAGE_REJECTED_BY_INBOUND_ADAPTER;
import static co.frakasoft.oraesb.beans.util.ESBStates._03_OUTBOUND_ADAPTER_TO_BE_EXECUTED;
import static co.frakasoft.oraesb.beans.util.ESBStates._04_OUTBOUND_ADAPTER_SUCCESFUL;
import static co.frakasoft.oraesb.beans.util.ESBStates._05_OUTBOUND_ADAPTER_FAULT;
import static co.frakasoft.oraesb.beans.util.ESBStates._06_OUTBOUND_ADAPTER_EXCEPTION;
import static co.frakasoft.oraesb.beans.util.ESBStates._08_ROUTING_ROULE_NOT_EXECUTED;
import static co.frakasoft.oraesb.beans.util.ESBStates._09_ROUTING_ROULE_TO_BE_EXECUTED;
import static co.frakasoft.oraesb.beans.util.ESBStates._10_ROUTING_ROULE_SUCCESFUL;
import static co.frakasoft.oraesb.beans.util.ESBStates._11_ROUTING_ROULE_FAULT;
import static co.frakasoft.oraesb.beans.util.ESBStates._12_ROUTING_ROULE_EXCEPTION;
import static co.frakasoft.oraesb.beans.util.ESBStates._13_RETRYABLE_ROUTING_ROULE_EXCEPTION;
import static co.frakasoft.oraesb.beans.util.ESBStates._14_MESSAGE_RAISED_FAILED;


/**
 *
 * @author esalaza
 */
public class BasicESBOperationInstanceInfo {

    private EnumSet<OperationState> state = null;
    private long timestamp = 0; // inicio
    private long duration = 0;
    private String flowId = null;
    private String id = null; //activity_id
    private int[] types = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    // Cada posicion equivale al numero de ocurrencias de ESBStates, la 2 no se usa
    
    public BasicESBOperationInstanceInfo(String id, String flowId, long timestamp) {
        this.id = id;
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
        String typesString = "[";
        for(int i=0; i<types.length; i++) {
            typesString += (i + "->" + types[i] + "|");
        }
        typesString += "]";
        return
                "Id: " + id +
                ", Flow id: " + flowId +
                ", Timestamp = " + timestamp +
                ", Duration = " + duration +
                ", State = " + state +
                ", Types = " + typesString;
    }
    
    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean hasErrors() {
        return state.contains(OperationState.HAS_ERRORS);
    }

    public void setHasErrors(boolean hasErrors) {
        state.add(OperationState.HAS_ERRORS);
    }

    public boolean hasFaults() {
        return state.contains(OperationState.HAS_FAULTS);
    }

    public void setHasFaults(boolean hasFaults) {
        state.add(OperationState.HAS_FAULTS);
    }

    public boolean isRunning() {
        return state.contains(OperationState.RUNNING);
    }

    public void setRunning(boolean running) {
        state.add(OperationState.RUNNING);
    }

    public boolean isSuccesful() {
        return state.contains(OperationState.SUCCESFUL);
    }

    public void setSuccesful(boolean running) {
        state.add(OperationState.SUCCESFUL);
    }

    public void addState(int state) {
        types[state]++;
    }

    public EnumSet getState() {
        int sum = getTypesSum();
        EnumSet globalState = EnumSet.noneOf(OperationState.class);

        if(
                //--------------------------------------------------------------
                types[_00_MESSAGE_RAISED] == 1 &&
                sum == 1
                //--------------------------------------------------------------
                ) {
            globalState.add(OperationState.SUCCESFUL);
            return globalState;
        }

        if(
                //--------------------------------------------------------------
                types[_14_MESSAGE_RAISED_FAILED] == 1 &&
                sum == 1
                //--------------------------------------------------------------
                ) {
            globalState.add(OperationState.HAS_ERRORS);
            return globalState;
        }

        if(
                //--------------------------------------------------------------
                types[_08_ROUTING_ROULE_NOT_EXECUTED] >= 1 &&
                types[_08_ROUTING_ROULE_NOT_EXECUTED] == sum
                //--------------------------------------------------------------
                ) {
            globalState.add(OperationState.NOT_EXECUTED);
            return globalState;
        }

        if(
                //--------------------------------------------------------------
                types[_02_MESSAGE_REJECTED_BY_INBOUND_ADAPTER] >= 1 ||
                types[_06_OUTBOUND_ADAPTER_EXCEPTION         ] >= 1 ||
                types[_12_ROUTING_ROULE_EXCEPTION            ] >= 1 ||
                types[_13_RETRYABLE_ROUTING_ROULE_EXCEPTION  ] >= 1 ||
                types[_14_MESSAGE_RAISED_FAILED              ] >= 1
                //--------------------------------------------------------------
                ) {
            globalState.add(OperationState.HAS_ERRORS);
        }

        if(
                //--------------------------------------------------------------
                types[_13_RETRYABLE_ROUTING_ROULE_EXCEPTION  ] >= 1
                //--------------------------------------------------------------
                ) {
            globalState.add(OperationState.HAS_ERRORS_AND_IS_RETRYABLE);
        }

        if(
                //--------------------------------------------------------------
                types[_05_OUTBOUND_ADAPTER_FAULT] >= 1 ||
                types[_11_ROUTING_ROULE_FAULT   ] >= 1
                //--------------------------------------------------------------
                ) {
            globalState.add(OperationState.HAS_FAULTS);
        }

        if(
                //--------------------------------------------------------------
                types[_09_ROUTING_ROULE_TO_BE_EXECUTED   ] >= 1 &&
                types[_03_OUTBOUND_ADAPTER_TO_BE_EXECUTED] >= 1 &&
                types[_04_OUTBOUND_ADAPTER_SUCCESFUL     ] >= 1 &&
                types[_10_ROUTING_ROULE_SUCCESFUL        ] >= 1
                //--------------------------------------------------------------
                ) {
            globalState.add(OperationState.SUCCESFUL);
        } else if(
                //--------------------------------------------------------------
                types[_09_ROUTING_ROULE_TO_BE_EXECUTED   ] >= 1 &&
                types[_03_OUTBOUND_ADAPTER_TO_BE_EXECUTED] == 0 &&
                types[_10_ROUTING_ROULE_SUCCESFUL        ] >= 1
                //--------------------------------------------------------------
                ) {
            globalState.add(OperationState.SUCCESFUL);
        } else if(
                //--------------------------------------------------------------
                types[_03_OUTBOUND_ADAPTER_TO_BE_EXECUTED] >= 1 &&
                types[_09_ROUTING_ROULE_TO_BE_EXECUTED   ] == 0 &&
                types[_04_OUTBOUND_ADAPTER_SUCCESFUL     ] >= 1
                //--------------------------------------------------------------
                ) {
            globalState.add(OperationState.SUCCESFUL);
        }

        if(
                //--------------------------------------------------------------
                types[_03_OUTBOUND_ADAPTER_TO_BE_EXECUTED] > 
                types[_04_OUTBOUND_ADAPTER_SUCCESFUL     ] + 
                types[_05_OUTBOUND_ADAPTER_FAULT         ] + 
                types[_06_OUTBOUND_ADAPTER_EXCEPTION     ]
                //--------------------------------------------------------------
                ) {
            globalState.add(OperationState.RUNNING);
        } else if(
                //--------------------------------------------------------------
                types[_03_OUTBOUND_ADAPTER_TO_BE_EXECUTED] <
                types[_04_OUTBOUND_ADAPTER_SUCCESFUL     ] +
                types[_05_OUTBOUND_ADAPTER_FAULT         ] +
                types[_06_OUTBOUND_ADAPTER_EXCEPTION     ]
                //--------------------------------------------------------------
                ) {
            globalState.add(OperationState.PREVIOUSLY_STARTED);
        }

        if(
                //--------------------------------------------------------------
                types[_09_ROUTING_ROULE_TO_BE_EXECUTED     ] >
                types[_10_ROUTING_ROULE_SUCCESFUL          ] +
                types[_11_ROUTING_ROULE_FAULT              ] +
                types[_12_ROUTING_ROULE_EXCEPTION          ] +
                types[_13_RETRYABLE_ROUTING_ROULE_EXCEPTION]
                //--------------------------------------------------------------
                ) {
            globalState.add(OperationState.RUNNING);
        } else if(
                //--------------------------------------------------------------
                types[_09_ROUTING_ROULE_TO_BE_EXECUTED     ] <
                types[_10_ROUTING_ROULE_SUCCESFUL          ] +
                types[_11_ROUTING_ROULE_FAULT              ] +
                types[_12_ROUTING_ROULE_EXCEPTION          ] +
                types[_13_RETRYABLE_ROUTING_ROULE_EXCEPTION]
                //--------------------------------------------------------------
                ) {
            globalState.add(OperationState.PREVIOUSLY_STARTED);
        }

        if(globalState.isEmpty()) {
            globalState.add(OperationState.UNKNOWN);
        }

        return globalState;
    }

    private int getTypesSum() {
        int sum = 0;
        for(int type : types) sum += type;
        return sum;
    }

    public String getTypesString() {
        String typesString = "";
        for(int i=0; i<types.length; i++) {
            typesString += (i + "=" + types[i] + "|");
        }
        return typesString;
    }
    
}


