package co.frakasoft.oraesb.beans.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esalaza
 */
public class BasicSystemInfo extends BasicESBEntityInfo {
    
    private List<Object> serviceGroupsOrServices = new ArrayList<Object>();

    public BasicSystemInfo() {
        super();
    }
    
    public BasicSystemInfo(String id, String name, String description) {
        super(id, name, description);
    }
    
    public List<Object> getServiceGroupsOrServices() {
        return serviceGroupsOrServices;
    }

    public void setServiceGroupsOrServices(List<Object> serviceGroupsOrServices) {
        this.serviceGroupsOrServices = serviceGroupsOrServices;
    }

    public void addServiceGroup(BasicServiceGroupInfo serviceGroup) {
        serviceGroupsOrServices.add(serviceGroup);
    }

    public void addService(BasicServiceInfo service) {
        serviceGroupsOrServices.add(service);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Type: SYSTEM\n");
        sb.append(super.toString());
        sb.append("\n----------------------------------------------------\n");
        sb.append("Services or Service Groups\n");
        sb.append("----------------------------------------------------\n");
        for(Object serviceGroupOrService : serviceGroupsOrServices) {
            sb.append((BasicESBEntityInfo)serviceGroupOrService);
            sb.append("----------------------------------------------------\n");
        }
        return sb.toString();
    }

}
