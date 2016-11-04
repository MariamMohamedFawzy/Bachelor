package helpers;

import java.util.ArrayList;
import java.util.List;

import json.Business;
import json.Category;
import json.Review;
import liuyang.nlp.lda.main.LdaModel;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import Engine.WordTopic;

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
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				Criteria c = session.createCriteria(Category.class);
				c.setProjection(Projections.distinct(Projections
						.property("name")));
				c.addOrder(Order.asc("name"));

				List<String> listCategories = c.list();

				tx.commit();

				for (String categoryName : listCategories) {
					if (!categoryName.equalsIgnoreCase("")) {
						categories.add(categoryName);
					}
				}
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		return categories;
	}

	public static ArrayList<Business> readBusinesses() {
		ArrayList<Business> businesses = new ArrayList<Business>();

		SessionFactory factory = getSessionFactory();
		if (factory != null) {
			Session session = factory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				String hql = "FROM json.Business";
				Query query = session.createQuery(hql);
				List results = query.list();
				businesses = (ArrayList<Business>) results;
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		return businesses;
	}

	public static ArrayList<Review> getReviewsByCategoryAndLocation(
			String category, double lng, double lat, boolean considerLocation) {
		ArrayList<Review> result = new ArrayList<Review>();
		SessionFactory factory = getSessionFactory();
		if (factory != null) {
			Session session = factory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				String hql = "SELECT businessId FROM json.Category WHERE name = :category_name";

				Query query = session.createQuery(hql);
				query.setParameter("category_name", category);
				List<Integer> businessIds = query.list();
				System.out.println("size = " + businessIds.size());

				tx.commit();

				String hql2 = "";
				if (considerLocation) {
					hql2 = "SELECT businessId From json.Business b WHERE longitude = :lng AND latitude = :lat AND id IN :list_ids";
				} else {
					hql2 = "SELECT businessId From json.Business b WHERE id IN :list_ids";
				}
				tx = session.beginTransaction();
				Query query2 = session.createQuery(hql2);
				query2.setParameterList("list_ids", businessIds);
				if (considerLocation) {
					query2.setParameter("lng", lng);
					query2.setParameter("lat", lat);
				}
				List<String> businessIdsStr = query2.list();

				tx.commit();

				tx = session.beginTransaction();

				String hql3 = "From json.Review WHERE stars = 5 AND businessId IN :list_ids";
				Query query3 = session.createQuery(hql3);
				query3.setParameterList("list_ids", businessIdsStr);
				List<Review> reviews = query3.list();
				tx.commit();

				result = (ArrayList<Review>) reviews;

			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		return result;
	}

	public static ArrayList  rankBusinesses(WordTopic wordTopic, LdaModel model,
			ArrayList<Review> reviews) {
		
		ArrayList result = new ArrayList();
		
		ArrayList<Business> businesses = new ArrayList<Business>();
		
		SessionFactory factory = getSessionFactory();
		if (factory != null) {
			Session session = factory.openSession();
			Transaction tx = null;
			try {
				double[][] theta = model.theta;
				int topicNum = wordTopic.getTopicNum();
				ArrayList<Integer> docsIndex = new ArrayList<Integer>();
				
				for (int i = 0; i < model.z.length; i++) {
					for (int j = 0; j < model.z[i].length; j++) {
						if (model.z[i][j] == topicNum) {
							docsIndex.add(i);
							break;
						}
					}
				}
				
				ArrayList<String> reviewIds = new ArrayList<String>();
				
				for (Review review : reviews) {
					reviewIds.add(review.getReviewId());
				}
				
				tx = session.beginTransaction();
				for (int i = 0; i < docsIndex.size(); i++) {
					String hql = "UPDATE json.Review set topicValue = :topicValue "
							+ "WHERE reviewId = :reviewId";
					Query query = session.createQuery(hql);
					query.setParameter("topicValue", theta[docsIndex.get(i)][topicNum]);
					query.setParameter("reviewId", reviews.get(i).getReviewId());
					query.executeUpdate();
				}
				tx.commit();
				tx = session.beginTransaction();
				String hql2 = "SELECT SUM(R.topicValue) AS sumTopics, R.businessId, B.name FROM json.Review R "
						+  "INNER JOIN json.Business as B "                                                                                     
						+ "ON B.businessId = R.businessId " 
						+ "WHERE R.reviewId IN :listReviewIds "
						+ "GROUP BY R.businessId , B.name ORDER BY sumTopics DESC";
				Query query2 = session.createQuery(hql2);
				query2.setParameterList("listReviewIds", reviewIds);
				List<Object[]> results = query2.list();
				tx.commit();

				result = (ArrayList) results;
				
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		
		return result;

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
