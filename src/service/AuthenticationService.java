package service;

import exception.CustomException;
import model.User;
import view.Admin;
import view.Customer;


public class AuthenticationService {
	private User testUser = new User(1, "Tea", "Lico", "tealico", "tea1234", 21, "tea@gmail.com", "696969696", 1, null); 
	
	public void login(User u) {
		if(u.getUsername().equals(testUser.getUsername()) && u.getPassword().equals(testUser.getPassword())) {
			if(testUser.getType() == 1) {
				new Admin(testUser).adminMenu();
			}
			else if(testUser.getType() == 2) {
				new Customer().userMenu();
			}
		}
		else {
			throw new CustomException("Incorrect username or password.");
		}
	}
	
	public void register(User u) {
	
		if(u.getUsername().equals(testUser.getUsername())) {
			throw new CustomException("Username alredy exist");
		}
		
		System.out.println("Registering..");
	}
	
}
