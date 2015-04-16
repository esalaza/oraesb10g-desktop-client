/*
 * MainTabbedWindow.java
 *
 */

package co.frakasoft.oraesb.gui;

import co.frakasoft.oraesb.beans.util.BasicMetadataInfo;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import co.frakasoft.util.ResourceLoader;

/**
 *
 * @author esalaza
 */
public class MainTabbedWindow extends javax.swing.JFrame {

    public MainTabbedWindow() throws Exception {
        initComponents();
        initMoreComponents();
    }

    private void initMoreComponents() throws Exception {
        setIconImage(ResourceLoader.loadImage("/img/brand.png", getClass()));
        progressDialog = new ProgressDialog(this, false);
        progressDialog.setLocationRelativeTo(this);
        pack();
    }

    public javax.swing.JMenuItem getItmMnuHelpAbout() {
        return itmMnuHelpAbout;
    }

    public javax.swing.JMenuItem getItmMnuToolsFlowIdsToFile() {
        return itmMnuToolsFlowIdsToFile;
    }

    public InstanceSearchPanel getInstanceSearchPanel() {
        return instanceSearchPanel;
    }

    public InstanceSearchByOperationPanel getInstanceSearchByOperationPanel() {
        return instanceSearchByOperationPanel;
    }

    public ReportsPanel getReportsPanel() {
        return reportsPanel;
    }

    public ReportsByOperationPanel getReportsByOperationPanel() {
        return reportsByOperationPanel;
    }
    
    public void setStatusText(String statusText) {
        txtStatus.setText(statusText);
    }
    
    public void showInformationDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showWarningDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    public void showAboutDialog() {
        AboutDialog about = new AboutDialog(this, true);
        about.setLocationRelativeTo(this);
        about.setVisible(true);
    }

    public void showProgressDialog() {
        progressDialog.setVisible(true);
    }

    public void hideProgressDialog() {
        progressDialog.setVisible(false);
    }
    
    public File showFileSaveDialog() {
        File file = null;
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            if(file.exists()) {
                if (JOptionPane.showConfirmDialog(
                        this,
                        "¿El archivo ya existe, desea reemplazarlo?\n",
                        "Confirmacion",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION) {
                    file = null;
                }
            }
        }
        return file;
    }

    public void setActionListener(ActionListener listener) {
        itmMnuHelpAbout.addActionListener(listener);
        itmMnuToolsFlowIdsToFile.addActionListener(listener);
        instanceSearchByOperationPanel.setActionListener(listener);
        instanceSearchPanel.setActionListener(listener);
        reportsByOperationPanel.setActionListener(listener);
        reportsPanel.setActionListener(listener);
    }

    public void setServices(BasicMetadataInfo metadata) {
        instanceSearchByOperationPanel.setServices(metadata);
        instanceSearchPanel.setServices(metadata);
        reportsPanel.setServices(metadata);
        reportsByOperationPanel.setServices(metadata);
    }

    public void changeLookAndFeel(String lnfName) {
        try {
            UIManager.setLookAndFeel(lnfName);
            SwingUtilities.updateComponentTreeUI(this);
            pack();
        } catch (Exception e) {
            showErrorDialog(e.getMessage());
        }
    }

    public void maximize() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtStatus = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        try {
            instanceSearchPanel = new co.frakasoft.oraesb.gui.InstanceSearchPanel();
        } catch (java.lang.Exception e1) {
            e1.printStackTrace();
        }
        reportsPanel = new co.frakasoft.oraesb.gui.ReportsPanel();
        try {
            instanceSearchByOperationPanel = new co.frakasoft.oraesb.gui.InstanceSearchByOperationPanel();
        } catch (java.lang.Exception e1) {
            e1.printStackTrace();
        }
        reportsByOperationPanel = new co.frakasoft.oraesb.gui.ReportsByOperationPanel();
        mnuMain = new javax.swing.JMenuBar();
        mnuTools = new javax.swing.JMenu();
        itmMnuToolsFlowIdsToFile = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        itmMnuLAFWindows = new javax.swing.JMenuItem();
        itmMnuLAFMotif = new javax.swing.JMenuItem();
        itmMnuLAFNimbus = new javax.swing.JMenuItem();
        itmMnuLAFNimrod = new javax.swing.JMenuItem();
        itmMnuLAFNapkin = new javax.swing.JMenuItem();
        itmMnuLAFSubstance = new javax.swing.JMenuItem();
        itmMnuLAFLiquid = new javax.swing.JMenuItem();
        itmMnuLAFFH = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();
        itmMnuHelpAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Unofficial ESB Client");

        jTabbedPane1.addTab("ESB Console", instanceSearchPanel);
        jTabbedPane1.addTab("Reports", reportsPanel);
        jTabbedPane1.addTab("ESB Console 2.0", instanceSearchByOperationPanel);
        jTabbedPane1.addTab("Reports (by operation)", reportsByOperationPanel);

        mnuTools.setText("Tools");

        itmMnuToolsFlowIdsToFile.setText("Save flow ids list in file");
        mnuTools.add(itmMnuToolsFlowIdsToFile);

        jMenu1.setText("Change Look and Feel");

