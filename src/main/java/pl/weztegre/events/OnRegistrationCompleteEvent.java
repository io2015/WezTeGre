package pl.weztegre.events;

import org.springframework.context.ApplicationEvent;
import pl.weztegre.models.Registration;

import java.util.Locale;

/**
* Klasa zdarzenia OnRegistrationCompleteEvent.
*/
@SuppressWarnings("serial")
public class OnRegistrationCompleteEvent extends ApplicationEvent {

    private final String appUrl;
    private final Locale locale;
    private final Registration registration;

	/**
	* Konstruktor klasy.
	* @param registration Typ Registration
	* @param locale Typ Locale
	* @param appUrl String
	*/
    public OnRegistrationCompleteEvent(Registration registration, Locale locale, String appUrl) {
        super(registration);
        this.registration = registration;
        this.locale = locale;
        this.appUrl = appUrl;
    }

	
	/**
	* @return AppUrl
	*/
    public String getAppUrl() {
        return appUrl;
    }

	/**
	* @return Locale
	*/
    public Locale getLocale() {
        return locale;
    }

	/**
	* @return Registration
	*/
    public Registration getRegistration() {
        return registration;
    }
}