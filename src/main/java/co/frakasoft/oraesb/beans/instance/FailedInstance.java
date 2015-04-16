package co.frakasoft.oraesb.beans.instance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="failureTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="errorMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="exception" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inPayload" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="flowId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="systemId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="serviceQName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="operationName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="retryable" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "failureTime",
    "errorMessage",
    "exception",
    "inPayload"
})
@XmlRootElement(name = "failedInstance")
public class FailedInstance {

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar failureTime;
    @XmlElement(required = true)
    protected String errorMessage;
    protected String exception;
    @XmlElement(required = true)
    protected String inPayload;
    @XmlAttribute(name = "flowId", required = true)
    protected String flowId;
    @XmlAttribute(name = "systemId")
    protected String systemId;
    @XmlAttribute(name = "serviceQName")
    protected String serviceQName;
    @XmlAttribute(name = "operationName")
    protected String operationName;
    @XmlAttribute(name = "retryable", required = true)
    protected boolean retryable;

    /**
     * Obtiene el valor de la propiedad failureTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFailureTime() {
        return failureTime;
    }

    /**
     * Define el valor de la propiedad failureTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFailureTime(XMLGregorianCalendar value) {
        this.failureTime = value;
    }

    /**
     * Obtiene el valor de la propiedad errorMessage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Define el valor de la propiedad errorMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

    /**
     * Obtiene el valor de la propiedad exception.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getException() {
        return exception;
    }

    /**
     * Define el valor de la propiedad exception.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setException(String value) {
        this.exception = value;
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
     * Obtiene el valor de la propiedad systemId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemId() {
        return systemId;
    }

    /**
     * Define el valor de la propiedad systemId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemId(String value) {
        this.systemId = value;
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
     * Obtiene el valor de la propiedad operationName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationName() {
        return operationName;
    }

    /**
     * Define el valor de la propiedad operationName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationName(String value) {
        this.operationName = value;
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

}
