package ch.adiutec.workshop.data;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch.adiutec.workshop.entities.Maker;

public class MakersDao {
	public java.util.List<Maker> getMakers() {
		SessionFactory sf = HibernateSessionFactory.Singleton().getSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction tr = session.beginTransaction();
		ArrayList<Maker> makers;
		try {
			makers = new ArrayList<Maker>(session.createQuery("from Maker").list());
			tr.commit();
			return makers;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return new ArrayList<Maker>();
		}
	}

	public void save(Maker maker) {
		SessionFactory sf = HibernateSessionFactory.Singleton().getSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			session.persist(maker);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
	}
}
