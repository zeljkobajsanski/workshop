package ch.adiutec.workshop.messaging;

import java.io.Serializable;
import java.util.ArrayList;

import ch.adiutec.workshop.entities.Vehicle;

public class SaveVehicle implements Serializable {
	private static final long serialVersionUID = 1259707458582306522L;
	private ArrayList<Vehicle> vehicles;
	private Vehicle vehicle;
	
	public SaveVehicle(ArrayList<Vehicle> vehicles, Vehicle vehicle) {
		super();
		this.vehicles = vehicles;
		this.vehicle = vehicle;
	}
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
