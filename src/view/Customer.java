package view;

import java.util.Scanner;

public class Customer {
	public void userMenu() {
		System.out.println("User");
		System.out.println("---------------------");
		System.out.println("1 | Profile");
		System.out.println("---------------------");
		System.out.println("2 | Reservartions");
		System.out.println("---------------------");
		System.out.println("3 | Trip");
		System.out.println("---------------------");
		
		Scanner in=new Scanner(System.in);
		System.out.print("Put the number: ");
		int number = in.nextInt();
		
		if(number == 1) {
//			new Profile().profileMenu();
		}
//		else if(number == 2) {
//			new Reservation().reservationMenu();
//		}
		else if(number == 3) {
			new Trip().tripMenu(2);
		}
//		else if(number > 3 || number < 1 ) {
//			System.out.println("Wrong menu.");
//			this.userMenu();
//		}
	}
}
