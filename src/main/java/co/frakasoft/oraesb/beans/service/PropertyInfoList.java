package co.frakasoft.oraesb.beans.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="propertyInfo" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                   &lt;element name="specValue" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="descriptionKey">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="1"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}ServiceTypeReference"/>
 *       &lt;attribute name="specClassName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "propertyInfo"
})
@XmlRootElement(name = "propertyInfoList")
public class PropertyInfoList {

    @XmlElement(required = true)
    protected List<PropertyInfoList.PropertyInfo> propertyInfo;
    @XmlAttribute(name = "specClassName")
    protected String specClassName;
    @XmlAttribute(name = "serviceSubType")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String serviceSubType;
    @XmlAttribute(name = "serviceType")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String serviceType;

    /**
     * Gets the value of the propertyInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the propertyInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPropertyInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PropertyInfoList.PropertyInfo }
     * 
     * 
     */
    public List<PropertyInfoList.PropertyInfo> getPropertyInfo() {
        if (propertyInfo == null) {
            propertyInfo = new ArrayList<PropertyInfoList.PropertyInfo>();
        }
        return this.propertyInfo;
    }

    /**
     * Obtiene el valor de la propiedad specClassName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecClassName() {
        return specClassName;
    }

    /**
     * Define el valor de la propiedad specClassName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecClassName(String value) {
        this.specClassName = value;
    }

    /**
     * Obtiene el valor de la propiedad serviceSubType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceSubType() {
        return serviceSubType;
    }

    /**
     * Define el valor de la propiedad serviceSubType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceSubType(String value) {
        this.serviceSubType = value;
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
     *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *         &lt;element name="specValue" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="descriptionKey">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;minLength value="1"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "description",
        "specValue"
    })
    public static class PropertyInfo {

        protected Object description;
        protected Object specValue;
        @XmlAttribute(name = "name", required = true)
        protected String name;
        @XmlAttribute(name = "descriptionKey")
        protected String descriptionKey;

        /**
         * Obtiene el valor de la propiedad description.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getDescription() {
            return description;
        }

        /**
         * Define el valor de la propiedad description.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setDescription(Object value) {
            this.description = value;
        }

        /**
         * Obtiene el valor de la propiedad specValue.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getSpecValue() {
            return specValue;
        }

        /**
         * Define el valor de la propiedad specValue.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setSpecValue(Object value) {
            this.specValue = value;
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
         * Obtiene el valor de la propiedad descriptionKey.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescriptionKey() {
            return descriptionKey;
        }

        /**
         * Define el valor de la propiedad descriptionKey.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescriptionKey(String value) {
            this.descriptionKey = value;
        }

    }

}
