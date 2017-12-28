package com.psl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.psl.model.Address;
import com.psl.model.PrimaryKeyClass;
import com.psl.model.User;

public class MainClass {

	public static void main(String[] args) {

		/*SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		User user = new User();
		PrimaryKeyClass primarykey =new PrimaryKeyClass();
		primarykey.setId(1);
		primarykey.setUsername("username");
		//user.setPrimarykey(primarykey);
		user.setFirstName("Sgaar");
		user.setLastName("HIngaspure");
		user.setPassword("sagar");
		//user.setUserName("ssh");
		Address address=new Address();
		
		address.setStreet("Street name");
		address.setCity("City name");
		
		user.setHomeAddress(address);
		
		User user2 = new User();
		user2.setFirstName("Sgaar");
		user2.setLastName("HIngaspure");
		user2.setPassword("sagar");
		//user2.setUserName("ssh");
		Transaction t = session.beginTransaction();
		session.save(user);
		PrimaryKeyClass primaryKeyClass = new PrimaryKeyClass();
		primaryKeyClass.setId(0);
		primaryKeyClass.setUsername("qwe");
		
		session.save(user2);
		user.setPassword("12345");
		
		user.setFirstName("ssss");
		user.setPassword("44444");
		t.commit();
		session.close();*/
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		User user = new User();
	
		user.setFirstName("Sgaar");
		user.setLastName("HIngaspure");
		user.setPassword("sagar");
		user.setUserName("ssh");
		
		Address address=new Address();
		address.setStreet("Street name");
		address.setCity("City name");
		
		Address address2=new Address();
		address2.setStreet("Street name 2");
		address2.setCity("City name 2");
		
		user.getAddresses().add(address);
		user.getAddresses().add(address2);
		
		//user2.setUserName("ssh");
		Transaction t = session.beginTransaction();
		session.save(user);
		t.commit();
		session.close();
		
	}

}
