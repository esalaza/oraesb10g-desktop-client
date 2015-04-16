package co.frakasoft.oraesb.beans.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ParentReferenceType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ParentReferenceType">
 *   &lt;complexContent>
 *     &lt;extension base="{}ReferenceType">
 *       &lt;attribute name="type" type="{}ParentType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParentReferenceType")
public class ParentReferenceType
    extends ReferenceType
{

    @XmlAttribute(name = "type")
    protected ParentType type;

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link ParentType }
     *     
     */
    public ParentType getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link ParentType }
     *     
     */
    public void setType(ParentType value) {
        this.type = value;
    }

}
