package co.frakasoft.oraesb.gui.renderers;

import co.frakasoft.oraesb.beans.util.BasicServiceGroupInfo;
import co.frakasoft.oraesb.beans.util.BasicServiceInfo;
import co.frakasoft.oraesb.beans.util.BasicSystemInfo;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author esalaza
 */
public class OperationTreeRenderer extends DefaultTreeCellRenderer {

    private Icon systemIcon;
    private Icon serviceGroupIcon;
    private Icon serviceIcon;
    private Icon operationIcon;
    private Icon rootIcon;

    @Override
    public Component getTreeCellRendererComponent(
            JTree tree,
            Object value,
            boolean sel,
            boolean expanded,
            boolean leaf,
            int row,
            boolean hasFocus) {

        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        
        Object entity = node.getUserObject();
        
        if(entity instanceof String) {
            setIcon(rootIcon);
        } else if(entity instanceof BasicSystemInfo) {
            setIcon(systemIcon);
        } else if(entity instanceof BasicServiceGroupInfo) {
            setIcon(serviceGroupIcon);
        } else if(entity instanceof BasicServiceInfo) {
            setIcon(serviceIcon);
        } else {
            setIcon(operationIcon);
        }
        
        return this;
    }

    public void setSystemIcon(Icon systemIcon) {
        this.systemIcon = systemIcon;
    }

    public void setServiceGroupIcon(Icon serviceGroupIcon) {
        this.serviceGroupIcon = serviceGroupIcon;
    }

    public void setServiceIcon(Icon serviceIcon) {
        this.serviceIcon = serviceIcon;
    }

    public void setOperationIcon(Icon operationIcon) {
        this.operationIcon = operationIcon;
    }

    /**
     * @param rootIcon the rootIcon to set
     */
    public void setRootIcon(Icon rootIcon) {
        this.rootIcon = rootIcon;
    }
}
