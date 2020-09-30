package view;

import java.util.Scanner;

import model.User;

public class AdminView {
	private User user;
	
	public AdminView(User user) {
		this.user = user;
	}
	
	public void adminMenu() {
		System.out.println("Admin");
		System.out.println("---------------------");
		System.out.println("1 | Trains");
		System.out.println("---------------------");
		System.out.println("2 | Location");
		System.out.println("---------------------");
		System.out.println("3 | Users");
		System.out.println("---------------------");
		System.out.println("4 | Trip");
		System.out.println("---------------------");
		System.out.println("5 | Wagons");
		System.out.println("---------------------");
		
		Scanner in=new Scanner(System.in);
		System.out.print("Put the number: ");
		int number = in.nextInt();
		if(number == 1) {
			new TrainView(this).trainMenu();
		}
		else if(number == 2) {
			new LocationView(this).locationMenu();
		}
		else if(number == 3) {
			new UsersView(this).usersMenu();
		}
		else if(number == 4) {
			new TripView(this).tripMenu(user);
		}
		else if(number == 5) {
			new WagonView(this).wagonMenu();
		}
		else {
			System.out.println("Invalid number.");
			this.adminMenu();
		}
	}
}
