package model;

public class Location {
	private int id;
	private String name;
	private String startlocation;
	private String endlocation;
	private Boolean available;
	
	public Location(int id, String name, String startlocation, String endlocation, Boolean available) {
		this.id = id;
		this.name = name;
		this.startlocation = startlocation;
		this.endlocation = endlocation;
		this.available = available;
	}
	public Location() {
		this.id = 0;
		this.name = "";
		this.startlocation = "";
		this.endlocation = "";
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
	public String getStartlocation() {
		return this.startlocation;
	}
	public void setStartlocation(String startlocation) {
		this.startlocation = startlocation;
	}
	public String getEndlocation() {
		return this.endlocation;
	}
	public void setEndlocation(String endlocation) {
		this.endlocation = endlocation;
	}
	public Boolean getAvailable() {
		return this.available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	@Override
	public String toString() {
		return "Location [id=" + this.id + ", name=" + this.name + ", startlocation=" + this.startlocation
				+ ", endlocation=" + this.endlocation + ", available=" + this.available + "]";
	}
}
	