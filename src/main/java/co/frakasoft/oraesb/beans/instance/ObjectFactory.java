package co.frakasoft.oraesb.beans.instance;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.frakasoft.oraesb.beans.instance package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MessageInstance_QNAME = new QName("http://www.oracle.com/esb", "messageInstance");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.frakasoft.oraesb.beans.instance
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MessageInstances }
     * 
     */
    public MessageInstances createMessageInstances() {
        return new MessageInstances();
    }

    /**
     * Create an instance of {@link MessageInstanceType }
     * 
     */
    public MessageInstanceType createMessageInstanceType() {
        return new MessageInstanceType();
    }

    /**
     * Create an instance of {@link Instance }
     * 
     */
    public Instance createInstance() {
        return new Instance();
    }

    /**
     * Create an instance of {@link FailedInstance }
     * 
     */
    public FailedInstance createFailedInstance() {
        return new FailedInstance();
    }

    /**
     * Create an instance of {@link Instances }
     * 
     */
    public Instances createInstances() {
        return new Instances();
    }

    /**
     * Create an instance of {@link ErrorInstances }
     * 
     */
    public ErrorInstances createErrorInstances() {
        return new ErrorInstances();
    }

    /**
     * Create an instance of {@link ErrorInstance }
     * 
     */
    public ErrorInstance createErrorInstance() {
        return new ErrorInstance();
    }

    /**
     * Create an instance of {@link InstanceLinkType }
     * 
     */
    public InstanceLinkType createInstanceLinkType() {
        return new InstanceLinkType();
    }

    /**
     * Create an instance of {@link FailedInstanceLinkType }
     * 
     */
    public FailedInstanceLinkType createFailedInstanceLinkType() {
        return new FailedInstanceLinkType();
    }

    /**
     * Create an instance of {@link ResubmissionFailureReport }
     * 
     */
    public ResubmissionFailureReport createResubmissionFailureReport() {
        return new ResubmissionFailureReport();
    }

    /**
     * Create an instance of {@link ResubmitInstanceId }
     * 
     */
    public ResubmitInstanceId createResubmitInstanceId() {
        return new ResubmitInstanceId();
    }

    /**
     * Create an instance of {@link ResubmitInstanceIds }
     * 
     */
    public ResubmitInstanceIds createResubmitInstanceIds() {
        return new ResubmitInstanceIds();
    }

    /**
     * Create an instance of {@link PurgeInstance }
     * 
     */
    public PurgeInstance createPurgeInstance() {
        return new PurgeInstance();
    }

    /**
     * Create an instance of {@link FailedInstances }
     * 
     */
    public FailedInstances createFailedInstances() {
        return new FailedInstances();
    }

    /**
     * Create an instance of {@link InstanceManage }
     * 
     */
    public InstanceManage createInstanceManage() {
        return new InstanceManage();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageInstanceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.oracle.com/esb", name = "messageInstance")
    public JAXBElement<MessageInstanceType> createMessageInstance(MessageInstanceType value) {
        return new JAXBElement<MessageInstanceType>(_MessageInstance_QNAME, MessageInstanceType.class, null, value);
    }

}
