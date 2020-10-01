package view;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import exception.CustomException;
import model.Reservation;
import model.Seat;
import model.Trip;
import model.User;
import model.Wagon;
import service.ReservationService;
import service.SeatService;
import service.TripService;
import service.WagonService;
import util.UserType;

public class ReservationView {
	private ReservationService reservationService=new ReservationService();
	private TripService tripService=new TripService();
	private WagonService wagonService=new WagonService();
	private SeatService seatService = new SeatService();
	
	private CustomerView customerHome;
	private AdminView adminHome;
	
	public ReservationView(CustomerView home) {
		this.customerHome = home;
	}
	public ReservationView(AdminView home) {
		this.adminHome=home;
	}
	public void reservationMenu(User user) {
		Scanner in=new Scanner(System.in);
		System.out.println("Reservation");
		System.out.println("-------------------");
		System.out.println("1 | List Reservation");
		System.out.println("-------------------");
		System.out.println("2 | Home");
		System.out.println("-------------------");
		System.out.print("Put the number: ");
		int number = in.nextInt();
		if(number == 1) {
			this.listUserReservations(user);
		}
		else if(number == 2) {
			customerHome.userMenu();
		}
		else {
			System.out.println("Invalid number. ");
			this.reservationMenu(user);
		}
	}
	
	public void addReservation(int userId,int tripId) {
		Scanner in=new Scanner(System.in);
		Trip trip =tripService.getTripById(tripId);
		System.out.println("Trip name: " +trip.getName());
		System.out.println("Trip price : "+trip.getPrice());
		System.out.println("Trip date : "+trip.getDate());
		System.out.println("Start location: " +trip.getStartLocation().getName());
		System.out.println("End location : "+trip.getEndLocation().getName());
		System.out.println("Train headcode : "+trip.getTrain().getHeadcode());
		ArrayList<Wagon> wagons =wagonService.getAllWagonsByTrainId(trip.getTrain().getId());
		System.out.println("ID    |    Number  ");
		for (Wagon w:wagons) {
			System.out.println(w.getId()+"   |  Wagon number: "+w.getNumber());
		}
		System.out.println("Put the wagon ID: ");
		int number=in.nextInt();
		ArrayList<Seat> seats =seatService.getAllSeatByWagonId(number);
		System.out.println("ID    |    Row    |    Column    |    Available");
		for(Seat s :seats) {
			System.out.println(s.getId()+"    |    "+s.getRow()+"    |    "+s.getColumn()+"    |    "+ (s.getAvailable() ? "yes" : "no"));
		}
		System.out.print("Put seat ID:");
		int seatId=in.nextInt();
		Reservation reservation=new Reservation();
		reservation.setDate(LocalDateTime.now());
		reservation.setTotalprice(trip.getPrice());
		reservationService.addReservation(reservation,userId,seatId,trip.getTrain().getId(),tripId);
		System.out.println("Reservation created successfully.");
		customerHome.userMenu();
	}
	public void listUserReservations(User user) {
		Scanner in=new Scanner(System.in);
		System.out.println("List Reservation");	
		System.out.println("----------------------------------------------");
		System.out.println("ID   |   Trip   |   Date   |   Total price ");
		System.out.println("----------------------------------------------");
		ArrayList<Reservation> reservations = reservationService. getReservationsByUserId(user.getId());
		for(Reservation r: reservations) {
			System.out.println(r.getId() + "   |   " + r.getTrip().getName() + "   |   " +r.getDate() +"   |   "+ r.getTotalprice());
		}
		
		System.out.println("0   |   Home");
		System.out.print("Put the number: ");
		int number = in.nextInt();
		if(number == 0) {
			customerHome.userMenu();
		}
		else {
			this.reservationDetails(number, user);
		}
	}
	public void listTripReservations(int tripId, User user) {
		Scanner in=new Scanner(System.in);
		System.out.println("List Reservation");	
		System.out.println("----------------------------------------------");
		System.out.println("ID   |   Trip   |   Date   |   Total price ");
		System.out.println("----------------------------------------------");
		ArrayList<Reservation> reservations = reservationService. getReservationsByTripId(tripId);
		for(Reservation r: reservations) {
			System.out.println(r.getId() + "   |   " + r.getTrip().getName() + "   |   " +r.getDate() +"   |   "+ r.getTotalprice());
		}
		
		System.out.println("0   |   Home");
		System.out.print("Put the number: ");
		int number = in.nextInt();
		if(number == 0) {
			adminHome.adminMenu();
		}
		else {
			this.reservationDetails(number,user);
		}
	}

