package view;

import java.util.Scanner;

public class MenuView {
	AuthenticationView authView =new AuthenticationView();
	
	public void start() {
		System.out.println("Welcome");
		System.out.println("---------------------");
		System.out.println("1 | Register");
		System.out.println("---------------------");
		System.out.println("2 | Login");
		System.out.println("---------------------");
		
		Scanner in=new Scanner(System.in);
		System.out.print("Put the number: ");
		int number = in.nextInt();
		if(number == 1) {
			authView.registerMenu();
		} else if(number == 2) {
			authView.loginMenu();
		}
		else if(number > 2 || number < 1 ) {
			System.out.println("Wrong menu.");
			this.start();
		}
	}
}

