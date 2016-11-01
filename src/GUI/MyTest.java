package GUI;

import processing.core.PApplet;
//import processing.xml.*; 
import wordcram.Word;
import wordcram.WordCram;
import Engine.Engine;
import Engine.WordTopic;

public class MyTest extends PApplet {

	/*
	 * US Constitution text from http://www.usconstitution.net/const.txt
	 * Liberation Serif font from RedHat: https://www.redhat.com/promo/fonts/
	 */

	WordCram wordCram;
	
//	MenuBar myMenu;
//	Menu topButton;
//	MenuItem item1,item2,item3,item4,item5;
//
//	myMenuListener menuListen;
	

	public void setup() {
		// size(800, 600);
		background(255);
		colorMode(HSB);

		initWordCram();
		
		GUIFunctions.addResizeEvent(frame);
		
//		menuListen = new myMenuListener();
//		 myMenu = new MenuBar();
//
//		 //create the top level button
//		 topButton = new Menu("Colours");
//
//		 //create all the Menu Items and add the menuListener to check their state.
//		 item1 = new MenuItem("Red");
//		 item1.addActionListener(menuListen);
//
//		 item2 = new MenuItem("Green");
//		 item2.addActionListener(menuListen);
//		 item3 = new MenuItem("Blue");
//		 item3.addActionListener(menuListen);
//		 item4 = new MenuItem("Yellow");
//		 item4.addActionListener(menuListen);
//		 item5 = new MenuItem("Black");
//		 item5.addActionListener(menuListen);
//
//		 //add the items to the top level Button
//		 topButton.add(item1);
//		 topButton.add(item2);
//		 topButton.add(item3);
//		 topButton.add(item4);
//		 topButton.add(item5);
//
//		 //add the button to the menu
//		 myMenu.add(topButton);
//
//		 //add the menu to the frame!
//		 frame.setMenuBar(myMenu);
//		 
//		 System.setProperty("apple.laf.useScreenMenuBar", "true");
//		
		
	}

	 
	
	public void settings() {
		size(GUIFunctions.getWindowWidth(), GUIFunctions.getWindowHeight());
	}

