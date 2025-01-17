package in.sp.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.sp.beans.Address;
import in.sp.beans.Student;

@Configuration
public class SpringConfigFile {
	
	@Bean
	public Address createAddObj() {
		Address add = new Address();
		add.setHouseno(123);
		add.setCity("Nerul");
		add.setPincode(123456);
		
		return add;
	}
	
	@Bean
	public Student createStdObj() {
		Student std = new Student();
		std.setName("xyz");
		std.setRollno(25);
		std.setAddress(createAddObj());
		return std;
	}
}
