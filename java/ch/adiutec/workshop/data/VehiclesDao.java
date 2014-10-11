package ch.adiutec.workshop.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch.adiutec.workshop.entities.Vehicle;

public class VehiclesDao {
	public ArrayList<Vehicle> getVehicles() {
		SessionFactory sf = HibernateSessionFactory.Singleton().getSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>(session.createQuery("from Vehicle").list());
			tr.commit();
			return vehicles;
		} catch (Exception e) {
			tr.rollback();
			return new ArrayList<Vehicle>();
		} 
	}
	
	public int saveVehicle(Vehicle vehicle) {
		SessionFactory sf = HibernateSessionFactory.Singleton().getSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			if (vehicle.getId() == 0) {
				session.persist(vehicle);
			} else {
				session.merge(vehicle);
			}
			tr.commit();
			return vehicle.getId();
		} catch (Exception e) {
			tr.rollback();
			return 0;
		}
	}

	public Vehicle getVehicle(int id) {
		SessionFactory sf = HibernateSessionFactory.Singleton().getSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			Vehicle vehicle = (Vehicle) session.createQuery("from Vehicle V where V.id=" + id).list().get(0);
			tr.commit();
			return vehicle;
		} catch (Exception e) {
			tr.rollback();
			return null;
		} 
	}
}
