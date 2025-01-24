package in.sp.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.sp.entities.User;

public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration();
        cfg.configure("/in/sp/config/hibernate.cfg.xml");
        
        //SessionFactory create and manage Session Objects; it is heavy weight, thread-safe Object used to configure Hibernate and handle Connections
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        //Session manages DB operations like CRUD and querying; it is lightweight short-lived object used for interacting with the DB
        Session session = sessionFactory.openSession();
        //Transaction controls the boundaries of a DB transaction; it is used to begin, commit, or roll back changes to ensure integrity
        Transaction transaction = session.beginTransaction();
        
        //Insert
//        User user1 = new User();
//        user1.setName("pqr");
//        user1.setEmail("pqr@gmail.com");
//        user1.setPassword("123456");
//        user1.setGender("other");
//        user1.setCity("Diva"); 
//        try {
//			session.save(user1);
//			transaction.commit();
//			System.out.println("Insert Successful");
//		} catch (Exception e) {
//			transaction.rollback();
//			e.printStackTrace();
//			System.out.println("Insert Fail");
//		}
        
        //Select
//        try {
//			User user = session.get(User.class, 1L);
//			System.out.println(user.getId());
//			System.out.println(user.getName());
//			System.out.println(user.getEmail());
//			System.out.println(user.getPassword());
//			System.out.println(user.getGender());
//			System.out.println(user.getCity());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
        
        //Update
//        try {
//        	User user = session.get(User.class, 3L);
//        	user.setCity("Banglore");
//			session.saveOrUpdate(user);
//			transaction.commit();
//			System.out.println("Updated Successful");
//		} catch (Exception e) {
//			transaction.rollback();
//			e.printStackTrace();
//			System.out.println("Update Fail");
//		}
        
        //delete
        try {
        	
        	User user = new User();
        	user.setId(2L);
        	
			session.delete(user);
			transaction.commit();
			System.out.println("Delete Successful");
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			System.out.println("Delete Fail");
		}
    }
}
