package Engine;

import helpers.Helper;

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

		return Helper.filterReviews(category, lat, lng);

	}

	public static Object[] doTopicModelling(ArrayList<Review> reviews) {

		Helper.writeReviewsToFiles(reviews);

		return Helper.doTopicModelling();

	}

	public static WordTopic[] getWordsOfTopics() {

		return Helper.getWordsOfTopics();

	}

	public static ArrayList<Review> getReviewsOfWord(WordTopic word) {
		
		return Helper.getReviewsOfWord(word);
		
	}

}
