package co.frakasoft.oraesb.gui;

import co.frakasoft.oraesb.beans.util.BasicESBEntityInfo;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author esalaza
 */
public class ServiceBrowserTree extends JTree {

    @Override
    public String convertValueToText(Object value,
                                 boolean selected,
                                 boolean expanded,
                                 boolean leaf,
                                 int row,
                                 boolean hasFocus) {
        if (value != null) {
            if (value instanceof DefaultMutableTreeNode) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
                Object userObject = node.getUserObject();
                if(userObject instanceof BasicESBEntityInfo) {
                    return ((BasicESBEntityInfo)userObject).getName();
                } else {
                    return value.toString();
                }
            } else {
                return value.toString();
            }
        }
        return "";
    }

}
