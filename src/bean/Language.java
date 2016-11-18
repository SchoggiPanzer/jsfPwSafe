package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Daniel Hirt ond Michel Tüscher
 */
@ManagedBean(name = "lang")
public class Language {

    private Locale locale;

    public void init() {
        locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    }


    public Locale getLocale() {
        return locale;
    }

    public String changeLanguage(String lang){
        locale = new Locale(lang);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
        return "";
    }
}
