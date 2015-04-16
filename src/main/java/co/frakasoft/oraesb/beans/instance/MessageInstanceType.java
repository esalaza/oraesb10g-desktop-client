package co.frakasoft.oraesb.beans.instance;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para MessageInstanceType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="MessageInstanceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="instanceLink" type="{http://www.oracle.com/esb}InstanceLinkType" maxOccurs="unbounded"/>
 *         &lt;element name="inPayload" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="flowId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="batchId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="serviceQName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="operationGUID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="operationQName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageInstanceType", propOrder = {
    "instanceLink",
    "inPayload"
})
@XmlSeeAlso({
    ErrorInstance.class
})
public class MessageInstanceType {

    @XmlElement(required = true)
    protected List<InstanceLinkType> instanceLink;
    @XmlElement(required = true)
    protected String inPayload;
    @XmlAttribute(name = "flowId", required = true)
    protected String flowId;
    @XmlAttribute(name = "batchId")
    protected String batchId;
    @XmlAttribute(name = "serviceQName")
    protected String serviceQName;
    @XmlAttribute(name = "operationGUID")
    protected String operationGUID;
    @XmlAttribute(name = "operationQName")
    protected String operationQName;

    /**
     * Gets the value of the instanceLink property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instanceLink property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstanceLink().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InstanceLinkType }
     * 
     * 
     */
    public List<InstanceLinkType> getInstanceLink() {
        if (instanceLink == null) {
            instanceLink = new ArrayList<InstanceLinkType>();
        }
        return this.instanceLink;
    }

    /**
     * Obtiene el valor de la propiedad inPayload.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInPayload() {
        return inPayload;
    }

    /**
     * Define el valor de la propiedad inPayload.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInPayload(String value) {
        this.inPayload = value;
    }

    /**
     * Obtiene el valor de la propiedad flowId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlowId() {
        return flowId;
    }

    /**
     * Define el valor de la propiedad flowId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlowId(String value) {
        this.flowId = value;
    }

    /**
     * Obtiene el valor de la propiedad batchId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchId() {
        return batchId;
    }

    /**
     * Define el valor de la propiedad batchId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchId(String value) {
        this.batchId = value;
    }

    /**
     * Obtiene el valor de la propiedad serviceQName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceQName() {
        return serviceQName;
    }

    /**
     * Define el valor de la propiedad serviceQName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceQName(String value) {
        this.serviceQName = value;
    }

    /**
     * Obtiene el valor de la propiedad operationGUID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationGUID() {
        return operationGUID;
    }

    /**
     * Define el valor de la propiedad operationGUID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationGUID(String value) {
        this.operationGUID = value;
    }

    /**
     * Obtiene el valor de la propiedad operationQName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationQName() {
        return operationQName;
    }

    /**
     * Define el valor de la propiedad operationQName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationQName(String value) {
        this.operationQName = value;
    }

}
