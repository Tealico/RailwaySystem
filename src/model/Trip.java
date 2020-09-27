package model;


import java.time.LocalDateTime;
import java.util.ArrayList;

public class Trip {
	private int id;
	private Location startLocation;
	private Location endLocation;
	private String name;
	private String description;
	private int price;
	private LocalDateTime date;
	private ArrayList<Reservation> reservations;
	private Train train;

	public Trip(int id, Location startLocation, Location endLocation, String name, String description,int price,LocalDateTime date,
			ArrayList<Reservation> reservations, Train train) {
		this.id = id;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.name = name;
		this.description = description;
		this.date=date;
		this.price=price;
		this.reservations = reservations;
		this.train = train;
	}

	public Trip() {
		this.id = 0;
		this.startLocation = new Location();
		this.endLocation = new Location();
		this.name = "";
		this.description = "";
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
	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDateTime getDate() {
		return this.date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
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
		return "Trip [id=" + this.id + ", startLocation=" + this.startLocation + ", endLocation=" + this.endLocation
				+ ", name=" + this.name + ", description=" + this.description + ", price=" + this.price + ", date="
				+ this.date + ", reservations=" + this.reservations + ", train=" + this.train + "]";
	}
}
