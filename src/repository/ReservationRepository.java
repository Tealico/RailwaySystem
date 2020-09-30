package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import model.Reservation;
import model.Seat;
import model.Train;
import model.Trip;
import model.User;
import model.Wagon;
import util.ConnectionManager;

public class ReservationRepository {
	public final String ADD_RESERVATION="INSERT INTO reservation(date,totalprice,user_id,seat_id,train_id,trip_id) VALUES (?,?,?,?,?,?)";
	public final String DELETE_RESERVATION="delete from reservation where reservation.reservation_id=?";
	public final String GET_RESERVATION_BY_ID="select r.reservation_id, r.date,r.totalprice, s.seat_id, s.seat_row,s.seat_column,s.available,w.wagon_id,w.number,t.train_id, t.headcode,u.firstname,u.lastname,tr.name "
			+ "from reservation r "
			+ "join users u on u.user_id=r.user_id "
			+ "join seat s on s.seat_id=r.seat_id "
			+ "join wagon w on w.wagon_id=s.wagon_id "
			+ "join train t on t.train_id=r.train_id "
			+ "join trip tr on tr.trip_id=r.trip_id "
			+ "where r.reservation_id=? ";
	public final String UPDATE_RESERVATION="update reservation "
			+ "set seat_id=? "
			+ "where reservation.reservation_id=?";
	public final String GET_ALL_RESERVATION="select * from reservation"
			+ "join trip on trip.trip_id=reservation.trip_id "
			+ "order by reservation.reservation_id";
	public final String GET_ALL_RESERVATION_BY_USER_ID="select * "
			+ "From reservation "
			+ "join trip on trip.trip_id=reservation.trip_id "
			+ "where reservation.user_id=? "
			+ "order by reservation.reservation_id";
	public final String GET_ALL_RESERVATION_BY_TRIP_ID="select * "
			+ "from reservation "
			+ "join trip on trip.trip_id=reservation.trip_id "
			+ "where reservation.trip_id=? "
			+ "order by reservation.reservation_id";
	
	public int addReservation(Reservation reservation,int userId,int seatId,int trainId,int tripId) {
		try{
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(ADD_RESERVATION);
			
			preparedStatement.setTimestamp(1, Timestamp.valueOf(reservation.getDate()));
			preparedStatement.setInt(2,reservation.getTotalprice());
			preparedStatement.setInt(3,userId);
			preparedStatement.setInt(4, seatId);
			preparedStatement.setInt(5, trainId);
			preparedStatement.setInt(6, tripId);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			System.out.println("error " + e);
		}
		return 0;
	}
	public void deleteReservation(int reservationId) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_RESERVATION); 
			preparedStatement.setInt(1, reservationId);
			int result = preparedStatement.executeUpdate();
			connection.close();
			System.out.println("Number of records affected :: " + result);
		}catch (SQLException e) {
			System.out.println("error " + e);
		}
	}
	public Reservation getReservationById(int reservationId) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_RESERVATION_BY_ID);
			preparedStatement.setInt(1, reservationId);
			ResultSet result = preparedStatement.executeQuery();
			connection.close();
			if(result.next()) {
				Reservation reservation = new Reservation();
				reservation.setDate(result.getTimestamp("date").toLocalDateTime());
				reservation.setTotalprice(result.getInt("totalprice"));
				reservation.setId(result.getInt("reservation_id"));
				User user=new User();
				user.setFirstName(result.getString("firstname"));
				user.setLastName(result.getString("lastname"));
				reservation.setUser(user);
				Seat seat =new Seat();
				seat.setId(result.getInt("seat_id"));
				seat.setRow(result.getInt("seat_row"));
				seat.setColumn(result.getInt("seat_column"));
				reservation.setSeat(seat);
				Train train =new Train();
				train.setId(result.getInt("train_id"));
				train.setHeadcode(result.getString("headcode"));
				reservation.setTrain(train);
				Wagon wagon = new Wagon();
				wagon.setId(result.getInt("wagon_id"));
				wagon.setNumber(result.getInt("number"));
				reservation.setWagon(wagon);
				Trip trip = new Trip();
				trip.setName(result.getString("name"));
				reservation.setTrip(trip);
				return reservation;
			}else {
				return null;
			}
		}catch(SQLException e) {
			System.out.println("error " + e);
		}
		return null;
	}
	public Reservation updateReservation(int reservationId,int seatId) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RESERVATION);
			preparedStatement.setInt(1, seatId);
			preparedStatement.setInt(2, reservationId);
			int result = preparedStatement.executeUpdate();
			connection.close();
			System.out.println("Number of records affected :: " + result);
		}catch(SQLException e) {
			System.out.println("error " + e);
		}
		return null;
	}
	public ArrayList<Reservation> getAllReservations() {
		ArrayList<Reservation> reservations = new ArrayList<>();
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_RESERVATION);
			ResultSet result = preparedStatement.executeQuery();
			connection.close();
			
			while (result.next()) {
				Reservation reservation = new Reservation();
				reservation.setId(result.getInt("reservation_id"));
				reservation.setDate(result.getTimestamp("date").toLocalDateTime());
				reservation.setTotalprice(result.getInt("totalprice"));
				Trip trip = new Trip();
				trip.setName(result.getString("name"));
				reservation.setTrip(trip);
				reservations.add(reservation);
			} 
			return reservations;
		}catch (SQLException e) {
			System.out.println("error " + e);
			return null;
		}
	}
	public ArrayList<Reservation>  getReservationsByUserId(int userId) {
		ArrayList<Reservation> reservations =new ArrayList<>();
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_RESERVATION_BY_USER_ID);
			preparedStatement.setInt(1, userId);
			ResultSet result = preparedStatement.executeQuery();
			connection.close();
			while (result.next()) {
				Reservation reservation = new Reservation();
				reservation.setId(result.getInt("reservation_id"));
				reservation.setDate(result.getTimestamp("date").toLocalDateTime());
				reservation.setTotalprice(result.getInt("totalprice"));
				Trip trip = new Trip();
				trip.setName(result.getString("name"));
				reservation.setTrip(trip);
				reservations.add(reservation);
			} 
			return reservations;
		}catch (SQLException e) {
			System.out.println("error " + e);
			return null;
		}
	}
	public ArrayList<Reservation>  getReservationsByTripId(int tripId) {
		ArrayList<Reservation> reservations =new ArrayList<>();
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_RESERVATION_BY_TRIP_ID);
			preparedStatement.setInt(1, tripId);
			ResultSet result = preparedStatement.executeQuery();
			connection.close();
			while (result.next()) {
				Reservation reservation = new Reservation();
				reservation.setId(result.getInt("reservation_id"));
				reservation.setDate(result.getTimestamp("date").toLocalDateTime());
				reservation.setTotalprice(result.getInt("totalprice"));
				Trip trip = new Trip();
				trip.setName(result.getString("name"));
				reservation.setTrip(trip);
				reservations.add(reservation);
			} 
			return reservations;
		}catch (SQLException e) {
			System.out.println("error " + e);
			return null;
		}
	}
	
}
