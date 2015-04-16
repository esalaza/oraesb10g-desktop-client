package co.frakasoft.oraesb.gui.models;

import co.frakasoft.oraesb.beans.util.BasicESBInstanceInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author esalaza
 */
public class InstanceListTableModel extends AbstractTableModel {
     
    public final static int FLOW_ID     = 0;
    public final static int TIME        = 1;
    public final static int DURATION    = 2;
    public final static int STATUS      = 3;

    private String[] columnNames = new String[]{"Identifier", "Time", "Duration", "Status"};
    private List<BasicESBInstanceInfo> instances = new ArrayList<BasicESBInstanceInfo>();

    public void setInstanceList(List<BasicESBInstanceInfo> instances) {
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
            return instances.get(rowIndex);
        } else if(columnIndex == DURATION) {
            long duration    = instances.get(rowIndex).getDuration();
            long seconds     = duration / 1000;
            long hours       = seconds  / 3600;
            seconds          = seconds  % 3600;
            long minutes     = seconds  / 60;
            seconds          = seconds  % 60;
            long miliseconds = duration % 1000;
            return hours + "h :" + minutes + "m :" + seconds + "s :" + miliseconds + "ms";
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
        else if(c == STATUS) return BasicESBInstanceInfo.class;
        else if(c == DURATION) return String.class;
        return String.class;
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        if(col == FLOW_ID) return true;
        else return false;
    }
    
}
