package pl.weztegre.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController {
    @RequestMapping(value = "/")
    public String indexPage() {
        return "index";
    }
}
