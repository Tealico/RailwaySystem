package view;

import java.util.Scanner;

public class TripView {
	public void tripMenu(int userType) {
		System.out.println("Trip");
		System.out.println("-------------------");
		System.out.println("1 | List Trips");
		System.out.println("-------------------");
		
		Scanner in=new Scanner(System.in);
		
		if(userType == 1) {
			System.out.println("2 | Create Trip");
			System.out.println("-------------------");
			System.out.print("Put the number: ");
			int number = in.nextInt();
			if(number == 1) {
				this.tripList();
			}
			else if(number == 2) {
				
			}
		}else if (userType == 2) {
			System.out.print("Put the number: ");
			int number = in.nextInt();
			if(number == 1) {
				this.tripList();
			}
		}
	}
	
	public void tripList() {
		System.out.print("List Trip");
		
	}
}

