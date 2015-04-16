package co.frakasoft.oraesb.beans.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Wrapper element that holds the XSL File location
 *                          information.
 * 
 * <p>Clase Java para TransformationType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TransformationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xslFileURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransformationType", propOrder = {
    "xslFileURL"
})
@XmlSeeAlso({
    co.frakasoft.oraesb.beans.service.HandlerType.Transformation.class
})
public class TransformationType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String xslFileURL;

    /**
     * Obtiene el valor de la propiedad xslFileURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXslFileURL() {
        return xslFileURL;
    }

    /**
     * Define el valor de la propiedad xslFileURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXslFileURL(String value) {
        this.xslFileURL = value;
    }

}
