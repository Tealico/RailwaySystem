package repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Trip;
import util.ConnectionManager;



public class TripRepository {
	private final String ADD_TRIP="INSERT INTO trip (name,description) VALUES (?,?)";
	private final String DELETE_TRIP ="Delete from trip where trip.trip_id=?";
	private final String GET_TRIP_BY_ID="Select * from trip"
			+ "where trip.trip_id=?"
			+ "order by trip.trip_id";
	private final String UPDATE_TRIP="select trip"
			+ "set name=?,set description=?";
	
	public void addTrip(Trip trip) {
		try{
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(ADD_TRIP);
			
			preparedStatement.setString(1,trip.getName());
			preparedStatement.setString(2,trip.getDescription());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error " + e);
		}
	}
	public void deleteTrip(int tripId) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TRIP); 
			preparedStatement.setInt(1, tripId);
			int result = preparedStatement.executeUpdate();
			System.out.println("Number of records affected :: " + result);
		}catch (SQLException e) {
			System.out.println("error " + e);
		}
	}
	public Trip getTripById(int tripId) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_TRIP_BY_ID);
			preparedStatement.setInt(1, tripId);
			ResultSet result = preparedStatement.executeQuery();
			
			if(result.next()) {
				Trip trip= new Trip();
				trip.setName(result.getString("name"));
				trip.setDescription(result.getString("description"));
				return trip;
			}else {
				return null;
			}
		}catch(SQLException e) {
			System.out.println("error " + e);
		}
		return null;
	}
	
	public Trip updateTrip(String name,String description) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TRIP);
			preparedStatement.setString(1,name);
			preparedStatement.setString(2,description);
			int result = preparedStatement.executeUpdate();
			System.out.println("Number of records affected :: " + result);
		}catch(SQLException e) {
			System.out.println("error " + e);
		}
		return null;
	}
}
