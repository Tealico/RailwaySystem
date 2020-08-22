package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Trip {
	private int id;
	private Location[] startLocation;
	private Location[] endLocation;
	private String name;
	private String description;
	private ArrayList<Date> availableDates;
	private Reservation[] reservations;
	
	public Trip(int id, Location[] startLocation, Location[] endLocation, String name, String description,
			ArrayList<Date> availableDates, Reservation[] reservations) {
		this.id = id;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.name = name;
		this.description = description;
		this.availableDates = availableDates;
		this.reservations = reservations;
	}
	public Trip() {
		this.id = 0;
		this.startLocation = null;
		this.endLocation = null;
		this.name = "";
		this.description = "";
		this.availableDates = null;
		this.reservations = null;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Location[] getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(Location[] startLocation) {
		this.startLocation = startLocation;
	}
	public Location[] getEndLocation() {
		return endLocation;
	}
	public void setEndLocation(Location[] endLocation) {
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
	public Reservation[] getReservations() {
		return reservations;
	}
	public void setReservations(Reservation[] reservations) {
		this.reservations = reservations;
	}
	@Override
	public String toString() {
		return "Trip [id=" + id + ", startLocation=" + Arrays.toString(startLocation) + ", endLocation="
				+ Arrays.toString(endLocation) + ", name=" + name + ", description=" + description + ", availableDates="
				+ availableDates + ", reservations=" + Arrays.toString(reservations) + "]";
	}
}
