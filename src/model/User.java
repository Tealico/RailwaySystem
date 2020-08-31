package model;

import java.util.ArrayList;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private int age;
	private String email;
	private String phoneNumber;
	private int type;
	private ArrayList<Reservation> reservations;

	public User(int id, String firstName, String lastName, String username, String password, int age, String email,
			String phoneNumber, int type, ArrayList<Reservation> reservations) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.age = age;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.type = type;
		this.reservations = reservations;
	}

	public User() {
		this.id = 0;
		this.firstName = "";
		this.lastName = "";
		this.username = "";
		this.password = "";
		this.age = 0;
		this.email = "";
		this.phoneNumber = "";
		this.type = 0;
		this.reservations = null;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public ArrayList<Reservation> getReservation() {
		return reservations;
	}

	public void setReservation(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", age=" + age + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", type=" + type + ", reservations=" + reservations + "]";
	}
}
