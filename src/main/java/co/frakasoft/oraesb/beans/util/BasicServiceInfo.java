package co.frakasoft.oraesb.beans.util;

import java.util.ArrayList;

/**
 *
 * @author esalaza
 */
public class BasicServiceInfo extends BasicESBEntityInfo {
    
    private ArrayList<BasicOperationInfo> operations = new ArrayList<BasicOperationInfo>();

    public BasicServiceInfo() {
        super();
    }
    
    public BasicServiceInfo(String id, String name, String description) {
        super(id, name, description);
    }

    public void addOperation(BasicOperationInfo operation) {
        getOperations().add(operation);
    }

    public ArrayList<BasicOperationInfo> getOperations() {
        return operations;
    }

    public void setOperations(ArrayList<BasicOperationInfo> operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Type: GROUP (SERVICE)\n");
        sb.append(super.toString());
            sb.append("\n----------------------------------------------------\n");
            sb.append("Operations\n");
            sb.append("----------------------------------------------------\n");
        for(BasicOperationInfo operation : operations) {
            sb.append((BasicESBEntityInfo)operation);
            sb.append("----------------------------------------------------\n");
        }
        return sb.toString();
    }

}
