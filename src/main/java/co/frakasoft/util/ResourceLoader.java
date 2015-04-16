package co.frakasoft.util;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.InputStream;

/**
 *
 * @author esalaza
 */
public class ResourceLoader {

    public static Image loadImage(String path, Class clazz) throws Exception {
        // Is not better new javax.swing.ImageIcon(getClass().getResource("/img/brand_logo.png"))? :|
        InputStream in = clazz.getResourceAsStream(path);
        byte buffer[] = new byte[in.available()];
        for (int i = 0, n = in.available(); i < n; i++) {
            buffer[i] = (byte) in.read();
        }
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.createImage(buffer);
        return image;
    }

}
