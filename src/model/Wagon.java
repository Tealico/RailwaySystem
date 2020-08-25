package model;

import java.util.ArrayList;

public class Wagon {
	private int id;
	private int number;
	private String description;
	private ArrayList<Seat> seats;
	
	public Wagon(int id, int number,String description, ArrayList<Seat> seats) {
		this.id = id;
		this.number = number;
		this.description = description;
		this.seats = seats;
	}
	public Wagon() {
		this.id = 0;
		this.number = 0;
		this.description = "";
		this.seats = null;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Seat> getSeats() {
		return seats;
	}
	public void setSeats(ArrayList<Seat> seats) {
		this.seats = seats;
	}
	@Override
	public String toString() {
		return "Wagon [id=" + id + ", number=" + number + ", description=" + description + ", seats=" + seats + "]";
	}
}
