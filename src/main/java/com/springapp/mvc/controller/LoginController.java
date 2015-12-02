package com.springapp.mvc.controller;

import com.springapp.mvc.service.BasicFunctions;
import com.springapp.mvc.model.LoginData;
import com.springapp.mvc.dao.UserDao;
import com.springapp.mvc.service.GeocodingApi;
import com.springapp.mvc.model.UserData;
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
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class LoginController {

    public static ServletRequestAttributes attr;
    public static HttpSession session;
    // private static final String DEFAULT_EMAIL = "email@email.com";
    //private static final String DEFAULT_PASSWORD = "password";

    @Autowired
    private UserDao userDao;



    @RequestMapping(method = RequestMethod.GET)
    public String defaultPage(ModelMap model) {

        attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        session = attr.getRequest().getSession();
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(ModelMap model, @ModelAttribute("SpringWeb") LoginData loginData) {


        String id = loginData.getId();
        String password = loginData.getPassword();

        List<UserData> userDataList = userDao.findAllLoginData();
        if (id.equalsIgnoreCase("admin") && password.equalsIgnoreCase(userDao.findUserByUserName("admin").getPassword())){
            session.setAttribute("userID", userDao.findUserByUserName("admin").getId());
            return "redirect:/adminPage";
        }

        List<UserData> foundUsers1 = userDataList.stream()
                .filter(userData -> userData.getEmail().equals(id) && userData.getPassword().equals(password))
                .collect(Collectors.toList());
        List<UserData> foundUsers2 = userDataList.stream().filter(userData -> userData.
                getUsername().equals(id) && userData.getPassword().equals(password)).collect(Collectors.toList());


        if (!foundUsers1.isEmpty() && foundUsers2.isEmpty()) {
            session.setAttribute("userID", foundUsers1.get(0).getId());
            return "redirect:/dashBoard";
        }
        if (foundUsers1.isEmpty() && !foundUsers2.isEmpty()){
            session.setAttribute("userID", foundUsers2.get(0).getId());
            return "redirect:/dashBoard";
        }
        return "login";

    }

    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})
    public String redirectToRegisterPage(ModelMap modelMap) {
        return "register";
    }

    @RequestMapping(value = "/registerSubmit", method = {RequestMethod.POST})
    public String registerUser(ModelMap modelMap, @ModelAttribute("SpringWeb") UserData userData) throws SQLException {

        double lat = 0;
        double lon = 0;

        BasicFunctions fcn = new BasicFunctions();
        GeocodingApi Geocode = new GeocodingApi();
        String address = fcn.userAddress(userData);
        try {
            lat = Geocode.getLatitude(address);
            lon = Geocode.getLongitude(address);
        }catch (Exception e){
            e.printStackTrace();
            return "register";
        }
        userData.setGeolat(lat);
        userData.setGeolon(lon);

        userDao.createUser(userData);

        return "redirect:/dashBoard";
    }
}
