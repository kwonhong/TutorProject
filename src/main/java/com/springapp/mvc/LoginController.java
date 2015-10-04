package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class LoginController {

	private static final String FILE_NAME = "loginData.txt";

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(ModelMap model, @ModelAttribute("SpringWeb") LoginData loginData) {

		//TODO Read UserLogin Data from loginData.txt
		List<LoginData> loginDataList = getAllUserLoginData();

		//TODO Check if user data exists within the list.
		String email = loginData.getEmail();
		String password = loginData.getPassword();

		//TODO If user data exists, go to first page

		//TODO If user data doesn't exist or invalid, go to login page with error message.

		// Redirecting Example
		if (isLoginValid()) {
			return "dashBoard";
		} else {
			return "login";
		}
	}

	@RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})
	public String register(ModelMap modelMap) {
		return "register";
	}

	// Reading all the login information from the specific file name;
	private List<LoginData> getAllUserLoginData() {
		return null;
	}

	//TODO Do Implementation
	private boolean isLoginValid() {
		return false;
	}


}
