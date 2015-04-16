package co.frakasoft.oraesb.gui.listeners;

import co.frakasoft.oraesb.gui.ConnectionManagerDialog;
import co.frakasoft.oraesb.gui.ConnectionManagerPanel;
import co.frakasoft.oraesb.util.ConnectionInfo;
import co.frakasoft.oraesb.util.SettingsManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author esalaza
 */
public class ConnectionManagerListener implements ActionListener {

    private ConnectionManagerPanel connectionManagerPanel = null;
    private ConnectionManagerDialog connectionManagerDialog = null;
    private SettingsManager settingsManager = null;

    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == getConnectionManagerPanel().getBtnCancel()) {
            // Cancelar --------------------------------------------------------
            System.exit(0);
            //------------------------------------------------------------------
        } else if(e.getSource() == getConnectionManagerPanel().getBtnConnect()) {
            // Conectar  -------------------------------------------------------
            connectionManagerDialog.setVisible(false);
            //------------------------------------------------------------------
        } else if(e.getSource() == getConnectionManagerPanel().getBtnDelete()) {
            // Eliminar  -------------------------------------------------------
            connectionManagerPanel.deleteSelectedConnectionInfo();
            //------------------------------------------------------------------
        } else if(e.getSource() == getConnectionManagerPanel().getBtnSave()) {
            // Guardar ---------------------------------------------------------
            if(connectionManagerPanel.validateFields()) {
                connectionManagerPanel.createOrSaveConnectionInfo();
                ArrayList<ConnectionInfo> connectionsInfo = connectionManagerPanel.getConnectionsInfo();
                settingsManager.setConnectionsInfo(connectionsInfo);
            }
            //------------------------------------------------------------------
        } else if(e.getSource() == getConnectionManagerPanel().getBtnAppSrvTest()) {
            // Probar conexion a Application Server ----------------------------
            connectionManagerPanel.setAppServerConnectionTestStatus("No implementado", true);
            //------------------------------------------------------------------
        } else if(e.getSource() == getConnectionManagerPanel().getBtnDBTest()) {
            // Probar conexion a Base de Datos ---------------------------------
            connectionManagerPanel.setDatabaseConnectionTestStatus("No implementado", true);
            //------------------------------------------------------------------
        }
    }

    public ConnectionManagerPanel getConnectionManagerPanel() {
        return connectionManagerPanel;
    }

    public void setConnectionManagerPanel(ConnectionManagerPanel connectionManagerPanel) {
        this.connectionManagerPanel = connectionManagerPanel;
    }

    public SettingsManager getSettingsManager() {
        return settingsManager;
    }

    public void setSettingsManager(SettingsManager settingsManager) {
        this.settingsManager = settingsManager;
    }

    public void setConnectionManagerDialog(ConnectionManagerDialog connectionManagerDialog) {
        this.connectionManagerDialog = connectionManagerDialog;
    }


}
