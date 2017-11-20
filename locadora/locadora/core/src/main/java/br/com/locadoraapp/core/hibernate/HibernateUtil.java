package br.com.locadoraapp.core.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		
		final StandardServiceRegistry registry = 
				new StandardServiceRegistryBuilder().configure().build();
		
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		
		return sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
