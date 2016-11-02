package helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import processing.core.PVector;
import json.Business;
import json.JsonToJava;
import json.Review;
import Engine.WordTopic;
import GUI.GUIFunctions;

import com.teamdev.jxmaps.s;

import liuyang.nlp.lda.com.FileUtil;
import liuyang.nlp.lda.conf.ConstantConfig;
import liuyang.nlp.lda.conf.PathConfig;
import liuyang.nlp.lda.main.Documents;
import liuyang.nlp.lda.main.LdaGibbsSampling;
import liuyang.nlp.lda.main.LdaGibbsSampling.modelparameters;
import liuyang.nlp.lda.main.LdaModel;
import wordcram.Word;

public class Helper {
	
	public static int numLines = 0;

	public static ArrayList<Review> filterReviews(String category, double lat,
			double lng) {
		DecimalFormat df = new DecimalFormat("#.##");

		if (lat != -1 && lng != -1) {
			lat = Double.valueOf(df.format(lat));
			lng = Double.valueOf(df.format(lng));
		}

		ArrayList<Business> businesses = JsonToJava.getBusinesses();

		ArrayList<Review> reviews = JsonToJava.readReviews();

		ArrayList<String> businessesFiltered = new ArrayList<String>();

		ArrayList<Review> reviewsFiltered = new ArrayList<Review>();

		if (lat != -1 && lng != -1) {
			for (Business business : businesses) {
				if (business.getCategories().contains(category)
						&& Double.valueOf(df.format(business.getLatitude())) == lat
						&& Double.valueOf(df.format(business.getLongitude())) == lng) {
					businessesFiltered.add(business.getBusinessId());
				}
			}
		} else {
			for (Business business : businesses) {
				if (business.getCategories().contains(category)) {
					businessesFiltered.add(business.getBusinessId());
				}
			}
		}

		for (Review review : reviews) {
			if (businessesFiltered.contains(review.getBusinessId())) {
				reviewsFiltered.add(review);
			}
		}

		return reviewsFiltered;
	}

	public static void purgeDirectory(File dir) {
		for (File file : dir.listFiles()) {
			if (file.isDirectory())
				purgeDirectory(file);
			file.delete();
		}
	}

	public static void writeReviewsToFiles(ArrayList<Review> reviews) {
//		PrintWriter writer2 = null;
//		try {
//			writer2 = new PrintWriter("/Users/apple/Desktop/c_arr.txt", "UTF-8");
//
//		} catch (Exception e) {
//			// do something
//		}
		// String rArr = "c(";
		String fileDir = "/Users/apple/Documents/workspace/Bachelor Project/data/LdaOriginalDocs/";
		Helper.purgeDirectory(new File(fileDir));

		for (Review review : reviews) {
			PrintWriter writer = null;
			try {
				writer = new PrintWriter(fileDir + "review_"
						+ review.getReviewId(), "UTF-8");
				writer.print(review.getText());
//				writer2.println(review.getReviewId());
				// rArr = rArr + "'" + review.getReviewId() + "', " ;

			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (writer != null) {
					writer.close();
				}
			}
		}
//		writer2.close();
		// rArr = rArr.substring(0, rArr.length() - 2);
		// rArr = rArr + ")";
		// System.out.println(rArr);
	}

	public static Object[] doTopicModelling() {
		try {
			return LdaGibbsSampling.prevMain();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static WordTopic[] getWordsOfTopics() {

		String filePath = "/Users/apple/Documents/workspace/Bachelor Project/data/LdaResults/lda_100.twords";

		ArrayList<WordTopic> words = new ArrayList<WordTopic>();
		try {
			List<String> lines = Files.readAllLines(Paths.get(filePath));
			numLines = lines.size();
			for (int k = 0; k < lines.size(); k++) {
				int yPos = 80 + 400 * (k / 15);
				int xPos = 80 + 90 * (k % 15);
				String line = lines.get(k);
				String[] strs = line.split("\\s+");
				for (int i = 3; i < strs.length; i += 2) {
//					if (strs[i].equals("goodreview")
//							|| strs[i].equals("badreview")) {
//						continue;
//					}
					WordTopic wt = new WordTopic(strs[i], Float
							.parseFloat(strs[i + 1]), k);
					wt.setProperty("colorType", String.valueOf(k));
					wt.setPlace(new PVector(xPos, yPos));
					words.add(wt);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WordTopic[] result = new WordTopic[words.size()];

		for (int i = 0; i < words.size(); i++) {
			result[i] = words.get(i);
		}

		return result;

	}

	public static ArrayList<Review> getReviewsOfWord(WordTopic word) {

		int topicIndex = word.getTopicNum();

		ArrayList<Integer> docsIndex = new ArrayList<Integer>();

		LdaModel model = GUIFunctions.getModel();
		Documents docSet = GUIFunctions.getDocSet();

		for (int i = 0; i < model.z.length; i++) {
			for (int j = 0; j < model.z[i].length; j++) {
				if (model.z[i][j] == topicIndex) {
					docsIndex.add(i);
					break;
				}
			}
		}

		ArrayList<Review> allReviews = GUIFunctions.getAllReviews();

		ArrayList<String> reviewsIds = new ArrayList<String>();

		for (int i = 0; i < docsIndex.size(); i++) {
			int docIndex = docsIndex.get(i);
			String docPath = docSet.docs.get(docIndex).docName;
			int lastSlash = docPath.lastIndexOf("/");
			String docId = docPath.substring(lastSlash + 8, docPath.length());
			reviewsIds.add(docId);
		}

		System.out.println("all reviews size = " + allReviews.size());
		ArrayList<Review> result = new ArrayList<Review>();
		for (Review review : allReviews) {
			if (reviewsIds.contains(review.getReviewId())) {
				result.add(review);
			}
		}
		System.out.println("result size = " + result.size());
		return result;
	}

}
