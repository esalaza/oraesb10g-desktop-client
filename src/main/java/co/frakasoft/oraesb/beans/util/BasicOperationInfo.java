package co.frakasoft.oraesb.beans.util;

/**
 *
 * @author esalaza
 */
public class BasicOperationInfo extends BasicESBEntityInfo {

    private BasicServiceInfo service = null;

    public BasicServiceInfo getService() {
        return service;
    }

    public void setService(BasicServiceInfo service) {
        this.service = service;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Type: EVENT (OPERATION)\n");
        sb.append(super.toString());
        return sb.toString();
    }

}
