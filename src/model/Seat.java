package model;

public class Seat {
	private int id;
	private int row;
	private int column;
	private Boolean available;
	
	public Seat(int id, int row, int column, Boolean available, int price) {
		this.id = id;
		this.row = row;
		this.column = column;
		this.available = available;
	}
	public Seat() {
		this.id = 0;
		this.row = 0;
		this.column = 0;
		this.available = false;
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
	@Override
	public String toString() {
		return "Seat [id=" + this.id + ", row=" + this.row + ", column=" + this.column + ", available=" + this.available
				+ "]";
	}
}