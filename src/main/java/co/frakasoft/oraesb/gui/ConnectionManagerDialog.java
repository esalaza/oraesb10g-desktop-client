package co.frakasoft.oraesb.gui;

import java.awt.BorderLayout;
import javax.swing.JDialog;

/**
 *
 * @author esalaza
 */
public class ConnectionManagerDialog extends JDialog {

    private ConnectionManagerPanel connectionManagerPanel = null;
    
    public ConnectionManagerDialog(ConnectionManagerPanel connectionManagerPanel) {
        this.connectionManagerPanel = connectionManagerPanel;
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        add(connectionManagerPanel, BorderLayout.CENTER);
        pack();
        setResizable(false);
        setModal(true);
        setLocationRelativeTo(null);
    }
    
    public ConnectionManagerPanel getConnectionManagerPanel() {
        return connectionManagerPanel;
    }
    
}
