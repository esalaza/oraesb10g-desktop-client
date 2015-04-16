package co.frakasoft.oraesb.gui.renderers;

import co.frakasoft.oraesb.beans.util.BasicESBInstanceInfo;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

/**
 *
 * @author esalaza
 */
public class ESBInstanceImageTableCellRenderer extends JLabel
        implements TableCellRenderer {

    Border  unselectedBorder                        = null;
    Border  selectedBorder                          = null;
    boolean isBordered                              = true;
    private ImageIcon faultIcon                     = null;
    private ImageIcon errorIcon                     = null;
    private ImageIcon resubmitableErrorIcon         = null;
    private ImageIcon faultErrorIcon                = null;
    private ImageIcon resubmitableFaultErrorIcon    = null;
    private ImageIcon okIcon                        = null;
    private ImageIcon unknownIcon                   = null;
    
    public ESBInstanceImageTableCellRenderer(boolean isBordered) {
        this.isBordered = isBordered;
        setOpaque(true); //MUST do this for background to show up.
    }
    
    public ESBInstanceImageTableCellRenderer(
            boolean isBordered,
            ImageIcon faultIcon,
            ImageIcon errorIcon,
            ImageIcon resubmitableErrorIcon,
            ImageIcon faultErrorIcon,
            ImageIcon resubmitableFaultErrorIcon,
            ImageIcon okIcon,
            ImageIcon unknownIcon) {
        this.isBordered = isBordered;
        setOpaque(true); //MUST do this for background to show up.
        this.faultIcon = faultIcon;
        this.errorIcon = errorIcon;
        this.resubmitableErrorIcon = resubmitableErrorIcon;
        this.faultErrorIcon = faultErrorIcon;
        this.resubmitableFaultErrorIcon = resubmitableFaultErrorIcon;
        this.okIcon = okIcon;
        this.unknownIcon = unknownIcon;
    }

    public Component getTableCellRendererComponent(
            JTable table, Object instanceInfo,
            boolean isSelected, boolean hasFocus,
            int row, int column) {
        BasicESBInstanceInfo instance = (BasicESBInstanceInfo) instanceInfo;
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
        
        if(!instance.hasErrors() && !instance.hasFaults()) {
            if(okIcon != null) setIcon(okIcon);
            else setText("OK");
            setToolTipText("OK");
        } else if(instance.hasErrors() && instance.hasFaults() && instance.isResubmitable()) {
            if(resubmitableFaultErrorIcon != null) setIcon(resubmitableFaultErrorIcon);
            else setText("Tiene errores y faltas, es reintentable");
            setToolTipText("Tiene errores y faltas, es reintentable");
        } else if(instance.hasErrors() && instance.hasFaults() && !instance.isResubmitable()) {
            if(faultErrorIcon != null) setIcon(faultErrorIcon);
            else setText("Tiene errores y faltas, no es reintentable");
            setToolTipText("Tiene errores y faltas, no es reintentable");
        } else if(instance.hasErrors() && instance.isResubmitable()) {
            if(resubmitableErrorIcon != null) setIcon(resubmitableErrorIcon);
            else setText("Tiene errores, es reintentable");
            setToolTipText("Tiene errores, es reintentable");
        } else if(instance.hasErrors() && !instance.isResubmitable()) {
            if(errorIcon != null) setIcon(errorIcon);
            else setText("Tiene errores, no es reintentable");
            setToolTipText("Tiene errores, no es reintentable");
        } else if(instance.hasFaults()) {
            if(faultIcon != null) setIcon(faultIcon);
            else setText("Tiene faltas");
            setToolTipText("Tiene faltas");
        } else {
            if(okIcon != null) setIcon(unknownIcon);
            else setText("WTF?");
            setToolTipText("WTF?");
        }

        if(instance.getDuration() > 120000) {
            setBackground(Color.RED);
        } else if(instance.getDuration() > 60000) {
            setBackground(Color.ORANGE);
        }
        
        setHorizontalAlignment(SwingConstants.CENTER);

        return this;
    }
}

