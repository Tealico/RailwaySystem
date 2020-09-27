package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Train;
import util.ConnectionManager;

public class TrainRepository {
	public final String ADD_TRAIN="INSERT INTO train(available,description,headcode) VALUES(?,?,?)";
	public final String DELETE_TRAIN="delete from train where train.train_id=?";
	public final String UPDATE_TRAIN="update train "
			+ "set available=?,description=? "
			+ "where train.train_id=?";
	public final String GET_TRAIN_BY_ID="select * from train "
			+ "where train.train_id=?";
	public final String GET_ALL_TRAINS="select * from train "
			+ "order by train.train_id";
	
	public void addTrain(Train train) {
		try{
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(ADD_TRAIN);
			
			preparedStatement.setBoolean(1,train.getAvailable());
			preparedStatement.setString(2,train.getDescription());
			preparedStatement.setString(3,train.getHeadcode());
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
				train.setId(result.getInt("train_id"));
				train.setAvailable(result.getBoolean("available"));
				train.setDescription(result.getString("description"));
				train.setHeadcode(result.getString("headcode"));
				return train;
			}else {
				return null;
			}
		}catch(SQLException e) {
			System.out.println("error " + e);
		}
		return null;
	}
	
	public Train updateTrain(Train train) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TRAIN);
			preparedStatement.setBoolean(1,train.getAvailable());
			preparedStatement.setString(2,train.getDescription());
			preparedStatement.setInt(3,train.getId());
			int result = preparedStatement.executeUpdate();
			System.out.println("Number of records affected :: " + result);
			return train;
		}catch(SQLException e) {
			System.out.println("error " + e);
		}
		return null;
	}
	public ArrayList<Train> getAll() {
		ArrayList<Train> trains = new ArrayList<>();
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_TRAINS);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Train train = new Train();
				train.setId(result.getInt("train_id"));
				train.setAvailable(result.getBoolean("available"));
				train.setDescription(result.getString("description"));
				train.setHeadcode(result.getString("headcode"));
				trains.add(train);
			} 
			return trains;
		}catch (SQLException e) {
			System.out.println("error " + e);
			return null;
		}
	}
}

