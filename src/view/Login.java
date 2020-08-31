package view;

import java.util.Scanner;

import exception.CustomException;
import service.AuthenticationService;
import model.User;

public class Login {
	AuthenticationService auth = new AuthenticationService();
	
	public void loginMenu() {
			
		Scanner in=new Scanner(System.in);
		System.out.print("Username: ");
		String username=in.next();
		System.out.println("--------------------------");
		System.out.print("Password: ");
		String password=in.next();
		System.out.println("--------------------------");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		try {
			auth.login(user);
		}catch(CustomException exception) {
			System.out.println(exception.getMessage());
			this.loginMenu();
		}
	}
}
