package in.sp.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.sp.beans.Student;
import in.sp.resources.SpringConfigFile;

public class Main {
	
	public static void main(String[] args) {
		
//		String resource_file_path = "in/sp/resources/applicationContext.xml";
//		ApplicationContext context = new ClassPathXmlApplicationContext(resource_file_path);
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
		Student std = (Student) context.getBean("student");
		std.display();
		
	}
}
