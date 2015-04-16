package co.frakasoft.oraesb.beans.util;

/**
 *
 * @author esalaza
 */
public enum OperationState {
    ANY,
    HAS_ERRORS,
    HAS_ERRORS_AND_IS_RETRYABLE,
    HAS_FAULTS,
    RUNNING,
    SUCCESFUL,
    EXECUTED,
    NOT_EXECUTED,
    PREVIOUSLY_STARTED,
    UNKNOWN
};
