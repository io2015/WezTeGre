package pl.weztegre.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.weztegre.formObjects.UserData;
import pl.weztegre.models.User;
import pl.weztegre.services.UserService;

import javax.validation.Valid;
import java.security.Principal;

/**
* Kontroler odpowiedzialny za zarządzanie kontem użytkownika.
*/
@Controller
@RequestMapping(value = "/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

	/**
	* Metoda wyświetlająca panel zarządzania profilem użytkownika. Jeżeli wykonano jakieś zmiany, to jako atrybut przekazywana jest informacja o sukcesie.
	* @param success Opcjonalny parametr typu String
	* @param model Model
	* @param userPrincipal
	*/
    @RequestMapping(value = "/controlPanel")
    public String controlPanel(@RequestParam(value = "success", required = false) String success, Model model, Principal userPrincipal) {
        model.addAttribute("nick", userPrincipal.getName());

        if(success != null)
            model.addAttribute("success", "Dane zostały zmienione");

        return "controlPanel";
    }

	/**
	* Metoda przekazująca do modelu dane użytkownika takie jak email.
	*/
    @RequestMapping(value = "/changeData", method = RequestMethod.GET)
    public String changeData(Model model, Principal userPrincipal) {
        User user = userService.findByEmail(userPrincipal.getName());

        model.addAttribute("userData", new UserData(user));
        model.addAttribute("email", user.getEmail());

        return "changeUserData";
    }

	/**
	* Metoda dokonująca zmian w profilu użytkownika.
	* @param userData dane o użytkowniku do zapisania
	*/
    @RequestMapping(value = "/changeData", method = RequestMethod.POST)
    public String changeDataUserContactDetails(@Valid UserData userData,  BindingResult bindingResult, Principal userPrincipal) {
        if(bindingResult.hasErrors())
            return "changeUserData";

        User user = userService.findByEmail(userPrincipal.getName());
        user.setName(userData.getName());
        user.setSurname(userData.getSurname());
        user.setCity(userData.getCity());
        user.setAddress(userData.getAddress());
        user.setGaduGadu(userData.getGaduGadu());
        user.setSkype(userData.getSkype());
        user.setPhoneNumber(userData.getPhoneNumber());
        userService.save(user);

        return "redirect:/user/controlPanel?success";
    }
}
