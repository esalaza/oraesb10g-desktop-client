package co.frakasoft.util.xml.binding;

import java.io.StringReader;
import java.io.StringWriter;
import org.apache.log4j.Logger;

/**
 *
 * @author esalaza
 */
public class JAXBUtil {
    
    static Logger logger = Logger.getLogger(JAXBUtil.class);

    public static String jaxbMarshal(Object o) {
        String xml = "";
        String className = "";
        try {
            className = o.getClass().getPackage().getName();
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(className);
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter writer = new StringWriter();
            marshaller.marshal(o, writer);
            writer.flush();
            xml = writer.toString();
        } catch (javax.xml.bind.JAXBException ex) {
            logger.fatal("Serializing object (" + className + "):\n" + o, ex); //NOI18N
        }
        return xml;
    }

    public static Object jaxbUnmarshal(String className, String xmlDoc) {
        Object o = null;

        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(className);
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            StringReader reader = new StringReader(xmlDoc);
            o = unmarshaller.unmarshal(reader); //NOI18N
        } catch (javax.xml.bind.JAXBException ex) {
            logger.fatal("Deserializing XML:\n" + xmlDoc, ex); //NOI18N

        }
        return o;
    }
}
