package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by honkwon on 15-10-12.
 */

@Controller
public class DashBoardController {

    @RequestMapping(value = "/dashBoard", method = RequestMethod.GET)
    public String defaultPage(ModelMap model) {
        //TODO Populate All the Soccer Events


        //TODO Display All the Soccer Events


        return "dashBoard";
    }

    @RequestMapping(value = "/eventCreate", method = RequestMethod.GET)
    public String redirectEventCreatePage(ModelMap modelMap) {
        System.out.println("C");
        return "eventRegistration";
    }

    @RequestMapping(value = "/eventCreateSubmit", method = RequestMethod.POST)
    public String submitEvent(ModelMap modelMap, @ModelAttribute("SpringWeb") SoccerEvent soccerEvent) {
        System.out.println(soccerEvent.getTitle());
        return "dashBoard";
    }

}
