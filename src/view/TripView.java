package view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import exception.CustomException;
import model.Location;
import model.Train;
import model.Trip;
import model.User;
import service.LocationService;
import service.TrainService;
import service.TripService;
import util.UserType;

public class TripView {
	private TripService tripService=new TripService();
	private LocationService locationService=new LocationService();
	private TrainService trainService = new TrainService();
	
	private AdminView adminHome;
	private CustomerView customerHome;
	
	public TripView(AdminView home) {
		this.adminHome = home;
	}
	
	public TripView(CustomerView home) {
		this.customerHome = home;
	}
	
	public void tripMenu(User user) {
		System.out.println("Trip");
		System.out.println("-------------------");
		System.out.println("1 | List Trips");
		System.out.println("-------------------");
		
		Scanner in=new Scanner(System.in);
		
		if(user.getType() == UserType.ADMIN) {
			System.out.println("2 | Create Trip");
			System.out.println("-------------------");
			System.out.println("3 | Home");
			System.out.println("-------------------");
			System.out.print("Put the number: ");
			int number = in.nextInt();
			if(number == 1) {
				this.listTrips(user);
			}
			else if(number == 2) {
				this.addTrip(user);
			}
			else if(number == 3) {
				adminHome.adminMenu();
			}
			else {
				this.tripMenu(user);
			}
		}else if (user.getType() == UserType.CUSTOMER) {
			System.out.println("2 | Home");
			System.out.println("-------------------");
			System.out.print("Put the number: ");
			int number = in.nextInt();
			if(number == 1) {
				this.listTrips(user);
			}
			else if(number == 2) {
				customerHome.userMenu();
			}
			else {
				this.tripMenu(user);
			}
		}
	}
	
	public void listTrips(User user) {
		Scanner in=new Scanner(System.in);
		System.out.println("List trips");	
		System.out.println("---------------------------------------------------------");
		System.out.println("ID   |   Name   |   Description   |   Date   |   Price ");
		System.out.println("---------------------------------------------------------");
		ArrayList<Trip> trips = tripService.getAllTrip();
		
		for(Trip t:trips) {
			System.out.println(t.getId() + "   |   " + t.getName() +"   |   "+ t.getDescription() +"   |   "+ t.getDate() +"   |   "+ t.getPrice());
		}
		
		System.out.println("0   |   Home");
		System.out.print("Put the number: ");
		int number = in.nextInt();
		if(number == 0) {
			if(user.getType()==UserType.ADMIN) {
				adminHome.adminMenu();
			}else {
				customerHome.userMenu();
			}
		}
		else {
			for(Trip t:trips) {
				if(t.getId() == number) {
					this.tripDetails(user, number);
					return;
				}
			}
			System.out.println("Select the correct number!");
			this.listTrips(user);
		}
	}
	
	public void tripDetails(User user, int tripId) {
		try {
			Scanner in=new Scanner(System.in);
			Trip trip = tripService.getTripById(tripId);
			System.out.println(this.buildView(trip));
			System.out.println("Trip Details");
			System.out.println("-------------------");
			if(user.getType() == UserType.ADMIN) {
				System.out.println("1 | Update");
				System.out.println("-------------------");
				System.out.println("2 | Delete");
				System.out.println("-------------------");
				System.out.println("3 | List Reservations");
				System.out.println("-------------------");
				System.out.println("4 | Home");
				System.out.println("-------------------");
				System.out.println("Put the number: ");
				int number=in.nextInt();
				if(number == 1) {
					this.updateTrip(trip,user);
				}
				else if(number == 2) {
					tripService.deleteTrip(trip.getId());
					this.listTrips(user);
				}
				else if(number == 3) {
					new ReservationView(adminHome).listTripReservations(tripId, user);
				}
				else if(number == 4) {
					adminHome.adminMenu();
				}
				else {
					System.out.println("Invalid number! ");
					this.tripDetails(user, tripId);
				}
			}
			else if(user.getType() == UserType.CUSTOMER) {
				System.out.println("1 | Book a trip");
				System.out.println("-------------------");
				System.out.println("2 | Home");
				System.out.println("-------------------");
				System.out.println("Put the number: ");
				int number=in.nextInt();
				if(number == 1) {
					new ReservationView(customerHome).addReservation(tripId,user.getId());
				}
				else if(number == 2) {
					customerHome.userMenu();
				}
				else {
					System.out.println("Invalid number! ");
					this.tripDetails(user, tripId);
				}
			}
		}catch(CustomException c) {
			System.out.println(c.getMessage());
			this.listTrips(user);
		}
	}
		
