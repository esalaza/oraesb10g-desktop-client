package co.frakasoft.oraesb.gui.renderers;

import co.frakasoft.oraesb.beans.util.OperationState;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.EnumSet;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author esalaza
 */
public class ESBOperationStatusImageTableCellRenderer extends JPanel
        implements TableCellRenderer {

    Border  unselectedBorder                = null;
    Border  selectedBorder                  = null;
    boolean isBordered                      = true;
    private ImageIcon faultIcon             = null;
    private ImageIcon errorIcon             = null;
    private ImageIcon resubmitableIcon      = null;
    private ImageIcon succesfulIcon         = null;
    private ImageIcon runningIcon           = null;
    private ImageIcon notExecutedIcon       = null;
    private ImageIcon previouslyStartedIcon = null;
    private ImageIcon unknownIcon           = null;
    
    public ESBOperationStatusImageTableCellRenderer(boolean isBordered) {
        this.isBordered = isBordered;
        setOpaque(true); //MUST do this for background to show up.
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
    }
    
    public ESBOperationStatusImageTableCellRenderer(
            boolean isBordered,
            ImageIcon faultIcon,
            ImageIcon errorIcon,
            ImageIcon resubmitableIcon,
            ImageIcon succesfulIcon,
            ImageIcon runningIcon,
            ImageIcon notExecutedIcon,
            ImageIcon previouslyStartedIcon,
            ImageIcon unknownIcon) {
        this.isBordered = isBordered;
        setOpaque(true); //MUST do this for background to show up.
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        this.faultIcon = faultIcon;
        this.errorIcon = errorIcon;
        this.resubmitableIcon = resubmitableIcon;
        this.succesfulIcon = succesfulIcon;
        this.runningIcon = runningIcon;
        this.notExecutedIcon = notExecutedIcon;
        this.previouslyStartedIcon = previouslyStartedIcon;
        this.unknownIcon = unknownIcon;
    }

    public Component getTableCellRendererComponent(
            JTable table, Object operationStatus,
            boolean isSelected, boolean hasFocus,
            int row, int column) {
        EnumSet status = (EnumSet) operationStatus;
        removeAll();

        if (isBordered) {
            if (isSelected) {
                if (selectedBorder == null) {
                    selectedBorder = BorderFactory.createMatteBorder(2, 5, 2, 5,
                            table.getSelectionBackground());
                }
                setBorder(selectedBorder);
            } else {
                if (unselectedBorder == null) {
                    unselectedBorder = BorderFactory.createMatteBorder(2, 5, 2, 5,
                            table.getBackground());
                }
                setBorder(unselectedBorder);
            }
        } else {
            if(isSelected) {
                setBackground(table.getSelectionBackground());
            } else {
                setBackground(table.getBackground());
            }
        }

        JLabel[] possibleStatesLabels = new JLabel[8];
        // 0. fault
        // 1. error
        // 2. resubmitable
        // 3. succesful
        // 4. running
        // 5. notExecuted
        // 6. previouslyStartted
        // 7. unknownIcon

        setToolTipText(status.toString());
        if(status.contains(OperationState.HAS_FAULTS)) {
            possibleStatesLabels[0] = new JLabel(faultIcon);
        }
        if(status.contains(OperationState.HAS_ERRORS)) {
            possibleStatesLabels[1] = new JLabel(errorIcon);
        }
        if(status.contains(OperationState.HAS_ERRORS_AND_IS_RETRYABLE)) {
            possibleStatesLabels[2] = new JLabel(resubmitableIcon);
        }
        if(status.contains(OperationState.SUCCESFUL)) {
            possibleStatesLabels[3] = new JLabel(succesfulIcon);
        }
        if(status.contains(OperationState.RUNNING)) {
            possibleStatesLabels[4] = new JLabel(runningIcon);
        }
        if(status.contains(OperationState.NOT_EXECUTED)) {
            possibleStatesLabels[5] = new JLabel(notExecutedIcon);
        }
        if(status.contains(OperationState.PREVIOUSLY_STARTED)) {
            possibleStatesLabels[6] = new JLabel(previouslyStartedIcon);
        }
        if(status.contains(OperationState.UNKNOWN)) {
            possibleStatesLabels[7] = new JLabel(unknownIcon);
        }
        
        for (JLabel label : possibleStatesLabels) {
            if (label != null) {
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setOpaque(true);
                if (isSelected) {
                    label.setBackground(table.getSelectionBackground());
                } else {
                    label.setBackground(table.getBackground());
                }
                add(label);
            }
        }
        
        return this;
    }
}

