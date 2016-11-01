package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import json.Review;
import liuyang.nlp.lda.main.Documents;
import liuyang.nlp.lda.main.LdaModel;
import processing.core.PApplet;
import processing.core.PSurface;
import Engine.Engine;
import Engine.WordTopic;
import JXMapClasses.GeocoderExample;

public class GUIFunctions {

	public static FirstWindow firstWindowFrame;

	private static ArrayList<Review> wordReviews = null;
	private static ArrayList<Review> allReviews = null;
	
	private static LdaModel model = null;
	private static Documents docSet;

	private static int windowWidth;
	private static int windowHeight;
	
	private static int posX;
	private static int posY;

	public static void addResizeEvent(Frame frame) {
		frame.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent evt) {
				Component c = (Component) evt.getSource();
				GUIFunctions.setWindowHeight(c.getHeight());
				GUIFunctions.setWindowWidth(c.getWidth());
			}
			public void componentMoved(ComponentEvent evt) {
				Component c = (Component) evt.getSource();
				GUIFunctions.setPosX(c.getX());
				GUIFunctions.setPosY(c.getY());
		    }
		});
	}

	public static void showMap() {

		firstWindowFrame.setVisible(false);

		final GeocoderExample mapView = new GeocoderExample();

		GeocoderExample.frame = new JFrame("Geocoder");

		GeocoderExample.frame
				.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		GeocoderExample.frame.add(mapView, BorderLayout.CENTER);
		GeocoderExample.frame.setSize(700, 500);
		GeocoderExample.frame.setLocationRelativeTo(null);
		GeocoderExample.frame.setVisible(true);
	}

	public static void hideMapWithOk() {

		firstWindowFrame.getjTextFieldLat().setText(
				Double.toString(GeocoderExample.getFinalLoc().getLat()));
		firstWindowFrame.getjTextFieldLong().setText(
				Double.toString(GeocoderExample.getFinalLoc().getLng()));

		// GeocoderExample.frame.setVisible(false);
		firstWindowFrame.setVisible(true);
		GeocoderExample.frame.dispose();
	}

	public static void cancelMap() {
		// GeocoderExample.frame.setVisible(false);
		firstWindowFrame.setVisible(true);
		GeocoderExample.frame.dispose();
	}

	public static void showWords() {
		firstWindowFrame.disable();
		Runnable doWorkRunnable = new Runnable() {
			@Override
			public void run() {
				double lat;
				double lng;
				String latStr = firstWindowFrame.getjTextFieldLat().getText();
				String lngStr = firstWindowFrame.getjTextFieldLong().getText();
				try {
					lat = Double.parseDouble(latStr);
				} catch (Exception e) {
					lat = -1;
				}
				try {
					lng = Double.parseDouble(lngStr);
				} catch (Exception e) {
					lng = -1;
				}
				if (firstWindowFrame.getjComboBox1().getSelectedItem() != null) {
					ArrayList<Review> reviews = Engine.filterReviews(
							firstWindowFrame.getjComboBox1().getSelectedItem()
									.toString(), lat, lng);
					doTopicModelling(reviews);
					PApplet.main(new String[] { "--bgcolor=#ECE9D8",
							"GUI.MyTest" });
					firstWindowFrame.setVisible(false);
				} else {
					firstWindowFrame.enable();
				}
			}
		};
		SwingUtilities.invokeLater(doWorkRunnable);
	}

	public static void showWords(JFrame frame, ArrayList<Review> reviews) {
		frame.disable();
		Runnable doWorkRunnable = new Runnable() {
			@Override
			public void run() {
				doTopicModelling(reviews);
				PApplet.main(new String[] { "--bgcolor=#ECE9D8", "GUI.MyTest" });
				frame.setVisible(false);
			}
		};
		SwingUtilities.invokeLater(doWorkRunnable);
	}

	public static void showReviewsOfWord(PSurface surface, Frame frame,
			WordTopic word) {

		Runnable doWorkRunnable = new Runnable() {
			@Override
			public void run() {
				frame.disable();
				Reviews wordReviews = new Reviews(word);
				wordReviews.setVisible(true);
				surface.setVisible(false);
				frame.dispose();
			}
		};
		SwingUtilities.invokeLater(doWorkRunnable);

	}

	public static void showReviewsFromFirstWindow() {
		if (firstWindowFrame.getjComboBox1().getSelectedItem() != null) {
			firstWindowFrame.setVisible(false);
			double lat;
			double lng;
			String latStr = firstWindowFrame.getjTextFieldLat().getText();
			String lngStr = firstWindowFrame.getjTextFieldLong().getText();
			try {
				lat = Double.parseDouble(latStr);
			} catch (Exception e) {
				lat = -1;
			}
			try {
				lng = Double.parseDouble(lngStr);
			} catch (Exception e) {
				lng = -1;
			}
			Reviews allReviews = new Reviews(true, firstWindowFrame
					.getjComboBox1().getSelectedItem().toString(), lat, lng);
			allReviews.setVisible(true);
		}
	}

	//
	public static void restart(JFrame frame) {
		firstWindowFrame.enable();
		firstWindowFrame.setSizeAndLocationFromPrev();
		firstWindowFrame.setVisible(true);
		// frame.setVisible(false);
		frame.dispose();
		// firstWindowFrame = new FirstWindow();

	}
	
	public static void resetFirstWindow() {
		firstWindowFrame.getjComboBox1().setSelectedIndex(-1);
		firstWindowFrame.getjTextFieldLat().setText("");
		firstWindowFrame.getjTextFieldLong().setText("");
	}

	//
	private static void doTopicModelling(ArrayList<Review> reviews) {
		setAllReviews(reviews);
		Object[] obj = Engine.doTopicModelling(reviews);
		model = (LdaModel) obj[0];
		docSet = (Documents) obj[1];
		
	}

	//
	public static ArrayList<Review> getWordReviews() {
		return wordReviews;
	}

	public static void setWordReviews(ArrayList<Review> wordReviews) {
		GUIFunctions.wordReviews = wordReviews;
	}

	public static ArrayList<Review> getAllReviews() {
		return allReviews;
	}

	public static void setAllReviews(ArrayList<Review> allReviews) {
		GUIFunctions.allReviews = allReviews;
	}

	public static int getWindowWidth() {
		return windowWidth;
	}

	public static void setWindowWidth(int windowWidth) {
		GUIFunctions.windowWidth = windowWidth;
	}

	public static int getWindowHeight() {
		return windowHeight;
	}

	public static void setWindowHeight(int windowHeight) {
		GUIFunctions.windowHeight = windowHeight;
	}

	public static int getPosX() {
		return posX;
	}

	public static void setPosX(int posX) {
		GUIFunctions.posX = posX;
	}

	public static int getPosY() {
		return posY;
	}

	public static void setPosY(int posY) {
		GUIFunctions.posY = posY;
	}

	public static LdaModel getModel() {
		return model;
	}

	public static void setModel(LdaModel model) {
		GUIFunctions.model = model;
	}

	public static Documents getDocSet() {
		return docSet;
	}

	public static void setDocSet(Documents docSet) {
		GUIFunctions.docSet = docSet;
	}

}
