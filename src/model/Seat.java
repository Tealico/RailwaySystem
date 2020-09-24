package model;

public class Seat {
	private int id;
	private int row;
	private int column;
	private Boolean available;
	private String type;
	private int price;
	
	public Seat(int id, int row, int column, Boolean available, String type, int price) {
		this.id = id;
		this.row = row;
		this.column = column;
		this.available = available;
		this.type = type;
		this.price = price;
	}
	public Seat() {
		this.id = 0;
		this.row = 0;
		this.column = 0;
		this.available = false;
		this.type = "";
		this.price = 0;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRow() {
		return this.row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return this.column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public Boolean getAvailable() {
		return this.available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return this.price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Seat [id=" + this.id + ", row=" + this.row + ", column=" + this.column + ", available=" + this.available
				+ ", type=" + this.type + ", price=" + this.price + "]";
	}
}