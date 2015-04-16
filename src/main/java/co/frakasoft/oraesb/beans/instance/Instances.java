package co.frakasoft.oraesb.beans.instance;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{http://www.oracle.com/esb}instance" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="instanceCount" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="availableMore" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="generatedTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="generatedTimeString" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "instance"
})
@XmlRootElement(name = "instances")
public class Instances {

    @XmlElement(namespace = "http://www.oracle.com/esb", required = true)
    protected List<Instance> instance;
    @XmlAttribute(name = "instanceCount")
    protected String instanceCount;
    @XmlAttribute(name = "availableMore")
    protected Boolean availableMore;
    @XmlAttribute(name = "generatedTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar generatedTime;
    @XmlAttribute(name = "generatedTimeString")
    protected String generatedTimeString;

    /**
     * Gets the value of the instance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Instance }
     * 
     * 
     */
    public List<Instance> getInstance() {
        if (instance == null) {
            instance = new ArrayList<Instance>();
        }
        return this.instance;
    }

    /**
     * Obtiene el valor de la propiedad instanceCount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstanceCount() {
        return instanceCount;
    }

    /**
     * Define el valor de la propiedad instanceCount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstanceCount(String value) {
        this.instanceCount = value;
    }

    /**
     * Obtiene el valor de la propiedad availableMore.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAvailableMore() {
        return availableMore;
    }

    /**
     * Define el valor de la propiedad availableMore.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAvailableMore(Boolean value) {
        this.availableMore = value;
    }

    /**
     * Obtiene el valor de la propiedad generatedTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getGeneratedTime() {
        return generatedTime;
    }

    /**
     * Define el valor de la propiedad generatedTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setGeneratedTime(XMLGregorianCalendar value) {
        this.generatedTime = value;
    }

    /**
     * Obtiene el valor de la propiedad generatedTimeString.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeneratedTimeString() {
        return generatedTimeString;
    }

    /**
     * Define el valor de la propiedad generatedTimeString.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeneratedTimeString(String value) {
        this.generatedTimeString = value;
    }

}
