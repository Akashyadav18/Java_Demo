package in.sp.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.sp.main.entities.User;
import in.sp.main.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

//It is used to handle http requests
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
	public String submitRegForm(@ModelAttribute("user") User user, Model model) {
		boolean status = userService.registerUser(user);
		if(status) {
			model.addAttribute("successMsg", "User Register Successfully");
		}
		else {
			model.addAttribute("errorMsg", "Register Fail");
		}
		return "login";
	}
	
	@GetMapping("/loginPage")
	public String openLoginPage(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@PostMapping("/loginForm")
	public String submitLoginForm(@ModelAttribute("user") User user, Model model) {
		User validUser = userService.loginUser(user.getEmail(), user.getPassword());
		if(validUser != null) {
			model.addAttribute("model_name", validUser.getName());
			return "profile";
		}
		model.addAttribute("errorMsg", "Invalid Email OR password");
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		//false-jo hamare pass jo exist karta hoga session ye wahi provide karega
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		
		return "login";
	}
}
