package view;

import java.util.ArrayList;
import java.util.Scanner;

import exception.CustomException;
import model.Location;
import service.LocationService;

public class LocationView {
	private LocationService locationService=new LocationService();
	private AdminView home;
	
	public LocationView(AdminView home) {
		this.home=home;
	}
	public void locationMenu() {
		Scanner in=new Scanner(System.in);
		System.out.println("Location");
		System.out.println("-------------------");
		System.out.println("1 | List Location");
		System.out.println("-------------------");
		System.out.println("2 | Add Location");
		System.out.println("-------------------");
		System.out.println("3 | Home");
		System.out.println("-------------------");
		System.out.print("Put the number: ");
		int number = in.nextInt();
		if(number == 1) {
			this.locationList();
		}
		else if(number == 2) {
			this.addLocation();
		}
		else if(number == 3) {
			home.adminMenu();
		}
	}
	public void locationList() {
		Scanner in=new Scanner(System.in);
		System.out.println("List Location");	
		System.out.println("----------------------------------------------");
		System.out.println("ID   |   Name   |   Available");
		System.out.println("----------------------------------------------");
		ArrayList<Location> locations = locationService.getAllLocation();
		
		for(Location l:locations) {
			System.out.println(l.getId() + "   |   " + l.getName() + "   |   " + l.getAvailable());
		}
		System.out.println("0   |   Home");
		System.out.print("Put the number: ");
		int number = in.nextInt();
		if(number == 0) {
			home.adminMenu();
		}
		else {
			try {
				this.locationDetails(number);
			}catch(Exception e) {
				System.out.println(e.getMessage());
				this.locationList();
			}
		}
	}
	public void locationDetails(int locationId) {
		try {
			Scanner in=new Scanner(System.in);
			Location location = locationService.getLocationById(locationId);
			System.out.println(this.buildView(location));
			System.out.println("Location Details");
			System.out.println("-------------------");
			System.out.println("1 | Update");
			System.out.println("-------------------");
			System.out.println("2 | Delete");
			System.out.println("-------------------");
			System.out.println("3 | Home");
			System.out.println("-------------------");
			System.out.println("Put the number: ");
			int number=in.nextInt();
			if(number == 1) {
				this.updateLocation(location);
			}
			else if(number == 2) {
				locationService.deleteLocation(location.getId());
				this.locationList();
			}
			else if(number == 3) {
				home.adminMenu();
			}
		}catch(CustomException c) {
			System.out.println(c.getMessage());
			this.locationList();
		}
	}
	private String buildView(Location location) {
		String str = "ID                 |  " + location.getId()               + "\n"
				   + "-----------------------------------------------------"   + "\n" 
				   + "Name               |  " + location.getName()             + "\n" 
				   + "-----------------------------------------------------"   + "\n" 
				   + "Available          |  " + location.getAvailable()        + "\n"
				   +"------------------------------------------------------"   + "\n";
		return str;
	}
	public void updateLocation(Location location) {
		Scanner in=new Scanner(System.in);
		if(location.getAvailable()) {
			System.out.print("Make unavailable?[y/n]: ");
			String answer = in.next();
			if(answer.equalsIgnoreCase("y")) {
				location.setAvailable(false);
			}else {
				location.setAvailable(true);
			}
		}else {
			System.out.print("Make available?[y/n]: ");
			String answer = in.next();
			if(answer.equalsIgnoreCase("y")) {
				location.setAvailable(true);
			}else {
				location.setAvailable(false);
			}
		}
		System.out.print("Do you want to change Name? [y/n]: ");
		String answer = in.next();
		if(answer.equalsIgnoreCase("y")) {
			System.out.print("Put new name: ");
			in.nextLine();
			String name = in.nextLine();
			location.setName(name);		
		}
		locationService.updateLocation(location);
		this.locationList();
	}
	public void addLocation() {
		Scanner in=new Scanner(System.in);
		System.out.println("Put the location name: ");
		String name =in.nextLine();
		System.out.print("Is available? [y/n]: ");
		String answer=in.next();
		boolean available;
		if(answer.equalsIgnoreCase("y")) {
			available=true;
		}else {
			available=false;
		}
		Location location = new Location();
		location.setName(name);
		location.setAvailable(available);
		locationService.addLocation(location);
		this.locationList();
	}
}
