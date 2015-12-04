package com.springapp.mvc.controller;


import com.springapp.mvc.dao.EventDao;
import com.springapp.mvc.dao.ReservationDao;
import com.springapp.mvc.dao.UserDao;
import com.springapp.mvc.model.Event;
import com.springapp.mvc.model.Reservation;
import com.springapp.mvc.service.BasicServices;
import com.springapp.mvc.service.GeocodingApi;
import com.springapp.mvc.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private EventDao eventDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ReservationDao reservationDao;

    @RequestMapping(value = "/adminPage", method = {RequestMethod.GET, RequestMethod.POST})
    public String adminPage(ModelMap model){
        HttpSession current = LoginController.session;
        UserData admin = userDao.findUserById((Integer) current.getAttribute("userID"));
        if(!admin.getUsername().equalsIgnoreCase("admin")) return "login";
        List<Event> eventList = eventDao.findAllEvents();
        model.addAttribute("eventList", eventList);

        return "adminPage";
    }

    @RequestMapping(value = "/eventDelete", method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteEvent(ModelMap modelMap, @ModelAttribute("eventid") int eventID) {
        Event event = eventDao.findEventById(eventID);
        eventDao.deleteEvent(event);
        List <Reservation> reservations = reservationDao.findReservationsByEvent(eventID);
        for (Reservation reservation : reservations) reservationDao.delete(reservation);
        return "redirect: adminPage";
    }

    @RequestMapping(value = "/eventCreate", method = {RequestMethod.GET, RequestMethod.POST})
    public String redirectEventCreatePage(ModelMap modelMap) {
        HttpSession current = LoginController.session;
        UserData admin = userDao.findUserById((Integer) current.getAttribute("userID"));
        if(!admin.getUsername().equalsIgnoreCase("admin")) return "login";
        return "eventCreate";
    }

    @RequestMapping(value = "/eventCreateSubmit", method = RequestMethod.POST)
    public String submitEvent(ModelMap modelMap, @ModelAttribute("SpringWeb") Event event) {
        double lat = 0;
        double lon = 0;
        BasicServices fcn =  new BasicServices();
        GeocodingApi Geocode = new GeocodingApi();
        String address = fcn.eventAddress(event);
        try {
            lat = Geocode.getLatitude(address);
            lon = Geocode.getLongitude(address);
        }catch (Exception e){
            e.printStackTrace();
            return "eventCreate";
        }
        event.setGeolat(lat);
        event.setGeolon(lon);
        eventDao.persist(event);
        return "dashBoard";
    }



}
