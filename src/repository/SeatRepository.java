package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Seat;
import util.ConnectionManager;

public class SeatRepository {
	public final String ADD_SEAT="INSERT INTO seat(seat_row,seat_column,available,wagon_id) VALUES (?,?,?,?)";
	public final String DELETE_SEAT="DELETE FROM seat where seat.seat_id=?";
	public final String UPDATE_SEAT="update seat"
			+ "set seat_row=?, seat_column=?,available=? "
			+ "where seat.seat_id=?";
	public final String GET_SEAT_BY_ID="select * from seat "
			+ "join wagon on seat.wagon_id=wagon.wagon_id "
			+ "where seat.seat_id=?";
	public final String GET_ALL_SEAT="select * from seat "
			+ "where seat.seat_id=?";
	
	public void addSeat(Seat seat,int wagonId) {
		try{
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(ADD_SEAT);
			
			preparedStatement.setInt(1,seat.getRow());
			preparedStatement.setInt(2,seat.getColumn());
			preparedStatement.setBoolean(3,seat.getAvailable());
			preparedStatement.setInt(4,wagonId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error " + e);
		}
	}
	public void deleteSeat(int seatId) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SEAT); 
			preparedStatement.setInt(1, seatId);
			int result = preparedStatement.executeUpdate();
			System.out.println("Number of records affected :: " + result);
		}catch (SQLException e) {
			System.out.println("error " + e);
		}
	}
	public Seat getSeatById(int seatId) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_SEAT_BY_ID);
			preparedStatement.setInt(1, seatId);
			ResultSet result = preparedStatement.executeQuery();
			
			if(result.next()) {
				Seat seat = new Seat();
				seat.setRow(result.getInt("seat_row"));
				seat.setColumn(result.getInt("seat_column"));
				seat.setAvailable(result.getBoolean("available"));
				return seat;
			}else {
				return null;
			}
		}catch(SQLException e) {
			System.out.println("error " + e);
		}
		return null;
	}
	public Seat updateSeat(int row,int column,Boolean available) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SEAT);
			preparedStatement.setInt(1,row);
			preparedStatement.setInt(2,column);
			preparedStatement.setBoolean(3,available);
			int result = preparedStatement.executeUpdate();
			System.out.println("Number of records affected :: " + result);
		}catch(SQLException e) {
			System.out.println("error " + e);
		}
		return null;
	}
	public ArrayList<Seat> getAllSeat() {
		ArrayList<Seat> seats = new ArrayList<>();
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_SEAT);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Seat seat = new Seat();
				seat.setId(result.getInt("seat_id"));
				seat.setRow(result.getInt("seat_row"));
				seat.setColumn(result.getInt("seat_column"));
				seat.setAvailable(result.getBoolean("available"));
				seats.add(seat);
			} 
			return seats;
		}catch (SQLException e) {
			System.out.println("error " + e);
			return null;
		}
	}
	
}
