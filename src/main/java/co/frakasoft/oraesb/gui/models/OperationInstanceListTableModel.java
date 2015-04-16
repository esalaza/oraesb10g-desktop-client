package co.frakasoft.oraesb.gui.models;

import co.frakasoft.oraesb.beans.util.BasicESBOperationInstanceInfo;
import co.frakasoft.oraesb.beans.util.OperationState;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import co.frakasoft.util.TimeUtils;

/**
 *
 * @author esalaza
 */
public class OperationInstanceListTableModel extends AbstractTableModel {
     
    public final static int FLOW_ID     = 0;
    public final static int TIME        = 1;
    public final static int DURATION    = 2;
    public final static int STATUS      = 3;

    private String[] columnNames = new String[]{"Flow identifier", "Start time", "Duration", "Status"};
    private List<BasicESBOperationInstanceInfo> instances = new ArrayList<BasicESBOperationInstanceInfo>();

    public void setInstanceList(List<BasicESBOperationInstanceInfo> instances) {
        this.instances = instances;
        fireTableDataChanged();
    }

    public int getRowCount() {
        return instances.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == FLOW_ID) {
            return instances.get(rowIndex).getFlowId();
        } else if(columnIndex == TIME) {
            return new Date(instances.get(rowIndex).getTimestamp());
        } else if(columnIndex == STATUS) {
            return instances.get(rowIndex).getState();
        } else if(columnIndex == DURATION) {
            long duration    = 0;
            if(instances.get(rowIndex).getState().contains(OperationState.RUNNING)) {
                duration = (new Date().getTime()) - instances.get(rowIndex).getTimestamp();
            } else {
                duration    = instances.get(rowIndex).getDuration();
            }
            return TimeUtils.longDuration2TimeDurationString(duration);
        }
        
        return null;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Class getColumnClass(int c) {
        if(c == FLOW_ID) return String.class;
        else if(c == TIME) return GregorianCalendar.class;
        else if(c == STATUS) return EnumSet.class;
        else if(c == DURATION) return String.class;
        return String.class;
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        if(col == FLOW_ID) return true;
        else return false;
    }
    
}
