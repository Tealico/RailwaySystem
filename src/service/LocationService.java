package service;

import java.util.ArrayList;

import model.Location;
import repository.LocationRepository;


public class LocationService {
	private LocationRepository locationRepository = new LocationRepository();
	
	public ArrayList<Location> getAllLocation(){
		ArrayList<Location> locations=locationRepository.getAllLocation();
		return locations;
	}
	
	public Location getLocationById(int locationId) {
		Location location= locationRepository.getLocationById(locationId);
		return location;
	}
	
	public void deleteLocation(int locationId){
		locationRepository.deleteLocation(locationId);
	}
	public Location updateLocation(Location location) {
		Location newLocation=locationRepository.updateLocation(location);
		return newLocation;
	}
	public void addLocation(Location location) {
		locationRepository.addLocation(location);
	}
}

