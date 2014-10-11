package ch.adiutec.workshop.data;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateSessionFactory {
	private static HibernateSessionFactory instance;
	
	private SessionFactory sessionFactory;
	
	private HibernateSessionFactory() {
		sessionFactory = new AnnotationConfiguration()
		.configure().buildSessionFactory();
	}
	
	public static HibernateSessionFactory Singleton() {
		if (instance == null) {
			instance = new HibernateSessionFactory();
		}
		return instance;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
