package Engine;

import wordcram.Word;

public class WordTopic extends Word {
	
	private int topicNum;

	public int getTopicNum() {
		return topicNum;
	}

	public void setTopicNum(int topicNum) {
		this.topicNum = topicNum;
	}

	public WordTopic(String word, float weight, int topicNum) {
		super(word, weight);
		this.topicNum = topicNum;
	}

	
	
	
}
