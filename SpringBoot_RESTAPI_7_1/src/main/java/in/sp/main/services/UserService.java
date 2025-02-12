package in.sp.main.services;

import java.util.List;
import java.util.Optional;

import in.sp.main.entities.User;

public interface UserService {
	
	public User createUser(User user);
	
	public List<User> getAllUser();
	
	public Optional<User> getUserById(int id);
	
	public User updateUserDetails(int id, User user);
	
	public void deleteUser(int id);
}
