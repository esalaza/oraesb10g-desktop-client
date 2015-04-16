package co.frakasoft.oraesb.beans.instance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;attribute name="flowId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="initiatedBy" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="initiatedAt" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="initiatedAtString" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="status" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "instance")
public class Instance {

    @XmlAttribute(name = "flowId", required = true)
    protected String flowId;
    @XmlAttribute(name = "initiatedBy", required = true)
    protected String initiatedBy;
    @XmlAttribute(name = "initiatedAt", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar initiatedAt;
    @XmlAttribute(name = "initiatedAtString", required = true)
    protected String initiatedAtString;
    @XmlAttribute(name = "status")
    protected String status;
    @XmlAttribute(name = "type")
    protected String type;

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
     * Obtiene el valor de la propiedad initiatedBy.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitiatedBy() {
        return initiatedBy;
    }

    /**
     * Define el valor de la propiedad initiatedBy.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitiatedBy(String value) {
        this.initiatedBy = value;
    }

    /**
     * Obtiene el valor de la propiedad initiatedAt.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInitiatedAt() {
        return initiatedAt;
    }

    /**
     * Define el valor de la propiedad initiatedAt.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInitiatedAt(XMLGregorianCalendar value) {
        this.initiatedAt = value;
    }

    /**
     * Obtiene el valor de la propiedad initiatedAtString.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitiatedAtString() {
        return initiatedAtString;
    }

    /**
     * Define el valor de la propiedad initiatedAtString.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitiatedAtString(String value) {
        this.initiatedAtString = value;
    }

    /**
     * Obtiene el valor de la propiedad status.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define el valor de la propiedad status.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
