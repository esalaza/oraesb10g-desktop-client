package co.frakasoft.oraesb.util;

/**
 *
 * @author esalaza
 */
public class SettingsManagerFactory {
    
    private static SettingsManager settingsManager = new PreferencesSettingsManager();
    
    public static SettingsManager getSettingsManager() {
        return settingsManager;
    }
    
}
