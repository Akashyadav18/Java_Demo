package in.sp.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.sp.main.dao.UserDao;
import in.sp.main.entity.User;

@SpringBootApplication
public class SpringBootJdbcCrud62Application implements CommandLineRunner {
	
	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcCrud62Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Insert
//		User user1 = new User();
//		user1.setName("xyz");
//		user1.setEmail("xyz@gmail.com");
//		user1.setGender("F");
//		user1.setCity("Nerul");
//		
//		userDao.insertUser(user1);
		
		//UPDATE 1
//		User user2 = new User();
//		user2.setName("xyz");
//		user2.setEmail("abc@gmail.com");
//		user2.setGender("F");
//		user2.setCity("Nerul");
//		
//		userDao.updateUser(user2);
		
		
		//DELETE
//		userDao.deleteUserByEmail("abc@gmail.com");
		
		//Select one user
//		User user = userDao.getUserByEmail("abc@gmail.com");
//		System.out.println("Name :"+user.getName());
//		System.out.println("Email :"+user.getEmail());
//		System.out.println("Gender :"+user.getGender());
//		System.out.println("City :"+user.getCity());
		
		//select All user
		List<User> list = userDao.getAllUser();
		for(User user : list) {
			System.out.println("Name :"+user.getName());
			System.out.println("Email :"+user.getEmail());
			System.out.println("Gender :"+user.getGender());
			System.out.println("City :"+user.getCity());
			System.out.println("");
		}
	}

}
