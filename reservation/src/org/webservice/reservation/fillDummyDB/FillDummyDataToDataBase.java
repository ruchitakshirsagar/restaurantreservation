package org.webservice.reservation.fillDummyDB;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.webservice.reservation.model.Menu;
import org.webservice.reservation.model.Message;
import org.webservice.reservation.model.Owner;
import org.webservice.reservation.model.Reservation;
import org.webservice.reservation.model.ResourceInformation;

public class FillDummyDataToDataBase implements ServletContextListener{

	public static SessionFactory globalHibernateSessionFactory; 

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// do nothing... 				
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		// Create 'session factory' using 'hibernate.cfg.xml' file. 
		// Create it ONLY once for an application. Necessary dependencies are specified in pom.xml file... 
		Configuration config = new Configuration().configure("/hibernate.cfg.xml");
		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(config.getProperties());
        ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
        FillDummyDataToDataBase.globalHibernateSessionFactory = config.buildSessionFactory(serviceRegistry);
        		
        /*
         * Load dummy data to the Database created above. This will help us to navigate through various 
         * functionalities of our application. 
         */
        loadDummyDataBase();
        
        
	}

	// Fill Menus, Reservations, OwnerLogin, Messages
	private void loadDummyDataBase(){
		
		// Create Menu
		Menu m1 = new Menu();
		List<String> descriptions = new ArrayList<String>();
		descriptions.add("Vegetable Samosa | Fried thin crisp pastry stuffed with spiced potaotes,grean peas,onion,ginger,garlic.");
		descriptions.add("Chilli Paneer | Cubes of homemade cottage cheese sauteed with garlic and chef's special sauce.");
		descriptions.add("Mix Veg Pakoda | Onion,potatoes,cauliflower seasoned with spices then dipped in chickpea batter and fried.");
		m1.setMenuCategory("Vegetarian Appetizers");
		m1.setDescriptions(descriptions);

		Menu m2 = new Menu();
		List<String> descriptions1 = new ArrayList<String>();
		descriptions1.add("Lamb Keema Samosa | Fried crisp pastry filled with minced meat and fresh spices.");
		descriptions1.add("Egg Spring Roll | Crispy rolls stuffed with shredded spring vegetables,eggs and deep fried.");
		descriptions1.add("Chicken - 65 | Boneless chicken cubes marinated in a spicy chef's special sauce and deep fried.");
		m2.setMenuCategory("Non Vegetarian Appetizers");
		m2.setDescriptions(descriptions1);
		
		Menu m3 = new Menu();
		List<String> descriptions3 = new ArrayList<String>();
		descriptions3.add("Paneer Tikka Masala | Diced homemade cottage cheese cooked with tomato & almond cream sauce.");
		descriptions3.add("Shai Paneer | Fresh homemade grated cheese cooked in a tomato based almond cream sauce with fresh green peas.");
		descriptions3.add("Palak Paneer | Homemade cottage cheese cooked in a mild, ground spinach gravy with fresh herbs.");
		m3.setMenuCategory("Vegetarian Entree");
		m3.setDescriptions(descriptions3);
		
		Menu m4 = new Menu();
		List<String> descriptions4 = new ArrayList<String>();
		descriptions4.add("Chicken Tikka Masala | Marinated chicken breast grilled in charcoal clay oven and cooked with tomato creamy sauce.");
		descriptions4.add("Chicken Makhani | Boneless chicken cooked in tomato based almond gravy and fresh spices.");
		descriptions4.add("Chicken Saag  | Boneless chicken cooked i ground spinach and fresh spices with chef's special sauce.");
		m4.setMenuCategory("Non Vegetarian Entree");
		m4.setDescriptions(descriptions4);
		 
		// Create Owner Login Id's
		Owner o1 = new Owner();
		o1.setEmail("john@gmail.com");
		o1.setPassword("JOHN123");
		
		Owner o2 = new Owner();
		o2.setEmail("mike@gmail.com");
		o2.setPassword("MIKE123");
		
		Owner o3 = new Owner();
		o3.setEmail("jack@gmail.com");
		o3.setPassword("JACK123");
		
		// Create Messages
		Message msg1 = new Message();	// Message id is auto increment.  
		msg1.setEmail("john@gmail.com");
		msg1.setMessage("Your reservation has been confirmed. Please note your reservation is valid only for 30min from reservation time.");
		Message msg2 = new Message();
		msg2.setEmail("john@gmail.com");
		msg2.setMessage("Sorry! We had to cancel the reservation. We will not take an reservaions till end of this week.");
		
		Message msg3 = new Message();
		msg3.setEmail("mike@gmail.com");
		msg3.setMessage("Your reservation has been confirmed. Please note your reservation is valid only for 30min from reservation time.");
		Message msg4 = new Message();
		msg4.setEmail("mike@gmail.com");
		msg4.setMessage("Alert! your reservation is vaild only for 20 min from now.");
		
		Message msg5 = new Message();
		msg5.setEmail("jack@gmail.com");
		msg5.setMessage("Your reservation has been confirmed. Please note your reservation is valid only for 30min from reservation time.");
		Message msg6 = new Message();
		msg6.setEmail("jack@gmail.com");
		msg6.setMessage("As requested your reservation has been cancled and the order will be delivered to mentioned address.");
		
		// Create dummy reservations
		Reservation r1 = new Reservation();	// reservation id is auto increment
		r1.setDate(new Date());	// Date format: Sun Jul 05 14:59:02 PDT 2015
		r1.setEmail("john@gmail.com");
		r1.setFirstName("John");
		r1.setLastName("Bosh");
		r1.setOwner(true);
		r1.setPartySize(8);
		r1.setPhone("9001235555");
		r1.setTable("A2");
		r1.setTime(String.valueOf(System.currentTimeMillis()));	// Time: 1436133542321
		
		Reservation r4 = new Reservation();	// reservation id is auto increment
		r4.setDate(new Date());	// Date format: Sun Jul 05 14:59:02 PDT 2015
		r4.setEmail("chris@hotmail.com");
		r4.setFirstName("Chris");
		r4.setLastName("D");
		r4.setOwner(false);
		r4.setPartySize(5);
		r4.setPhone("9002342342");
		r4.setTable("E2");
		r4.setTime(String.valueOf(System.currentTimeMillis()));	// Time: 1436133542321
		
		Reservation r5 = new Reservation();	// reservation id is auto increment
		r5.setDate(new Date());	// Date format: Sun Jul 05 14:59:02 PDT 2015
		r5.setEmail("dan@yahoo.com");
		r5.setFirstName("Dan");
		r5.setLastName("Bosh");
		r5.setOwner(false);
		r5.setPartySize(2);
		r5.setPhone("3546782190");
		r5.setTable("J3");
		r5.setTime(String.valueOf(System.currentTimeMillis()));	// Time: 1436133542321
	
		Reservation r6 = new Reservation();	// reservation id is auto increment
		r6.setDate(new Date());	// Date format: Sun Jul 05 14:59:02 PDT 2015
		r6.setEmail("alia@gmail.com");
		r6.setFirstName("Alia");
		r6.setLastName("Denum");
		r6.setOwner(false);
		r6.setPartySize(9);
		r6.setPhone("8751236567");
		r6.setTable("B1");
		r6.setTime(String.valueOf(System.currentTimeMillis()));	// Time: 1436133542321
		
		Reservation r7 = new Reservation();	// reservation id is auto increment
		r7.setDate(new Date());	// Date format: Sun Jul 05 14:59:02 PDT 2015
		r7.setEmail("ganam@hotmail.com");
		r7.setFirstName("Ganam");
		r7.setLastName("G");
		r7.setOwner(false);
		r7.setPartySize(3);
		r7.setPhone("5435672139");
		r7.setTable("A2");
		r7.setTime(String.valueOf(System.currentTimeMillis()));	// Time: 1436133542321
		
		ResourceInformation resInfo1 = new ResourceInformation();
		resInfo1.setImageLink("http://localhost:8080/reservation/ImageResource/dish1.jpg");
		ResourceInformation resInfo2 = new ResourceInformation();
		resInfo2.setImageLink("http://localhost:8080/reservation/ImageResource/dish2.jpg");
		ResourceInformation resInfo3 = new ResourceInformation();
		resInfo3.setImageLink("http://localhost:8080/reservation/ImageResource/dish3.jpg");
		ResourceInformation resInfo4 = new ResourceInformation();
		resInfo4.setImageLink("http://localhost:8080/reservation/ImageResource/dish4.jpg");
		ResourceInformation resInfo5 = new ResourceInformation();
		resInfo5.setImageLink("http://localhost:8080/reservation/ImageResource/dish5.jpg");
		ResourceInformation resInfo6 = new ResourceInformation();
		resInfo6.setImageLink("http://localhost:8080/reservation/ImageResource/dish6.jpg");
		ResourceInformation resInfo7 = new ResourceInformation();
		resInfo7.setImageLink("http://localhost:8080/reservation/ImageResource/dish7.jpg");
		ResourceInformation resInfo8 = new ResourceInformation();
		resInfo8.setImageLink("http://localhost:8080/reservation/ImageResource/dish8.jpg");
		
		
		
		// save the details to Database
		Session session = FillDummyDataToDataBase.globalHibernateSessionFactory.openSession();
		// First begin a 'transaction', it can be used to save multiple objects.  
		session.beginTransaction();
				
		// save 'MULTIPLE' object to Database. 
		session.save(m1);
		session.save(m2);
		session.save(m3);
		session.save(m4);
		
		session.save(o1);
		session.save(o2);
		session.save(o3);
		
		session.save(msg1);
		session.save(msg2);
		session.save(msg3);
		session.save(msg4);
		session.save(msg5);
		session.save(msg6);
		
		session.save(r1);
		session.save(r4);
		session.save(r5);
		session.save(r6);
		session.save(r7);
				
		session.save(resInfo1);
		session.save(resInfo2);
		session.save(resInfo3);
		session.save(resInfo4);
		session.save(resInfo5);
		session.save(resInfo6);
		session.save(resInfo7);
		session.save(resInfo8);
		
		// close 'transaction'.  
		session.getTransaction().commit();
		session.close();
		
	}
	
	
}



