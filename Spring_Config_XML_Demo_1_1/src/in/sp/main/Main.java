package in.sp.main;

import javax.naming.Context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.sp.beans.Student;

public class Main {
	
	public static void main(String[] args) {
		
		String location = "in/sp/resources/applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(location);
		Student std = (Student) context.getBean("stdId");
		std.display();
		Student std2 = (Student) context.getBean("stdId2");
		std2.display();
	}
}
