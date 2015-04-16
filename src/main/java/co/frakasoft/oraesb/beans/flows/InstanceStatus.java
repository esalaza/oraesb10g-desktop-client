package co.frakasoft.oraesb.beans.flows;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para InstanceStatus.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="InstanceStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="Error"/>
 *     &lt;enumeration value="RetryableError"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InstanceStatus")
@XmlEnum
public enum InstanceStatus {

    @XmlEnumValue("Error")
    ERROR("Error"),
    @XmlEnumValue("RetryableError")
    RETRYABLE_ERROR("RetryableError");
    private final String value;

    InstanceStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InstanceStatus fromValue(String v) {
        for (InstanceStatus c: InstanceStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
