package in.sp.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.sp.main.entities.User;
import in.sp.main.services.UserService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

//The @Controller annotation makes a class as Spring MVC controller, allowing it to handle
//HTTP req. and return views or data;
//In SB, a Controller class is a class which manages web req. and res. It handles
//user input, processes data, and return views or other res.;
@Controller
public class MyController {
	
	@Autowired
	private UserService userService;
	
	//Register page pe jane se phele user ka User ka object le k jaao.
	//Or jaise hi client Register button pe click karega saare data ko "uses" k andar store karlo
	//Model k help se User entity ka object bana diya
	@GetMapping("/regPage")
	public String openRegPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	//ModelAttribute form k data ko bind karwane k kaam aata h.
		//form ka data h "user" me usko bind kar diya user entity ka andar
	//may is user ko le k chala jauga UserServiceImpl class me
		//Or call kardega (registerUser(User user)) method ko jo DB me save kardega
	@PostMapping("/regForm")
	public String submitRegFrom(@ModelAttribute("user") User user, Model model) {
		boolean status = userService.registerUser(user);
		if(status) { 
			model.addAttribute("SuccessMsg", "User registered successfully");
		}
		else {
			model.addAttribute("errorMsg", "User Not Registered");
		}
		return "register";
	}
	
	@GetMapping("/loginPage")
	public String openLoginPage(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@PostMapping("/loginForm")
	public String submitLoginForm(@ModelAttribute("user") User user, Model model) {
		User validUser= userService.loginUser(user.getEmail(), user.getPassword());
		if(validUser != null) {
			model.addAttribute("modelName", validUser.getName());
			return "profile";
		}
		else {
			model.addAttribute("errorMsg", "Email or Password is not Valid");
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logoutUser(HttpServletRequest request) {
		
		HttpSession session	 = request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		
		return "login";
	}

}
