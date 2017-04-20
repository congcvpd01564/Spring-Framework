package edu.poly.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.poly.bean.User;
import edu.poly.service.LoginService;



@Controller
@RequestMapping(value="login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping()
	public String showForm(ModelMap model){
		model.addAttribute("login", new User());
		return "login";
		}
	
	
	/*@RequestMapping(method= RequestMethod.POST)
	public String processForm(@Validated @ModelAttribute("login") User user,
			BindingResult result, ModelMap model){
		
		if(result.hasErrors()){
			model.addAttribute("message", "Login Invalid");
			return "login";
		}
		
		boolean userExits = loginService.checkLogin(user.getUsername(), user.getPassword());
		if(userExits){
			model.addAttribute("login", user);
			return "index";
		}else{

			return "login";
		}
}*/
	@RequestMapping(method = RequestMethod.POST)
	public String Form(ModelMap model, @ModelAttribute("login") User user){
		
		boolean userExits = loginService.checkLogin(user.getUsername(), user.getPassword());
		if(userExits){
			model.addAttribute("login", user);
			return "index";
			
		}else{
			model.addAttribute("message", "Login Invaild");
			model.addAttribute("login", new User());
			return "login";
		}
	}
}
	
	


