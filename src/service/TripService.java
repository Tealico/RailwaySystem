package service;

import java.util.ArrayList;

import model.Trip;
import repository.TripRepository;

public class TripService {
	private TripRepository tripRepository = new TripRepository();
	
	public ArrayList<Trip> getAllTrip(){
		ArrayList<Trip> trip=tripRepository.getAllTrips();
		return trip;
	}
	public Trip getTripById(int tripId) {
		Trip trip= tripRepository.getTripById(tripId);
		return trip;
	}
	
	public void deleteTrip(int tripId){
		tripRepository.deleteTrip(tripId);
	}
	public Trip updateTrip(Trip trip,int trainId) {
		Trip newTrip=tripRepository.updateTrip(trip,trainId);
		return newTrip;
	}
	public void addTrip(Trip trip,int startlocation,int endlocation,int trainId) {
		tripRepository.addTrip(trip,startlocation,endlocation,trainId);
	}
}
