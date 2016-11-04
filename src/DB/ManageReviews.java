package DB;

import helpers.HelperManageReviews;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;

import json.Business;
import json.Category;
import json.Review;
import liuyang.nlp.lda.main.LdaModel;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Engine.WordTopic;

import com.mysql.jdbc.Statement;

public class ManageReviews {

	public static void saveReviews(ArrayList<Review> reviews) {
		HelperManageReviews.saveReviews(reviews);
	}

	public static void saveBusinesses(ArrayList<Business> businesses) {
		HelperManageReviews.saveBusinesses(businesses);
	}

	public static ArrayList<Business> readBusinesses() {
		return HelperManageReviews.readBusinesses();
	}

	public static ArrayList<String> readCategories() {
		return HelperManageReviews.getDistinctCategories();
	}

	public static ArrayList<Review> getReviewsByCategoryAndLocation(
			String category, double lng, double lat, boolean considerLocation) {
		return HelperManageReviews.getReviewsByCategoryAndLocation(category,
				lng, lat, considerLocation);
	}
	
	public static ArrayList rankBusinesses(WordTopic wordTopic, LdaModel model,
			ArrayList<Review> reviews) {
		return HelperManageReviews.rankBusinesses(wordTopic, model, reviews);
	}

}
