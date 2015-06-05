package pl.weztegre.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
* Kontroler LoginController.
* Odpowiada za logowanie na stronie.
* Podstrona /login
*/
@Controller
public class LoginController {
	/**
	* Metoda loginPage.
	* @return ModelAndView zawierający status logowania lub błędy, które zostały wychwycone podczas logowania.
	*/
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();

        if (error != null) {
            model.addObject("error", "Niepoprawna nazwa użytkownika lub hasło");
        }

        if (logout != null) {
            model.addObject("msg", "Zostałes poprawnie wylogowany");
        }
        model.setViewName("login");

        return model;//test
    }
}
