package GUI.other;

import java.util.Locale;
import java.util.ResourceBundle;

public class Translator {
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("bundles.messages",Locale.getDefault());

    public String getTranslation(String key) {
        return resourceBundle.getString(key);
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle("bundles.messages", locale);
        resourceBundle.getLocale();
    }

    public String getLocale(){
        return resourceBundle.getLocale().toString();
    }
}
