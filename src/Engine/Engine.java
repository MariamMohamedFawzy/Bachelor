package Engine;

import helpers.HelperGUI;
import helpers.HelperManageReviews;

import java.text.DecimalFormat;
import java.util.ArrayList;

import DB.ManageReviews;
import json.Business;
import json.JsonToJava;
import json.Review;
import wordcram.Word;
import liuyang.nlp.lda.main.LdaModel;

public class Engine {


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
	
	public static ArrayList rankBusinesses(WordTopic wordTopic, LdaModel model,
			ArrayList<Review> reviews) {
		return ManageReviews.rankBusinesses(wordTopic, model, reviews);
	}

}
