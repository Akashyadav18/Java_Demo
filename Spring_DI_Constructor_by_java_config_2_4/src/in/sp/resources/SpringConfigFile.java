package in.sp.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.sp.beans.Address;
import in.sp.beans.Student;

@Configuration
public class SpringConfigFile {
	
	@Bean
	public Address createAddObj() {
		Address add = new Address(12, "Nerul", 789056);
		return add;
	}
	
	@Bean
	public Student createStdObj() {
		Student std = new Student("pqr", 23, createAddObj());
		return std;
	}
}
