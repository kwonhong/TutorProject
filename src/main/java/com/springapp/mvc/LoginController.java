package com.springapp.mvc;

import com.springapp.mvc.dao.EventDao;
import com.springapp.mvc.dao.UserDao;
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
import java.sql.SQLException;
import java.util.List;

@Controller
public class LoginController {

   // private static final String DEFAULT_EMAIL = "email@email.com";
    //private static final String DEFAULT_PASSWORD = "password";

     @Autowired
     private UserDao userDao;

    @Autowired
    private EventDao eventDao;

    @RequestMapping(method = RequestMethod.GET)
    public String defaultPage(ModelMap model) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(ModelMap model, @ModelAttribute("SpringWeb") LoginData loginData) {

        List<UserData> userDataList = userDao.findAllLoginData();
        List<Event> events = eventDao.findAllEvents();

        String id = loginData.getId();
        String password = loginData.getPassword();
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();

        try {
            if (isValidLoginData(id, password)) {
                session.setAttribute("ID", id);
                return "redirect:/dashBoard";
            }
        }
        catch (SQLException e){}
        return "login";
    }

    private boolean isValidLoginData(String identification, String password) throws SQLException{
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
    public String registerUser(ModelMap modelMap, @ModelAttribute("SpringWeb") UserData userData) throws SQLException{
//        String id = userData.getId();
//        String password = userData.getPassword();
//        String fname = userData.getFname();
//        String lname = userData.getLname();
//        String city = userData.getCity();
//        String address = userData.getAddress();
//        String email = userData.getEmail();
//        String gender = userData.getGender();
//        String postalcode = userData.getPostalcode();
//        int age = userData.getAge();
//
//        Statement stmt = DBCon.createStatement();
//        String sql = "SELECT * FROM user WHERE ID = '"+id+"' OR Email = '"+email+"'";
//        ResultSet rs = stmt.executeQuery(sql);
//        if (rs.next()){
//            return "redirect: /register";
//        }
//        sql = "INSERT INTO user VALUES(('"+id+"', '"+password+"', '"+fname+"', '"+lname+"', '"+address+"', '"+city+"', '"+email+"', '"+postalcode+"', "+age+", '"+gender+"')";
//        stmt.executeUpdate(sql);
        return "redirect:/dashBoard";
    }

}
