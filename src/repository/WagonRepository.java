package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Wagon;
import util.ConnectionManager;

public class WagonRepository {
	public final String ADD_WAGON="INSERT INTO wagon(number,description,train_id) VALUES (?,?,?)";
	public final String DELETE_WAGON="delete from wagon where wagon.wagon_id=?";
	public final String GET_WAGON_BY_ID="select * from wagon"
			+ "join train on wagon.train_id=train.train_id"
			+ " where wagon_id=?";
	public final String UPDATE_WAGON="update wagon"
			+ "set number=?,set description=?,set wagon_id=?";
	public final String GET_ALL_WAGON="select * from wagon"
			+ "join train on wagon.train_id=train.train_id"
			+ "order by wagon.wagon_id";
	
	public void addWagon(Wagon wagon,int trainId) {
		try{
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(ADD_WAGON);
			
			preparedStatement.setInt(1,wagon.getNumber());
			preparedStatement.setString(2,wagon.getDescription());
			preparedStatement.setInt(3,trainId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error " + e);
		}
	}
	public void deleteWagon(int wagonId) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_WAGON); 
			preparedStatement.setInt(1, wagonId);
			int result = preparedStatement.executeUpdate();
			System.out.println("Number of records affected :: " + result);
		}catch (SQLException e) {
			System.out.println("error " + e);
		}
	}
	public Wagon getWagonById(int wagonId) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_WAGON_BY_ID);
			preparedStatement.setInt(1, wagonId);
			ResultSet result = preparedStatement.executeQuery();
			
			if(result.next()) {
				Wagon wagon = new Wagon();
				wagon.setNumber(result.getInt("number"));
				wagon.setDescription(result.getString("description"));
				return wagon;
			}else {
				return null;
			}
		}catch(SQLException e) {
			System.out.println("error " + e);
		}
		return null;
	}
	public Wagon updateWagon(int number,String description,int trainId) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_WAGON);
			preparedStatement.setInt(1,number);
			preparedStatement.setString(2,description);
			preparedStatement.setInt(3,trainId);
			int result = preparedStatement.executeUpdate();
			System.out.println("Number of records affected :: " + result);
		}catch(SQLException e) {
			System.out.println("error " + e);
		}
		return null;
	}
	public ArrayList<Wagon> getAllWagon() {
		ArrayList<Wagon> wagon = new ArrayList<>();
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_WAGON);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Wagon wagons = new Wagon();
				wagons.setId(result.getInt("id"));
				wagons.setNumber(result.getInt("number"));
				wagons.setDescription(result.getString("description"));
				wagon.add(wagons);
			} 
			return wagon;
		}catch (SQLException e) {
			System.out.println("error " + e);
			return null;
		}
	}
	
}


