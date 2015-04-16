package co.frakasoft.oraesb.beans.flows;

import java.math.BigInteger;
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
 *         &lt;element name="resubmitInstanceId" type="{http://www.oracle.com/esb}ResubmitInstanceId" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="onError" default="SkipAndContinue">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="SkipAndContinue"/>
 *             &lt;enumeration value="Abort"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="abortThreshold" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="delay" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "resubmitInstanceId"
})
@XmlRootElement(name = "resubmitInstanceIds")
public class ResubmitInstanceIds {

    @XmlElement(required = true)
    protected List<ResubmitInstanceId> resubmitInstanceId;
    @XmlAttribute(name = "onError")
    protected String onError;
    @XmlAttribute(name = "abortThreshold")
    protected BigInteger abortThreshold;
    @XmlAttribute(name = "delay")
    protected Long delay;

    /**
     * Gets the value of the resubmitInstanceId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resubmitInstanceId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResubmitInstanceId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResubmitInstanceId }
     * 
     * 
     */
    public List<ResubmitInstanceId> getResubmitInstanceId() {
        if (resubmitInstanceId == null) {
            resubmitInstanceId = new ArrayList<ResubmitInstanceId>();
        }
        return this.resubmitInstanceId;
    }

    /**
     * Obtiene el valor de la propiedad onError.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnError() {
        if (onError == null) {
            return "SkipAndContinue";
        } else {
            return onError;
        }
    }

    /**
     * Define el valor de la propiedad onError.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnError(String value) {
        this.onError = value;
    }

    /**
     * Obtiene el valor de la propiedad abortThreshold.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAbortThreshold() {
        return abortThreshold;
    }

    /**
     * Define el valor de la propiedad abortThreshold.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAbortThreshold(BigInteger value) {
        this.abortThreshold = value;
    }

    /**
     * Obtiene el valor de la propiedad delay.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDelay() {
        return delay;
    }

    /**
     * Define el valor de la propiedad delay.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDelay(Long value) {
        this.delay = value;
    }

}
