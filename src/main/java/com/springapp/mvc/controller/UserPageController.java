package com.springapp.mvc.controller;

import com.springapp.mvc.dao.EventDao;
import com.springapp.mvc.dao.ReservationDao;
import com.springapp.mvc.dao.UserDao;
import com.springapp.mvc.model.Event;
import com.springapp.mvc.model.Reservation;
import com.springapp.mvc.service.GeocodingApi;
import com.springapp.mvc.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
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
        eventDao.freeUpSLot(eventID);
        return "redirect:/myPage";
    }

    @RequestMapping(value ="editInfo", method = RequestMethod.POST)
    public String displayForm (ModelMap model){
        HttpSession current = LoginController.session;
        if((current.getAttribute("userID") == null)) return "login";
        int id = (int) current.getAttribute("userID");
        UserData currentUser = userDao.findUserById(id);
        model.addAttribute("user", currentUser);
        return "editUserInfo";
    }

    @RequestMapping(value = "/editUserSubmit", method = RequestMethod.POST)
    public String editUser (ModelMap modelMap, @ModelAttribute("password") String password,
                            @ModelAttribute("address") String address, @ModelAttribute("city") String city,
                            @ModelAttribute("country") String country, @ModelAttribute("postalcode") String postalcode){
        HttpSession current = LoginController.session;
        if((current.getAttribute("userID") == null)) return "login";
        int id = (int) current.getAttribute("userID");
        UserData currentUser = userDao.findUserById(id);
        currentUser.setAddress(address);
        currentUser.setCity(city);
        currentUser.setCountry(country);
        currentUser.setPostalcode(postalcode);
        currentUser.setPassword(password);

        double lat = 0;
        double lon = 0;

        String new_address = address + "," + city + "," + country +". " +postalcode;
        GeocodingApi Geocode = new GeocodingApi();
        try {
            lat = Geocode.getLatitude(new_address);
            lon = Geocode.getLongitude(new_address);
        }catch (Exception e){
            e.printStackTrace();
            return "editInfo";
        }
        currentUser.setGeolat(lat);
        currentUser.setGeolon(lon);
        userDao.update(currentUser);

        return "redirect: /myPage";
    }
    @RequestMapping(value = "/yourEvent", method = {RequestMethod.GET, RequestMethod.POST})
    public String showReservedEvent(ModelMap model, @ModelAttribute("SpringWeb") Reservation reservation) throws SQLException {
        HttpSession current = LoginController.session;

        if((current.getAttribute("userID") == null)) return "login";

        int eventid = reservation.getEventid();
        Event thisEvent = eventDao.findEventById(eventid);
        int id = (int) current.getAttribute("userID");
        UserData currentUser = userDao.findUserById(id);
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("currentEvent", thisEvent);
        return "yourEvent";
    }
}

