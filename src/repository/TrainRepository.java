package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Train;
import util.ConnectionManager;

public class TrainRepository {
	public final String ADD_TRAIN="INSERT INTO train(available,description) VALUES(?,?)";
	public final String DELETE_TRAIN="delete from train where train.train_id=?";
	public final String UPDATE_TRAIN="select * from train"
			+ "set available=?,set description=?";
	public final String GET_TRAIN_BY_ID="select * from train"
			+ "where train.train_id=?"
			+ "order by train.train_id";
	public final String GET_ALL_TRAIN="select * from train";
	public void addTrain(Train train) {
		try{
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(ADD_TRAIN);
			
			preparedStatement.setBoolean(1,train.getAvailable());
			preparedStatement.setString(2,train.getDescription());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error " + e);
		}
	}
	public void deleteTrain(int trainId) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TRAIN); 
			preparedStatement.setInt(1, trainId);
			int result = preparedStatement.executeUpdate();
			System.out.println("Number of records affected :: " + result);
		}catch (SQLException e) {
			System.out.println("error " + e);
		}
	}
	public Train getTrainById(int trainId) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_TRAIN_BY_ID);
			preparedStatement.setInt(1, trainId);
			ResultSet result = preparedStatement.executeQuery();
			
			if(result.next()) {
				Train train= new Train();
				train.setAvailable(result.getBoolean("available"));
				train.setDescription(result.getString("description"));
				return train;
			}else {
				return null;
			}
		}catch(SQLException e) {
			System.out.println("error " + e);
		}
		return null;
	}
	
	public Train updateTrain(Boolean available,String description) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TRAIN);
			preparedStatement.setBoolean(1,available);
			preparedStatement.setString(2,description);
			int result = preparedStatement.executeUpdate();
			System.out.println("Number of records affected :: " + result);
		}catch(SQLException e) {
			System.out.println("error " + e);
		}
		return null;
	}
	public ArrayList<Train> getAllTrain() {
		ArrayList<Train> train = new ArrayList<>();
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_TRAIN);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Train trains = new Train();
				trains.setId(result.getInt("id"));
				trains.setAvailable(result.getBoolean("available"));
				trains.setDescription(result.getString("description"));
				train.add(trains);
			} 
			return train;
		}catch (SQLException e) {
			System.out.println("error " + e);
			return null;
		}
	}
}

