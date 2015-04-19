package pl.weztegre.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.weztegre.events.OnRegistrationCompleteEvent;
import pl.weztegre.exceptions.EmailExistsException;
import pl.weztegre.exceptions.NickExistsException;
import pl.weztegre.formObjects.AdvertisementForm;
import pl.weztegre.models.Advertisement;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping(value = "/addAdvertisement")
public class AddAdvertisementController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddAdvertisementController.class);

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @RequestMapping
    public ModelAndView addAdvertisement() {
        return new ModelAndView("addAdvertisement", "advertisementForm", new AdvertisementForm());
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addAdvertisement(@Valid final AdvertisementForm advertisementForm,  BindingResult bindingResult, HttpServletRequest httpServletRequest) {
        if(bindingResult.hasErrors())
            return "addAdvertisement";

        Advertisement advertisement = null;

        if(bindingResult.hasErrors())
            return "addAdvertisement";

        /*final String appUrl = "http://" + httpServletRequest.getServerName() + ":"
                + httpServletRequest.getServerPort()
                + httpServletRequest.getContextPath();
        applicationEventPublisher.publishEvent(new OnRegistrationCompleteEvent(advertisement, httpServletRequest.getLocale(), appUrl));
*/
        return "addAdvertisement";

    }

}
