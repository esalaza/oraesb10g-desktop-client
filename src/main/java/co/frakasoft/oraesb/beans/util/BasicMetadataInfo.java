package co.frakasoft.oraesb.beans.util;

import java.util.ArrayList;

/**
 *
 * @author esalaza
 */
public class BasicMetadataInfo {

    private ArrayList<BasicSystemInfo> systems = new ArrayList<BasicSystemInfo>();

    public ArrayList<BasicSystemInfo> getSystems() {
        return systems;
    }

    public void setSystems(ArrayList<BasicSystemInfo> systems) {
        this.systems = systems;
    }

    public void addSystem(BasicSystemInfo system) {
        systems.add(system);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(BasicSystemInfo system : systems) {
            sb.append(system + "\n");
        }
        return sb.toString();
    }

}
