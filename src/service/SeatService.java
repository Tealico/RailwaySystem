package service;

import java.util.ArrayList;

import model.Seat;
import repository.SeatRepository;

public class SeatService {
	private SeatRepository seatRespository=new SeatRepository();
	
	public ArrayList<Seat> getAllSeatByWagonId(int wagonId){
		ArrayList<Seat> seats = seatRespository.getAllSeatByWagonId(wagonId);
		return seats;
	}
}
