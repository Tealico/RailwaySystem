package repository;

import java.util.ArrayList;

import model.User;

public class UserRepository {
	User admin = new User(1, "Tea", "Lico", "tealico", "tea1234", 21, "tea@gmail.com", "696969696", 1, null); 
	
	private ArrayList<User> users; 
	
	public UserRepository() {
		users=new ArrayList<User>();
		users.add(admin);
	}
	
	public ArrayList<User> getAll(){
		return this.users;
	}
	
	public void addUser(User u) {
		users.add(u);
	}
	
	public void deleteUser(User u) {
		for(User user : users) {
			if(u.getUsername().equals(user.getUsername())) {
				users.remove(user);
			}
		}
	}
	
	public User getUser(String username) {
		for(User user : users) {
			if(username.equals(user.getUsername())) {
				return user;
			}
		}
		return null;
	}
}