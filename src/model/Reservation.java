package model;

public class Reservation {
	private int id;
	private String date;
	private int price;
	private Seat seat;
	
	public Reservation(int id, String date, int price, Seat seat) {
		this.id = id;
		this.date = date;
		this.price = price;
		this.seat = seat;
	}
	public Reservation() {
		this.id = 0;
		this.date = "";
		this.price = 0;
		this.seat = new Seat();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", date=" + date + ", price=" + price + ", seat=" + seat + "]";
	}
}
	
	