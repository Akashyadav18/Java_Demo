package in.sp.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.sp.beans.User;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	
//	@RequestMapping(value = "/helloPage", method = RequestMethod.GET)
	@GetMapping("/helloPage")
	public ModelAndView openHelloPage() {
		System.out.println("Open Hello Page() executed");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		
		return mav;
	}
	
	@GetMapping("/aboutUs")
	public String openAboutPage() {
		return "about_us";
	}
	
	@GetMapping("/myForm")
	public String openMyFormPage() {
		return "my_form";
	}
	
//	@PostMapping("/submitForm")
//	public String handleMyForm(HttpServletRequest req) {
//		String myname = req.getParameter("name");
//		String myemail = req.getParameter("email");
//		String myphone = req.getParameter("phone");
//		
//		System.out.println("Name :"+myname);
//		System.out.println("Email :"+myemail);
//		System.out.println("Phone No :"+myphone);
//		
//		return "profile";
//	}
	
//	@PostMapping("/submitForm")
//	public String handleMyForm(
//			@RequestParam("name") String myname,
//			@RequestParam("email") String myemail,
//			@RequestParam("phone") String myphone,
//			Model model
//			) {
//		
//		model.addAttribute("model_name", myname);
//		model.addAttribute("model_email", myemail);
//		model.addAttribute("model_phone", myphone);
//		
//		return "profile";
//	}
	
//	@PostMapping("/submitForm")
//	public String handleMyForm(
//			@RequestParam("name") String myname,
//			@RequestParam("email") String myemail,
//			@RequestParam("phone") String myphone,
//			Model model
//			) {
//		
//		User user = new User();
//		user.setName(myname);
//		user.setEmail(myemail);
//		user.setPhoneno(myphone);
//		
//		model.addAttribute("model_user", user);
//		
//		return "profile";
//	}
	
	@PostMapping("/submitForm")
	public String handleMyForm(@ModelAttribute User user) {
		
		return "profile";
	}
}
