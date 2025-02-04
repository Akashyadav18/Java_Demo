package in.sp.main.repository;

import org.hibernate.Session;

import in.sp.main.config.HibernateConfig;
import in.sp.main.entities.User;

public class DBOperationsImpl implements DBOperations {

	@Override
	public User getUserDetails(Long id) {
		User user = null;
		try(Session session = HibernateConfig.getSessionFactory().openSession())
		{
			user = session.get(User.class, 1L);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
