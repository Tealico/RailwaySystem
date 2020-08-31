package model;

import java.util.ArrayList;
import java.util.Date;

public class Trip {
	private int id;
	private Location startLocation;
	private Location endLocation;
	private String name;
	private String description;
	private ArrayList<Date> availableDates;
	private ArrayList<Reservation> reservations;
	private Train train;

	public Trip(int id, Location startLocation, Location endLocation, String name, String description,
			ArrayList<Date> availableDates, ArrayList<Reservation> reservations, Train train) {
		this.id = id;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.name = name;
		this.description = description;
		this.availableDates = availableDates;
		this.reservations = reservations;
		this.train = train;
	}

	public Trip() {
		this.id = 0;
		this.startLocation = new Location();
		this.endLocation = new Location();
		this.name = "";
		this.description = "";
		this.availableDates = null;
		this.reservations = null;
		this.train = new Train();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Location getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(Location startLocation) {
		this.startLocation = startLocation;
	}

	public Location getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(Location endLocation) {
		this.endLocation = endLocation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Date> getAvailableDates() {
		return availableDates;
	}

	public void setAvailableDates(ArrayList<Date> availableDates) {
		this.availableDates = availableDates;
	}

	public ArrayList<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	@Override
	public String toString() {
		return "Trip [id=" + id + ", startLocation=" + startLocation + ", endLocation=" + endLocation + ", name=" + name
				+ ", description=" + description + ", availableDates=" + availableDates + ", reservations="
				+ reservations + ", train=" + train + "]";
	}
}
