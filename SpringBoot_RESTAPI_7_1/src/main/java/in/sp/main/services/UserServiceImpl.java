package in.sp.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.entities.User;
import in.sp.main.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public User updateUserDetails(int id, User newUser) {
		 User userDate = userRepository.findById(id).orElse(null);
		 if(userDate != null) {
			 return userRepository.save(newUser);
		 }
		 return null;
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
	
}
