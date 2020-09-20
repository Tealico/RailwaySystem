package service;

import java.util.ArrayList;

import exception.CustomException;
import model.User;
import repository.UserRepository;
import util.UserType;


public class AuthenticationService {
	
	UserRepository userRepository = new UserRepository();
	
	public User login(User u) {
		User user = userRepository.getUserByUsernamePassword(u);
		if(user == null) {
			throw new CustomException("Incorrect username or password.");	
		}
		return user;
	}
	
	public void register(User u) {
		ArrayList<User> users = userRepository.getAll();
		
		for(User user : users ) {
			if(u.getUsername().equals(user.getUsername())) {
				throw new CustomException("Username alredy exist");
			}
		}
		u.setType(UserType.CUSTOMER);
		userRepository.addUser(u);
	}
	
}
