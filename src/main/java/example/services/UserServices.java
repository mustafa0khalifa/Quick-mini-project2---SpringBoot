package example.services;

import example.models.User;
import example.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServices {

	private final UserRepo userRepo ;

	@Autowired
	public UserServices(UserRepo userRepo){
		this.userRepo=userRepo;
	}

	public User addUser(User user){
		return userRepo.save(user);
	}

	public Optional<User> getUserById(Long id){
		return userRepo.findById(id);
	}
	public void deleteUser(Long id){
		 userRepo.deleteById(id);
	}
}
