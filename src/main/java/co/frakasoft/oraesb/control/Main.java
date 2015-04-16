package co.frakasoft.oraesb.control;

import co.frakasoft.oraesb.beans.util.BasicMetadataInfo;
import co.frakasoft.oraesb.client.ESBClient;
import co.frakasoft.oraesb.db.client.ESBDBClient;
import co.frakasoft.oraesb.gui.ConnectionManagerDialog;
import co.frakasoft.oraesb.gui.ConnectionManagerPanel;
import co.frakasoft.oraesb.gui.MainTabbedWindow;
import co.frakasoft.oraesb.gui.TextAreaDialog;
import co.frakasoft.oraesb.gui.listeners.ConnectionManagerListener;
import co.frakasoft.oraesb.gui.listeners.MainListener;
import co.frakasoft.oraesb.util.ConnectionInfo;
import co.frakasoft.oraesb.util.DatabaseConnectionInfo;
import co.frakasoft.oraesb.util.SettingsManager;
import co.frakasoft.oraesb.util.SettingsManagerFactory;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author esalaza
 */
public class Main {

    public static void main(String[] args) throws Exception {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                try {
                    tryLookAndFeel("com.nilo.plaf.nimrod.NimRODLookAndFeel");
                    
                    boolean existConnectionSettings = false;

                    SettingsManager settingsManager = SettingsManagerFactory.getSettingsManager();
                    ArrayList<ConnectionInfo> connectionsInfo = settingsManager.getConnectionsInfo();

                    if(connectionsInfo == null) {
                        connectionsInfo = new ArrayList<ConnectionInfo>();
                    }

                    ConnectionManagerPanel connManagerPanel = new ConnectionManagerPanel();
                    connManagerPanel.setConnectionsInfo(connectionsInfo);
                    ConnectionManagerDialog connManagerDialog = new ConnectionManagerDialog(connManagerPanel);
                    ConnectionManagerListener connManagerListener = new ConnectionManagerListener();
                    connManagerPanel.setActionListener(connManagerListener);
                    connManagerListener.setConnectionManagerPanel(connManagerPanel);
                    connManagerListener.setConnectionManagerDialog(connManagerDialog);
                    connManagerListener.setSettingsManager(settingsManager);

                    if (connectionsInfo.size() == 0) {
                        JOptionPane.showMessageDialog(
                                null,
                                "There are not connection configurations",
                                "Message",
                                JOptionPane.INFORMATION_MESSAGE);
                        while (!existConnectionSettings) {
                            connManagerDialog.setVisible(true);
                            if(connectionsInfo.size() != 0) {
                                existConnectionSettings = true;
                            }
                        }
                    } else {
                        existConnectionSettings = true;
                        connManagerDialog.setVisible(true);
                    }

                    ConnectionInfo connectionInfo = connManagerPanel.getCurrentConnectionInfo();
                    DatabaseConnectionInfo  db = connectionInfo.getDatabaseConnectionInfo();

                    ESBClient client = null;
                    ESBDBClient dbClient = null;

                    try {
                        dbClient = new ESBDBClient(
                                db.getHost(),
                                Integer.parseInt(db.getPort()),
                                db.getSid(),
                                db.getUsername(),
                                db.getPassword());
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Error:\n" + e,
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                        System.exit(1);
                    }

                    MainListener listener = new MainListener();
                    listener.setESBClient(client);
                    listener.setESBDBClient(dbClient);

                    BasicMetadataInfo basicMetadata = dbClient.exploreServices();

                    initializeAndShowMainGUI(listener, basicMetadata);


                } catch (Exception ex) {
                    System.out.println("Exception: " + ex);
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void initializeAndShowMainGUI(MainListener listener, BasicMetadataInfo basicMetadata) throws Exception {

                    MainTabbedWindow mainWindow = new MainTabbedWindow();
                    mainWindow.setActionListener(listener);

                    listener.setMainTabbedWindow(mainWindow);

                    mainWindow.setServices(basicMetadata);

                    // Move to MainTabbedWindow
                    TextAreaDialog textAreaDialog = new TextAreaDialog(mainWindow, true);
                    listener.setTextAreaDialog(textAreaDialog);
                    textAreaDialog.setActionListener(listener);
                    textAreaDialog.setLocationRelativeTo(mainWindow);

                    mainWindow.pack();
                    mainWindow.setLocationRelativeTo(null);
                    mainWindow.maximize();
                    mainWindow.setVisible(true);
    }

    public static void tryLookAndFeel(String lnfName) {
        try {
            UIManager.setLookAndFeel(lnfName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
