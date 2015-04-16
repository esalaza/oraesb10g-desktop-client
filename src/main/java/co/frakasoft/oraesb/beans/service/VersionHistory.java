package co.frakasoft.oraesb.beans.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="entity" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{}versionInfo"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="guid" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="qname" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "entity"
})
@XmlRootElement(name = "versionHistory")
public class VersionHistory {

    @XmlElement(required = true)
    protected List<VersionHistory.Entity> entity;

    /**
     * Gets the value of the entity property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entity property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VersionHistory.Entity }
     * 
     * 
     */
    public List<VersionHistory.Entity> getEntity() {
        if (entity == null) {
            entity = new ArrayList<VersionHistory.Entity>();
        }
        return this.entity;
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
     *         &lt;element ref="{}versionInfo"/>
     *       &lt;/sequence>
     *       &lt;attribute name="guid" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="qname" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "versionInfo"
    })
    public static class Entity {

        @XmlElement(required = true)
        protected VersionInfo versionInfo;
        @XmlAttribute(name = "guid", required = true)
        protected String guid;
        @XmlAttribute(name = "qname", required = true)
        protected String qname;

        /**
         * Node that holds the version information for
         *                                      a particular entity. The node is re-used
         *                                      for both versionHistory requests and entity
         *                                      detail XMLs. For instance, a service XML
         *                                      could have a version information for the
         *                                      selected service.
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

}
