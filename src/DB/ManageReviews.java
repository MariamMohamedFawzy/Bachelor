package DB;

import java.util.ArrayList;

import json.Business;
import json.Review;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;

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
			for (Review review : reviews) {
				session.save(review);
				session.flush();
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
			int counter = 0;
			// Gson gson = new Gson();
			for (int i = 0; i < businesses.size(); i++) {
				Business business = businesses.get(i);
				// System.out.println(gson.toJson(business));
				// System.out.println(counter);
				// business.setId(counter);
				session.save(business);
				// session.flush();
				if (counter % 20 == 0) {
					session.flush();
					session.clear();
				}
				counter++;
			}
			System.out.println("all");
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
