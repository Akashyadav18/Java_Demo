package in.sp.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.sp.main.entities.User;

@SpringBootApplication
public class SpringBootHibernate63Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernate63Application.class, args);
		
		Configuration cfg = new Configuration();
		 cfg.configure("/in/sp/main/config/hibernate.cfg.xml");
		SessionFactory sessionFactory =  cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			User user = session.get(User.class, 13L);
			if(user != null) {
				System.out.println("Name :"+ user.getName());
				System.out.println("Email :"+ user.getEmail());
				System.out.println("Gender :"+user.getGender());
				System.out.println("City :"+user.getCity());
			}
			else {
				System.out.println("User Not Found");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
