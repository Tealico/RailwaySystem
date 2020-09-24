package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Location;
import util.ConnectionManager;

public class LocationRepository {
	public final String ADD_LOCATION="INSERT INTO location(name,startlocation,endlocation,available,trip_id) VALUES(?,?,?,?,?)";
	public final String DELETE_LOCATION="delete from location where location.location_id=?";
	public final String GET_LOCATION_BY_ID="select * from location "
			+ "join trip on location.trip_id=trip.trip_id"
			+ "where trip.trip_id=?"
			+ "order by trip.trip_id";
	public final String UPDATE_LOCATION="update location"
			+ "set name=?,set firstname=?,set endlocation=?,set available=?";
	public final String GET_ALL_LOCATION="select startlocation,endlocation,available"
			+ "from location";
	
	public void addLocation(Location location,int tripId) {
		try{
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(ADD_LOCATION);
			
			preparedStatement.setString(1,location.getName());
			preparedStatement.setString(2,location.getStartlocation());
			preparedStatement.setString(3,location.getEndlocation());
			preparedStatement.setString(4,location.getStartlocation());
			preparedStatement.setBoolean(5,location.getAvailable());
			preparedStatement.setInt(6,tripId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error " + e);
		}
	}
	public void deleteLocation(int locationId) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_LOCATION); 
			preparedStatement.setInt(1, locationId);
			int result = preparedStatement.executeUpdate();
			System.out.println("Number of records affected :: " + result);
		}catch (SQLException e) {
			System.out.println("error " + e);
		}
	}
	public Location getLocationById(int locationId) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_LOCATION_BY_ID);
			preparedStatement.setInt(1, locationId);
			ResultSet result = preparedStatement.executeQuery();
			
			if(result.next()) {
				Location location = new Location();
				location.setName(result.getString("name"));
				location.setStartlocation(result.getString("startlocation"));
				location.setEndlocation(result.getString("endlocation"));
				location.setAvailable(result.getBoolean("available"));
				return location;
			}else {
				return null;
			}
		}catch(SQLException e) {
			System.out.println("error " + e);
		}
		return null;
	}
	public Location updateLocation(String name,String startLocation,String endLocation,Boolean available) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LOCATION);
			preparedStatement.setString(1,name);
			preparedStatement.setString(2,startLocation);
			preparedStatement.setString(3,endLocation);
			preparedStatement.setBoolean(4,available);
			int result = preparedStatement.executeUpdate();
			System.out.println("Number of records affected :: " + result);
		}catch(SQLException e) {
			System.out.println("error " + e);
		}
		return null;
	}
	public ArrayList<Location> getAllLocation() {
		ArrayList<Location> location = new ArrayList<>();
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_LOCATION);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Location locations = new Location();
				locations.setId(result.getInt("id"));
				locations.setName(result.getString("name"));
				locations.setStartlocation(result.getString("startlocation"));
				locations.setEndlocation(result.getString("endlocation"));
				locations.setAvailable(result.getBoolean("available"));
				location.add(locations);
			} 
			return location;
		}catch (SQLException e) {
			System.out.println("error " + e);
			return null;
		}
	}
	
}
