package service;

import java.util.ArrayList;

import model.Train;
import model.Wagon;
import repository.TrainRepository;
import repository.WagonRepository;


public class TrainService {
	private TrainRepository trainRepository = new TrainRepository();
	private WagonRepository wagonRepository = new WagonRepository();
	
	public ArrayList<Train> getAll(){
		ArrayList<Train> train=trainRepository.getAll();
		return train;
	}
	public Train getTrainById(int trainId) {
		Train train= trainRepository.getTrainById(trainId);
		ArrayList<Wagon> wagons=wagonRepository.getAllWagonsByTrainId(trainId);
		train.setWagons(wagons);
		return train;
	}
	
	public void deleteTrain(int trainId){
		trainRepository.deleteTrain(trainId);
	}
	public Train updateTrain(Train train) {
		Train newTrain=trainRepository.updateTrain(train);
		return newTrain;
	}
	public void addTrain(Train train) {
		trainRepository.addTrain(train);
	}
}

