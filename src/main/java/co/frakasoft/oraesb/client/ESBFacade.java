package co.frakasoft.oraesb.client;

import co.frakasoft.oraesb.beans.instance.Instances;
import co.frakasoft.oraesb.beans.flows.InstanceFilter;
import co.frakasoft.oraesb.beans.flows.InstanceStatus;
import co.frakasoft.oraesb.beans.instance.Instance;
import co.frakasoft.oraesb.beans.service.Metadata;
import co.frakasoft.oraesb.beans.service.Service;
import co.frakasoft.oraesb.beans.service.ServiceGroup;
import co.frakasoft.util.TimeUtils;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author esalaza
 */
public class ESBFacade {

    static Logger logger = Logger.getLogger(ESBFacade.class);
    private ESBClient esbClient;

    public ESBFacade(ESBClient esbClient) {
        this.esbClient = esbClient;
    }

    /**
     * Nota: por defecto el ESB solo retorna 100 instancias. Se puede cambiar este
     * valor permanentemente con insert into esb_parameter (PARAM_NAME, PARAM_VALUE) 
     * values ( 'MaxInstanceCount', '1000' ). Mirar 
     * http://chintanblog.blogspot.com/2008/05/esb-display-older-instances-i-used-to.html
     * @param serviceName
     * @param milliseconds
     * @param onlyErrorInstances
     * @return
     * @throws java.lang.Exception
     */
    public Instances getInstancesSince(
            String serviceName,
            long milliseconds,
            boolean onlyErrorInstances) throws Exception {
        InstanceFilter filter = new InstanceFilter();
        String serviceGUID = "";
        filter.setStartTime(milliseconds);
        if (onlyErrorInstances) {
            filter.setStatus(InstanceStatus.ERROR);
        }
        if (serviceName != null || !"".equals(serviceName)) {
            serviceGUID = getServiceGUID(serviceName);
            filter.setServiceGUID(serviceGUID);
        }
        Instances instances = esbClient.getInstances(filter);
        return instances;
    }

    public Instances getInstancesSince(
            String serviceName,
            int hours,
            int minutes,
            int seconds,
            boolean onlyErrorInstances) throws Exception {
        long milliseconds = TimeUtils.getMilliseconds(hours, minutes, seconds);
        return getInstancesSince(serviceName, milliseconds, onlyErrorInstances);
    }

    public Instances getTodayInstances(
            String serviceName,
            boolean onlyErrorInstances) throws Exception {
        long milliseconds = TimeUtils.getTodayElapsedMilliseconds();
        return getInstancesSince(serviceName, milliseconds, onlyErrorInstances);
    }

    public String getSystemIDForService(String serviceName) throws Exception {
        String systemID = "";
        Metadata metadata = esbClient.exploreServices();
        List<co.frakasoft.oraesb.beans.service.System> systems = metadata.getSystem();
        systemsLoop:
        for (co.frakasoft.oraesb.beans.service.System system : systems) {
            // La lista puede contener Servicios o Grupos de Servicios. Parece
            // que los Grupos de Servicios pueden contener otros Grupos de
            // Servicios. Por esta razon hay que buscar recursivamente con
            // findServiceInServiceGroup()
            List<Object> servicesOrGroups = system.getServiceGroupOrService();
            for (Object o : servicesOrGroups) {
                Service service;
                ServiceGroup serviceGroup;
                if (o instanceof Service) {
                    service = (Service) o;
                    if (service.getName().equals(serviceName)) {
                        systemID = system.getGuid();
                        break systemsLoop;
                    }
                } else { // Instance of ServiceGroup

                    serviceGroup = (ServiceGroup) o;
                    service = findServiceInServiceGroup(serviceName, serviceGroup);
                    if (service != null) {
                        systemID = system.getGuid();
                        break systemsLoop;
                    }
                }
            }
        }
        return systemID;
    }

    public String getServiceGUID(String serviceName) throws Exception {
        String serviceGUID = "";
        Metadata metadata = esbClient.exploreServices();
        List<co.frakasoft.oraesb.beans.service.System> systems = metadata.getSystem();
        systemsLoop:
        for (co.frakasoft.oraesb.beans.service.System system : systems) {
            // La lista puede contener Servicios o Grupos de Servicios. Parece
            // que los Grupos de Servicios pueden contener otros Grupos de
            // Servicios. Por esta razon hay que buscar recursivamente con
            // findServiceInServiceGroup()
            List<Object> servicesOrGroups = system.getServiceGroupOrService();
            for (Object o : servicesOrGroups) {
                Service service;
                ServiceGroup serviceGroup;
                if (o instanceof Service) {
                    service = (Service) o;
                    if (service.getName().equals(serviceName)) {
                        serviceGUID = service.getGuid();
                        break systemsLoop;
                    }
                } else { // Instance of ServiceGroup

                    serviceGroup = (ServiceGroup) o;
                    service = findServiceInServiceGroup(serviceName, serviceGroup);
                    if (service != null) {
                        serviceGUID = service.getGuid();
                        break systemsLoop;
                    }
                }
            }
        }
        return serviceGUID;
    }

    public String getHourFromLastInstanceSince(
            String serviceName,
            int hours,
            int minutes,
            int seconds) throws Exception {
        String hour = null;
        Instances instances = getInstancesSince(serviceName, hours, minutes, seconds, false);
        List<Instance> instanceList = instances.getInstance();
        if(instanceList != null && instanceList.size() != 0) {
            Instance instance = instanceList.get(0);
            hour = instance.getInitiatedAt().toString();
        }
        return hour;
    }

    /**
     * Un Grupo de Servicios puede contener Servicios y Grupos de Servicios.
     * Esta funcion busca un Servicio a traves de su nombre en el Grupo de 
     * Servicios actual o en alguno de sus sub-Grupos de Servicios.
     * @param serviceName
     * @param serviceGroup
     * @return
     */
    private Service findServiceInServiceGroup(String serviceName, ServiceGroup serviceGroup) {
        List<Object> servicesOrGroups = serviceGroup.getServiceGroupOrService();
        for (Object o : servicesOrGroups) {
            if (o instanceof Service) {
                Service service = (Service) o;
                if (service.getName().equals(serviceName)) {
                    return service;
                }
            } else { // Instance of ServiceGroup
                ServiceGroup group = (ServiceGroup) o;
                return findServiceInServiceGroup(serviceName, group);
            }
        }
        return null;
    }
}
