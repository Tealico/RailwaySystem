package service;

import exception.CustomException;
import model.User;
import repository.UserRepository;


public class AuthenticationService {
	
	UserRepository userRepository = new UserRepository();
	
	public User login(User u) throws CustomException {
		User user = userRepository.getUserByUsernamePassword(u);
		if(user == null) {
			throw new CustomException("Incorrect username or password.");	
		}
		return user;
	}
	
	public void register(User u) throws CustomException {
		userRepository.addUser(u);
	}
}
