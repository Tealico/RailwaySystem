package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import exception.CustomException;
import model.User;
import util.ConnectionManager;
import util.UserType;

public class UserRepository {
	User admin = new User(1, "Tea", "Lico", "tealico", "tea1234", 21, "tea@gmail.com", "696969696", UserType.ADMIN, null); 
	
	private final String GET_USER_BY_USERNAME_PASSWORD = ""
			+ "select users.user_id as id,users.firstname, users.lastname, users.age, users.email, users.username,usertype.type as userType "
			+ "from users "
			+ "join usertype on usertype.id=users.usertype_id "
			+ "where users.username = ? and users.password = ?";
	
	private final String ADD_USER = "INSERT INTO users (firstname,lastname,username,password,age,email,usertype_id) VALUES(?,?,?,?,?,?,?)";
	
	public void addUser(User u) throws CustomException {
		try{
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER);
			
			preparedStatement.setString(1,u.getFirstName());
			preparedStatement.setString(2,u.getLastName());
			preparedStatement.setString(3,u.getUsername());
			preparedStatement.setString(4,u.getPassword());
			preparedStatement.setInt(5,u.getAge());
			preparedStatement.setString(6,u.getEmail());
			preparedStatement.setInt(7,2); 
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
//			System.out.println("error " + e);
			throw new CustomException("Username already exist.");
		}
	}
	public User getUserByUsernamePassword(User u) throws CustomException {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_USERNAME_PASSWORD);
			preparedStatement.setString(1, u.getUsername());
			preparedStatement.setString(2, u.getPassword());
			ResultSet result = preparedStatement.executeQuery();

			
			if(result.next()) {
				User user = new User();
				user.setId(result.getInt("id"));
				user.setFirstName(result.getString("firstname"));
				user.setLastName(result.getString("lastname"));
				user.setAge(result.getInt("age"));
				user.setEmail(result.getString("email"));
				user.setUsername(result.getString("username"));
				user.setType(UserType.valueOf(result.getString("userType")));
				return user;
			}
			else {
				return null;
			}
			
		} catch (SQLException e) {
//			System.out.println("error " + e);
			throw new CustomException("Something went wrong.");
		}
	}
	
	
	private ArrayList<User> users; 
	
	public UserRepository() {
		users=new ArrayList<User>();
		users.add(admin);
	}
	
	public ArrayList<User> getAll(){
		return this.users;
	}
	
//	public void addUser(User u) {
//		users.add(u);
//	}
	
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