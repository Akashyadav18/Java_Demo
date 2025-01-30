package in.sp.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.sp.main.services.StudentService;
import in.sp.main.services.StudentServiceImpl;

@SpringBootApplication
public class SpringBootJpaCrud64Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootJpaCrud64Application.class, args);
		
		StudentService stdService = context.getBean(StudentServiceImpl.class);
		
//		Student std = new Student();
//		std.setName("xyz");
//		std.setRollno(94);
//		std.setMarks(67.8f);
//		
//		boolean status = stdService.addStudentdetails(std);
//		if(status) {
//			System.out.println("Insert Successful");
//		}
//		else {
//			System.out.println("Insert Fail");
//		}
		
//		List<Student> stdList =  stdService.getAllStdDetail();
//		for(Student list : stdList) {
//			System.out.println("Name "+list.getName());
//			System.out.println("Roll No :"+list.getRollno());
//			System.out.println("Marks :"+list.getMarks());
//			System.out.println();
//		}
		
//		Student std = stdService.getStdDetails(1L);
//		System.out.println("Id :"+std.getId());
//		System.out.println("Name "+std.getName());
//		System.out.println("Roll No :"+std.getRollno());
//		System.out.println("Marks :"+std.getMarks());
//		System.out.println();
		
//		boolean status =  stdService.updateStdDetails(1L, 67.9f);
//		if(status) {
//			System.out.println("Updated Successful");
//		}
//		else {
//			System.out.println("Upate Fail");
//		}
		
		boolean status = stdService.deleteStdDetails(2L);
		if(status) {
			System.out.println("Delete Successful");
		}
		else {
			System.out.println("delete Fail");
		}
	}

}
