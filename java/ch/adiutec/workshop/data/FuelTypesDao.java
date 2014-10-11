package ch.adiutec.workshop.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch.adiutec.workshop.entities.FuelType;

public class FuelTypesDao {

	public List<FuelType> getFuelTypes() {
		SessionFactory sf = HibernateSessionFactory.Singleton().getSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction tr = session.beginTransaction();
		ArrayList<FuelType> fuelTypes;
		try {
			fuelTypes = new ArrayList<FuelType>(session.createQuery("from FuelType").list());
			tr.commit();
			return fuelTypes;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return new ArrayList<FuelType>();
		}
	}

	public void save(FuelType fuelType) {
		SessionFactory sf = HibernateSessionFactory.Singleton().getSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			session.persist(fuelType);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		
	}

}
