package json;

import helpers.HelperManageReviews;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import nlp.NLP;
import DB.ManageReviews;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class JsonToJava {

	public static void start() {
		if (isTheFirstTime()) {
			saveBusinesses();
			saveReviews();
		}
	}

	public static ArrayList<Review> readReviews() {
		// long startTime = System.nanoTime();
		//
		// long stopTime = System.nanoTime();
		// System.out.println(stopTime - startTime);
		// 161856370659

		String goodReviewsSer = "/Users/apple/Documents/workspace/Bachelor Project/src/good_reviews";
		ArrayList<Review> goodReviews = new ArrayList<Review>();
		File f = new File(goodReviewsSer);
		if (f.exists() && !f.isDirectory()) {
			goodReviews = loadFile(goodReviewsSer);
		} else {

			String reviews5Star = "/Users/apple/Documents/workspace/Bachelor Project/src/stars_5_reviews";

			File f2 = new File(reviews5Star);
			if (f2.exists() && !f2.isDirectory()) {
				goodReviews = loadGoodReviews();
			} else {
				String reviewsSer = "/Users/apple/Documents/workspace/Bachelor Project/src/ser_reviews";
				File f3 = new File(reviewsSer);
				if (f3.exists() && !f3.isDirectory()) {
					ArrayList<Review> star_5_Reviews = load5StarReviews();
					goodReviews = loadGoodReviews();
				} else {
					loadSerReviews();
					load5StarReviews();
					goodReviews = loadGoodReviews();
				}
			}

		}
		return goodReviews;
	}

	private static ArrayList<Review> load5StarReviews() {
		String reviews5StarSer = "/Users/apple/Documents/workspace/Bachelor Project/src/stars_5_reviews";

		ArrayList<Review> reviews = loadFile("/Users/apple/Documents/workspace/Bachelor Project/src/ser_reviews");

		ArrayList<Review> star_5_Reviews = new ArrayList<Review>();

		if (reviews != null && reviews.size() > 0) {
			NLP.init();
			for (Review review : reviews) {
				if (review.getStars() == 5) {
					star_5_Reviews.add(review);
				}
			}
		}

		saveFile(star_5_Reviews, reviews5StarSer);
		return star_5_Reviews;

	}

	private static ArrayList<Review> loadSerReviews() {
		ArrayList<Review> reviews = new ArrayList<Review>();

		try {
			for (String line : Files
					.readAllLines(Paths
							.get("/Users/apple/Documents/workspace/Bachelor Project/src/reviews50000.json"))) {
				Gson gson = new GsonBuilder().create();
				Review review = gson.fromJson(line, Review.class);
				reviews.add(review);
			}
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ManageReviews.saveReviews(reviews);

		saveFile(reviews,
				"/Users/apple/Documents/workspace/Bachelor Project/src/ser_reviews");

		return reviews;
	}

	private static ArrayList<Review> loadGoodReviews() {
		String goodReviewsSer = "/Users/apple/Documents/workspace/Bachelor Project/src/good_reviews";
		ArrayList<Review> goodReviews = new ArrayList<Review>();
		String reviews5Star = "/Users/apple/Documents/workspace/Bachelor Project/src/stars_5_reviews";
		ArrayList<Review> star_5_Reviews = loadFile(reviews5Star);
		HashMap<String, Integer> lookup = new HashMap<String, Integer>();
		NLP.init();
		for (Review review : star_5_Reviews) {
			String[] strs = review.getText().split(" ");
			for (int i = 0; i < strs.length; i++) {
				int sentiment;
				if (lookup.containsKey(strs[i])) {
					sentiment = lookup.get(strs[i]);
				} else {
					sentiment = NLP.findSentiment(strs[i]);
					lookup.put(strs[i], sentiment);
				}
				if (sentiment < 2) {
					strs[i] = strs[i] + " " + "BADREVIEW";
				} else if (sentiment > 2) {
					strs[i] = strs[i] + " " + "GOODREVIEW";
				}
			}
			String txt = String.join(" ", strs);
			review.setText(txt);
			goodReviews.add(review);
		}
		saveFile(goodReviews, goodReviewsSer);
		return goodReviews;
	}

	public static ArrayList<Business> readBusinesses() {
		return ManageReviews.readBusinesses();
	}

	public static Object[] readCategories() {
		ArrayList<String> categories = HelperManageReviews
				.getDistinctCategories();
		return categories.toArray();
	}

	private static void saveReviews() {
		ArrayList<Review> reviews = new ArrayList<Review>();
		String reviewsFilePath = "/Users/apple/Documents/workspace/Bachelor Project/src/reviews50000.json";
		try {
			for (String line : Files.readAllLines(Paths.get(reviewsFilePath))) {
				Gson gson = new GsonBuilder().create();
				Review review = gson.fromJson(line, Review.class);
				reviews.add(review);
			}
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ManageReviews.saveReviews(reviews);
	}

	private static void saveBusinesses() {
		ArrayList<Business> businesses = new ArrayList<Business>();
		String businessFilePath = "/Users/apple/Documents/workspace/Bachelor Project/src/yelp_academic_dataset_business.json";
		try {
			for (String line : Files.readAllLines(Paths.get(businessFilePath))) {
				Gson gson = new GsonBuilder().create();
				Business business = gson.fromJson(line, Business.class);
				businesses.add(business);
			}
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ManageReviews.saveBusinesses(businesses);
	}

	private static boolean isTheFirstTime() {
		boolean flag = false;
		BufferedReader br = null;
		String filePath = "/Users/apple/Documents/workspace/Bachelor Project/startProject/start.txt";
		try {
			br = new BufferedReader(new FileReader(filePath));

			String line = br.readLine();

			if (line.equals("true")) {
				flag = true;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (flag) {
			try {
				PrintWriter writer = new PrintWriter(filePath, "UTF-8");
				writer.println("false");
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	private static ArrayList loadFile(String filename) {
		ArrayList reviews;
		try {
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fis);
			reviews = (ArrayList) in.readObject();
			in.close();
			return reviews;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	private static void saveFile(ArrayList reviews, String filename) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(reviews);
			out.flush();
			out.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