	private String buildView(Trip trip ) {
		String str = "ID                  |  " + trip.getId()                 		+ "\n"
				   + "--------------------------------------------------"     		+ "\n" 
				   + "Name                |  " + trip.getName()               		+ "\n" 
				   + "--------------------------------------------------"  	  		+ "\n" 
				   + "Description         |  " + trip.getDescription()        		+ "\n"
				   +"---------------------------------------------------"           + "\n"
				   + "Date                |  " + trip.getDate()               		+ "\n" 
				   + "--------------------------------------------------"  		    + "\n" 
				   + "Price               |  " + trip.getPrice()              		+ "\n"
				   +"---------------------------------------------------"     		+ "\n"
				   + "Start               |  " + trip.getStartLocation().getName()  + "\n" 
				   + "--------------------------------------------------"  		 	+ "\n" 
				   + "Destination         |  " + trip.getEndLocation().getName()    + "\n"
				   +"---------------------------------------------------"           + "\n"
				   + "Train Headcode      |  " + trip.getTrain().getHeadcode()      + "\n" 
				   + "--------------------------------------------------"  			+ "\n";
		return str;
	}
	public void updateTrip(Trip trip,User user) {
		Scanner in=new Scanner(System.in);
		System.out.print("Do you want to change trip name? [y/n]: ");
		String answer1 = in.next();
		if(answer1.equalsIgnoreCase("y")) {
			System.out.print("Put new name: ");
			in.nextLine();
			String name=in.nextLine();
			trip.setName(name);		
		}
		System.out.print("Do you want to change trip description? [y/n]: ");
		String answer2 = in.next();
		if(answer2.equalsIgnoreCase("y")) {
			System.out.print("Put new description: ");
			in.nextLine();
			String description = in.nextLine();
			trip.setDescription(description);		
		}
		System.out.print("Do you want to change trip date? [y/n]: ");
		String answer3 = in.next();
		if(answer3.equalsIgnoreCase("y")) {
			System.out.print("Put new date (dd-MM-yyyy HH:mm): ");
			in.nextLine();
			String dateString=in.nextLine();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
			LocalDateTime date = LocalDateTime.parse(dateString,formatter);
			trip.setDate(date);
		}
		System.out.print("Do you want to change price? [y/n]: ");
		String answer4 = in.next();
		if(answer4.equalsIgnoreCase("y")) {
			System.out.print("Put new price: ");
			int price = in.nextInt();
			trip.setPrice(price);		
		}
		System.out.print("Do you want to change train? [y/n]: ");
		String answer5 = in.next();
		if(answer5.equalsIgnoreCase("y")) {
			ArrayList<Train> trains = trainService.getAll();
			for(Train t:trains) {
				System.out.println(t.getId() + "   |   " + t.getAvailable() + "    |    " + t.getDescription() + "    |    " + t.getHeadcode());
			}
			int trainId=in.nextInt();
			Train train=trip.getTrain();
			train.setId(trainId);
			trip.setTrain(train);
		}
		tripService.updateTrip(trip,trip.getTrain().getId());
		this.listTrips(user);
	}
	public void addTrip(User user) {
		Scanner in=new Scanner(System.in);
		System.out.print("Put the trip name: ");
		String name=in.nextLine();
		System.out.print("Put the trip description: ");
		String description=in.nextLine();
		LocalDateTime date = null;
		try {
			System.out.print("Put the trip date (dd-MM-yyyy HH:mm): ");
			String dateString=in.nextLine();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
			date = LocalDateTime.parse(dateString, formatter);
		}catch(DateTimeParseException e) {
			System.out.println(e.getMessage());
			this.addTrip(user);
			return;
		}
		System.out.print("Put the price: ");
		int price=in.nextInt();
		ArrayList<Location> locations = locationService.getAllLocation();
		for(Location l:locations) {
			System.out.println(l.getId()+"   |    "+l.getName()+"      |    "+l.getAvailable());
		}
		System.out.print("Select start location from the list: ");
		int startlocation=in.nextInt();
		boolean valid1=false;
		for(Location l:locations) {
			if(l.getId() == startlocation) {
				valid1=true;
			}
		}
		if(valid1==false) {
			System.out.println("Invalid startlocation!");
			this.addTrip(user);
			return;
		}
		System.out.print("Select end location from the list: ");
		int endlocation=in.nextInt();
		boolean valid2=false;
		for(Location l:locations) {
			if(l.getId() == endlocation) {
				valid2=true;
			}
		}
		if(valid2==false) {
			System.out.println("Invalid endlocation!");
			this.addTrip(user);
			return;
		}
		ArrayList<Train> trains=trainService.getAll();
		for(Train t:trains) {
			System.out.println(t.getId()+"    |    "+t.getAvailable()+"    |   "+t.getHeadcode());
		}
		System.out.print("Select train from the list: ");
		int trainId=in.nextInt();
		boolean valid3=false;
		for(Train t:trains) {
			if(t.getId() == trainId) {
				valid3=true;
			}
		}
		if(valid3==false) {
			System.out.println("Invalid trainId!");
			this.addTrip(user);
			return;
		}
		Trip trip =new Trip();
		trip.setName(name);
		trip.setDescription(description);
		trip.setDate(date);
		trip.setPrice(price);
		tripService.addTrip(trip,startlocation,endlocation,trainId);
		this.listTrips(user);
	}
}





