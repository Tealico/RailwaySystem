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
		System.out.println("1 | Profile");
		System.out.println("---------------------");
		System.out.println("2 | Trains");
		System.out.println("---------------------");
		System.out.println("3 | Location");
		System.out.println("---------------------");
		System.out.println("4 | Users");
		System.out.println("---------------------");
		System.out.println("5 | Trip");
		System.out.println("---------------------");
		System.out.println("6 | Wagons");
		System.out.println("---------------------");
		
		Scanner in=new Scanner(System.in);
		System.out.print("Put the number: ");
		int number = in.nextInt();
		if(number == 1) {
//			new Profile().profileMenu();
		}
		else if(number == 2) {
			new TrainView(this).trainMenu();
		}
		else if(number == 3) {
			new LocationView(this).locationMenu();
		}
		else if(number == 4) {
			new UsersView(this).usersMenu();
		}
		else if(number == 5) {
			new TripView(this).tripMenu(user);
		}
		else if(number == 6) {
			new WagonView(this).wagonMenu();
		}
		else if(number > 5 || number < 1 ) {
			System.out.println("Wrong menu.");
			this.adminMenu();
		}
	}
}
