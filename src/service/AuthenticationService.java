package service;

import java.util.ArrayList;

import exception.CustomException;
import model.User;
import repository.UserRepository;
import util.UserType;
import view.AdminView;
import view.CustomerView;


public class AuthenticationService {
	
	UserRepository userRepository = new UserRepository();
	
	public User login(User u) {
		ArrayList<User> users = userRepository.getAll();
		
		for(User user : users) {
			if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
				return user;
			}
		}
		throw new CustomException("Incorrect username or password.");	
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
