package in.sp.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.sp.main.entities.User;

@SpringBootApplication
public class SpringBootHibernate63Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootHibernate63Application.class, args);
		
		DBOperations dbop = context.getBean(DBOperations.class);
	
	}

}
