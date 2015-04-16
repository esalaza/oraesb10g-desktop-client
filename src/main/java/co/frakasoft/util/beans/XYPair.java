package co.frakasoft.util.beans;

/**
 *
 * @author esalaza
 */
public class XYPair {
    private String x;
    private String y;

    /**
     * @return the x
     */
    public String getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(String x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public String getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(String y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "X = " + x + ", Y = " + y;
    }

}
