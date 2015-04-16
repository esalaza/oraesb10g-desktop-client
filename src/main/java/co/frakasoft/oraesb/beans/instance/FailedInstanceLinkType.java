package co.frakasoft.oraesb.beans.instance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para FailedInstanceLinkType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FailedInstanceLinkType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.oracle.com/esb}InstanceLinkType">
 *       &lt;sequence>
 *         &lt;element name="failureTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="failureTimeString" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="errorMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="exception" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="outPayload" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FailedInstanceLinkType", propOrder = {
    "failureTime",
    "failureTimeString",
    "errorMessage",
    "exception",
    "outPayload"
})
public class FailedInstanceLinkType
    extends InstanceLinkType
{

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar failureTime;
    @XmlElement(required = true)
    protected String failureTimeString;
    @XmlElement(required = true)
    protected String errorMessage;
    protected String exception;
    protected String outPayload;

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
     * Obtiene el valor de la propiedad failureTimeString.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFailureTimeString() {
        return failureTimeString;
    }

    /**
     * Define el valor de la propiedad failureTimeString.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFailureTimeString(String value) {
        this.failureTimeString = value;
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
     * Obtiene el valor de la propiedad outPayload.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutPayload() {
        return outPayload;
    }

    /**
     * Define el valor de la propiedad outPayload.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutPayload(String value) {
        this.outPayload = value;
    }

}
