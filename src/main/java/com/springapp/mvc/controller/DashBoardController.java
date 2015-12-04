package com.springapp.mvc.controller;

import com.springapp.mvc.dao.EventDao;
import com.springapp.mvc.dao.ReservationDao;
import com.springapp.mvc.dao.UserDao;
import com.springapp.mvc.model.Event;
import com.springapp.mvc.model.Reservation;
import com.springapp.mvc.model.UserData;
import com.springapp.mvc.service.BasicServices;
import com.springapp.mvc.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private EmailService emailService;

    public BasicServices basicServices;

    @RequestMapping(value = "/dashBoard", method = {RequestMethod.GET, RequestMethod.POST})
    public String defaultPage(ModelMap model) {
        HttpSession current = LoginController.session;

        if((current.getAttribute("userID") == null)) return "login";

        int id = (int) current.getAttribute("userID");
        UserData currentUser = userDao.findUserById(id);

        // for search results
        if((current.getAttribute("search")) != null){
            model.addAttribute("eventList", (current.getAttribute("search")));
            model.addAttribute("currentUser", currentUser);
        }

        List<Reservation> reservationList = reservationDao.findReservations(id);
        ArrayList<Integer> filter = new ArrayList<Integer>();

        for (Reservation r: reservationList) {
            filter.add(r.getEventid());
           // System.out.println(r);
        }

        List<Event> eventList = eventDao.findAllEventsNotReserved(filter);
        List<Event> toRemove = basicServices.filterAgeGenderReserved(eventList, currentUser);
        eventList.removeAll(toRemove);

        model.addAttribute("eventList", eventList);
        model.addAttribute("currentUser", currentUser);


        return "dashBoard";
    }

    @RequestMapping(value = "/eventDetails", method = {RequestMethod.GET, RequestMethod.POST})
    public String showEventDetails(ModelMap modelMap, @ModelAttribute("SpringWeb") Reservation reservation) throws SQLException {
        HttpSession current = LoginController.session;

        if((current.getAttribute("userID") == null)) return "login";

        int eventid = reservation.getEventid();
        int id = (int) current.getAttribute("userID");


        UserData currentUser = userDao.findUserById(id);
        Event thisEvent = eventDao.findEventById(eventid);
        modelMap.addAttribute("currentUser", currentUser);
        modelMap.addAttribute("currentEvent", thisEvent);
        return "eventDetails";
    }


    @RequestMapping(value = "/eventRsvp", method = RequestMethod.POST)
    public String rsvpEvent(ModelMap modelMap, @ModelAttribute("SpringWeb") Reservation reservation) throws SQLException {
        int eventid = reservation.getEventid();
        int userid = reservation.getUserid();

        UserData user = userDao.findUserById(userid);
        Event event = eventDao.findEventById(eventid);

        String user_email = user.getEmail();
        String event_name = event.getName();
        String event_date = event.getDate();



        eventDao.occupyEvent(eventid);
        reservationDao.createReservation(reservation);
        try {
            emailService.sendEmail(user_email, "footyfixtoronto@gmail.com", "Your Reservation for " + event_name + " is confirmed", "Hello "+user.getFirstname()+
                    ",\nWe received your confirmation\nYour event is on " + event_date + " at "+event_name);
        }catch (Exception e) {}
        return "dashBoard";
    }

    @RequestMapping(value ="/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public String logoutCompleted (ModelMap modelMap){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        session.invalidate();

        return "login";
    }

    @RequestMapping(value = "/searchNear", method = RequestMethod.GET)
    public String getNearbyEvents(ModelMap model){
        HttpSession current = LoginController.session;

        if((current.getAttribute("userID") == null)) return "login";

        int id = (int) current.getAttribute("userID");

        UserData currentUser = userDao.findUserById(id);

        List<Reservation> reservationList = reservationDao.findReservations(id);
        ArrayList<Integer> filter = new ArrayList<Integer>();
        for (Reservation r: reservationList) {
            filter.add(r.getEventid());
        }

        List<Event> eventList = eventDao.searchNearbyEvents(id, filter);
        List<Event> toRemove = basicServices.filterAgeGenderReserved(eventList, currentUser);
        eventList.removeAll(toRemove);

        model.addAttribute("eventList", eventList);
        model.addAttribute("currentUser", currentUser);

        current.setAttribute("search", eventList);


        return "dashBoard";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getSearchResult(ModelMap model,
                                  @RequestParam("searchText") String searchText) {

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

        List<Event> eventList = eventDao.searchEventByQuery(filter, searchText);
        List<Event> toRemove = basicServices.filterAgeGenderReserved(eventList, currentUser);
        eventList.removeAll(toRemove);
        model.addAttribute("eventList", eventList);
        model.addAttribute("currentUser", currentUser);

        current.setAttribute("search", eventList);

        return "dashBoard";

    }
}
