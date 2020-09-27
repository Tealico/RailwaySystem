package service;

import java.util.ArrayList;

import model.Seat;
import model.Wagon;
import repository.SeatRepository;
import repository.WagonRepository;

public class WagonService {
	WagonRepository wagonRepository = new WagonRepository();
	SeatRepository seatRepository=new SeatRepository();
	
	public ArrayList<Wagon> getAllWagons(){
		ArrayList<Wagon> wagons=wagonRepository.getAllWagons();
		return wagons;
	}
	
	public Wagon getWagonById(int wagonId) {
		Wagon wagon= wagonRepository.getWagonById(wagonId);
		return wagon;
	}
	public void deleteWagon(int wagonId) {
		wagonRepository.deleteWagon(wagonId);
	}
	public Wagon updateWagon(Wagon wagon) {
		wagon=wagonRepository.updateWagon(wagon);
		return wagon;
	}
	public void addWagon(Wagon wagon,int trainId,int row,int column) {
		int wagonId=wagonRepository.addWagon(wagon, trainId);
		for (int i=1;i <= row;i++) {
			for(int j=1;j <= column;j++) {
				Seat seat=new Seat();
				seat.setRow(i);
				seat.setColumn(j);
				seat.setAvailable(true);
				seatRepository.addSeat(seat, wagonId);
			}
		}
	}
}

