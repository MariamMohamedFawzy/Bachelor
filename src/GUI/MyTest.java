package GUI;

import java.awt.Toolkit;

import processing.core.PApplet;
//import processing.xml.*; 
import wordcram.Word;
import wordcram.WordColorer;
import wordcram.WordCram;
import Engine.Engine;
import Engine.WordTopic;

public class MyTest extends PApplet {

	/*
	 * US Constitution text from http://www.usconstitution.net/const.txt
	 * Liberation Serif font from RedHat: https://www.redhat.com/promo/fonts/
	 */

	WordCram wordCram;

	public void setup() {
		background(255);
		colorMode(HSB);

		initWordCram();

		GUIFunctions.addResizeEvent(frame);

	}

	public void settings() {
//		size(GUIFunctions.getWindowWidth(), GUIFunctions.getWindowHeight());
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());
		size(xSize,ySize);
	}

	public void initWordCram() {

		WordTopic[] populationSizes = Engine.getWordsOfTopics();

		wordCram = new WordCram(this)
				.fromWords(populationSizes)
				.withFont(createFont("https://www.redhat.com/promo/fonts/", 1))
				.sizedByWeight(10, 90)
//				.withColors(color(0, 250, 200), color(30), color(170, 230, 200));
				 .withColorer(createColorer());
	}

	public void draw() {
		if (wordCram.hasMore()) {
			wordCram.drawNext();
		}
	}

	public void mouseClicked() {
		WordTopic lastClickedWord;
		lastClickedWord = (WordTopic) wordCram.getWordAt(mouseX, mouseY);
		GUIFunctions.showReviewsOfWord(surface, frame, lastClickedWord);
	}
	
	public WordColorer createColorer() {
		WordColorer wc = new WordColorer() {
		       public int colorFor(Word w) {
//		    	   System.out.println(w.getProperty("colorType"));
		         if (w.getProperty("colorType").equals("0")) {
		           return color(132,208,41);
		         }
		         else if (w.getProperty("colorType").equals("0")) {
		        	 return color(255, 204, 0);
		         }
		         else if (w.getProperty("colorType").equals("2")) {
		        	 return color(255,49,0);
		         } 
		         else if (w.getProperty("colorType").equals("3")) {
		        	 return color(255,0,135);
		         }
		         else if (w.getProperty("colorType").equals("4")) {
		        	 return color(50,255,252);
		         }
		         else if (w.getProperty("colorType").equals("5")) {
		        	 return color(0,255,26);
		         }
		         else if (w.getProperty("colorType").equals("6")) {
		        	 return color(50, 55, 100);
		         }
		         else if (w.getProperty("colorType").equals("7")) {
		        	 return color(81,213,255);
		         }
		         else if (w.getProperty("colorType").equals("8")) {
		        	 return color(65);
		         }
		         else if (w.getProperty("colorType").equals("9")) {
		        	 return color(0,151,255);
		         }
		         else if (w.getProperty("colorType").equals("10")) {
		        	 return color(187,255,0);
		         }
		         else if (w.getProperty("colorType").equals("11")) {
		        	 return color(173,78,0);
		         }
		         else if (w.getProperty("colorType").equals("12")) {
		        	 return color(173,197,255);
		         }
		         else if (w.getProperty("colorType").equals("13")) {
		        	 return color(181,112,255);
		         }
		         else if (w.getProperty("colorType").equals("14")) {
		        	 return color(71,164,255);
		         }
		         else if (w.getProperty("colorType").equals("15")) {
		        	 return color(217,255,0);
		         }
		         else if (w.getProperty("colorType").equals("16")) {
		        	 return color(71,211,255);
		         }
		         else if (w.getProperty("colorType").equals("17")) {
		        	 return color(255,122,246);
		         }
		         else if (w.getProperty("colorType").equals("18")) {
		        	 return color(100);
		         }
		         else if (w.getProperty("colorType").equals("19")) {
		        	 return color(112,255,170);
		         }
		         else if (w.getProperty("colorType").equals("20")) {
		        	 return color(3,0,122);
		         }
		         else if (w.getProperty("colorType").equals("21")) {
		        	 return color(191,81,255);
		         }
		         else if (w.getProperty("colorType").equals("22")) {
		        	 return color(122,250,255);
		         }
		         else if (w.getProperty("colorType").equals("23")) {
		        	 return color(132,0,57);
		         }
		         else if (w.getProperty("colorType").equals("24")) {
		        	 return color(61,255,134);
		         }
		         else if (w.getProperty("colorType").equals("25")) {
		        	 return color(97,0,163);
		         }
		         else if (w.getProperty("colorType").equals("26")) {
		        	 return color(118,163,0);
		         }
		         else if (w.getProperty("colorType").equals("27")) {
		        	 return color(81,91,255);
		         }
		         else if (w.getProperty("colorType").equals("28")) {
		        	 return color(255,71,104);
		         }
		         else if (w.getProperty("colorType").equals("29")) {
		        	 return color(12,142,0);
		         }
		         else {
		           return color(255, 100, 200);
		         }
		       }
		     };
		return wc;
	}

}
