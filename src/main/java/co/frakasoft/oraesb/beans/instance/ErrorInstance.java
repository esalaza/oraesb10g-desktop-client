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
 *     &lt;extension base="{http://www.oracle.com/esb}MessageInstanceType">
 *       &lt;sequence>
 *         &lt;element name="failedInstanceLink" type="{http://www.oracle.com/esb}FailedInstanceLinkType" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.oracle.com/esb}messageInstance"/>
 *       &lt;/sequence>
 *       &lt;attribute name="retryable" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="serviceType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "failedInstanceLink",
    "messageInstance"
})
@XmlRootElement(name = "errorInstance")
public class ErrorInstance
    extends MessageInstanceType
{

    @XmlElement(required = true)
    protected List<FailedInstanceLinkType> failedInstanceLink;
    @XmlElement(namespace = "http://www.oracle.com/esb", required = true)
    protected MessageInstanceType messageInstance;
    @XmlAttribute(name = "retryable", required = true)
    protected boolean retryable;
    @XmlAttribute(name = "serviceType", required = true)
    protected String serviceType;

    /**
     * Gets the value of the failedInstanceLink property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the failedInstanceLink property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFailedInstanceLink().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FailedInstanceLinkType }
     * 
     * 
     */
    public List<FailedInstanceLinkType> getFailedInstanceLink() {
        if (failedInstanceLink == null) {
            failedInstanceLink = new ArrayList<FailedInstanceLinkType>();
        }
        return this.failedInstanceLink;
    }

    /**
     * Obtiene el valor de la propiedad messageInstance.
     * 
     * @return
     *     possible object is
     *     {@link MessageInstanceType }
     *     
     */
    public MessageInstanceType getMessageInstance() {
        return messageInstance;
    }

    /**
     * Define el valor de la propiedad messageInstance.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageInstanceType }
     *     
     */
    public void setMessageInstance(MessageInstanceType value) {
        this.messageInstance = value;
    }

    /**
     * Obtiene el valor de la propiedad retryable.
     * 
     */
    public boolean isRetryable() {
        return retryable;
    }

    /**
     * Define el valor de la propiedad retryable.
     * 
     */
    public void setRetryable(boolean value) {
        this.retryable = value;
    }

    /**
     * Obtiene el valor de la propiedad serviceType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * Define el valor de la propiedad serviceType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceType(String value) {
        this.serviceType = value;
    }

}
