package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Location;
import util.ConnectionManager;

public class LocationRepository {
	public final String ADD_LOCATION="INSERT INTO location(name,available) VALUES(?,?)";
	public final String DELETE_LOCATION="delete from location where location.location_id=?";
	public final String GET_LOCATION_BY_ID="select * from location "
			+ "where location.location_id=?";
	public final String UPDATE_LOCATION="update location "
			+ "set name=?,available=? "
			+ "where location.location_id=?";
	public final String GET_ALL_LOCATION="select * "
			+ "from location "
			+ "order by location.location_id";
	
	public void addLocation(Location location) {
		try{
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(ADD_LOCATION);
			
			preparedStatement.setString(1,location.getName());
			preparedStatement.setBoolean(2,location.getAvailable());
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
				location.setId(result.getInt("location_id"));
				location.setName(result.getString("name"));
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
	public Location updateLocation(Location location) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LOCATION);
			preparedStatement.setString(1,location.getName());
			preparedStatement.setBoolean(2,location.getAvailable());
			preparedStatement.setInt(3,location.getId());
			int result = preparedStatement.executeUpdate();
			System.out.println("Number of records affected :: " + result);
		}catch(SQLException e) {
			System.out.println("error " + e);
		}
		return null;
	}
	public ArrayList<Location> getAllLocation() {
		ArrayList<Location> locations = new ArrayList<>();
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_LOCATION);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Location location = new Location();
				location.setId(result.getInt("location_id"));
				location.setName(result.getString("name"));
				location.setAvailable(result.getBoolean("available"));
				locations.add(location);
			} 
			return locations;
		}catch (SQLException e) {
			System.out.println("error " + e);
			return null;
		}
	}
	
}
