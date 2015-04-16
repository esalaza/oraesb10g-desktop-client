package co.frakasoft.oraesb.util;

import co.frakasoft.oraesb.beans.service.Metadata;
import co.frakasoft.oraesb.beans.service.Service;
import co.frakasoft.oraesb.beans.service.ServiceGroup;
import co.frakasoft.oraesb.beans.service.System;
import co.frakasoft.oraesb.beans.util.BasicESBEntityInfo;
import co.frakasoft.oraesb.beans.util.BasicMetadataInfo;
import co.frakasoft.oraesb.beans.util.BasicServiceGroupInfo;
import co.frakasoft.oraesb.beans.util.BasicServiceInfo;
import co.frakasoft.oraesb.beans.util.BasicSystemInfo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esalaza
 */
public class BeansUtil {
	
    public static List<BasicESBEntityInfo> getBasicESBEntitiesFromBasicMetadata(BasicMetadataInfo metadata) {
        List<BasicESBEntityInfo> esbEntities = new ArrayList<BasicESBEntityInfo>();
        List<BasicSystemInfo> systems = metadata.getSystems();
        for(BasicSystemInfo system : systems) {
            esbEntities.add(system);
            esbEntities.addAll(getBasicESBEntitiesFromBasicSystem(system));
        }
        return esbEntities;
    }

    public static List<BasicESBEntityInfo> getBasicESBEntitiesFromBasicSystem(BasicSystemInfo system) {
        List<BasicESBEntityInfo> esbEntities = new ArrayList<BasicESBEntityInfo>();
        List<Object> serviceGroupsOrServices = system.getServiceGroupsOrServices();
        for (Object serviceGroupOrService : serviceGroupsOrServices) {
            esbEntities.add((BasicESBEntityInfo) serviceGroupOrService);
            if (serviceGroupOrService instanceof BasicServiceGroupInfo) {
                esbEntities.addAll(getBasicESBEntitiesFromBasicServiceGroup((BasicServiceGroupInfo) serviceGroupOrService));
            } else if (serviceGroupOrService instanceof BasicServiceInfo) {
                esbEntities.addAll(getBasicESBEntitiesFromBasicService((BasicServiceInfo) serviceGroupOrService));
            }
        }
        return esbEntities;
    }

    public static List<BasicESBEntityInfo> getBasicESBEntitiesFromBasicServiceGroup(BasicServiceGroupInfo serviceGroup) {
        List<BasicESBEntityInfo> esbEntities = new ArrayList<BasicESBEntityInfo>();
        List<Object> serviceGroupsOrServices = serviceGroup.getServiceGroupsOrServices();
        for(Object serviceGroupOrService : serviceGroupsOrServices) {
            esbEntities.add((BasicESBEntityInfo)serviceGroupOrService);
            if(serviceGroupOrService instanceof BasicServiceGroupInfo) {
                esbEntities.addAll(getBasicESBEntitiesFromBasicServiceGroup((BasicServiceGroupInfo)serviceGroupOrService));
            } else if(serviceGroupOrService instanceof BasicServiceInfo) {
                esbEntities.addAll(getBasicESBEntitiesFromBasicService((BasicServiceInfo)serviceGroupOrService));
            }
        }
        return esbEntities;
    }

    public static List<BasicESBEntityInfo> getBasicESBEntitiesFromBasicService(BasicServiceInfo service) {
        List<BasicESBEntityInfo> esbEntities = new ArrayList<BasicESBEntityInfo>(service.getOperations());
        return esbEntities;
    }
    
    public static BasicSystemInfo system2BasicSystem(System system) {
        BasicSystemInfo basicSystem = new BasicSystemInfo();
        basicSystem.setName(system.getName());
        basicSystem.setDescription(system.getDescription());
        basicSystem.setId(system.getGuid());
        List<Object> serviceGroupsOrServices = system.getServiceGroupOrService();
        List<Object> basicServiceGroupsOrServices = new ArrayList<Object>();
        for(Object serviceGroupOrService : serviceGroupsOrServices) {
            if(serviceGroupOrService instanceof ServiceGroup) {
                BasicServiceGroupInfo basicServiceGroupInfo =
                        serviceGroup2BasicServiceGroup((ServiceGroup)serviceGroupOrService);
                basicServiceGroupInfo.setSystem(basicSystem);
                basicServiceGroupsOrServices.add(basicServiceGroupInfo);
            } else if(serviceGroupOrService instanceof Service) {
                BasicServiceInfo basicServiceInfo =
                        service2BasicService((Service)serviceGroupOrService);
                basicServiceInfo.setSystem(basicSystem);
                basicServiceGroupsOrServices.add(basicServiceInfo);
            }
        }
        basicSystem.setServiceGroupsOrServices(basicServiceGroupsOrServices);
        return basicSystem;
    }
    
    public static BasicServiceGroupInfo serviceGroup2BasicServiceGroup(ServiceGroup serviceGroup) {
        BasicServiceGroupInfo basicServiceGroup = new BasicServiceGroupInfo();
        basicServiceGroup.setDescription(serviceGroup.getDescription());
        basicServiceGroup.setName(serviceGroup.getName());
        basicServiceGroup.setId(serviceGroup.getGuid());
        List<Object> serviceGroupsOrServices = serviceGroup.getServiceGroupOrService();
        List<Object> basicServiceGroupsOrServices = new ArrayList<Object>();
        for(Object serviceGroupOrService : serviceGroupsOrServices) {
            if(serviceGroupOrService instanceof ServiceGroup) {
                basicServiceGroupsOrServices.add(
                        serviceGroup2BasicServiceGroup((ServiceGroup)serviceGroupOrService));
            } else if(serviceGroupOrService instanceof Service) {
                basicServiceGroupsOrServices.add(
                        service2BasicService((Service)serviceGroupOrService));
            }
        }
        basicServiceGroup.setServiceGroupsOrServices(basicServiceGroupsOrServices);
        return basicServiceGroup;
    }
    
    public static BasicServiceInfo service2BasicService(Service service) {
        BasicServiceInfo basicService = new BasicServiceInfo();
        basicService.setName(service.getName());
        basicService.setDescription(service.getDescription());
        basicService.setId(service.getGuid());
        return basicService;
    }
}
