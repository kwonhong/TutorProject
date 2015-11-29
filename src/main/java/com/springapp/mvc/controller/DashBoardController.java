package com.springapp.mvc.controller;

import com.springapp.mvc.dao.EventDao;
import com.springapp.mvc.dao.ReservationDao;
import com.springapp.mvc.dao.UserDao;
import com.springapp.mvc.event.Event;
import com.springapp.mvc.event.Reservation;
import com.springapp.mvc.user.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



@Controller
public class DashBoardController {

    @Autowired
    private EventDao eventDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ReservationDao reservationDao;

    @RequestMapping(value = "/dashBoard", method = RequestMethod.GET)
    public String defaultPage(ModelMap model) {
        HttpSession current = LoginController.session;

        if((current.getAttribute("userID") == null)) return "login";

        int id = (int) current.getAttribute("userID");

        UserData currentUser = userDao.findUserById(id);
        List<Reservation> reservationList = reservationDao.findReservations(id);
        ArrayList<Integer> filter = new ArrayList<Integer>();

        for (Reservation r: reservationList) {
            filter.add(r.getEventid());
            System.out.println(r);
        }


        List<Event> eventList = eventDao.findAllEvents(id, filter);

        for (Event event : eventList)
        System.out.println("Event ids" +event.getId());

        model.addAttribute("eventList", eventList);
        model.addAttribute("currentUser", currentUser);


        return "dashBoard";
    }

    @RequestMapping(value = "/myPage", method = {RequestMethod.GET,RequestMethod.POST})
    public String redirectUserPage(ModelMap modelMap){
        HttpSession current = LoginController.session;
        int id = (int) current.getAttribute("userID");
        UserData currentUser = userDao.findUserById(id);
        modelMap.addAttribute("currentUser", currentUser);

        return "myPage";
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

    @RequestMapping(value = "/eventRsvp", method = RequestMethod.POST)
    public String rsvpEvent(ModelMap modelMap, @ModelAttribute("SpringWeb") Reservation reservation) throws SQLException {
        reservationDao.createReservation(reservation);
        return "redirect:/dashBoard";
    }

    @RequestMapping(value ="/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public String logoutCompleted (ModelMap modelMap){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        session.invalidate();

        return "login";
    }
}
