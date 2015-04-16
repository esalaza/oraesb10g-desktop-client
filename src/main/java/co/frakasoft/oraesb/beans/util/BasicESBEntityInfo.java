package co.frakasoft.oraesb.beans.util;

/**
 *
 * @author esalaza
 */
public class BasicESBEntityInfo {
    
    private String name;
    private String id;
    private String description;
    private BasicESBEntityInfo owner;  // null if it is system or a ServiceGroup without owner
    private BasicSystemInfo system; // null if it is system
    
    public BasicESBEntityInfo() {
        
    }

    public BasicESBEntityInfo(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BasicESBEntityInfo getOwner() {
        return owner;
    }

    public void setOwner(BasicESBEntityInfo owner) {
        this.owner = owner;
    }

    public BasicSystemInfo getSystem() {
        return system;
    }

    public void setSystem(BasicSystemInfo system) {
        this.system = system;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: " + id);
        sb.append("\n");
        sb.append("Name: " + name);
        sb.append("\n");
        sb.append("Description: " + description);
        sb.append("\n");
        if(owner != null) {
            sb.append("Owner: " + owner.getId() + ", " + owner.getName());
        } else {
            sb.append("Owner: null");
        }
        sb.append("\n");
        if(system != null) {
            sb.append("System: " + system.getId() + ", " + system.getName());
        } else {
            sb.append("System: null");
        }
        sb.append("\n");
        return sb.toString();
    }

}
