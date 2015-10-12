package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class LoginController {

    private static final String DEFAULT_EMAIL = "email@email.com";
    private static final String DEFAULT_PASSWORD = "password";

    @RequestMapping(method = RequestMethod.GET)
    public String defaultPage(ModelMap model) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(ModelMap model, @ModelAttribute("SpringWeb") LoginData loginData) {

        //TODO Read UserLogin Data from loginData.txt
        List<LoginData> loginDataList;

        String email = loginData.getEmail();
        String password = loginData.getPassword();

        if (isValidLoginData(email, password)) {
            return "redirect:/dashBoard";
        }
        return "login";
    }

    private boolean isValidLoginData(String email, String password) {
        return (email.equals(DEFAULT_EMAIL) && password.equals(DEFAULT_PASSWORD));
    }

    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})
    public String redirectToRegisterPage(ModelMap modelMap) {
        return "register";
    }

    @RequestMapping(value = "/registerSubmit", method = {RequestMethod.POST})
    public String registerUser(ModelMap modelMap, @ModelAttribute("SpringWeb") LoginData loginData) {
        System.out.println(loginData.getEmail());
        System.out.println(loginData.getPassword());

        //TODO Save the user information in MySQL Table.
        return "redirect:/dashBoard";
    }

}
