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
import java.util.*;

@Controller
public class UserPageController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    private EventDao eventDao;

    @RequestMapping(value = "/myPage", method = {RequestMethod.GET, RequestMethod.POST})
    public String defaultPage(ModelMap model) {
        HttpSession current = LoginController.session;
        if((current.getAttribute("userID") == null)) return "login";
        int id = (int) current.getAttribute("userID");

        UserData currentUser = userDao.findUserById(id);
        List<Reservation> reservationList = reservationDao.findReservations(id);

        ArrayList <Event> reservedList = new ArrayList<Event>();

        for (Reservation r: reservationList) {
            int eventid = r.getEventid();
            Event event = eventDao.findEventById(eventid);
            reservedList.add(event);
        }


        model.addAttribute("currentUser", currentUser);
        model.addAttribute("reservedList", reservedList);

        return "myPage";
    }

    @RequestMapping(value ="/cancelRsvp", method = {RequestMethod.GET, RequestMethod.POST})
    public String cancelReservation (ModelMap modelMap,
                                     @ModelAttribute("userid") int userID,
                                     @ModelAttribute("eventid") int eventID){

        Reservation reservation = reservationDao.findReservationWithEventAndUserId(userID, eventID);
        reservationDao.deleteReservation(reservation);
        return "redirect:/myPage";
    }
}

