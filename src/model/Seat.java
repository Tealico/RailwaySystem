package model;

public class Seat {
	private int id;
	private int row;
	private int column;
	private Boolean available;
	
	public Seat(int id, int row, int column, Boolean available) {
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
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	@Override
	public String toString() {
		return "Seat [id=" + id + ", row=" + row + ", column=" + column + ", available=" + available + "]";
	}
}
