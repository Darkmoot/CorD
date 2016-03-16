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
		
		QuestionCreator qc = new QuestionCreatorFactory().getInstance();
		Level l = new Level(w.getQuestionText(), w.getInputMatcher(), qc);
		// currently levels hard coded to last for 20 secs : add parameter
		l.startLevel();
		System.out.println("this many questions asked: " + l.getNumQuestions());
		//l.Question1();
		
		
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
		}, 0, 1*1000); //0 is the delay before the timerTask starts running, 1*1000 is how often it goes off (meaning it goes off every second)
		
		Timer t = new Timer();
		
		t.schedule(new TimerTask() {
			public void run() {
				ArrayList<Player> players = w.getGameArea().getPlayers();
				for (Player player : players) {
					System.out.println("Check");
					System.out.println(player);
				}
				w.getGameArea().repaint();
			}
		}, 0, 1*1000);
		
	}
	

}
 
