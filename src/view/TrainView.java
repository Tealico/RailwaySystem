package view;

import java.util.ArrayList;
import java.util.Scanner;

import exception.CustomException;
import model.Train;
import service.TrainService;

public class TrainView {
	private TrainService trainService=new TrainService();
	private AdminView home;
	
	public TrainView(AdminView home) {
		this.home=home;
	}
	
	public void trainMenu() {
		Scanner in=new Scanner(System.in);
		System.out.println("Train");
		System.out.println("-------------------");
		System.out.println("1 | List Train");
		System.out.println("-------------------");
		System.out.println("2 | Add Train");
		System.out.println("-------------------");
		System.out.println("3 | Home");
		System.out.println("-------------------");
		System.out.print("Put the number: ");
		int number = in.nextInt();
		if(number == 1) {
			this.trainList();
		}
		else if(number == 2) {
			this.addTrain();
		}
		else if(number == 3) {
			home.adminMenu();
		}
	}
		public void trainList() {
			Scanner in=new Scanner(System.in);
			System.out.println("List Train");	
			System.out.println("----------------------------------------------");
			System.out.println("ID | Available | Description | Headcode ");
			System.out.println("----------------------------------------------");
			ArrayList<Train> trains = trainService.getAll();
			
			for(Train t:trains) {
				System.out.println(t.getId() + "   |   " + t.getAvailable() + "    |    " + t.getDescription() + "    |    " + t.getHeadcode());
			}
			System.out.println("0   |   Home");
			System.out.print("Put the number: ");
			int number = in.nextInt();
			if(number == 0) {
				home.adminMenu();
			}
			else {
				this.trainDetails(number);
			}
		}
		public void trainDetails(int trainId) {
			try {
				Scanner in=new Scanner(System.in);
				Train train = trainService.getTrainById(trainId);
				System.out.println(this.buildView(train));
				System.out.println("Train Details");
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
					this.updateTrain(train);
				}
				else if(number == 2) {
					trainService.deleteTrain(train.getId());
					this.trainList();
				}
				else if(number == 3) {
					home.adminMenu();
				}
			}catch(CustomException c) {
				System.out.println(c.getMessage());
				this.trainList();
			}
		}
		private String buildView(Train train) {
			String str = "ID            |  " + train.getId()                 + "\n"
					   + "------------------------------------------"        + "\n" 
					   + "Available     |  " + train.getAvailable()          + "\n" 
					   + "------------------------------------------"  		 + "\n" 
					   + "Description   |  " + train.getDescription()        + "\n"
					   +"-------------------------------------------"        + "\n"
					   + "Headcode      |  " + train.getHeadcode()           + "\n"
					   +"-------------------------------------------"        + "\n"
					   + "Wagon NO.     |  " + train.getWagons().size()      + "\n"
					   +"-------------------------------------------"        + "\n";
			return str;
		}
		public void updateTrain(Train train) {
			Scanner in=new Scanner(System.in);
			if(train.getAvailable()) {
				System.out.print("Make unavailable?[y/n]: ");
				String answer = in.next();
				if(answer.equalsIgnoreCase("y")) {
					train.setAvailable(false);
				}else {
					train.setAvailable(true);
				}
			}else {
				System.out.print("Make available?[y/n]: ");
				String answer = in.next();
				if(answer.equalsIgnoreCase("y")) {
					train.setAvailable(true);
				}else {
					train.setAvailable(false);
				}
			}
			System.out.print("Do you want to change desciption? [y/n]: ");
			String answer = in.next();
			if(answer.equalsIgnoreCase("y")) {
				System.out.print("Put new description: ");
				in.nextLine();
				String description = in.nextLine();
				train.setDescription(description);		
			}
			trainService.updateTrain(train);
			this.trainList();
		}
		public void addTrain() {
			Scanner in=new Scanner(System.in);
			System.out.println("Put the train headcode: ");
			String headcode =in.nextLine();
			System.out.println("Put the train description: ");
			String description =in.nextLine();
			System.out.print("Is available? [y/n]: ");
			String answer=in.next();
			boolean available;
			if(answer.equalsIgnoreCase("y")) {
				available=true;
			}else {
				available=false;
			}
			Train train = new Train();
			train.setHeadcode(headcode);
			train.setDescription(description);
			train.setAvailable(available);
			trainService.addTrain(train);
			this.trainList();
		}
}
