package pl.weztegre.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* Kontroler NavigationController.
* Odpowiada za wyświetlenie strony głownej.
*/
@Controller
public class NavigationController {
    /**
	* Mapowanie na /.
	* Metoda kontrolera odpowiedzialna za przekierowanie do strony głównej.
	*/
	@RequestMapping(value = "/")
    public String indexPage() {
        return "index";
    }
}