        itmMnuLAFWindows.setText("Windows");
        itmMnuLAFWindows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMnuLAFWindowsActionPerformed(evt);
            }
        });
        jMenu1.add(itmMnuLAFWindows);

        itmMnuLAFMotif.setText("Motif");
        itmMnuLAFMotif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMnuLAFMotifActionPerformed(evt);
            }
        });
        jMenu1.add(itmMnuLAFMotif);

        itmMnuLAFNimbus.setText("Nimbus");
        itmMnuLAFNimbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMnuLAFNimbusActionPerformed(evt);
            }
        });
        jMenu1.add(itmMnuLAFNimbus);

        itmMnuLAFNimrod.setText("Nimrod");
        itmMnuLAFNimrod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMnuLAFNimrodActionPerformed(evt);
            }
        });
        jMenu1.add(itmMnuLAFNimrod);

        itmMnuLAFNapkin.setText("Napkin");
        itmMnuLAFNapkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMnuLAFNapkinActionPerformed(evt);
            }
        });
        jMenu1.add(itmMnuLAFNapkin);

        itmMnuLAFSubstance.setText("Substance");
        itmMnuLAFSubstance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMnuLAFSubstanceActionPerformed(evt);
            }
        });
        jMenu1.add(itmMnuLAFSubstance);

        itmMnuLAFLiquid.setText("Liquid");
        itmMnuLAFLiquid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMnuLAFLiquidActionPerformed(evt);
            }
        });
        jMenu1.add(itmMnuLAFLiquid);

        itmMnuLAFFH.setText("FH");
        itmMnuLAFFH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMnuLAFFHActionPerformed(evt);
            }
        });
        jMenu1.add(itmMnuLAFFH);

        mnuTools.add(jMenu1);

        mnuMain.add(mnuTools);

        mnuHelp.setText("Ayuda");

        itmMnuHelpAbout.setText("Acerca de...");
        mnuHelp.add(itmMnuHelpAbout);

        mnuMain.add(mnuHelp);

        setJMenuBar(mnuMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
            .addComponent(txtStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Informes");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itmMnuLAFWindowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMnuLAFWindowsActionPerformed
        changeLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        maximize();
    }//GEN-LAST:event_itmMnuLAFWindowsActionPerformed

    private void itmMnuLAFMotifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMnuLAFMotifActionPerformed
        changeLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        maximize();
    }//GEN-LAST:event_itmMnuLAFMotifActionPerformed

    private void itmMnuLAFNimbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMnuLAFNimbusActionPerformed
        changeLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        maximize();
    }//GEN-LAST:event_itmMnuLAFNimbusActionPerformed

    private void itmMnuLAFNimrodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMnuLAFNimrodActionPerformed
        changeLookAndFeel("com.nilo.plaf.nimrod.NimRODLookAndFeel");
        maximize();
    }//GEN-LAST:event_itmMnuLAFNimrodActionPerformed

    private void itmMnuLAFSubstanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMnuLAFSubstanceActionPerformed
        changeLookAndFeel("org.jvnet.substance.skin.SubstanceBusinessLookAndFeel");
        maximize();
}//GEN-LAST:event_itmMnuLAFSubstanceActionPerformed

    private void itmMnuLAFNapkinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMnuLAFNapkinActionPerformed
        changeLookAndFeel("net.sourceforge.napkinlaf.NapkinLookAndFeel");
        maximize();
    }//GEN-LAST:event_itmMnuLAFNapkinActionPerformed

    private void itmMnuLAFLiquidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMnuLAFLiquidActionPerformed
        changeLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        maximize();
    }//GEN-LAST:event_itmMnuLAFLiquidActionPerformed

    private void itmMnuLAFFHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMnuLAFFHActionPerformed
        changeLookAndFeel("com.shfarr.ui.plaf.fh.FhLookAndFeel");
        maximize();
    }//GEN-LAST:event_itmMnuLAFFHActionPerformed


    private ProgressDialog progressDialog = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private co.frakasoft.oraesb.gui.InstanceSearchByOperationPanel instanceSearchByOperationPanel;
    private co.frakasoft.oraesb.gui.InstanceSearchPanel instanceSearchPanel;
    private javax.swing.JMenuItem itmMnuHelpAbout;
    private javax.swing.JMenuItem itmMnuLAFFH;
    private javax.swing.JMenuItem itmMnuLAFLiquid;
    private javax.swing.JMenuItem itmMnuLAFMotif;
    private javax.swing.JMenuItem itmMnuLAFNapkin;
    private javax.swing.JMenuItem itmMnuLAFNimbus;
    private javax.swing.JMenuItem itmMnuLAFNimrod;
    private javax.swing.JMenuItem itmMnuLAFSubstance;
    private javax.swing.JMenuItem itmMnuLAFWindows;
    private javax.swing.JMenuItem itmMnuToolsFlowIdsToFile;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenuBar mnuMain;
    private javax.swing.JMenu mnuTools;
    private co.frakasoft.oraesb.gui.ReportsByOperationPanel reportsByOperationPanel;
    private co.frakasoft.oraesb.gui.ReportsPanel reportsPanel;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables

}
