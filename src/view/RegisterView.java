package view;

import java.util.Scanner;

import exception.CustomException;
import model.User;
import service.AuthenticationService;


public class RegisterView {
	AuthenticationService auth = new AuthenticationService();
	
	public void registerMenu() {
		Scanner in=new Scanner(System.in);
		System.out.print("First name: ");
		String firstName=in.next();
		System.out.println("--------------------------");
		System.out.print("Last name: ");
		String lastName=in.next();
		System.out.println("--------------------------");
		System.out.print("Username: ");
		String username=in.next();
		System.out.println("--------------------------");
		System.out.print("Password: ");
		String password=in.next();
		System.out.println("--------------------------");
		System.out.print("Age: ");
		int age=in.nextInt();
		System.out.println("--------------------------");
		System.out.print("Email: ");
		String email=in.next();
		System.out.println("--------------------------");
		
		User user  = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUsername(username);
		user.setPassword(password);
		user.setAge(age);
		user.setEmail(email);
		try {
			auth.register(user);
			new LoginView().loginMenu();
		}
		catch(CustomException exception) {
			System.out.println(exception.getMessage());
			this.registerMenu();
		}
		
	}
}
