package co.frakasoft.util.xml;

/**
 *
 * @author esalaza
 */
public class XMLUtil {

    public static String dirtilyAddNamespaceWithPrefixForOracleESB(String rootElement, String xmlDoc) {
        xmlDoc = xmlDoc.replaceAll("<" + rootElement, "<" + "ns2:" + rootElement + " " + "xmlns:ns2=\"http://www.oracle.com/esb\"");
        xmlDoc = xmlDoc.replaceAll("</" + rootElement, "</" + "ns2:" + rootElement);
        return xmlDoc;
    }

    public static String dirtilyAddNamespaceForOracleESB(String rootElement, String xmlDoc) {
        xmlDoc = xmlDoc.replaceFirst("<" + rootElement, "<" + rootElement + " " + "xmlns=\"http://www.oracle.com/esb\"");
        return xmlDoc;
    }
}
