package co.frakasoft.oraesb.beans.util;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 *
 * @author esalaza
 */
public class ESBUtil {

    public static String resumeESBException(String exception) {
        if (exception.contains("WSIF JCA")) {
            exception = exception.substring(exception.indexOf("WSIF JCA"));
        } else if (exception.contains("No resource named") && exception.contains("found")) {
            exception = exception.substring(exception.indexOf("No resource named"), (exception.indexOf("found") + "found".length()));
            return exception;
        } else if (exception.contains("java.sql.SQLException")) {
            exception = exception.substring(exception.indexOf("java.sql.SQLException"));
        }
        exception = exception.replace("oracle.tip.esb.server.common.exceptions.BusinessEventRetriableException: ", "");
        exception = exception.replace("An unhandled exception has been thrown in the ESB system. The exception reported is: ", "");
        exception = exception.replace("oracle.tip.esb.server.dispatch", "");
        exception = exception.replace("org.collaxa.thirdparty.apache.wsif.WSIFException:", "");
        exception = exception.replace("javax.xml.soap.SOAPException: ", "");
        exception = exception.replace("java.security.PrivilegedActionException: ", "");
        exception = exception.replace("; nested exception is:", "");
        exception = exception.replace("\"", "");
        if (exception.contains("\n")) {
            exception = exception.split("\n")[0];
        }
        if (exception.length() > 200) {
            exception = exception.substring(0, 200);
        }
        exception = exception.trim();
        return exception;
    }

    // ESBUtil.getOperationDurationAverage(instances, EnumSet.of(OperationState.SUCCESFUL), EnumSet.of(OperationState.HAS_ERRORS, OperationState.HAS_ERRORS_AND_IS_RETRYABLE, OperationState.HAS_FAULTS, OperationState.NOT_EXECUTED, OperationState.RUNNING));
    public static long getOperationDurationAverage(List<BasicESBOperationInstanceInfo> operations) {

        long average = 0;
        long sum = 0;
        int count = 0;

        for (BasicESBOperationInstanceInfo operation : operations) {
            sum += operation.getDuration();
            count++;
        }

        average = sum / count;
        return average;
    }

    public static long getFlowDurationAverage(List<BasicESBInstanceInfo> flows) {

        long average = 0;
        long sum = 0;
        int count = 0;

        for (BasicESBInstanceInfo flow : flows) {
            sum += flow.getDuration();
            System.out.println(flow.getDuration());
            count++;
        }

        average = sum / count;
        return average;
    }

    public static List<BasicESBOperationInstanceInfo> getOperationsByState(
            List<BasicESBOperationInstanceInfo> operations,
            EnumSet<OperationState> containedStates,
            EnumSet<OperationState> notContainedStates) {

        if(containedStates.contains(OperationState.EXECUTED)) {
            containedStates = EnumSet.of(OperationState.SUCCESFUL, OperationState.HAS_ERRORS, OperationState.HAS_ERRORS_AND_IS_RETRYABLE, OperationState.HAS_FAULTS, OperationState.RUNNING);
        }

        ArrayList<BasicESBOperationInstanceInfo> salida = new ArrayList<BasicESBOperationInstanceInfo>();

        boolean checkNotContainedStates = true;

        if(notContainedStates == null || notContainedStates.isEmpty()) {
            checkNotContainedStates = false;
        }

        iteration:
        for (BasicESBOperationInstanceInfo operation : operations) {
            if (operationStateContainsAny(containedStates, operation)) {
                if (checkNotContainedStates) {
                    if (operationStateContainsAny(notContainedStates, operation)) {
                        continue iteration;
                    }
                }
                salida.add(operation);
            }
        }

        return salida;
    }

    public static boolean operationStateContainsAny(EnumSet<OperationState> states, BasicESBOperationInstanceInfo operation) {
        for(OperationState state : states) {
            if(operation.getState().contains(state)) {
                return true;
            }
        }
        return false;
    }

}
