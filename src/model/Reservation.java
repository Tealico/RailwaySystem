package model;

public class Reservation {
	private int id;
	private String date;
	private int totalprice;
	private Seat seat;
	
	public Reservation(int id, String date, int totalprice, Seat seat) {
		this.id = id;
		this.date = date;
		this.totalprice = totalprice;
		this.seat = seat;
	}
	public Reservation() {
		this.id = 0;
		this.date = "";
		this.totalprice = 0;
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
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", date=" + date + ", totalprice=" + totalprice + ", seat=" + seat + "]";
	}
}
	
	