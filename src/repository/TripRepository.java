package repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import model.Location;
import model.Train;
import model.Trip;
import util.ConnectionManager;

public class TripRepository {
	private final String ADD_TRIP="INSERT INTO trip (name,description,price,date,startlocation,endlocation,train_id) VALUES (?,?,?,?,?,?,?)";
	private final String DELETE_TRIP ="Delete from trip where trip.trip_id=?";
	private final String GET_TRIP_BY_ID="Select trip.trip_id, trip.name, trip.description, trip.price, trip.date, "
			+ "t.train_id, t.description as train_description, t.available as train_available, t.headcode as train_headcode, "
			+ "sl.location_id as startlocation_id, sl.name as startlocation_name, sl.available as startlocation_available, "
			+ "el.location_id as endlocation_id, el.name as endlocation_name, el.available as endlocation_available "
			+ "from trip "
			+ "join train t on t.train_id=trip.train_id "
			+ "join location sl on sl.location_id=trip.startlocation "
			+ "join location el on el.location_id=trip.endlocation "
			+ "where trip.trip_id=?";
	private final String UPDATE_TRIP="update trip "
			+ "set name=?, description=?,date=?,price=?,trainId=?";
	public final String GET_ALL_TRIP="select * from trip "
			+ "order by trip.trip_id";
	private Connection connection=ConnectionManager.getConnection();
	
	public void addTrip(Trip trip,int startlocation,int endlocation,int trainId) {
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(ADD_TRIP);
			
			preparedStatement.setString(1,trip.getName());
			preparedStatement.setString(2,trip.getDescription());
			preparedStatement.setInt(3,trip.getPrice());
			preparedStatement.setObject(4, trip.getDate());
			preparedStatement.setInt(5,startlocation);
			preparedStatement.setInt(6,endlocation);
			preparedStatement.setInt(7, trainId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error " + e);
		}
	}
	public void deleteTrip(int tripId) {
		try {
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
			PreparedStatement preparedStatement = connection.prepareStatement(GET_TRIP_BY_ID);
			preparedStatement.setInt(1, tripId);
			ResultSet result = preparedStatement.executeQuery();
			
			if(result.next()) {
				Trip trip= new Trip();
				trip.setName(result.getString("name"));
				trip.setDescription(result.getString("description"));
				trip.setPrice(result.getInt("price"));
				trip.setDate(result.getObject("date", LocalDate.class));
				trip.setId(result.getInt("trip_id"));
				Train train = new Train();
				train.setId(result.getInt("train_id"));
				train.setDescription(result.getString("train_description"));
				train.setAvailable(result.getBoolean("train_available"));
				train.setHeadcode(result.getString("train_headcode"));
				trip.setTrain(train);
				Location startlocation = new Location();
				startlocation.setId(result.getInt("startlocation_id"));
				startlocation.setName(result.getString("startlocation_name"));
				startlocation.setAvailable(result.getBoolean("startlocation_available"));
				trip.setStartLocation(startlocation);
				Location endlocation=new Location();
				endlocation.setId(result.getInt("endlocation_id"));
				endlocation.setName(result.getString("endlocation_name"));
				endlocation.setAvailable(result.getBoolean("endlocation_available"));
				trip.setEndLocation(endlocation);
				return trip;
			}else {
				return null;
			}
		}catch(SQLException e) {
			System.out.println("error " + e);
		}
		return null;
	}
	
	public Trip updateTrip(Trip trip,int trainId) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TRIP);
			preparedStatement.setString(1,trip.getName());
			preparedStatement.setString(2,trip.getDescription());
			preparedStatement.setInt(3,trip.getPrice());
			preparedStatement.setObject(4, trip.getDate());
			preparedStatement.setInt(5, trainId);
			int result = preparedStatement.executeUpdate();
			System.out.println("Number of records affected :: " + result);
		}catch(SQLException e) {
			System.out.println("error " + e);
		}
		return null;
	}
	public ArrayList<Trip> getAllTrips() {
		ArrayList<Trip> trips = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_TRIP);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Trip trip = new Trip();
				trip.setId(result.getInt("trip_id"));
				trip.setName(result.getString("name"));
				trip.setDescription(result.getString("description"));
				trip.setPrice(result.getInt("price"));	
				trip.setDate(result.getTimestamp("date").toLocalDateTime());
				trips.add(trip);
			} 
			return trips;
		}catch (SQLException e) {
			System.out.println("error " + e);
			return null;
		}
	}
}
