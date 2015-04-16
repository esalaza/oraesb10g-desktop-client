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
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}versionInfo" minOccurs="0"/>
 *         &lt;element name="parent" type="{}ParentReferenceType" minOccurs="0"/>
 *         &lt;element name="serviceDefinition" type="{}ServiceDefinitionType" minOccurs="0"/>
 *         &lt;element name="invocation" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="targetService" type="{}ReferenceType" minOccurs="0"/>
 *                   &lt;element name="interface" type="{}WSDLInfoType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="parameters" type="{}ParametersType" minOccurs="0"/>
 *         &lt;element name="operations" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="operationInfo" type="{}OperationInfoType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="endpointProperties" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="property" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="trackableFields" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="trackableField" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="operationRef" type="{}OperationReferenceType"/>
 *                             &lt;element name="expression" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="status" type="{}StatusType" default="ENABLED" />
 *                           &lt;attribute name="bindTo" type="{}BindingType" default="REQUEST" />
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
 *       &lt;attGroup ref="{}ServiceTypeInfo"/>
 *       &lt;attGroup ref="{}IdentifierInfo"/>
 *       &lt;attribute name="isWSDLEditable" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="status" type="{}ServiceStatusType" />
 *       &lt;attribute name="soapEndpointStatus" type="{}SoapEndpointStatusType" />
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
    "versionInfo",
    "parent",
    "serviceDefinition",
    "invocation",
    "parameters",
    "operations",
    "endpointProperties",
    "trackableFields"
})
@XmlRootElement(name = "service")
public class Service {

