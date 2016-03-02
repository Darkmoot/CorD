import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import backEnd.*;
import userInterface.Window;


public class Game {
	
	public static void main(String[] args) {
		
		Window w = new Window();
		
		try {
			// Open up the XML database
			File input = new File("src" + File.separator + "recources" + File.separator + "questions.xml");
			// Parse it, and store it as a document
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setValidating(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(input);
			// Set up document for reading with XPath
			XPathFactory xpathfactory = XPathFactory.newInstance();
			XPath xpath = xpathfactory.newXPath();
			// Creates a new question creator
			QuestionCreator qc = new QuestionCreator(doc, xpath);
			
			// Getting 1 question for each difficulty level
			// This will need to be changed once we implement levels, and start picking question difficulty based on level
			for (int diff = 1; diff <= 5; diff++) {
				// Compiles XPath expression that gets questions of a certain difficulty
				
				// Uses the Question creator, and passes it the expr, in order to get a random question satisfying the expression
				Question q = qc.getRandomQuestion(diff);
				// TODO: this should be printed to the window.
				System.out.println(q);
				System.out.println("\n");
			}
		
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//This section is to test making the enemies move and repaint the GameArea
		Timer timer = new Timer();
		
		timer.schedule(new TimerTask() {
			public void run() {
				ArrayList<Enemy> enemies = w.getGameArea().getEnemies();
				for (Enemy enemy : enemies) {
					enemy.moveDown(10);
				}
				w.getGameArea().repaint();
			}
		}, 0, 1*1000);
		
	}
	

}
 