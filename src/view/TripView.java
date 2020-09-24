package view;

import java.util.Scanner;

import model.User;
import util.UserType;

public class TripView {
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
				this.tripList();
			}
			else if(number == 2) {
				
			}
			else if(number == 3) {
				adminHome.adminMenu();
			}
		}else if (user.getType() == UserType.CUSTOMER) {
			System.out.println("2 | Home");
			System.out.println("-------------------");
			System.out.print("Put the number: ");
			int number = in.nextInt();
			if(number == 1) {
				this.tripList();
			}
			else if(number == 2) {
				customerHome.userMenu();
			}
		}
	}
	
	public void tripList() {
		System.out.print("List Trip");
		
	}
}

