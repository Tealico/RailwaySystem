package model;

import java.util.Arrays;

public class Train {
	private int id;
	private Boolean available;
	private String description;
	private Trip[] trip;
	private Wagon[] wagons;
	
	public Train(int id, Boolean available, String description, Trip[] trip, Wagon[] wagons) {
		this.id = id;
		this.available = available;
		this.description = description;
		this.trip = trip;
		this.wagons = wagons;
	}
	public Train() {
		this.id = 0;
		this.available = false;
		this.description = "";
		this.trip = null;
		this.wagons = null;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Trip[] getTrip() {
		return trip;
	}
	public void setTrip(Trip[] trip) {
		this.trip = trip;
	}
	public Wagon[] getWagons() {
		return wagons;
	}
	public void setWagons(Wagon[] wagons) {
		this.wagons = wagons;
	}
	@Override
	public String toString() {
		return "Train [id=" + id + ", available=" + available + ", description=" + description + ", trip="
				+ Arrays.toString(trip) + ", wagons=" + Arrays.toString(wagons) + "]";
	}
}
