package ru.fsinfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	@RequestMapping(value = {"/","/main"}, method = RequestMethod.GET)
	public String index(ModelMap model) {
		return "index";
	}

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info(ModelMap model) {
        return "info";
    }
}