package in.sp.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.sp.beans.Address;
import in.sp.beans.Student;
import in.sp.beans.Subject;

@Configuration
public class SpringConfigFile {
	@Bean
	public Address createAddObj() {
		Address add = new Address();
		add.setHouseno(12);
		add.setCity("Kolkata");
		add.setPincode(1234);
		
		return add;
	}
	@Bean
	public Address createAddObj2() {
		Address add = new Address();
		add.setHouseno(12);
		add.setCity("Kolkata");
		add.setPincode(1234);
		
		return add;
	}
	@Bean
	public Subject createSubObj() {
		Subject sub = new Subject();
		List<String>  sub_list = new ArrayList<>();
		sub_list.add("java");
		sub_list.add("Python");
		sub_list.add("C++");
		
		sub.setSubject(sub_list);
		return sub;
	}
	
	@Bean
	public Student createStdObj() {
		Student std = new Student();
		std.setName("rty");
		std.setRollno(67);
//		std.setAddress(createAddObj()); //manually DI
//		std.setSubject(createSubObj()); //manually DI
		
		return std;
	}
}
