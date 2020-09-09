package service;

import java.util.ArrayList;
import java.util.Date;

import exception.CustomException;
import model.Location;
import model.Train;
import model.Trip;
import repository.TripRepository;

public class TripService {
	TripRepository tripRepository= new TripRepository();
	
	public void addTrip(Trip trip) {
		ArrayList<Train> trains=tripRepository.getAllTrains();
		String trainId=trip.getTrain().getId();
		for(Train train: trains) {
			if()
		}
		
	}
}	

