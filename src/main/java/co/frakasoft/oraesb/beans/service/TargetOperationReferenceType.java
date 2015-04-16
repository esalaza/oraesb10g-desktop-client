package co.frakasoft.oraesb.beans.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TargetOperationReferenceType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TargetOperationReferenceType">
 *   &lt;complexContent>
 *     &lt;extension base="{}ReferenceType">
 *       &lt;attribute name="serviceGUID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="serviceQName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="mep" type="{}MEPType" />
 *       &lt;attribute name="mepDisplayName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TargetOperationReferenceType")
public class TargetOperationReferenceType
    extends ReferenceType
{

    @XmlAttribute(name = "serviceGUID")
    protected String serviceGUID;
    @XmlAttribute(name = "serviceQName")
    protected String serviceQName;
    @XmlAttribute(name = "mep")
    protected MEPType mep;
    @XmlAttribute(name = "mepDisplayName")
    protected String mepDisplayName;

    /**
     * Obtiene el valor de la propiedad serviceGUID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceGUID() {
        return serviceGUID;
    }

    /**
     * Define el valor de la propiedad serviceGUID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceGUID(String value) {
        this.serviceGUID = value;
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
     * Obtiene el valor de la propiedad mep.
     * 
     * @return
     *     possible object is
     *     {@link MEPType }
     *     
     */
    public MEPType getMep() {
        return mep;
    }

    /**
     * Define el valor de la propiedad mep.
     * 
     * @param value
     *     allowed object is
     *     {@link MEPType }
     *     
     */
    public void setMep(MEPType value) {
        this.mep = value;
    }

    /**
     * Obtiene el valor de la propiedad mepDisplayName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMepDisplayName() {
        return mepDisplayName;
    }

    /**
     * Define el valor de la propiedad mepDisplayName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMepDisplayName(String value) {
        this.mepDisplayName = value;
    }

}
