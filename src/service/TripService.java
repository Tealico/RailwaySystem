package service;

import java.util.ArrayList;

import model.Location;
import model.Trip;
import repository.LocationRepository;
import repository.TripRepository;

public class TripService {
	private TripRepository tripRepository = new TripRepository();
	private LocationRepository locationRepository = new LocationRepository();
	
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
	public void updateTrip(Trip trip,int trainId) {
		tripRepository.updateTrip(trip,trainId);
	}
	public void addTrip(Trip trip,int startlocation,int endlocation,int trainId) {
		Location location1=locationRepository.getLocationById(startlocation);
		if(location1.getAvailable() == false || location1 == null) {
			System.out.println("Start location isn't available or does not exist");
			return;
		}
		Location location2=locationRepository.getLocationById(endlocation);
		if(location2.getAvailable() == false || location2 == null) {
			System.out.println("End location isn't available or does not exist");
			return;
		}
		tripRepository.addTrip(trip,startlocation,endlocation,trainId);
	}
}
