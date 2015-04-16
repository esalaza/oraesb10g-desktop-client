package co.frakasoft.oraesb.beans.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para HandlerType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="HandlerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="transformation" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{}TransformationType">
 *                 &lt;attribute name="attachRequestPayload" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="targetOperation" type="{}TargetOperationReferenceType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HandlerType", propOrder = {
    "transformation",
    "targetOperation"
})
public class HandlerType {

    protected HandlerType.Transformation transformation;
    protected TargetOperationReferenceType targetOperation;

    /**
     * Obtiene el valor de la propiedad transformation.
     * 
     * @return
     *     possible object is
     *     {@link HandlerType.Transformation }
     *     
     */
    public HandlerType.Transformation getTransformation() {
        return transformation;
    }

    /**
     * Define el valor de la propiedad transformation.
     * 
     * @param value
     *     allowed object is
     *     {@link HandlerType.Transformation }
     *     
     */
    public void setTransformation(HandlerType.Transformation value) {
        this.transformation = value;
    }

    /**
     * Obtiene el valor de la propiedad targetOperation.
     * 
     * @return
     *     possible object is
     *     {@link TargetOperationReferenceType }
     *     
     */
    public TargetOperationReferenceType getTargetOperation() {
        return targetOperation;
    }

    /**
     * Define el valor de la propiedad targetOperation.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetOperationReferenceType }
     *     
     */
    public void setTargetOperation(TargetOperationReferenceType value) {
        this.targetOperation = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{}TransformationType">
     *       &lt;attribute name="attachRequestPayload" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Transformation
        extends TransformationType
    {

        @XmlAttribute(name = "attachRequestPayload")
        protected Boolean attachRequestPayload;

        /**
         * Obtiene el valor de la propiedad attachRequestPayload.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isAttachRequestPayload() {
            return attachRequestPayload;
        }

        /**
         * Define el valor de la propiedad attachRequestPayload.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setAttachRequestPayload(Boolean value) {
            this.attachRequestPayload = value;
        }

    }

}
