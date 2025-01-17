package in.sp.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.sp.beans.Student;

@Configuration
public class SpringConfigFile {
	
	@Bean
	public Student stdId() {
		
		Student std = new Student();
		std.setName("XYZ");
		std.setMarks(89);
		std.setRollno(78);
		
		return std;
	}
}
