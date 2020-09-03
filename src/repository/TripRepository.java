package repository;

import java.util.ArrayList;

import model.Location;
import model.Reservation;
import model.Train;


public class TripRepository {
	 private ArrayList<Train> trains ;
	 private ArrayList<Location> locations;
	 private ArrayList<Reservation> reservations;
	 
	 public TripRepository() {
		 trains=new ArrayList<Train>();
		 locations=new ArrayList<Location>();
		 reservations=new ArrayList<Reservation>();
	 }
	 public ArrayList<Train> getAllTrains(){
		 return this.trains;
	 }
	 public ArrayList<Location> getAllLocation(){
		 return this.locations;
	 }
	 public ArrayList<Reservation> getAllReservation(){
		 return this.reservations;
	 }
	 public void addTrain(Train t) {
		 trains.add(t);
	 }
	 public void addLocation(Location l) {
		 locations.add(l);
	 }
	 public void addReservations(Reservation r) {
		 reservations.add(r);
	 }
	 public Train getTrainById(int id) {
		 for(Train train : trains) {
			 if(train.getId()==id) {
				 return train;
			 }
		 }
		 return null;
	 }
	 public Location getLocationId(int id) {
		 for(Location location : locations) {
			 if(location.getId()==id) {
				 return location;
			 }
		 }
		 return null;
	 }
	 public Reservation getReservationById (int id) {
		 for(Reservation reservation : reservations) {
			 if(reservation.getId()==id) {
				 return reservation;
			 }
		 }
		 return null;
	 }
}
