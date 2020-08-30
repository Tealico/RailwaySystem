package view;

import java.util.Scanner;

public class Menu {

	public void start() {
		System.out.println("Welcome");
		System.out.println("------------------------------------");
		System.out.println("1 | Register");
		System.out.println("------------------------------------");
		System.out.println("2 | Login");
		System.out.println("------------------------------------");
		
		Scanner in=new Scanner(System.in);
		System.out.print("Put the number: ");
		int number = in.nextInt();
		if(number == 1) {
//			new UserView().UserMenu();
		} else if(number == 2) {
//			new Reser
		}
		
	}
}

