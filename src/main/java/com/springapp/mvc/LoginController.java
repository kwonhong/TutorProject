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
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class LoginController {

    // private static final String DEFAULT_EMAIL = "email@email.com";
    //private static final String DEFAULT_PASSWORD = "password";

    @Autowired
    private UserDao userDao;

    @RequestMapping(method = RequestMethod.GET)
    public String defaultPage(ModelMap model) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(ModelMap model, @ModelAttribute("SpringWeb") LoginData loginData) {
        String email = loginData.getEmail();
        String password = loginData.getPassword();

        List<UserData> userDataList = userDao.findAllLoginData();
        List<UserData> foundUsers = userDataList.stream()
                .filter(userData -> userData.getEmail().equals(email) && userData.getPassword().equals(password))
                .collect(Collectors.toList());

        if (foundUsers.isEmpty()) {
            return "login";
        } else {
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession();
            session.setAttribute("userID", foundUsers.get(0).getId());
            return "redirect:/dashBoard";
        }
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
        //TODO Check fields

        userDao.createUser(userData);

        return "redirect:/dashBoard";
    }

}
