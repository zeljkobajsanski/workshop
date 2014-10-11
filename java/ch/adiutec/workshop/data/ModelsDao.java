package ch.adiutec.workshop.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch.adiutec.workshop.entities.Maker;
import ch.adiutec.workshop.entities.Model;

public class ModelsDao {
	public List<Model> getAllModel() {
		SessionFactory sf = HibernateSessionFactory.Singleton().getSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction tr = session.beginTransaction();
		ArrayList<Model> models;
		try {
			models = new ArrayList<Model>(session.createQuery("from Model").list());
			tr.commit();
			return models;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return new ArrayList<Model>();
		}
	}

	public void save(Model model) {
		SessionFactory sf = HibernateSessionFactory.Singleton().getSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			session.persist(model);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
	}
}
