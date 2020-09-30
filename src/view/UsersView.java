package view;

import java.util.ArrayList;
import java.util.Scanner;

import exception.CustomException;
import model.User;
import service.UserService;
import util.UserType;

public class UsersView {
	private UserService userService = new UserService();
	private AdminView home;
	
	public UsersView(AdminView home) {
		this.home = home;
	}
	
	public void usersMenu() {
		Scanner in=new Scanner(System.in);
		System.out.println("Users");
		System.out.println("-------------------");
		System.out.println("1 | List Users");
		System.out.println("-------------------");
		System.out.println("2 | Home");
		System.out.println("-------------------");
		System.out.print("Put the number: ");
		int number = in.nextInt();
		if(number == 1) {
			this.usersList();
		}
		else if(number == 2) {
			home.adminMenu();
		}
		else {
			System.out.println("Invalid number. ");
			this.usersMenu();
		}
	}
	
	public void usersList() {
		Scanner in=new Scanner(System.in);
		System.out.println("List Users");	
		System.out.println("----------------------------------------------");
		System.out.println("ID | First Name | Last Name | Username | Type");
		System.out.println("----------------------------------------------");
		ArrayList<User> users = userService.getAllUsers();
		
		for(User u:users) {
			System.out.println(u.getId() + " | " + u.getFirstName( )+ " | " + u.getLastName() + " | " + u.getUsername() + " | " + u.getType());
		}
		
		System.out.println("0 | Home");
		System.out.print("Put the number: ");
		int number = in.nextInt();
		if(number == 0) {
			home.adminMenu();
		}
		else {
			this.userDetails(number);
		}
	}
	
	public void userDetails(int id) {
		try {
			Scanner in=new Scanner(System.in);
			User user = userService.getUserById(id);
			System.out.println(this.buildView(user));
			
			System.out.println("User Details");
			System.out.println("-------------------");
			System.out.println("1 | Update(Make admin/customer)");
			System.out.println("-------------------");
			System.out.println("2 | Delete");
			System.out.println("-------------------");
			System.out.println("3 | Home");
			System.out.println("-------------------");
			System.out.print("Put the number: ");
			int number = in.nextInt();
			
			if(number==1) {
				int newTypeId = 0;
				if(user.getType() == UserType.ADMIN) {
					newTypeId = 2;
				}else if(user.getType() == UserType.CUSTOMER) {
					newTypeId = 1;
				}
				int result = userService.updateUserType(user.getId(), newTypeId);
				this.usersList();
			}else if(number==2) {
				userService.deleteUser(id);
				this.usersList();
			}else if(number==3) {
				home.adminMenu();
			}
			else {
				System.out.println("Invalid number. ");
				this.userDetails(id);
			}
		}catch(CustomException e) {
			System.out.println(e.getMessage());
			this.usersList();
		}
	}
	
	private String buildView(User user) {
		String str = "First Name  |  " + user.getFirstName() + "\n" 
					+"----------------------------------------" + "\n" 
					+"Last Name   |  " + user.getLastName() + "\n"
					+"----------------------------------------" + "\n" 
					+"Username    |  " + user.getUsername() + "\n"
					+"----------------------------------------" + "\n" 
					+"Age         |  " + user.getAge() + "\n"
					+"----------------------------------------" + "\n" 
					+"Email       |  " + user.getEmail() + "\n"
					+"----------------------------------------" + "\n" 
					+"Role        |  " + user.getType() + "\n"
					+"----------------------------------------" + "\n";
		return str;
	}
}
