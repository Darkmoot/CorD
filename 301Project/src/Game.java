import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import backEnd.*;
import backEnd.Question.type;
import userInterface.Window;


public class Game {
	
	public static void main(String[] args) {
		
		Window w = new Window();
		
		QuestionFactory qc = new QuestionCreatorFactory().getInstance();
		LevelGenerator lgen = new LevelGenerator(w, qc);
		// Testing get question by type
		System.out.println(qc.getRandomQuestionByType(type.ARITHMETIC)+"\n");
		System.out.println(qc.getRandomQuestionByType(type.ARITHMETIC)+"\n");
		System.out.println(qc.getRandomQuestionByType(type.ARITHMETIC)+"\n");
		System.out.println(qc.getRandomQuestionByType(type.LIST)+"\n");
		
		// testing get question by types
		List<type> lt = new ArrayList<>();
		lt.add(type.CALL);
		lt.add(type.LIST);
		System.out.println(qc.getRandomQuestionByTypes(lt));
		
		Level curLevel = lgen.createLevel();
		curLevel.startLevel();
		System.out.println("this many questions asked: " + curLevel.getNumQuestions());
		//l.Question1();
		
		//This section is to test making the enemies move and repaint the GameArea
		
		//only do it if 
		//if (!w.getGameArea().isLessonActive()) {
		
		//This section is to make the enemies move and repaint the GameArea
		
		
	
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
		
		//}
	
	}
	

}
 
