package co.frakasoft.oraesb.util.comparators;

import co.frakasoft.oraesb.beans.util.BasicESBOperationInstanceInfo;
import java.util.Comparator;

/**
 *
 * @author esalaza
 */
public class BasicESBOperationInstanceTimestampComparator implements Comparator<BasicESBOperationInstanceInfo> {

    public int compare(BasicESBOperationInstanceInfo instance1, BasicESBOperationInstanceInfo instance2) {
        return (int)(instance1.getTimestamp() - instance2.getTimestamp());
    }

}
