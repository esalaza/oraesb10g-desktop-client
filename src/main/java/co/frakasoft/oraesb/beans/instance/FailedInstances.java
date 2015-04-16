package co.frakasoft.oraesb.beans.instance;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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
 *       &lt;sequence>
 *         &lt;element ref="{http://www.oracle.com/esb}failedInstance" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="availableMore" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "failedInstance"
})
@XmlRootElement(name = "failedInstances")
public class FailedInstances {

    @XmlElement(namespace = "http://www.oracle.com/esb", required = true)
    protected List<FailedInstance> failedInstance;
    @XmlAttribute(name = "availableMore")
    protected Boolean availableMore;

    /**
     * Gets the value of the failedInstance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the failedInstance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFailedInstance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FailedInstance }
     * 
     * 
     */
    public List<FailedInstance> getFailedInstance() {
        if (failedInstance == null) {
            failedInstance = new ArrayList<FailedInstance>();
        }
        return this.failedInstance;
    }

    /**
     * Obtiene el valor de la propiedad availableMore.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAvailableMore() {
        return availableMore;
    }

    /**
     * Define el valor de la propiedad availableMore.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAvailableMore(Boolean value) {
        this.availableMore = value;
    }

}
