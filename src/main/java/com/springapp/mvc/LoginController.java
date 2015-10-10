package com.springapp.mvc;

import com.springapp.mvc.config.InputFileDeclared;
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


		String email = loginData.getEmail();
		String password = loginData.getPassword();

		// Redirecting Example
		if (isLoginValid(email, password)) {
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
	private List<LoginData> getAllUserLoginData() throws java.io.IOException{
		InputFileDeclared file = new InputFileDeclared("UserLoginData.txt");
	}


	private boolean isLoginValid(email, password)
	{
		if(email == loginData.getEmail() && password == loginData.getPassword){
			return true;
		}
		else {
			system.out.println("Invalid Email or Password");
			return false;
		}
	}


}
