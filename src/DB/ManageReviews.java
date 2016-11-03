package DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;

import json.Business;
import json.Category;
import json.Review;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.jdbc.Statement;

public class ManageReviews {

	public static void saveReviews(ArrayList<Review> reviews) {
		SessionFactory factory;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			int counter = 1;
			for (Review review : reviews) {
				review.setId(counter);
				session.save(review);
				counter++;
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				try {
					tx.rollback();
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
	}


	public static void saveBusinesses(ArrayList<Business> businesses) {
		SessionFactory factory;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			int counter = 1;
			int counter2 = 1;
			for (int i = 0; i < businesses.size(); i++) {
				Business business = businesses.get(i);
				business.setId(counter);
				session.save(business);
				for (Category category : business.getListCategories()) {
					category.setId(counter2);
					category.setBusinessId(counter);
					session.save(category);
					counter2++;
				}

				counter++;
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				try {
					tx.rollback();
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// catch (Exception e) {
		// // TODO: handle exception
		// e.printStackTrace();
		// }
		finally {
			session.close();
		}
	}

}