	public void reservationDetails(int reservationId, User user) {
		try {
			Scanner in=new Scanner(System.in);
			Reservation reservation= reservationService.getReservationById(reservationId);
			System.out.println(this.buildView(reservation));
			System.out.println("Reservation Details");
			System.out.println("-------------------");
			if(user.getType() == UserType.ADMIN) {
				System.out.println("1 | Home");
				System.out.println("-------------------");
				System.out.println("Put the number: ");
				int number=in.nextInt();
				if(number == 1) {
					adminHome.adminMenu();
				}
				else {
					System.out.println("Invalid number! ");
					this.reservationDetails(reservationId, user);
				}
			}else {
				System.out.println("1 | Update");
				System.out.println("-------------------");
				System.out.println("2 | Delete");
				System.out.println("-------------------");
				System.out.println("3 | Home");
				System.out.println("-------------------");
				System.out.println("Put the number: ");
				int number=in.nextInt();
				if(number == 1) {
					this.updateReservation(reservation);
					this.reservationDetails(reservationId, user);
				}
				else if(number == 2) {
					reservationService.deleteReservation(reservation.getId(),user.getId());
					this.listUserReservations(user);
				}
				else if(number == 3) {
					customerHome.userMenu();
				}
				else {
					System.out.println("Invalid number! ");
					this.reservationDetails(reservationId, user);
				}
			}
		}catch(CustomException c) {
			System.out.println(c.getMessage());
			this.reservationDetails(reservationId, user);
		}
	}
	private String buildView(Reservation reservation ) {
		String str = "ID                  |  " + reservation.getId()                 						+ "\n"
				   + "---------------------------------------------------------"         				    + "\n" 
				   + "Date                |  " + reservation.getDate()               		                + "\n" 
				   + "---------------------------------------------------------"  	                        + "\n" 
				   + "Total price         |  " + reservation.getTotalprice()       	    				  	+ "\n"
				   +"----------------------------------------------------------"       				    	+ "\n"
				   + "Firstname           |  " + reservation.getUser().getFirstName()   					+ "\n"
				   +"----------------------------------------------------------"         				 	+ "\n"
				   + "LastName            |  " + reservation.getUser().getLastName()     					+ "\n" 
				   + "---------------------------------------------------------"  							+ "\n"
				   + "Row                 |  " + reservation.getSeat().getRow()             				+ "\n" 
				   + "---------------------------------------------------------"  		   					+ "\n" 
				   + "Column              |  " + reservation.getSeat().getColumn()    						+ "\n"
				   +"----------------------------------------------------------"     						+ "\n"
				   + "Available           |  " + (reservation.getSeat().getAvailable() ? "yes" : "no")  	+ "\n" 
				   + "---------------------------------------------------------"  		 					+ "\n" 
				   + "Number              |  " + reservation.getWagon().getNumber()  		                + "\n"
				   +"----------------------------------------------------------"          	                + "\n"
				   + "Train Headcode      |  " + reservation.getTrain().getHeadcode()                       + "\n" 
				   + "---------------------------------------------------------"  							+ "\n";
		return str;
	}
	public void updateReservation(Reservation reservation) {
		Scanner in=new Scanner(System.in);
		int wagonId = reservation.getWagon().getId(); 
		System.out.println("Do you want to change wagon?[y/n] ");
		String answer1 = in.next();
		if(answer1.equalsIgnoreCase("y")) {
			ArrayList<Wagon> wagons =wagonService.getAllWagonsByTrainId(reservation.getTrain().getId());
			System.out.println("ID    |    Number  ");
			for (Wagon w:wagons) {
				System.out.println(w.getId()+"   |  Wagon number: "+w.getNumber());
			}
			System.out.print("Put the wagon: ");
			wagonId=in.nextInt(); 
		}
		System.out.println("Do you want to change seat?[y/n] ");
		String answer2 = in.next();
		if(answer2.equalsIgnoreCase("y")) {
			ArrayList<Seat> seats =seatService.getAllSeatByWagonId(wagonId);
			System.out.println("ID    |    Row    |    Column    |    Available");
			for(Seat s :seats) {
				System.out.println(s.getId()+"    |    "+s.getRow()+"    |    "+s.getColumn()+"    |    "+ (s.getAvailable() ? "yes" : "no"));
			}
			System.out.print("Put the seat id: ");
			int number=in.nextInt();
			reservationService.updateReservation(reservation, number);
		}
	}
}
	

		

