package in.sp.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.entities.User;
import in.sp.main.services.UserService;

//In Spring Boot, the @RestController annotation is used to create RESTful service.
//It combines @Controller and @ResponseBody, meaning the controller method return data
//(like JSON or XML) directly instead of rendering a view, making it suitable for APIs;

@RestController
public class MyController {

	@Autowired
	private UserService userService;
	
	//In SB, the @RequestBody annotation is used in RESTful APIs to bind the HTTP request
	//body (usually in JSON or XML format) directly to method's parameter, converting it into a java Objects
	@PostMapping("/user")
	public User addUserDetails(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@GetMapping("/user")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}
	
	//ReponseEntity in spring API represent the entire HTTP response, including
	//status code, headers, and body. It allow for greater control over the response sent to client, 
	//enhancing API flexibility.
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserDtail(@PathVariable int id) {
		User user = userService.getUserById(id).orElse(null);
		if(user != null) {
			return ResponseEntity.ok().body(user);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUserDetail(@PathVariable int id, @RequestBody User user) {
		User updatedUser = userService.updateUserDetails(id, user);
		if(updatedUser != null) {
			return ResponseEntity.ok(updatedUser);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable int id){
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}
