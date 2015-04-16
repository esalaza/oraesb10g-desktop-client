/*
 * InstanceSearchPanel.java
 *
 */

package co.frakasoft.oraesb.gui;

import co.frakasoft.oraesb.beans.service.Metadata;
import co.frakasoft.oraesb.beans.util.BasicESBEntityInfo;
import co.frakasoft.oraesb.beans.util.BasicESBInstanceInfo;
import co.frakasoft.oraesb.beans.util.BasicMetadataInfo;
import co.frakasoft.oraesb.beans.util.BasicServiceInfo;
import co.frakasoft.oraesb.db.client.ESBDBClient;
import co.frakasoft.oraesb.gui.models.InstanceListTableModel;
import co.frakasoft.oraesb.gui.renderers.ColorRenderer;
import co.frakasoft.oraesb.gui.renderers.ESBInstanceImageTableCellRenderer;
import co.frakasoft.util.TimeUtils;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.util.EventListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import co.frakasoft.util.ResourceLoader;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author esalaza
 */
public class InstanceSearchPanel
        extends javax.swing.JPanel {

    public InstanceSearchPanel() throws Exception {
        initComponents();
        initMoreComponents();
    }

    private void initMoreComponents() throws Exception {
        InstanceListTableModel model = new InstanceListTableModel();
        ESBInstanceImageTableCellRenderer cellRenderer = new ESBInstanceImageTableCellRenderer(false,
                new ImageIcon(ResourceLoader.loadImage("/img/status_faulted.gif", getClass())),
                new ImageIcon(ResourceLoader.loadImage("/img/status_errored.gif", getClass())),
                new ImageIcon(ResourceLoader.loadImage("/img/resubmittable_error.gif", getClass())),
                new ImageIcon(ResourceLoader.loadImage("/img/error_faulted.gif", getClass())),
                new ImageIcon(ResourceLoader.loadImage("/img/resubmittable_error_faulted.gif", getClass())),
                new ImageIcon(ResourceLoader.loadImage("/img/status_noerrors_nofaults.gif", getClass())),
                new ImageIcon(ResourceLoader.loadImage("/img/unknown.gif", getClass())));
        tblInstances.setDefaultRenderer(Color.class, new ColorRenderer(true));
        tblInstances.setDefaultRenderer(BasicESBInstanceInfo.class, cellRenderer);
        tblInstances.setModel(model);
        txtStartHour.setValue("00:00:00");
        txtEndHour.setValue("00:00:00");
        serviceBrowserPanel.getServiceBrowserTree().getSelectionModel()
                .setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        serviceBrowserPanel.getServiceBrowserTree().setEnabled(false);
        chkEnableServiceElection.setSelected(false);
        // se estan portando mal :-(
        GregorianCalendar calendar = new GregorianCalendar();
        jxdateStartDate.setPreferredSize(new Dimension(133, 24));
        jxdateStartDate.setMaximumSize(new Dimension(133, 24));
        jxdateStartDate.setMinimumSize(new Dimension(133, 24));
        jxdateStartDate.setDate(calendar.getTime());
        jxdateEndDate.setPreferredSize(new Dimension(133, 24));
        jxdateEndDate.setMaximumSize(new Dimension(133, 24));
        jxdateEndDate.setMinimumSize(new Dimension(133, 24));
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        jxdateEndDate.setDate(calendar.getTime());
        disableRetryControls();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMainForm = new javax.swing.JPanel();
        lblStartDate = new javax.swing.JLabel();
        jxdateStartDate = new org.jdesktop.swingx.JXDatePicker();
        jxdateEndDate = new org.jdesktop.swingx.JXDatePicker();
        lblEndDate = new javax.swing.JLabel();
        lblStartHour = new javax.swing.JLabel();
        lblEndHour = new javax.swing.JLabel();
        lblState = new javax.swing.JLabel();
        cmbState = new javax.swing.JComboBox();
        btnSearch = new javax.swing.JButton();
        serviceBrowserPanel = new co.frakasoft.oraesb.gui.ServiceBrowserPanel();
        chkEnableServiceElection = new javax.swing.JCheckBox();
        txtStartHour = new javax.swing.JFormattedTextField(createFormatter("##:##:##"));
        txtEndHour = new javax.swing.JFormattedTextField(createFormatter("##:##:##"));
        scrlTableInstances = new javax.swing.JScrollPane();
        tblInstances = new javax.swing.JTable();
        btnRetry = new javax.swing.JButton();
        lblDelay = new javax.swing.JLabel();
        txtRetry = new javax.swing.JTextField();

        pnlMainForm.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblStartDate.setText("Start Date");

        jxdateStartDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jxdateStartDateActionPerformed(evt);
            }
        });

        jxdateEndDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jxdateEndDateActionPerformed(evt);
            }
        });

        lblEndDate.setText("End Date");

        lblStartHour.setText("Start Time");

        lblEndHour.setText("End Time");

        lblState.setText("Status");

        cmbState.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Any", "Has errors", "Has faults", "Is retryable" }));

        btnSearch.setText("Search");

        chkEnableServiceElection.setText("Choose service");
        chkEnableServiceElection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEnableServiceElectionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMainFormLayout = new javax.swing.GroupLayout(pnlMainForm);
        pnlMainForm.setLayout(pnlMainFormLayout);
        pnlMainFormLayout.setHorizontalGroup(
            pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(serviceBrowserPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(chkEnableServiceElection, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbState, javax.swing.GroupLayout.Alignment.LEADING, 0, 230, Short.MAX_VALUE)
                    .addComponent(lblState, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMainFormLayout.createSequentialGroup()
                        .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtStartHour)
                            .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jxdateStartDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblStartHour, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(lblStartDate)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblEndDate)
                            .addComponent(lblEndHour)
                            .addComponent(jxdateEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEndHour)))
                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlMainFormLayout.setVerticalGroup(
            pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStartDate)
                    .addComponent(lblEndDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jxdateStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxdateEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStartHour)
                    .addComponent(lblEndHour))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStartHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblState)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkEnableServiceElection)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serviceBrowserPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addContainerGap())
        );

        tblInstances.setModel(new InstanceListTableModel());
        scrlTableInstances.setViewportView(tblInstances);

        btnRetry.setText("Retry");

        lblDelay.setText("Delay (sg)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlMainForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblDelay)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtRetry, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnRetry, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                        .addComponent(scrlTableInstances, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlMainForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(scrlTableInstances, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblDelay)
                                .addComponent(txtRetry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnRetry))))
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chkEnableServiceElectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEnableServiceElectionActionPerformed
        if (chkEnableServiceElection.isSelected()) {
            serviceBrowserPanel.getServiceBrowserTree().setEnabled(true);
        } else {
            serviceBrowserPanel.getServiceBrowserTree().setEnabled(false);
            serviceBrowserPanel.getServiceBrowserTree().setSelectionPath(null);
        }
}//GEN-LAST:event_chkEnableServiceElectionActionPerformed

    private void jxdateStartDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jxdateStartDateActionPerformed
        // :-(
        // Se esta redimensionando solo al ingresar el panel en un JTabbedPane
        jxdateStartDate.setPreferredSize(new Dimension(133, 24));
        jxdateStartDate.setMaximumSize(new Dimension(133, 24));
        jxdateStartDate.setMinimumSize(new Dimension(133, 24));
    }//GEN-LAST:event_jxdateStartDateActionPerformed

    private void jxdateEndDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jxdateEndDateActionPerformed
        // :-(
        // Se esta redimensionando solo al ingresar el panel en un JTabbedPane
        jxdateEndDate.setPreferredSize(new Dimension(133, 24));
        jxdateEndDate.setMaximumSize(new Dimension(133, 24));
        jxdateEndDate.setMinimumSize(new Dimension(133, 24));
    }//GEN-LAST:event_jxdateEndDateActionPerformed
    
    // Get (no todos son JavaBean) =============================================

    public JTable getInstancesTable() {
        return tblInstances;
    }

    public javax.swing.JButton getSearchButton() {
        return btnSearch;
    }

    public javax.swing.JButton getRetryButton() {
        return btnRetry;
    }

    public Date getEndDate() {
        return jxdateEndDate.getDate();
    }

    public Date getStartDate() {
        return jxdateStartDate.getDate();
    }

    public ServiceBrowserPanel getServiceBrowserPanel() {
        return serviceBrowserPanel;
    }

    public int getSearchMode() {
        int selectedIndex = cmbState.getSelectedIndex();
        switch (selectedIndex) {
            case 0: // todos
                return ESBDBClient.ANY_STATUS;
            case 1:
                return ESBDBClient.ERROR_STATUS;
            case 2:
                return ESBDBClient.FAULTED_STATUS;
            case 3:
                return ESBDBClient.RESUBMITABLE_STATUS;
            case 4:
                return ESBDBClient.OK_STATUS;
            case 5:
                return ESBDBClient.NOT_EXECUTED_OPERATION_STATUS;
            case 6:
                return ESBDBClient.EXECUTED_OPERATION_STATUS;
        }
        return -1;
    }

    public long getStartTime() {
        long time = 0;
        try {
            time = TimeUtils.parseTime(txtStartHour.getValue().toString());
        } catch (Exception e) {
            e.printStackTrace();
            time = -1;
        }
        return time;
    }

    public long getEndTime() {
        long time = 0;
        try {
            time = TimeUtils.parseTime(txtEndHour.getValue().toString());
        } catch (Exception e) {
            e.printStackTrace();
            time = -1;
        }
        return time;
    }

    public boolean isServiceElectionEnabled() {
        return serviceBrowserPanel.getServiceBrowserTree().isEnabled();
    }

    public String[] getFlowIds() {
        String[] flowIds = null;
        TableModel model = tblInstances.getModel();
        flowIds = new String[model.getRowCount()];
        for (int i = 0; i < flowIds.length; i++) {
            flowIds[i] = (String) model.getValueAt(i, InstanceListTableModel.FLOW_ID);
        }
        return flowIds;
    }

    public BasicServiceInfo getSelectedService() {
        BasicServiceInfo service = null;
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)serviceBrowserPanel.getServiceBrowserTree().getLastSelectedPathComponent();
        //if (selectedNode != null && selectedNode.isLeaf()) {
        //    service = (BasicServiceInfo) selectedNode.getUserObject();
        //}
        if(selectedNode != null) {
            BasicESBEntityInfo entity = (BasicESBEntityInfo)selectedNode.getUserObject();
            if(entity instanceof BasicServiceInfo) service = (BasicServiceInfo)entity;
        }
        return service;
    }

    // Set (no todos son JavaBean) =============================================

    public void setServices(Metadata metadata) {
        // Mejorar
        //realServiceBrowserPanel.getServiceBrowserTree().addTreeSelectionListener(this);
        serviceBrowserPanel.setMetadata(metadata);
        serviceBrowserPanel.setOpaque(true);
        if (!chkEnableServiceElection.isSelected()) {
            serviceBrowserPanel.getServiceBrowserTree().setEnabled(false);
        }
    }

    public void setServices(BasicMetadataInfo metadata) {
        // Mejorar
        //realServiceBrowserPanel.getServiceBrowserTree().addTreeSelectionListener(this);
        serviceBrowserPanel.setMetadata(metadata);
        serviceBrowserPanel.setOpaque(true);
        if (!chkEnableServiceElection.isSelected()) {
            serviceBrowserPanel.getServiceBrowserTree().setEnabled(false);
        }
    }

    public void setInstances(List<BasicESBInstanceInfo> instances) {
        ((InstanceListTableModel) tblInstances.getModel()).setInstanceList(instances);
    }

    public void setActionListener(EventListener listener) {
        ActionListener actionListener = (ActionListener) listener;
        btnSearch.addActionListener(actionListener);
        btnRetry.addActionListener(actionListener);
        TreeSelectionListener treeSelectionListener = (TreeSelectionListener) listener;
        serviceBrowserPanel.getServiceBrowserTree().addTreeSelectionListener(treeSelectionListener);
    }

    
    // Util ====================================================================

    protected MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.err.println("Formatter is bad: " + exc.getMessage());
        }
        return formatter;
    }

    // GUI =====================================================================

    public void disableRetryControls() {
        txtRetry.setEnabled(false);
        btnRetry.setEnabled(false);
    }

    public void enableRetryControls() {
        txtRetry.setEnabled(true);
        btnRetry.setEnabled(true);
    }

    // Pasar a la ventana principal
    public void showInformationDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showWarningDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Advertencia", JOptionPane.WARNING_MESSAGE);
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

    // Validations =============================================================

    public boolean validateForSearch() {
        Date startDate = getStartDate();
        Date endDate = getEndDate();
        String startHour = txtStartHour.getValue().toString();
        String endHour = txtEndHour.getValue().toString();

        if (startDate == null && endDate == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor especifique la o las fechas",
                    "Faltan datos",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        if (endDate == null) {
            if (JOptionPane.showConfirmDialog(
                    this,
                    "¿Esta seguro que desea especificar solo la fecha inicial?\n" +
                    "La consulta a BD puede ser muy pesada!",
                    "Confirmacion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION) {
                return false;
            }
        }

        if (startDate == null) {
            if (JOptionPane.showConfirmDialog(
                    this,
                    "¿Esta seguro que desea especificar solo la fecha final?\n" +
                    "La consulta a BD puede ser muy pesada!",
                    "Confirmacion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION) {
                return false;
            }
        }

        if (startDate != null && endDate != null) {
            if (endDate.before(startDate)) {
                JOptionPane.showMessageDialog(
                        this,
                        "La fecha final es menor que la fecha inicial",
                        "Error",
                        JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
            long difference = endDate.getTime() - startDate.getTime();
            // 15 dias = 1.296'000.000 de milisegundos
            if (difference >= 1296000000L) {
                if (JOptionPane.showConfirmDialog(
                        this,
                        "¿Esta seguro que desea hacer una consulta mayor a 15 dias?\n" +
                        "La consulta a BD puede ser muy pesada!",
                        "Confirmacion",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION) {
                    return false;
                }
            }
        }

        try {
            TimeUtils.parseTime(startHour);
            TimeUtils.parseTime(endHour);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor revise el formato de la hora ingresada",
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        if (isServiceElectionEnabled()) {
            if ((DefaultMutableTreeNode)serviceBrowserPanel.getServiceBrowserTree().getLastSelectedPathComponent() == null
                    || !((DefaultMutableTreeNode)serviceBrowserPanel.getServiceBrowserTree().getLastSelectedPathComponent()).isLeaf()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Por favor elija un servicio",
                        "Faltan datos",
                        JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        }

        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRetry;
    private javax.swing.JButton btnSearch;
    private javax.swing.JCheckBox chkEnableServiceElection;
    private javax.swing.JComboBox cmbState;
    private org.jdesktop.swingx.JXDatePicker jxdateEndDate;
    private org.jdesktop.swingx.JXDatePicker jxdateStartDate;
    private javax.swing.JLabel lblDelay;
    private javax.swing.JLabel lblEndDate;
    private javax.swing.JLabel lblEndHour;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblStartHour;
    private javax.swing.JLabel lblState;
    private javax.swing.JPanel pnlMainForm;
    private javax.swing.JScrollPane scrlTableInstances;
    private co.frakasoft.oraesb.gui.ServiceBrowserPanel serviceBrowserPanel;
    private javax.swing.JTable tblInstances;
    private javax.swing.JFormattedTextField txtEndHour;
    private javax.swing.JTextField txtRetry;
    private javax.swing.JFormattedTextField txtStartHour;
    // End of variables declaration//GEN-END:variables

}
