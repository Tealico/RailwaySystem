package view;

import java.util.ArrayList;
import java.util.Scanner;

import exception.CustomException;
import model.Train;
import model.Wagon;
import service.TrainService;
import service.WagonService;



public class WagonView {
	private WagonService wagonService=new WagonService();
	private TrainService trainService=new TrainService();

	private AdminView home;
	
	public WagonView(AdminView home) {
		this.home=home;
	}
	public void wagonMenu() {
		Scanner in=new Scanner(System.in);
		System.out.println("Wagon");
		System.out.println("-------------------");
		System.out.println("1 | List Wagon");
		System.out.println("-------------------");
		System.out.println("2 | Add Wagon");
		System.out.println("-------------------");
		System.out.println("3 | Home");
		System.out.println("-------------------");
		System.out.print("Put the number: ");
		int number = in.nextInt();
		if( number == 1) {
			this.listWagons();
		}
		else if(number == 2) {
			this.addWagon();
		}
		else if(number == 3) {
			home.adminMenu();
		}
	}
	public void listWagons() {
		Scanner in=new Scanner(System.in);
		System.out.println("List wagons");	
		System.out.println("----------------------------------------------");
		System.out.println("ID   |   Number   |   Description ");
		System.out.println("----------------------------------------------");
		ArrayList<Wagon> wagons = wagonService.getAllWagons();
		
		for(Wagon w:wagons) {
			System.out.println(w.getId() + "   |   " + w.getNumber() +"   |   "+ w.getDescription());
		}
		
		System.out.println("0   |   Home");
		System.out.print("Put the number: ");
		int number = in.nextInt();
		if(number == 0) {
			home.adminMenu();
		}
		else {
			this.wagonDetails(number);
		}
	}
	
	public void wagonDetails(int wagonId) {
		try {
			Scanner in=new Scanner(System.in);
			Wagon wagon = wagonService.getWagonById(wagonId);
			System.out.println(this.buildView(wagon));
			System.out.println("Wagon Details");
			System.out.println("-------------------");
			System.out.println("1 | Update");
			System.out.println("-------------------");
			System.out.println("2 | Delete");
			System.out.println("-------------------");
			System.out.println("3 | Home");
			System.out.println("-------------------");
			System.out.println("Put the number: ");
			int number=in.nextInt();
			if(number == 1) {
				this.updateWagon(wagon);
			}
			else if(number == 2) {
				wagonService.deleteWagon(wagon.getId());
				this.listWagons();
			}
			else if(number == 3) {
				home.adminMenu();
			}
		}catch(CustomException c) {
			System.out.println(c.getMessage());
			this.listWagons();
		}
	}
		
	private String buildView(Wagon wagon) {
		String str = "ID            |  " + wagon.getId()                 + "\n"
				   + "------------------------------------------"        + "\n" 
				   + "Number        |  " + wagon.getNumber()             + "\n" 
				   + "------------------------------------------"  		 + "\n" 
				   + "Description   |  " + wagon.getDescription()        + "\n"
				   +"-------------------------------------------"        + "\n";
		return str;
	}
	public void updateWagon(Wagon wagon) {
		Scanner in=new Scanner(System.in);
		System.out.print("Do you want to change wagon number? [y/n]: ");
		String answer1 = in.next();
		if(answer1.equalsIgnoreCase("y")) {
			System.out.print("Put new number: ");
			in.nextLine();
			int number = in.nextInt();
			wagon.setNumber(number);		
		}
		System.out.print("Do you want to change description? [y/n]: ");
		String answer2 = in.next();
		if(answer2.equalsIgnoreCase("y")) {
			System.out.print("Put new description: ");
			in.nextLine();
			String description = in.nextLine();
			wagon.setDescription(description);		
		}
		wagonService.updateWagon(wagon);
		this.listWagons();
	}

	public void addWagon() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Put the wagon number: ");
		int number =in.nextInt();
		System.out.println("Put the wagon description: ");
		in.nextLine();
		String description =in.nextLine();
		ArrayList<Train> trains = trainService.getAll();
		System.out.println("ID   |   Headcode ");
		System.out.println("----------------------------------------------");
		for(Train t:trains) {
			System.out.println(t.getId() + "   |   " + t.getHeadcode());
		}
		System.out.println("Select the train from the list: ");
		int trainId=in.nextInt();
		System.out.println("Put the number of seat rows: ");
		int row = in.nextInt();
		System.out.println("Put the number of seat columns: ");
		int column=in.nextInt();
		Wagon wagon = new Wagon();
		wagon.setNumber(number);
		wagon.setDescription(description);
		wagonService.addWagon(wagon,trainId,row,column);
		this.listWagons();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
