package pl.weztegre.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
*  Kontroler nawigacja
*/
@Controller
public class NavigationController {

	/**
	* Metoda przekierowuje na stronę główną
	*/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String startPage() {
        return "redirect:advertisement/list";
    }
}
