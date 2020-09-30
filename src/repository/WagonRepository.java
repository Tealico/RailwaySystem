package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Wagon;
import util.ConnectionManager;

public class WagonRepository {
	public final String ADD_WAGON="INSERT INTO wagon(number,description,train_id) VALUES (?,?,?) returning wagon_id";
	public final String DELETE_WAGON="delete from wagon where wagon.wagon_id=?";
	public final String GET_WAGON_BY_ID="select * from wagon "
			+ "join train on wagon.train_id=train.train_id "
			+ " where wagon_id=?";
	public final String UPDATE_WAGON="update wagon "
			+ "set number=?,description=?";
	public final String GET_ALL_WAGONS="select * from wagon "
			+ "order by wagon.wagon_id";
	public final String GET_ALL_WAGONS_BY_TRAIN_ID="select * "
			+ "From wagon "
			+ "where wagon.train_id=?";
	
	public int addWagon(Wagon wagon,int trainId) {
		try{
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(ADD_WAGON);
			
			preparedStatement.setInt(1,wagon.getNumber());
			preparedStatement.setString(2,wagon.getDescription());
			preparedStatement.setInt(3,trainId);
			ResultSet result=preparedStatement.executeQuery();
			connection.close();
			if(result.next()) {
				int id = result.getInt("wagon_id");
				System.out.println(id);
				return id;
			}
		} catch (SQLException e) {
			System.out.println("error " + e);
		}
		return 0;
	}
	public void deleteWagon(int wagonId) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_WAGON); 
			preparedStatement.setInt(1, wagonId);
			int result = preparedStatement.executeUpdate();
			connection.close();
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
			connection.close();
			if(result.next()) {
				Wagon wagon = new Wagon();
				wagon.setNumber(result.getInt("number"));
				wagon.setDescription(result.getString("description"));
				wagon.setId(result.getInt("wagon_id"));
				return wagon;
			}else {
				return null;
			}
		}catch(SQLException e) {
			System.out.println("error " + e);
		}
		return null;
	}
	public Wagon updateWagon(Wagon wagon) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_WAGON);
			preparedStatement.setInt(1,wagon.getNumber());
			preparedStatement.setString(2,wagon.getDescription());
			int result = preparedStatement.executeUpdate();
			connection.close();
			System.out.println("Number of records affected :: " + result);
		}catch(SQLException e) {
			System.out.println("error " + e);
		}
		return null;
	}
	public ArrayList<Wagon> getAllWagons() {
		ArrayList<Wagon> wagons = new ArrayList<>();
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_WAGONS);
			ResultSet result = preparedStatement.executeQuery();
			connection.close();
			while (result.next()) {
				Wagon wagon = new Wagon();
				wagon.setId(result.getInt("wagon_id"));
				wagon.setNumber(result.getInt("number"));
				wagon.setDescription(result.getString("description"));
				wagons.add(wagon);
			} 
			return wagons;
		}catch (SQLException e) {
			System.out.println("error " + e);
			return null;
		}
	}
	public ArrayList<Wagon> getAllWagonsByTrainId(int trainId) {
		ArrayList<Wagon> wagons = new ArrayList<>();
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_WAGONS_BY_TRAIN_ID);
			preparedStatement.setInt(1, trainId);
			ResultSet result = preparedStatement.executeQuery();
			connection.close();
			while (result.next()) {
				Wagon wagon = new Wagon();
				wagon.setId(result.getInt("wagon_id"));
				wagon.setNumber(result.getInt("number"));
				wagon.setDescription(result.getString("description"));
				wagons.add(wagon);
			} 
			return wagons;
		}catch (SQLException e) {
			System.out.println("error " + e);
			return null;
		}
	}
	
}


