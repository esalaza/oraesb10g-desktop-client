package co.frakasoft.oraesb.beans.util;

/**
 *
 * @author esalaza
 */
public class ESBStates {

    public static final int _00_MESSAGE_RAISED = 0;
    public static final int _01_NOT_USED = 1;
    public static final int _02_MESSAGE_REJECTED_BY_INBOUND_ADAPTER = 2;
    public static final int _03_OUTBOUND_ADAPTER_TO_BE_EXECUTED = 3;
    public static final int _04_OUTBOUND_ADAPTER_SUCCESFUL = 4;
    public static final int _05_OUTBOUND_ADAPTER_FAULT = 5;
    public static final int _06_OUTBOUND_ADAPTER_EXCEPTION = 6;
    public static final int _07_NOT_USED = 7;
    public static final int _08_ROUTING_ROULE_NOT_EXECUTED = 8;
    public static final int _09_ROUTING_ROULE_TO_BE_EXECUTED = 9;
    public static final int _10_ROUTING_ROULE_SUCCESFUL = 10;
    public static final int _11_ROUTING_ROULE_FAULT = 11;
    public static final int _12_ROUTING_ROULE_EXCEPTION = 12;
    public static final int _13_RETRYABLE_ROUTING_ROULE_EXCEPTION = 13;
    public static final int _14_MESSAGE_RAISED_FAILED = 14;
    public static final int _15_GLOBAL_TX_COMMITED = 15;
    public static final int _16_GLOBAL_TX_ROLLED_BACK_DUE_TO_ERROR = 16;

}
