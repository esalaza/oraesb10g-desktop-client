package co.frakasoft.oraesb.beans.service;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para MEPType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="MEPType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OneWay"/>
 *     &lt;enumeration value="RequestResponse"/>
 *     &lt;enumeration value="RequestResponseFault"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MEPType")
@XmlEnum
public enum MEPType {

    @XmlEnumValue("OneWay")
    ONE_WAY("OneWay"),
    @XmlEnumValue("RequestResponse")
    REQUEST_RESPONSE("RequestResponse"),
    @XmlEnumValue("RequestResponseFault")
    REQUEST_RESPONSE_FAULT("RequestResponseFault");
    private final String value;

    MEPType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MEPType fromValue(String v) {
        for (MEPType c: MEPType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
