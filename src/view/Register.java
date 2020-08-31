package view;

import java.util.Scanner;

import service.AuthenticationService;


public class Register {
	AuthenticationService auth = new AuthenticationService();
	
	public void registerMenu() {
		Scanner in=new Scanner(System.in);
		System.out.print("First name: ");
		String firstName=in.next();
		System.out.println("--------------------------");
		System.out.print("Last name: ");
		String lastName=in.next();
		System.out.println("--------------------------");
		System.out.println("Password: ");
		String password=in.next();
		System.out.println("--------------------------");
		System.out.print("Age: ");
		int age=in.nextInt();
		System.out.println("--------------------------");
		System.out.print("Email: ");
		String email=in.next();
		System.out.println("--------------------------");
	}
}
