package in.sp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.entities.User;

//A custom repository interface in Spring Data JPA extends JpaRepository
//or another repository interface to define additional query methods or custom logic
//It is used to add extra methods or custom behavior to handle specific DB queries
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByEmail(String email);
}
