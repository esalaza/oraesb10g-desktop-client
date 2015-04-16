package co.frakasoft.oraesb.beans.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * Used to capture the interface WSDL information
 *                          specifically for inbound adapter services. [port type,
 *                          partner link type etc]
 * 
 * <p>Clase Java para WSDLInfoType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="WSDLInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsdlURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element name="portType" type="{http://www.w3.org/2001/XMLSchema}QName"/>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element name="partnerLinkType" type="{http://www.w3.org/2001/XMLSchema}QName"/>
 *             &lt;element name="myRole" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *             &lt;element name="partnerRole" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WSDLInfoType", propOrder = {
    "wsdlURL",
    "portType",
    "partnerLinkType",
    "myRole",
    "partnerRole"
})
@XmlSeeAlso({
    ServiceDefinitionType.class
})
public class WSDLInfoType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String wsdlURL;
    protected QName portType;
    protected QName partnerLinkType;
    protected String myRole;
    protected String partnerRole;

    /**
     * Obtiene el valor de la propiedad wsdlURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWsdlURL() {
        return wsdlURL;
    }

    /**
     * Define el valor de la propiedad wsdlURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWsdlURL(String value) {
        this.wsdlURL = value;
    }

    /**
     * Obtiene el valor de la propiedad portType.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getPortType() {
        return portType;
    }

    /**
     * Define el valor de la propiedad portType.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setPortType(QName value) {
        this.portType = value;
    }

    /**
     * Obtiene el valor de la propiedad partnerLinkType.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getPartnerLinkType() {
        return partnerLinkType;
    }

    /**
     * Define el valor de la propiedad partnerLinkType.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setPartnerLinkType(QName value) {
        this.partnerLinkType = value;
    }

    /**
     * Obtiene el valor de la propiedad myRole.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMyRole() {
        return myRole;
    }

    /**
     * Define el valor de la propiedad myRole.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMyRole(String value) {
        this.myRole = value;
    }

    /**
     * Obtiene el valor de la propiedad partnerRole.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartnerRole() {
        return partnerRole;
    }

    /**
     * Define el valor de la propiedad partnerRole.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartnerRole(String value) {
        this.partnerRole = value;
    }

}
