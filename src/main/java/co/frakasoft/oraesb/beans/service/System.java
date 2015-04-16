package co.frakasoft.oraesb.beans.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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
 *         &lt;element ref="{}versionInfo" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parameters" type="{}ParametersType" minOccurs="0"/>
 *         &lt;element name="clusterName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deferredQueueName" type="{}QueueInfoType" minOccurs="0"/>
 *         &lt;element name="errorQueueName" type="{}QueueInfoType" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{}serviceGroup"/>
 *           &lt;element ref="{}service"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}IdentifierInfo"/>
 *       &lt;attribute name="status" type="{}StatusType" default="ENABLED" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "versionInfo",
    "description",
    "parameters",
    "clusterName",
    "deferredQueueName",
    "errorQueueName",
    "serviceGroupOrService"
})
@XmlRootElement(name = "system")
public class System {

    protected VersionInfo versionInfo;
    protected String description;
    protected ParametersType parameters;
    protected String clusterName;
    protected QueueInfoType deferredQueueName;
    protected QueueInfoType errorQueueName;
    @XmlElements({
        @XmlElement(name = "serviceGroup", type = ServiceGroup.class),
        @XmlElement(name = "service", type = Service.class)
    })
    protected List<Object> serviceGroupOrService;
    @XmlAttribute(name = "status")
    protected StatusType status;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "guid")
    protected String guid;
    @XmlAttribute(name = "dirty")
    protected Boolean dirty;
    @XmlAttribute(name = "qname")
    protected String qname;

    /**
     * Contains the version information for the entity.
     * 
     * @return
     *     possible object is
     *     {@link VersionInfo }
     *     
     */
    public VersionInfo getVersionInfo() {
        return versionInfo;
    }

    /**
     * Define el valor de la propiedad versionInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionInfo }
     *     
     */
    public void setVersionInfo(VersionInfo value) {
        this.versionInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtiene el valor de la propiedad parameters.
     * 
     * @return
     *     possible object is
     *     {@link ParametersType }
     *     
     */
    public ParametersType getParameters() {
        return parameters;
    }

    /**
     * Define el valor de la propiedad parameters.
     * 
     * @param value
     *     allowed object is
     *     {@link ParametersType }
     *     
     */
    public void setParameters(ParametersType value) {
        this.parameters = value;
    }

    /**
     * Obtiene el valor de la propiedad clusterName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClusterName() {
        return clusterName;
    }

    /**
     * Define el valor de la propiedad clusterName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClusterName(String value) {
        this.clusterName = value;
    }

    /**
     * Obtiene el valor de la propiedad deferredQueueName.
     * 
     * @return
     *     possible object is
     *     {@link QueueInfoType }
     *     
     */
    public QueueInfoType getDeferredQueueName() {
        return deferredQueueName;
    }

    /**
     * Define el valor de la propiedad deferredQueueName.
     * 
     * @param value
     *     allowed object is
     *     {@link QueueInfoType }
     *     
     */
    public void setDeferredQueueName(QueueInfoType value) {
        this.deferredQueueName = value;
    }

    /**
     * Obtiene el valor de la propiedad errorQueueName.
     * 
     * @return
     *     possible object is
     *     {@link QueueInfoType }
     *     
     */
    public QueueInfoType getErrorQueueName() {
        return errorQueueName;
    }

    /**
     * Define el valor de la propiedad errorQueueName.
     * 
     * @param value
     *     allowed object is
     *     {@link QueueInfoType }
     *     
     */
    public void setErrorQueueName(QueueInfoType value) {
        this.errorQueueName = value;
    }

    /**
     * Gets the value of the serviceGroupOrService property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceGroupOrService property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceGroupOrService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceGroup }
     * {@link Service }
     * 
     * 
     */
    public List<Object> getServiceGroupOrService() {
        if (serviceGroupOrService == null) {
            serviceGroupOrService = new ArrayList<Object>();
        }
        return this.serviceGroupOrService;
    }

    /**
     * Obtiene el valor de la propiedad status.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getStatus() {
        if (status == null) {
            return StatusType.ENABLED;
        } else {
            return status;
        }
    }

    /**
     * Define el valor de la propiedad status.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setStatus(StatusType value) {
        this.status = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad guid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuid() {
        return guid;
    }

    /**
     * Define el valor de la propiedad guid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuid(String value) {
        this.guid = value;
    }

    /**
     * Obtiene el valor de la propiedad dirty.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isDirty() {
        if (dirty == null) {
            return true;
        } else {
            return dirty;
        }
    }

    /**
     * Define el valor de la propiedad dirty.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDirty(Boolean value) {
        this.dirty = value;
    }

    /**
     * Obtiene el valor de la propiedad qname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQname() {
        return qname;
    }

    /**
     * Define el valor de la propiedad qname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQname(String value) {
        this.qname = value;
    }

}
