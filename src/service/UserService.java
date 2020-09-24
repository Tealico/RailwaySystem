package service;

import java.util.ArrayList;

import exception.CustomException;
import model.User;
import repository.UserRepository;

public class UserService {
	private UserRepository userRepository = new UserRepository();
	
	public ArrayList<User> getAllUsers(){
		ArrayList<User> users=userRepository.getAllUsers();
		return users;
	}
	
	public User getUserById(int userId) throws CustomException {
		User user= userRepository.getUserById(userId);
		if(user == null) {
			throw new CustomException("User does not exist.");
		}
		return user;
	}
	public void deleteUser(int userId) throws CustomException{
		userRepository.deleteUser(userId);
	}
	public int updateUserType(int userId,int usertypeId) {
		int result = userRepository.updateUserType(userId, usertypeId);
		return result;
	}
}
