package model;

public class Location {
	private int id;
	private String name;
	private String address;
	private Boolean available;
	
	public Location(int id, String name, String address, Boolean available) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.available = available;
	}
	public Location() {
		this.id = 0;
		this.name = "";
		this.address = "";
		this.available = false;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	@Override
	public String toString() {
		return "Location [id=" + id + ", name=" + name + ", address=" + address + ", available=" + available + "]";
	}
}
