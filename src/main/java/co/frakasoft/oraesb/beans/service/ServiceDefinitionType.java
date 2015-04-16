package co.frakasoft.oraesb.beans.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Holds the WSDL Information [portype, plnk type etc for
 *                          the service. Used for all services except inbound
 *                          servies. Inbound services do not have a serive
 *                          definition
 * 
 * <p>Clase Java para ServiceDefinitionType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ServiceDefinitionType">
 *   &lt;complexContent>
 *     &lt;extension base="{}WSDLInfoType">
 *       &lt;sequence>
 *         &lt;element name="endpointDefinition" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="concreteWSDLURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *                   &lt;element name="soapEndpointURI" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceDefinitionType", propOrder = {
    "endpointDefinition"
})
public class ServiceDefinitionType
    extends WSDLInfoType
{

    protected ServiceDefinitionType.EndpointDefinition endpointDefinition;

    /**
     * Obtiene el valor de la propiedad endpointDefinition.
     * 
     * @return
     *     possible object is
     *     {@link ServiceDefinitionType.EndpointDefinition }
     *     
     */
    public ServiceDefinitionType.EndpointDefinition getEndpointDefinition() {
        return endpointDefinition;
    }

    /**
     * Define el valor de la propiedad endpointDefinition.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceDefinitionType.EndpointDefinition }
     *     
     */
    public void setEndpointDefinition(ServiceDefinitionType.EndpointDefinition value) {
        this.endpointDefinition = value;
    }


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
     *         &lt;element name="concreteWSDLURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
     *         &lt;element name="soapEndpointURI" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "concreteWSDLURL",
        "soapEndpointURI"
    })
    public static class EndpointDefinition {

        @XmlElement(required = true)
        @XmlSchemaType(name = "anyURI")
        protected String concreteWSDLURL;
        @XmlElement(required = true)
        protected String soapEndpointURI;

        /**
         * Obtiene el valor de la propiedad concreteWSDLURL.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getConcreteWSDLURL() {
            return concreteWSDLURL;
        }

        /**
         * Define el valor de la propiedad concreteWSDLURL.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setConcreteWSDLURL(String value) {
            this.concreteWSDLURL = value;
        }

        /**
         * Obtiene el valor de la propiedad soapEndpointURI.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSoapEndpointURI() {
            return soapEndpointURI;
        }

        /**
         * Define el valor de la propiedad soapEndpointURI.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSoapEndpointURI(String value) {
            this.soapEndpointURI = value;
        }

    }

}
