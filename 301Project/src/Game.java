import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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
	
	public static type[][] levelTypes = {{type.VAR}, {type.LIST}, {type.FOR}};
	public static String[] lessonPaths = {"/Lessons/lesson2.jpg", "/Lessons/Loops4.jpg", 
		"/Lessons/Functions3.jpg", "/Lessons/StringsAndIndexes2.jpg", "/Lessons/TypesAndVariables1.jpg"	};
	
	public static void main(String[] args) {
		
		Window w = new Window();
		
		QuestionFactory qc = new QuestionCreatorFactory().getInstance();
		LevelGenerator lgen = new LevelGenerator(w, qc);
		// Testing get question by type
//		System.out.println(qc.getRandomQuestionByType(type.ARITHMETIC)+"\n");
//		System.out.println(qc.getRandomQuestionByType(type.ARITHMETIC)+"\n");
//		System.out.println(qc.getRandomQuestionByType(type.ARITHMETIC)+"\n");
//		System.out.println(qc.getRandomQuestionByType(type.LIST)+"\n");
//		
//		// testing get question by types
//		List<type> lt = new ArrayList<>();
//		lt.add(type.CALL);
//		lt.add(type.LIST);
//		System.out.println(qc.getRandomQuestionByTypes(lt));
		int level = 0;
		
			
		List<type> tt = Arrays.asList(levelTypes[level]);
		// curently level qtypes dont match with lessons
		Level curLevel = lgen.createLevel(new Lesson(0, 0, lessonPaths[level]), tt);
		List<Long> times = curLevel.startLevel();
		//level ++;
		
		while (true) {
			
			// should wait till last question is asked - currently it is going a bit early
			if (System.currentTimeMillis() >= times.get(times.size() - 1) + 3000) {
				System.out.println("time");
				System.out.println(w.getGameArea().getEnemies().size());
			
				// wait to check if no enemies left
				// need to add checker to see if they lost too
				if (w.getGameArea().getEnemies().size() == 0) {
				
					// clear stuff of screen here to start new level
					// also curently just using same question types and lesson
					//w.setGameArea();
					tt = Arrays.asList(levelTypes[level]);
					level++;
					curLevel = lgen.createLevel(new Lesson(0, 0, lessonPaths[level]), tt);
					
					times = curLevel.startLevel();
					//level ++;
				}
			}
			//}
			
		}
		
		
//		System.out.println("this many questions asked: " + curLevel.getNumQuestions());
		//l.Question1();

		
		//only do it if 
		//if (!w.getGameArea().isLessonActive()) {
		
		//}
	
	}
	

}
 
