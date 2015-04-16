package co.frakasoft.oraesb.beans.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Clase Java para OperationInfoType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="OperationInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;sequence>
 *           &lt;element name="request" type="{}RequestReplyFaultType" minOccurs="0"/>
 *           &lt;element name="reply" type="{}RequestReplyFaultType" minOccurs="0"/>
 *           &lt;element name="fault" type="{}RequestReplyFaultType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;element name="routingRules" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="routingRule" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="targetOperation" type="{}TargetOperationReferenceType"/>
 *                             &lt;element name="filterExpression" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="transformation" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="xslFileURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="replyHandler" type="{}HandlerType" minOccurs="0"/>
 *                             &lt;element name="faultHandler" type="{}HandlerType" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="guid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="subscriptionType" use="required">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;enumeration value="LOCAL"/>
 *                                 &lt;enumeration value="EXTERNAL"/>
 *                                 &lt;enumeration value="ANY"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="executionType" use="required">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;enumeration value="Immediate"/>
 *                                 &lt;enumeration value="Deferred"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="status" type="{}StatusType" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="wsdlOperation" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="guid" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="mep" type="{}MEPType" />
 *       &lt;attribute name="mepDisplayName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="qname" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperationInfoType", propOrder = {
    "request",
    "reply",
    "fault",
    "routingRules"
})
public class OperationInfoType {

    protected RequestReplyFaultType request;
    protected RequestReplyFaultType reply;
    protected List<RequestReplyFaultType> fault;
    protected OperationInfoType.RoutingRules routingRules;
    @XmlAttribute(name = "wsdlOperation", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String wsdlOperation;
    @XmlAttribute(name = "guid", required = true)
    protected String guid;
    @XmlAttribute(name = "mep")
    protected MEPType mep;
    @XmlAttribute(name = "mepDisplayName")
    protected String mepDisplayName;
    @XmlAttribute(name = "qname")
    protected String qname;

    /**
     * Obtiene el valor de la propiedad request.
     * 
     * @return
     *     possible object is
     *     {@link RequestReplyFaultType }
     *     
     */
    public RequestReplyFaultType getRequest() {
        return request;
    }

    /**
     * Define el valor de la propiedad request.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestReplyFaultType }
     *     
     */
    public void setRequest(RequestReplyFaultType value) {
        this.request = value;
    }

    /**
     * Obtiene el valor de la propiedad reply.
     * 
     * @return
     *     possible object is
     *     {@link RequestReplyFaultType }
     *     
     */
    public RequestReplyFaultType getReply() {
        return reply;
    }

    /**
     * Define el valor de la propiedad reply.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestReplyFaultType }
     *     
     */
    public void setReply(RequestReplyFaultType value) {
        this.reply = value;
    }

    /**
     * Gets the value of the fault property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fault property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFault().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RequestReplyFaultType }
     * 
     * 
     */
    public List<RequestReplyFaultType> getFault() {
        if (fault == null) {
            fault = new ArrayList<RequestReplyFaultType>();
        }
        return this.fault;
    }

    /**
     * Obtiene el valor de la propiedad routingRules.
     * 
     * @return
     *     possible object is
     *     {@link OperationInfoType.RoutingRules }
     *     
     */
    public OperationInfoType.RoutingRules getRoutingRules() {
        return routingRules;
    }

    /**
     * Define el valor de la propiedad routingRules.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationInfoType.RoutingRules }
     *     
     */
    public void setRoutingRules(OperationInfoType.RoutingRules value) {
        this.routingRules = value;
    }

    /**
     * Obtiene el valor de la propiedad wsdlOperation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWsdlOperation() {
        return wsdlOperation;
    }

    /**
     * Define el valor de la propiedad wsdlOperation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWsdlOperation(String value) {
        this.wsdlOperation = value;
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
     *         &lt;element name="routingRule" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="targetOperation" type="{}TargetOperationReferenceType"/>
     *                   &lt;element name="filterExpression" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="transformation" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="xslFileURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="replyHandler" type="{}HandlerType" minOccurs="0"/>
     *                   &lt;element name="faultHandler" type="{}HandlerType" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="guid" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="subscriptionType" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;enumeration value="LOCAL"/>
     *                       &lt;enumeration value="EXTERNAL"/>
     *                       &lt;enumeration value="ANY"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="executionType" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;enumeration value="Immediate"/>
     *                       &lt;enumeration value="Deferred"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="status" type="{}StatusType" />
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
        "routingRule"
    })
    public static class RoutingRules {

        @XmlElement(required = true)
        protected List<OperationInfoType.RoutingRules.RoutingRule> routingRule;

        /**
         * Gets the value of the routingRule property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the routingRule property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRoutingRule().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OperationInfoType.RoutingRules.RoutingRule }
         * 
         * 
         */
        public List<OperationInfoType.RoutingRules.RoutingRule> getRoutingRule() {
            if (routingRule == null) {
                routingRule = new ArrayList<OperationInfoType.RoutingRules.RoutingRule>();
            }
            return this.routingRule;
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
         *         &lt;element name="targetOperation" type="{}TargetOperationReferenceType"/>
         *         &lt;element name="filterExpression" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="transformation" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="xslFileURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="replyHandler" type="{}HandlerType" minOccurs="0"/>
         *         &lt;element name="faultHandler" type="{}HandlerType" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *       &lt;attribute name="guid" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="subscriptionType" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;enumeration value="LOCAL"/>
         *             &lt;enumeration value="EXTERNAL"/>
         *             &lt;enumeration value="ANY"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="executionType" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;enumeration value="Immediate"/>
         *             &lt;enumeration value="Deferred"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="status" type="{}StatusType" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "targetOperation",
            "filterExpression",
            "transformation",
            "replyHandler",
            "faultHandler"
        })
        public static class RoutingRule {

