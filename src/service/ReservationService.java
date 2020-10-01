package service;

import java.util.ArrayList;

import model.Reservation;
import model.Seat;
import repository.ReservationRepository;
import repository.SeatRepository;

public class ReservationService {
	private ReservationRepository reservationRepository=new ReservationRepository();
	private SeatRepository seatRepository=new SeatRepository();
	
	public void addReservation(Reservation reservation,int userId,int seatId,int trainId,int tripId) {
		Seat seat = seatRepository.getSeatById(seatId);
		if(seat == null || seat.getAvailable() == false) { 
			System.out.println("Seat isn't available or does not exist.");
			return;
		}
		reservationRepository.addReservation(reservation,userId,seatId,trainId,tripId);
		seat.setAvailable(false);
		seatRepository.updateSeat(seat);	
	}
	public ArrayList<Reservation>  getReservationsByUserId(int userId){
		ArrayList<Reservation> reservations = reservationRepository.getReservationsByUserId(userId);
		return reservations;
	}
	public ArrayList<Reservation>  getReservationsByTripId(int tripId){
		ArrayList<Reservation> reservations =reservationRepository.getReservationsByTripId(tripId);
		return reservations;
	}
	public Reservation getReservationById(int reservationId) {
		Reservation reservation=reservationRepository.getReservationById(reservationId);
		return reservation;
	}
	public void deleteReservation(int reservationId,int userId) {
		Reservation reservation =reservationRepository.getReservationById(reservationId);
		if(reservation.getUser().getId() != userId) {
			System.out.println("Unauthorized.");
			 return;
		}
		 reservationRepository.deleteReservation(reservationId);
		
	}
	public void updateReservation(Reservation reservation, int newSeatId) {
		
		Seat newSeat = seatRepository.getSeatById(newSeatId);
		if(newSeat == null || newSeat.getAvailable() == false) {
			System.out.println("Seat isn't available or does not exist."); 
			return;
		}
		newSeat.setAvailable(false);
		
		Reservation oldReservation = reservationRepository.getReservationById(reservation.getId());
		Seat oldSeat = oldReservation.getSeat();
		oldSeat.setAvailable(true);
		
		seatRepository.updateSeat(oldSeat); 
		reservationRepository.updateReservation(reservation.getId(), newSeatId); 
		seatRepository.updateSeat(newSeat); 
	}
}
