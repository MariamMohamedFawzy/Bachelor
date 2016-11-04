package Engine;

import helpers.HelperGUI;

import java.text.DecimalFormat;
import java.util.ArrayList;

import json.Business;
import json.JsonToJava;
import json.Review;
import wordcram.Word;
import liuyang.nlp.lda.main.LdaModel;

public class Engine {

	public static ArrayList<Review> filterReviews(String category, double lat,
			double lng) {

		return HelperGUI.filterReviews(category, lat, lng);

	}

	public static Object[] doTopicModelling(ArrayList<Review> reviews) {

		HelperGUI.writeReviewsToFiles(reviews);

		return HelperGUI.doTopicModelling();

	}

	public static WordTopic[] getWordsOfTopics() {

		return HelperGUI.getWordsOfTopics();

	}

	public static ArrayList<Review> getReviewsOfWord(WordTopic word) {
		
		return HelperGUI.getReviewsOfWord(word);
		
	}

}