            @XmlElement(required = true)
            protected TargetOperationReferenceType targetOperation;
            protected String filterExpression;
            protected OperationInfoType.RoutingRules.RoutingRule.Transformation transformation;
            protected HandlerType replyHandler;
            protected List<HandlerType> faultHandler;
            @XmlAttribute(name = "guid")
            protected String guid;
            @XmlAttribute(name = "subscriptionType", required = true)
            protected String subscriptionType;
            @XmlAttribute(name = "executionType", required = true)
            protected String executionType;
            @XmlAttribute(name = "status")
            protected StatusType status;

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
             * Obtiene el valor de la propiedad transformation.
             * 
             * @return
             *     possible object is
             *     {@link OperationInfoType.RoutingRules.RoutingRule.Transformation }
             *     
             */
            public OperationInfoType.RoutingRules.RoutingRule.Transformation getTransformation() {
                return transformation;
            }

            /**
             * Define el valor de la propiedad transformation.
             * 
             * @param value
             *     allowed object is
             *     {@link OperationInfoType.RoutingRules.RoutingRule.Transformation }
             *     
             */
            public void setTransformation(OperationInfoType.RoutingRules.RoutingRule.Transformation value) {
                this.transformation = value;
            }

            /**
             * Obtiene el valor de la propiedad replyHandler.
             * 
             * @return
             *     possible object is
             *     {@link HandlerType }
             *     
             */
            public HandlerType getReplyHandler() {
                return replyHandler;
            }

            /**
             * Define el valor de la propiedad replyHandler.
             * 
             * @param value
             *     allowed object is
             *     {@link HandlerType }
             *     
             */
            public void setReplyHandler(HandlerType value) {
                this.replyHandler = value;
            }

            /**
             * Gets the value of the faultHandler property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the faultHandler property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getFaultHandler().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link HandlerType }
             * 
             * 
             */
            public List<HandlerType> getFaultHandler() {
                if (faultHandler == null) {
                    faultHandler = new ArrayList<HandlerType>();
                }
                return this.faultHandler;
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
             * Obtiene el valor de la propiedad subscriptionType.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSubscriptionType() {
                return subscriptionType;
            }

            /**
             * Define el valor de la propiedad subscriptionType.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSubscriptionType(String value) {
                this.subscriptionType = value;
            }

            /**
             * Obtiene el valor de la propiedad executionType.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getExecutionType() {
                return executionType;
            }

            /**
             * Define el valor de la propiedad executionType.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setExecutionType(String value) {
                this.executionType = value;
            }

            /**
             * Obtiene el valor de la propiedad status.
             * 
             * @return
             *     possible object is
             *     {@link StatusType }
             *     
             */
            public StatusType getStatus() {
                return status;
            }

            /**
             * Define el valor de la propiedad status.
             * 
             * @param value
             *     allowed object is
             *     {@link StatusType }
             *     
             */
            public void setStatus(StatusType value) {
                this.status = value;
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
             *         &lt;element name="xslFileURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
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
                "xslFileURL"
            })
            public static class Transformation {

                @XmlElement(required = true)
                @XmlSchemaType(name = "anyURI")
                protected String xslFileURL;

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

            }

        }

    }

}
