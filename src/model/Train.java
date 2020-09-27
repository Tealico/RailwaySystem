package model;

import java.util.ArrayList;

public class Train {
	private int id;
	private Boolean available;
	private String description;
	private String headcode;
	private ArrayList<Trip> trips;
	private ArrayList<Wagon> wagons;

	public Train(int id, Boolean available, String description,String headcode, ArrayList<Trip> trips, ArrayList<Wagon> wagons) {
		this.id = id;
		this.available = available;
		this.description = description;
		this.headcode=headcode;
		this.trips = trips;
		this.wagons = wagons;
	}

	public Train() {
		this.id = 0;
		this.available = false;
		this.description = "";
		this.headcode="";
		this.trips = null;
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
	
	public String getHeadcode() {
		return this.headcode;
	}

	public void setHeadcode(String headcode) {
		this.headcode = headcode;
	}

	public ArrayList<Trip> getTrip() {
		return trips;
	}

	public void setTrip(ArrayList<Trip> trips) {
		this.trips = trips;
	}

	public ArrayList<Wagon> getWagons() {
		return wagons;
	}

	public void setWagons(ArrayList<Wagon> wagons) {
		this.wagons = wagons;
	}

	@Override
	public String toString() {
		return "Train [id=" + this.id + ", available=" + this.available + ", description=" + this.description
				+ ", headcode=" + this.headcode + ", trips=" + this.trips + ", wagons=" + this.wagons + "]";
	}
}
