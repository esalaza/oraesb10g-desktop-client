package co.frakasoft.oraesb.beans.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Indicates the deferred and Error Queue Information for
 *                          the System
 * 
 * <p>Clase Java para QueueInfoType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="QueueInfoType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="numberOfListeners" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="topicConnectionFactory" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueueInfoType", propOrder = {
    "value"
})
public class QueueInfoType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "numberOfListeners")
    protected String numberOfListeners;
    @XmlAttribute(name = "topicConnectionFactory")
    protected String topicConnectionFactory;

    /**
     * Obtiene el valor de la propiedad value.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Define el valor de la propiedad value.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Obtiene el valor de la propiedad numberOfListeners.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfListeners() {
        return numberOfListeners;
    }

    /**
     * Define el valor de la propiedad numberOfListeners.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfListeners(String value) {
        this.numberOfListeners = value;
    }

    /**
     * Obtiene el valor de la propiedad topicConnectionFactory.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTopicConnectionFactory() {
        return topicConnectionFactory;
    }

    /**
     * Define el valor de la propiedad topicConnectionFactory.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTopicConnectionFactory(String value) {
        this.topicConnectionFactory = value;
    }

}
