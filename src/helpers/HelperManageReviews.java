package helpers;

import java.util.ArrayList;
import java.util.List;

import json.Business;
import json.Category;
import json.Review;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

public class HelperManageReviews {

	public static void saveReviews(ArrayList<Review> reviews) {
		SessionFactory factory = getSessionFactory();
		if (factory != null) {
			Session session = factory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				int counterReviews = 1;
				for (Review review : reviews) {
					review.setId(counterReviews);
					session.save(review);
					counterReviews++;
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
	}

	public static void saveBusinesses(ArrayList<Business> businesses) {
		SessionFactory factory = getSessionFactory();
		if (factory != null) {
			Session session = factory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				int counterBusinesses = 1;
				int counterCategories = 1;
				for (int i = 0; i < businesses.size(); i++) {
					Business business = businesses.get(i);
					business.setId(counterBusinesses);
					session.save(business);
					for (Category category : business.getListCategories()) {
						category.setId(counterCategories);
						category.setBusinessId(counterBusinesses);
						session.save(category);
						counterCategories++;
					}
					counterBusinesses++;
				}
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					try {
						tx.rollback();
					} catch (IllegalStateException e1) {
						e1.printStackTrace();
					}
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
	}

	public static ArrayList<String> getDistinctCategories() {
		ArrayList<String> categories = new ArrayList<String>();

		SessionFactory factory = getSessionFactory();
		if (factory != null) {
			Session session = factory.openSession();
			Criteria c = session.createCriteria(Category.class);
			c.setProjection(Projections.distinct(Projections.property("name")));
			c.addOrder(Order.asc("name"));

			List<String> listCategories = c.list();

			for (String categoryName : listCategories) {
				if (!categoryName.equalsIgnoreCase("")) {
					categories.add(categoryName);
				}
			}

		}
		return categories;
	}
	
	public static ArrayList<Business> readBusinesses() {
		ArrayList<Business> businesses = new ArrayList<Business>();

		SessionFactory factory = getSessionFactory();
		if (factory != null) {
			Session session = factory.openSession();
			String hql = "FROM business";
			Query query = session.createQuery(hql);
			List results = query.list();
			businesses = (ArrayList<Business>) results;
		}
		return businesses;
	}

	private static SessionFactory getSessionFactory() {
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return factory;
	}

}
