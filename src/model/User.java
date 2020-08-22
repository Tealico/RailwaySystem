package model;

import java.util.Arrays;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private int age;
	private String email;
	private int phoneNumber;
	private int type;
	private Reservation[] reservation;
	
	public User(int id, String firstName, String lastName, String username, int age, String email, int phoneNumber,
			int type, Reservation[] reservation) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.age = age;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.type = type;
		this.reservation = reservation;
	}
	public User() {
		this.id = 0;
		this.firstName = "";
		this.lastName = "";
		this.username = "";
		this.age = 0;
		this.email = "";
		this.phoneNumber = 0;
		this.type = 0;
		this.reservation = null;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Reservation[] getReservation() {
		return reservation;
	}
	public void setReservation(Reservation[] reservation) {
		this.reservation = reservation;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", age=" + age + ", email=" + email + ", phoneNumber=" + phoneNumber + ", type=" + type
				+ ", reservation=" + Arrays.toString(reservation) + "]";
	}
}
