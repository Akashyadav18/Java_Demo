package in.sp.main.services;

import java.util.List;

import in.sp.main.entities.Student;

public interface StudentService {

	public boolean addStudentdetails(Student std);
	
	public List<Student> getAllStdDetail();
	
	public Student getStdDetails(long id);
	
	public boolean updateStdDetails(long id, float marks);
	
	public boolean deleteStdDetails(long id);
}
