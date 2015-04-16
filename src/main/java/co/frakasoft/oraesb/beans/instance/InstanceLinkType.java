package co.frakasoft.oraesb.beans.instance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para InstanceLinkType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="InstanceLinkType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="filterExpression" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xslFileURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="guid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="subFlowId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="serviceQName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="operationQName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InstanceLinkType", propOrder = {
    "filterExpression",
    "xslFileURL"
})
@XmlSeeAlso({
    FailedInstanceLinkType.class
})
public class InstanceLinkType {

    protected String filterExpression;
    protected String xslFileURL;
    @XmlAttribute(name = "guid")
    protected String guid;
    @XmlAttribute(name = "subFlowId", required = true)
    protected String subFlowId;
    @XmlAttribute(name = "serviceQName", required = true)
    protected String serviceQName;
    @XmlAttribute(name = "operationQName", required = true)
    protected String operationQName;

    /**
     * Obtiene el valor de la propiedad filterExpression.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilterExpression() {
        return filterExpression;
    }

    /**
     * Define el valor de la propiedad filterExpression.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilterExpression(String value) {
        this.filterExpression = value;
    }

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
     * Obtiene el valor de la propiedad subFlowId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubFlowId() {
        return subFlowId;
    }

    /**
     * Define el valor de la propiedad subFlowId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubFlowId(String value) {
        this.subFlowId = value;
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
     * Obtiene el valor de la propiedad operationQName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationQName() {
        return operationQName;
    }

    /**
     * Define el valor de la propiedad operationQName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationQName(String value) {
        this.operationQName = value;
    }

}
