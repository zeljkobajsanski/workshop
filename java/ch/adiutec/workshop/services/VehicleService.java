package ch.adiutec.workshop.services;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Connection;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import ch.adiutec.workshop.data.FuelTypesDao;
import ch.adiutec.workshop.data.MakersDao;
import ch.adiutec.workshop.data.VehiclesDao;
import ch.adiutec.workshop.entities.FuelType;
import ch.adiutec.workshop.entities.Maker;
import ch.adiutec.workshop.entities.Vehicle;
import ch.adiutec.workshop.messaging.SaveVehicle;

public class VehicleService {
	private MakersDao makersDao = new MakersDao();
	private VehiclesDao vehiclesDao = new VehiclesDao();
	private FuelTypesDao fuelTypesDao = new FuelTypesDao();
	private MessagingService messagingService = new MessagingService();

	public java.util.List<Maker> getMakers() throws Exception {
		try {
			return makersDao.getMakers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	public List<Vehicle> getVehicles() {
		return vehiclesDao.getVehicles();
	}
	
	public List<FuelType> getFuelTypes() {
		return fuelTypesDao.getFuelTypes();
	}

	public int saveVehicle(Vehicle vehicle) {
		int id = vehiclesDao.saveVehicle(vehicle);
		ArrayList<Vehicle> vehicles = vehiclesDao.getVehicles();
		try {
			messagingService.sendMessage(new SaveVehicle(vehicles, vehicle));
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return id;
		}
	}
}
