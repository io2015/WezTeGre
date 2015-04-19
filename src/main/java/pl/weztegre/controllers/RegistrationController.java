package pl.weztegre.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.weztegre.events.OnRegistrationCompleteEvent;
import pl.weztegre.exceptions.EmailExistsException;
import pl.weztegre.exceptions.NickExistsException;
import pl.weztegre.formObjects.UserForm;
import pl.weztegre.models.Registration;
import pl.weztegre.models.User;
import pl.weztegre.services.RegistrationService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Calendar;

@Controller
@RequestMapping(value = "/signup")
public class RegistrationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @RequestMapping
    public ModelAndView singUp() {
        return new ModelAndView("signup", "userForm", new UserForm());
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerUser(@Valid final UserForm userForm,  BindingResult bindingResult, HttpServletRequest httpServletRequest) {
        if(bindingResult.hasErrors())
            return "signup";

        Registration registration = registrationService.createUserAndRegistration(userForm);

        final String appUrl = "http://" + httpServletRequest.getServerName() + ":"
                + httpServletRequest.getServerPort()
                + httpServletRequest.getContextPath();

        LOGGER.info("Przed wyslaniem maila");
        applicationEventPublisher.publishEvent(new OnRegistrationCompleteEvent(registration, httpServletRequest.getLocale(), appUrl));
        LOGGER.info("Po wyslaniem maila");

        return "registeredSuccessfully";

    }

    @RequestMapping(value = "/confirm/{token}", method = RequestMethod.GET)
    public String cofirmRegistration(@PathVariable("token") String token, HttpServletRequest httpServletRequest, Model model) {
        Registration registration = registrationService.getRegistrationToken(token);

        if (registration == null)
            return "badToken";


        if ((registration.getExpiryDate().getTime() - Calendar.getInstance().getTime().getTime()) <= 0) {
            registrationService.updateUserAndRegistration(registration);

            final String appUrl = "http://" + httpServletRequest.getServerName() + ":"
                    + httpServletRequest.getServerPort()
                    + httpServletRequest.getContextPath();
            applicationEventPublisher.publishEvent(new OnRegistrationCompleteEvent(registration, httpServletRequest.getLocale(), appUrl));

            model.addAttribute("user", registration.getUser());

            return "tokenExpired";
        }

        registration.getUser().setEnabled(true);
        registrationService.saveUserAndDeleteRegistration(registration);

        return "registrationConfirmed";
    }
}
