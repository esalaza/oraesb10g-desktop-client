package co.frakasoft.oraesb.beans.service;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ParentType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="ParentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="system"/>
 *     &lt;enumeration value="serviceGroup"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ParentType")
@XmlEnum
public enum ParentType {

    @XmlEnumValue("system")
    SYSTEM("system"),
    @XmlEnumValue("serviceGroup")
    SERVICE_GROUP("serviceGroup");
    private final String value;

    ParentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ParentType fromValue(String v) {
        for (ParentType c: ParentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
