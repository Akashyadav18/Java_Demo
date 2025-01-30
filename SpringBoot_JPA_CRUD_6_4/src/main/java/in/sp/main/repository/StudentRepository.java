package in.sp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.entities.Student;

//A coustom interface(StudentRepository in this class) in spring JPA allow us to
//define additionl query method or businness logic beyond the standard CRUD operations
//It extends "JpaRepository" and provides a way to implement complex or specialized
//DB operations
public interface StudentRepository extends JpaRepository<Student, Long> 
{
	
}
