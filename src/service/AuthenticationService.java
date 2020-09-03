package service;

import java.util.ArrayList;

import exception.CustomException;
import model.User;
import view.AdminView;
import view.CustomerView;


public class AuthenticationService {
	User admin = new User(1, "Tea", "Lico", "tealico", "tea1234", 21, "tea@gmail.com", "696969696", 1, null); 
	
	private ArrayList<User> users; 
	
	public AuthenticationService() {
		users=new ArrayList<User>();
		users.add(admin);
	}
	public User login(User u) {
		for(User user : users) {
			if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
				return user;
			}
		}
		throw new CustomException("Incorrect username or password.");	
	}
	
	public void register(User u) {
		for(User user : users ) {
			if(u.getUsername().equals(user.getUsername())) {
				throw new CustomException("Username alredy exist");
			}
		}
		u.setType(2);
		users.add(u);
	}
	
}
