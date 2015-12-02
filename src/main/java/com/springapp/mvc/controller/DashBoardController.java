package com.springapp.mvc.controller;

import com.springapp.mvc.dao.EventDao;
import com.springapp.mvc.dao.ReservationDao;
import com.springapp.mvc.dao.UserDao;
import com.springapp.mvc.model.Event;
import com.springapp.mvc.model.Reservation;
import com.springapp.mvc.model.UserData;
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

    @RequestMapping(value = "/dashBoard", method = {RequestMethod.GET, RequestMethod.POST})
    public String defaultPage(ModelMap model) {
        HttpSession current = LoginController.session;

        if((current.getAttribute("userID") == null)) return "login";

        int id = (int) current.getAttribute("userID");

        UserData currentUser = userDao.findUserById(id);
        List<Reservation> reservationList = reservationDao.findReservations(id);
        ArrayList<Integer> filter = new ArrayList<Integer>();

        for (Reservation r: reservationList) {
            filter.add(r.getEventid());
           // System.out.println(r);
        }

        String gender = currentUser.getGender();
        List<Event> eventList = eventDao.findAllEventsNotReserved(filter);

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

        String event_sex = eventDao.findEventById(eventid).getGender();
        String user_sex = userDao.findUserById(userid).getGender();
        String user_email = userDao.findUserById(userid).getEmail();
        String event_name = eventDao.findEventById(eventid).getName();
        String event_date = eventDao.findEventById(userid).getDate();

        if (!event_sex.equalsIgnoreCase(user_sex) && !event_sex.equalsIgnoreCase("Mixed")){
            return "redirect:/dashBoard";
        }

        eventDao.occupyEvent(eventid);
        reservationDao.createReservation(reservation);
        EmailService email = new EmailService();
        email.sendEmail(user_email,);
        return "redirect:/dashBoard";
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
            // System.out.println(r);
        }

        List<Event> eventList = eventDao.searchNearbyEvents(id, filter);
        model.addAttribute("eventList", eventList);
        model.addAttribute("currentUser", currentUser);

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
        model.addAttribute("eventList", eventList);
        model.addAttribute("currentUser", currentUser);

        return "dashBoard";

    }
}
