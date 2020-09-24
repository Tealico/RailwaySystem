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

	private final String GET_USER_BY_USERNAME_PASSWORD = ""
			+ "select users.user_id as id,users.firstname, users.lastname, users.age, users.email, users.username,usertype.type as userType "
			+ "from users "
			+ "join usertype on usertype.id=users.usertype_id "
			+ "where users.username = ? and users.password = ? "
			+ "order by id";
	
	private final String ADD_USER = "INSERT INTO users (firstname,lastname,username,password,age,email,usertype_id) VALUES(?,?,?,?,?,?,?)";
	private final String DELETE_USER = "DELETE FROM users where user_id = ?";
	private final String GET_ALL_USERS = "select users.user_id as id, users.firstname, users.lastname,users.username, usertype.type as userType "
			+ "FROM users "
			+ "join usertype on usertype.id=users.usertype_id "
			+ "order by id";
	private final String GET_USER_BY_ID = "select * From users "
			+ "join usertype on usertype.id=users.usertype_id "
			+ "where user_id=? "
			+ "order by users.user_id";
	private final String UPDATE_USER_BY_USER_TYPE="update users "
			+ "set usertype_id=? "
			+ "where user_id=?";
	
	
	public int updateUserType(int userId,int usertypeId) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_BY_USER_TYPE);
			preparedStatement.setInt(1,usertypeId);
			preparedStatement.setInt(2,userId);
			int result = preparedStatement.executeUpdate();
			System.out.println("Number of records affected :: " + result);
			return usertypeId;
		}catch(SQLException e) {
			System.out.println("error " + e);
			return 0;
		}
	}
	
	public User getUserById(int userId) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID);
			preparedStatement.setInt(1, userId);
			ResultSet result = preparedStatement.executeQuery();
			
			if(result.next()) {
				User user= new User();
				user.setId(result.getInt("user_id"));
				user.setFirstName(result.getString("firstname"));
				user.setLastName(result.getString("lastname"));
				user.setAge(result.getInt("age"));
				user.setEmail(result.getString("email"));
				user.setPassword(result.getString("password"));
				user.setUsername(result.getString("username"));
				user.setType(UserType.valueOf(result.getString("type")));
				return user;
			}else {
				return null;
			}
		}catch(SQLException e) {
			System.out.println("error " + e);
		}
		return null;
	}
	
	
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
			System.out.println("error " + e);
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
			System.out.println("error " + e);
			throw new CustomException("Something went wrong.");
		}
	}
	public void deleteUser(int userId) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER); 
			preparedStatement.setInt(1, userId);
			int result = preparedStatement.executeUpdate();
			System.out.println("Number of records affected :: " + result);
		}catch (SQLException e) {
			System.out.println("error " + e);
		}
	}
	public ArrayList<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<>();
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				User user = new User();
				user.setId(result.getInt("id"));
				user.setFirstName(result.getString("firstname"));
				user.setLastName(result.getString("lastname"));
				user.setUsername(result.getString("username"));
				user.setType(UserType.valueOf(result.getString("userType")));
				users.add(user);
			} 
			return users;
		}catch (SQLException e) {
			System.out.println("error " + e);
			return null;
		}
	}
}