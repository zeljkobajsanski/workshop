package ch.adiutec.workshop.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Vehicles")
public class Vehicle implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "MAKER_ID")
	private Maker maker;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "MODEL_ID")
	private Model model;
	
	@Column(name = "PLATE", nullable = false)
	private String plate;
	
	@Column(name = "CHASIS")
	private String vehicleId;
	
	@Column(name = "ENGINE")
	private String engine;
	
	@Column(name = "COLOR")
	private String color;
	
	@Lob
	@Column(name = "IMAGE")
	private byte[] image;
	
	@Lob
	@Column(name = "DESCRIPTION")
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FUEL_TYPE")
	private FuelType fuelType;
	
	@Column(name = "POWER")
	private int power;
	
	@Column(name = "YEAR")
	private int year;
	
	@Column(name = "VOLUME")
	private int volume;
	
	@Column(name = "MASS")
	private int mass;
	
	@Column(name = "WEIGHT")
	private int weight;
	
	@Column(name = "PRICE", precision = 10, scale = 2)
	private double price;
	
	@Column(name = "ODOMETER")
	private int odometer;
	
	public Vehicle() {
		
	}
	
	public Vehicle(int id, Maker maker, Model model, String plate,
			String vehicleId, String engine, String color, byte[] image,
			String description, FuelType fuelType, int power, int year,
			int volume, int mass, int weight, double price, int odometer) {
		super();
		this.id = id;
		this.maker = maker;
		this.model = model;
		this.plate = plate;
		this.vehicleId = vehicleId;
		this.engine = engine;
		this.color = color;
		this.image = image;
		this.description = description;
		this.fuelType = fuelType;
		this.power = power;
		this.year = year;
		this.volume = volume;
		this.mass = mass;
		this.weight = weight;
		this.price = price;
		this.odometer = odometer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Maker getMaker() {
		return maker;
	}
	public void setMaker(Maker maker) {
		this.maker = maker;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public FuelType getFuelType() {
		return fuelType;
	}
	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public int getMass() {
		return mass;
	}
	public void setMass(int mass) {
		this.mass = mass;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getOdometer() {
		return odometer;
	}
	public void setOdometer(int odometer) {
		this.odometer = odometer;
	}
}
