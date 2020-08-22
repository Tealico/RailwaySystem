package model;

public class Reservation {
	private int id;
	private int date;
	private double price;
	
	public Reservation(int id, int date, double price) {
		this.id = id;
		this.date = date;
		this.price = price;
	}
	public Reservation() {
		this.id=0;
		this.date=0;
		this.price=0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", date=" + date + ", price=" + price + "]";
	}
}
