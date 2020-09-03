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
		
		Scanner in=new Scanner(System.in);
		System.out.print("Put the number: ");
		int number = in.nextInt();
		if(number == 1) {
//			new Profile().profileMenu();
		}
//		else if(number == 2) {
//			new Train().trainMenu();
//		}
//		else if(number == 3) {
//			new Location().locationMenu();
//		}
//		else if(number == 4) {
//			new Users().usersMenu();
//		}
		else if(number == 5) {
			new TripView().tripMenu(1);
		}
//		else if(number > 5 || number < 1 ) {
//			System.out.println("Wrong menu.");
//			this.adminMenu();
//		}
	}
}
