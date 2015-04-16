package co.frakasoft.oraesb.beans.flows;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element name="flowId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startTime" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="serviceGUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.oracle.com/esb}InstanceStatus" minOccurs="0"/>
 *         &lt;element name="errorMessageContains" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trackableFields" type="{http://www.oracle.com/esb}TrackableFieldValueList" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="timeZone" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *       &lt;attribute name="pageStartsFrom" type="{http://www.w3.org/2001/XMLSchema}integer" default="1" />
 *       &lt;attribute name="pageSize" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="includeMoreDetails" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "flowId",
    "startTime",
    "serviceGUID",
    "status",
    "errorMessageContains",
    "trackableFields"
})
@XmlRootElement(name = "instanceFilter")
public class InstanceFilter {

    protected String flowId;
    protected Long startTime;
    protected String serviceGUID;
    protected InstanceStatus status;
    protected String errorMessageContains;
    protected TrackableFieldValueList trackableFields;
    @XmlAttribute(name = "timeZone", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String timeZone;
    @XmlAttribute(name = "pageStartsFrom")
    protected BigInteger pageStartsFrom;
    @XmlAttribute(name = "pageSize")
    protected BigInteger pageSize;
    @XmlAttribute(name = "includeMoreDetails")
    protected Boolean includeMoreDetails;

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
     * Obtiene el valor de la propiedad startTime.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStartTime() {
        return startTime;
    }

    /**
     * Define el valor de la propiedad startTime.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStartTime(Long value) {
        this.startTime = value;
    }

    /**
     * Obtiene el valor de la propiedad serviceGUID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceGUID() {
        return serviceGUID;
    }

    /**
     * Define el valor de la propiedad serviceGUID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceGUID(String value) {
        this.serviceGUID = value;
    }

    /**
     * Obtiene el valor de la propiedad status.
     * 
     * @return
     *     possible object is
     *     {@link InstanceStatus }
     *     
     */
    public InstanceStatus getStatus() {
        return status;
    }

    /**
     * Define el valor de la propiedad status.
     * 
     * @param value
     *     allowed object is
     *     {@link InstanceStatus }
     *     
     */
    public void setStatus(InstanceStatus value) {
        this.status = value;
    }

    /**
     * Obtiene el valor de la propiedad errorMessageContains.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessageContains() {
        return errorMessageContains;
    }

    /**
     * Define el valor de la propiedad errorMessageContains.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessageContains(String value) {
        this.errorMessageContains = value;
    }

    /**
     * Obtiene el valor de la propiedad trackableFields.
     * 
     * @return
     *     possible object is
     *     {@link TrackableFieldValueList }
     *     
     */
    public TrackableFieldValueList getTrackableFields() {
        return trackableFields;
    }

    /**
     * Define el valor de la propiedad trackableFields.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackableFieldValueList }
     *     
     */
    public void setTrackableFields(TrackableFieldValueList value) {
        this.trackableFields = value;
    }

    /**
     * Obtiene el valor de la propiedad timeZone.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * Define el valor de la propiedad timeZone.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeZone(String value) {
        this.timeZone = value;
    }

    /**
     * Obtiene el valor de la propiedad pageStartsFrom.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPageStartsFrom() {
        if (pageStartsFrom == null) {
            return new BigInteger("1");
        } else {
            return pageStartsFrom;
        }
    }

    /**
     * Define el valor de la propiedad pageStartsFrom.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPageStartsFrom(BigInteger value) {
        this.pageStartsFrom = value;
    }

    /**
     * Obtiene el valor de la propiedad pageSize.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPageSize() {
        return pageSize;
    }

    /**
     * Define el valor de la propiedad pageSize.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPageSize(BigInteger value) {
        this.pageSize = value;
    }

    /**
     * Obtiene el valor de la propiedad includeMoreDetails.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeMoreDetails() {
        return includeMoreDetails;
    }

    /**
     * Define el valor de la propiedad includeMoreDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeMoreDetails(Boolean value) {
        this.includeMoreDetails = value;
    }

}
