package com.springapp.mvc;

import com.springapp.mvc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;
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

    private boolean isValidLoginData(String identification, String password) throws SQLException {
        boolean result = false;
//        Statement stmt = DBCon.createStatement();
//        String sql = "SELECT * FROM user WHERE Email = '"+identification+"' AND Password = '"+password+"'";
//        ResultSet rs = stmt.executeQuery(sql);
//        if (rs.next()){
//            result = true;
//        }
//        sql = "SELECT * FROM user WHERE ID = '"+identification+"' AND Password = '"+password+"'";
//        rs = stmt.executeQuery(sql);
//        if (rs.next()){
//            result = true;
//        }
        return result;
    }

    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})
    public String redirectToRegisterPage(ModelMap modelMap) {
        return "register";
    }

    @RequestMapping(value = "/registerSubmit", method = {RequestMethod.POST})
    public String registerUser(ModelMap modelMap, @ModelAttribute("SpringWeb") UserData userData) throws SQLException {
        String a = userData.getAddress();
        String b = userData.getCity();
        String c = userData.getCountry();
        String d = userData.getPostalcode();
        double lat = 0;
        double lon = 0;

        String address = a + "," + b + "," + c +". " +d;
        GeocodingApi Geocode = new GeocodingApi();
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
