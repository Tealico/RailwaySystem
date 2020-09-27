package model;

public class Location {
	private int id;
	private String name;
	private Boolean available;
	
	public Location(int id, String name, Boolean available) {
		this.id = id;
		this.name = name;
		this.available = available;
	}
	public Location() {
		this.id = 0;
		this.name = "";
		this.available = false;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getAvailable() {
		return this.available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	@Override
	public String toString() {
		return "Location [id=" + this.id + ", name=" + this.name + ", available=" + this.available + "]";
	}
}
	