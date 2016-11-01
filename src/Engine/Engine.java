package Engine;

import helpers.Helper;

import java.text.DecimalFormat;
import java.util.ArrayList;

import wordcram.Word;
import liuyang.nlp.lda.main.LdaModel;
import models.Business;
import models.JsonToJava;
import models.Review;

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
