package in.sp.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.entities.User;

//JpaRepository interface in Spring Data JPA offers a set of methods for performing
//CRUD operations, pagination and sorting on entities, streamlining DB interactions without boilerplate code
public interface UserRepository extends JpaRepository<User, Integer> {

}
