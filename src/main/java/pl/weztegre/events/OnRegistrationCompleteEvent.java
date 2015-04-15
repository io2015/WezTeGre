package pl.weztegre.events;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;
import pl.weztegre.models.Registration;
import pl.weztegre.models.User;

@SuppressWarnings("serial")
public class OnRegistrationCompleteEvent extends ApplicationEvent {

    private final String appUrl;
    private final Locale locale;
    private final Registration registration;

    public OnRegistrationCompleteEvent(Registration registration, Locale locale, String appUrl) {
        super(registration);
        this.registration = registration;
        this.locale = locale;
        this.appUrl = appUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public Locale getLocale() {
        return locale;
    }

    public Registration getRegistration() {
        return registration;
    }
}