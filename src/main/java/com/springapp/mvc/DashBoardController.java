package com.springapp.mvc;

import com.springapp.mvc.dao.EventDao;
import com.springapp.mvc.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;



@Controller
public class DashBoardController {

    @Autowired
    private EventDao eventDao;

    @RequestMapping(value = "/dashBoard", method = RequestMethod.GET)
    public String defaultPage(ModelMap model) {
        HttpSession current = LoginController.session;

        if((current.getAttribute("userID") == null)) return "login";


        List<Event> eventList = eventDao.findAllEvents();
        model.addAttribute("eventList", eventList);



        return "dashBoard";
    }

    @RequestMapping(value = "/eventCreate", method = RequestMethod.GET)
    public String redirectEventCreatePage(ModelMap modelMap) {
        System.out.println("C");
        return "eventRegistration";
    }

    @RequestMapping(value = "/eventCreateSubmit", method = RequestMethod.POST)
    public String submitEvent(ModelMap modelMap, @ModelAttribute("SpringWeb") Event soccerEvent) {
        return "dashBoard";
    }

    @RequestMapping(value ="/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public String logOut (ModelMap modelMap){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        session.invalidate();

        return "login";
    }
}
