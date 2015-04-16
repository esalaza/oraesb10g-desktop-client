package co.frakasoft.oraesb.util.comparators;

import co.frakasoft.oraesb.beans.util.BasicESBInstanceInfo;
import java.util.Comparator;

/**
 *
 * @author esalaza
 */
public class BasicESBInstanceTimestampComparator implements Comparator<BasicESBInstanceInfo> {

    public int compare(BasicESBInstanceInfo instance1, BasicESBInstanceInfo instance2) {
        return (int)(instance1.getTimestamp() - instance2.getTimestamp());
    }

}
