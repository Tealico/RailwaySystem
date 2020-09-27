package model;

public class Reservation {
	private int id;
	private String date;
	private int totalprice;
	private Seat seat;
	private Train train;
	private Wagon wagon;
	private Trip trip;
	
	public Reservation(int id, String date, int totalprice, Seat seat ,Train train,Wagon wagon,Trip trip ) {
		this.id = id;
		this.date = date;
		this.totalprice = totalprice;
		this.seat = seat;
		this.train=train;
		this.wagon=wagon;
		this.trip=trip;
	}
	public Reservation() {
		this.id = 0;
		this.date = "";
		this.totalprice = 0;
		this.seat = new Seat();
		this.train=new Train();
		this.wagon=new Wagon();
		this.trip=new Trip();
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return this.date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTotalprice() {
		return this.totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public Seat getSeat() {
		return this.seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public Train getTrain() {
		return this.train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
	public Wagon getWagon() {
		return this.wagon;
	}
	public void setWagon(Wagon wagon) {
		this.wagon = wagon;
	}
	public Trip getTrip() {
		return this.trip;
	}
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + this.id + ", date=" + this.date + ", totalprice=" + this.totalprice + ", seat="
				+ this.seat + ", train=" + this.train + ", wagon=" + this.wagon + ", trip=" + this.trip + "]";
	}
}