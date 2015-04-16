package co.frakasoft.oraesb.util;

/**
 *
 * @author esalaza
 */
public class AppServerConnectionInfo {
    
    private String host     = null;
    private String port     = null;
    private String username = null;
    private String password = null;
    private int    id       = 0;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