    protected String description;
    protected VersionInfo versionInfo;
    protected ParentReferenceType parent;
    protected ServiceDefinitionType serviceDefinition;
    protected List<Service.Invocation> invocation;
    protected ParametersType parameters;
    protected Service.Operations operations;
    protected Service.EndpointProperties endpointProperties;
    protected Service.TrackableFields trackableFields;
    @XmlAttribute(name = "isWSDLEditable")
    protected Boolean isWSDLEditable;
    @XmlAttribute(name = "status")
    protected String status;
    @XmlAttribute(name = "soapEndpointStatus")
    protected String soapEndpointStatus;
    @XmlAttribute(name = "typeDescription")
    protected String typeDescription;
    @XmlAttribute(name = "serviceSubType")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String serviceSubType;
    @XmlAttribute(name = "serviceType")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String serviceType;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "guid")
    protected String guid;
    @XmlAttribute(name = "dirty")
    protected Boolean dirty;
    @XmlAttribute(name = "qname")
    protected String qname;

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtiene el valor de la propiedad versionInfo.
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
     * Obtiene el valor de la propiedad parent.
     * 
     * @return
     *     possible object is
     *     {@link ParentReferenceType }
     *     
     */
    public ParentReferenceType getParent() {
        return parent;
    }

    /**
     * Define el valor de la propiedad parent.
     * 
     * @param value
     *     allowed object is
     *     {@link ParentReferenceType }
     *     
     */
    public void setParent(ParentReferenceType value) {
        this.parent = value;
    }

    /**
     * Obtiene el valor de la propiedad serviceDefinition.
     * 
     * @return
     *     possible object is
     *     {@link ServiceDefinitionType }
     *     
     */
    public ServiceDefinitionType getServiceDefinition() {
        return serviceDefinition;
    }

    /**
     * Define el valor de la propiedad serviceDefinition.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceDefinitionType }
     *     
     */
    public void setServiceDefinition(ServiceDefinitionType value) {
        this.serviceDefinition = value;
    }

    /**
     * Gets the value of the invocation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the invocation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvocation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Service.Invocation }
     * 
     * 
     */
    public List<Service.Invocation> getInvocation() {
        if (invocation == null) {
            invocation = new ArrayList<Service.Invocation>();
        }
        return this.invocation;
    }

    /**
     * Obtiene el valor de la propiedad parameters.
     * 
     * @return
     *     possible object is
     *     {@link ParametersType }
     *     
     */
    public ParametersType getParameters() {
        return parameters;
    }

    /**
     * Define el valor de la propiedad parameters.
     * 
     * @param value
     *     allowed object is
     *     {@link ParametersType }
     *     
     */
    public void setParameters(ParametersType value) {
        this.parameters = value;
    }

    /**
     * Obtiene el valor de la propiedad operations.
     * 
     * @return
     *     possible object is
     *     {@link Service.Operations }
     *     
     */
    public Service.Operations getOperations() {
        return operations;
    }

    /**
     * Define el valor de la propiedad operations.
     * 
     * @param value
     *     allowed object is
     *     {@link Service.Operations }
     *     
     */
    public void setOperations(Service.Operations value) {
        this.operations = value;
    }

    /**
     * Obtiene el valor de la propiedad endpointProperties.
     * 
     * @return
     *     possible object is
     *     {@link Service.EndpointProperties }
     *     
     */
    public Service.EndpointProperties getEndpointProperties() {
        return endpointProperties;
    }

    /**
     * Define el valor de la propiedad endpointProperties.
     * 
     * @param value
     *     allowed object is
     *     {@link Service.EndpointProperties }
     *     
     */
    public void setEndpointProperties(Service.EndpointProperties value) {
        this.endpointProperties = value;
    }

    /**
     * Obtiene el valor de la propiedad trackableFields.
     * 
     * @return
     *     possible object is
     *     {@link Service.TrackableFields }
     *     
     */
    public Service.TrackableFields getTrackableFields() {
        return trackableFields;
    }

    /**
     * Define el valor de la propiedad trackableFields.
     * 
     * @param value
     *     allowed object is
     *     {@link Service.TrackableFields }
     *     
     */
    public void setTrackableFields(Service.TrackableFields value) {
        this.trackableFields = value;
    }

    /**
     * Obtiene el valor de la propiedad isWSDLEditable.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsWSDLEditable() {
        return isWSDLEditable;
    }

    /**
     * Define el valor de la propiedad isWSDLEditable.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsWSDLEditable(Boolean value) {
        this.isWSDLEditable = value;
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
     * Obtiene el valor de la propiedad soapEndpointStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoapEndpointStatus() {
        return soapEndpointStatus;
    }

    /**
     * Define el valor de la propiedad soapEndpointStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoapEndpointStatus(String value) {
        this.soapEndpointStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad typeDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeDescription() {
        return typeDescription;
    }

    /**
     * Define el valor de la propiedad typeDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeDescription(String value) {
        this.typeDescription = value;
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
     * Obtiene el valor de la propiedad dirty.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isDirty() {
        if (dirty == null) {
            return true;
        } else {
            return dirty;
        }
    }

    /**
     * Define el valor de la propiedad dirty.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDirty(Boolean value) {
        this.dirty = value;
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
     *         &lt;element name="property" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        "property"
    })
    public static class EndpointProperties {

        protected List<Service.EndpointProperties.Property> property;

        /**
         * Gets the value of the property property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the property property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProperty().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Service.EndpointProperties.Property }
         * 
         * 
         */
        public List<Service.EndpointProperties.Property> getProperty() {
            if (property == null) {
                property = new ArrayList<Service.EndpointProperties.Property>();
            }
            return this.property;
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
         *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Property {

            @XmlAttribute(name = "name", required = true)
            protected String name;
            @XmlAttribute(name = "value", required = true)
            protected String value;

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
             * Obtiene el valor de la propiedad value.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Define el valor de la propiedad value.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

        }

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
     *         &lt;element name="targetService" type="{}ReferenceType" minOccurs="0"/>
     *         &lt;element name="interface" type="{}WSDLInfoType" minOccurs="0"/>
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
        "targetService",
        "_interface"
    })
    public static class Invocation {

        protected ReferenceType targetService;
        @XmlElement(name = "interface")
        protected WSDLInfoType _interface;

        /**
         * Obtiene el valor de la propiedad targetService.
         * 
         * @return
         *     possible object is
         *     {@link ReferenceType }
         *     
         */
        public ReferenceType getTargetService() {
            return targetService;
        }

        /**
         * Define el valor de la propiedad targetService.
         * 
         * @param value
         *     allowed object is
         *     {@link ReferenceType }
         *     
         */
        public void setTargetService(ReferenceType value) {
            this.targetService = value;
        }

        /**
         * Obtiene el valor de la propiedad interface.
         * 
         * @return
         *     possible object is
         *     {@link WSDLInfoType }
         *     
         */
        public WSDLInfoType getInterface() {
            return _interface;
        }

        /**
         * Define el valor de la propiedad interface.
         * 
         * @param value
         *     allowed object is
         *     {@link WSDLInfoType }
         *     
         */
        public void setInterface(WSDLInfoType value) {
            this._interface = value;
        }

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
     *         &lt;element name="operationInfo" type="{}OperationInfoType" maxOccurs="unbounded"/>
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
        "operationInfo"
    })
    public static class Operations {

        @XmlElement(required = true)
        protected List<OperationInfoType> operationInfo;

        /**
         * Gets the value of the operationInfo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the operationInfo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOperationInfo().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OperationInfoType }
         * 
         * 
         */
        public List<OperationInfoType> getOperationInfo() {
            if (operationInfo == null) {
                operationInfo = new ArrayList<OperationInfoType>();
            }
            return this.operationInfo;
        }

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
     *         &lt;element name="trackableField" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="operationRef" type="{}OperationReferenceType"/>
     *                   &lt;element name="expression" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="status" type="{}StatusType" default="ENABLED" />
     *                 &lt;attribute name="bindTo" type="{}BindingType" default="REQUEST" />
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
        "trackableField"
    })
    public static class TrackableFields {

        @XmlElement(required = true)
        protected List<Service.TrackableFields.TrackableField> trackableField;

        /**
         * Gets the value of the trackableField property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the trackableField property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTrackableField().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Service.TrackableFields.TrackableField }
         * 
         * 
         */
        public List<Service.TrackableFields.TrackableField> getTrackableField() {
            if (trackableField == null) {
                trackableField = new ArrayList<Service.TrackableFields.TrackableField>();
            }
            return this.trackableField;
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
         *         &lt;element name="operationRef" type="{}OperationReferenceType"/>
         *         &lt;element name="expression" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="status" type="{}StatusType" default="ENABLED" />
         *       &lt;attribute name="bindTo" type="{}BindingType" default="REQUEST" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "operationRef",
            "expression"
        })
        public static class TrackableField {

            @XmlElement(required = true)
            protected OperationReferenceType operationRef;
            @XmlElement(required = true)
            protected String expression;
            @XmlAttribute(name = "name", required = true)
            protected String name;
            @XmlAttribute(name = "status")
            protected StatusType status;
            @XmlAttribute(name = "bindTo")
            protected BindingType bindTo;

            /**
             * Obtiene el valor de la propiedad operationRef.
             * 
             * @return
             *     possible object is
             *     {@link OperationReferenceType }
             *     
             */
            public OperationReferenceType getOperationRef() {
                return operationRef;
            }

            /**
             * Define el valor de la propiedad operationRef.
             * 
             * @param value
             *     allowed object is
             *     {@link OperationReferenceType }
             *     
             */
            public void setOperationRef(OperationReferenceType value) {
                this.operationRef = value;
            }

            /**
             * Obtiene el valor de la propiedad expression.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getExpression() {
                return expression;
            }

            /**
             * Define el valor de la propiedad expression.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setExpression(String value) {
                this.expression = value;
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
             * Obtiene el valor de la propiedad status.
             * 
             * @return
             *     possible object is
             *     {@link StatusType }
             *     
             */
            public StatusType getStatus() {
                if (status == null) {
                    return StatusType.ENABLED;
                } else {
                    return status;
                }
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
             * Obtiene el valor de la propiedad bindTo.
             * 
             * @return
             *     possible object is
             *     {@link BindingType }
             *     
             */
            public BindingType getBindTo() {
                if (bindTo == null) {
                    return BindingType.REQUEST;
                } else {
                    return bindTo;
                }
            }

            /**
             * Define el valor de la propiedad bindTo.
             * 
             * @param value
             *     allowed object is
             *     {@link BindingType }
             *     
             */
            public void setBindTo(BindingType value) {
                this.bindTo = value;
            }

        }

    }

}