	public void initWordCram() {

		// PFont averia = createFont("AveriaSerif-Regular.ttf", 1);
		// PFont janeAusten = createFont("JaneAust.ttf", 1);

//		Word[] populationSizes = new Word[] { new Word("China", 1339360000),
//				new Word("India", 10000), new Word("USA", 310192000),
//				new Word("Egypt", 1360000), new Word("Saudi Arabia", 1099000),
//				new Word("UK", 31000), new Word("Japan", 199330000),
//				new Word("Russia", 100029900), new Word("Turkey", 3192000),
//				new Word("Lybia", 13350000), new Word("Maroco", 10098700),
//				new Word("Tunisia", 310222000), new Word("Tunisia", 310222000) };
		
		WordTopic[] populationSizes = Engine.getWordsOfTopics();

		wordCram = new WordCram(this).fromWords(populationSizes)
		// .fromTextString(
		// "As they rounded a bend in the path that ran beside the river, Lara recognized the silhouette of a fig tree atop a nearby hill. The weather was hot and the days were long. The fig tree was in full leaf, but not yet bearing fruit."
		// +
		// "Soon Lara spotted other landmarks—an outcropping of limestone beside the path that had a silhouette like a man’s face, a marshy spot beside the river where the waterfowl were easily startled, a tall tree that looked like a man with his arms upraised. They were drawing near to the place where there was an island in the river. The island was a good spot to make camp. They would sleep on the island tonight."
		// +
		// " Lara had been back and forth along the river path many times in her short life. Her people had not created the path—it had always been there, like the river—but their deerskin-shod feet and the wooden wheels of their handcarts kept the path well worn. Lara’s people were salt traders, and their livelihood took them on a continual journey."
		// +
		// " At the mouth of the river, the little group of half a dozen intermingled families gathered salt from the great salt beds beside the sea. They groomed and sifted the salt and loaded it into handcarts. When the carts were full, most of the group would stay behind, taking shelter amid rocks and simple lean-tos, while a band of fifteen or so of the heartier members set out on the path that ran alongside the river."
		// +
		// " With their precious cargo of salt, the travelers crossed the coastal lowlands and traveled toward the mountains. But Lara’s people never reached the mountaintops; they traveled only as far as the foothills. Many people lived in the forests and grassy meadows of the foothills, gathered in small villages. In return for salt, these people would give Lara’s people dried meat, animal skins, cloth spun from wool, clay pots, needles and scraping tools carved from bone, and little toys made of wood."
		// +
		// " Their bartering done, Lara and her people would travel back down the river path to the sea. The cycle would begin again."
		// +
		// " It had always been like this. Lara knew no other life. She traveled back and forth, up and down the river path. No single place was home. She liked the seaside, where there was always fish to eat, and the gentle lapping of the waves lulled her to sleep at night. She was less fond of the foothills, where the path grew steep, the nights could be cold, and views of great distances made her dizzy. She felt uneasy in the villages, and was often shy around strangers. The path itself was where she felt most at home. She loved the smell of the river on a hot day, and the croaking of frogs at night. Vines grew amid the lush foliage along the river, with berries that were good to eat. Even on the hottest day, sundown brought a cool breeze off the water, which sighed and sang amid the reeds and tall grasses."
		// +
		// " Of all the places along the path, the area they were approaching, with the island in the river, was Lara’s favorite."
		// +
		// " The terrain along this stretch of the river was mostly flat, but in the immediate vicinity of the island, the land on the sunrise side was like a rumpled cloth, with hills and ridges and valleys. Among Lara’s people, there was a wooden baby’s crib, suitable for strapping to a cart, that had been passed down for generations. The island was shaped like that crib, longer than it was wide and pointed at the upriver end, where the flow had eroded both banks. The island was like a crib, and the group of hills on the sunrise side of the river were like old women mantled in heavy cloaks gathered to have a look at the baby in the crib—that was how Lara’s father had once described the lay of the land.")
				// .fromTextFile("http://www.usconstitution.net/const.txt")
				.withFont(createFont("https://www.redhat.com/promo/fonts/", 1))
				// .withFonts(janeAusten)
				.sizedByWeight(10, 90)
				// .withColorer(Colorers.pickFrom(color(20,0,0),
				// color(0,255,0)))
				.withColors(color(0, 250, 200), color(30), color(170, 230, 200));
		;
	}

	public void draw() {
		if (wordCram.hasMore()) {
			wordCram.drawNext();
		}
	}

	public void mouseClicked() {
		// background(255);
		// initWordCram();
		WordTopic lastClickedWord;
		lastClickedWord = (WordTopic) wordCram.getWordAt(mouseX, mouseY);
		GUIFunctions.showReviewsOfWord(surface, frame, lastClickedWord);
	}

	// static public void main(String args[]) {
	// PApplet.main(new String[] { "--bgcolor=#ECE9D8", "MyTest" });
	// }
}



//class myMenuListener implements ActionListener, ItemListener{
//
//	 myMenuListener(){
//
//	 }
//
//	 public void actionPerformed(ActionEvent e) {
//	   MenuItem source = (MenuItem)(e.getSource());
//	   //
//	 }
//	 
//	 public void itemStateChanged(ItemEvent e) {
//	       MenuItem source = (MenuItem)(e.getSource());
//	       String s = "Item event detected."
//	                  + "    Event source: " + source.getLabel()
//	                  + " (an instance of " + getClassName(source) + ")"
//	                  + "    New state: "
//	                  + ((e.getStateChange() == ItemEvent.SELECTED) ?
//	                    "selected":"unselected");
////	       println(s);
//	   }
//
//	//gets the class name of an object
//		protected String getClassName(Object o) {
//		 String classString = o.getClass().getName();
//		 int dotIndex = classString.lastIndexOf(".");
//		 return classString.substring(dotIndex+1);
//		}
//
//	}