package co.frakasoft.oraesb.beans.instance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="userPurgeTimePeriod" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "purgeInstance")
public class PurgeInstance {

    @XmlAttribute(name = "userPurgeTimePeriod", required = true)
    protected long userPurgeTimePeriod;

    /**
     * Obtiene el valor de la propiedad userPurgeTimePeriod.
     * 
     */
    public long getUserPurgeTimePeriod() {
        return userPurgeTimePeriod;
    }

    /**
     * Define el valor de la propiedad userPurgeTimePeriod.
     * 
     */
    public void setUserPurgeTimePeriod(long value) {
        this.userPurgeTimePeriod = value;
    }

}
