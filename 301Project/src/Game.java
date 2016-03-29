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
	
	public static type[][] levelTypes = {{type.VAR, type.ARITHMETIC}, {type.LIST}, {type.FOR}};
	public static String[] lessonPaths = {"/Lessons/lesson2.jpg", "/Lessons/loops.jpg"};
	
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
		
		Level curLevel = lgen.createLevel(new Lesson(0, 0, "/Lessons/lesson2.jpg"));
		curLevel.startLevel();
//		System.out.println("this many questions asked: " + curLevel.getNumQuestions());
		//l.Question1();

		
		//only do it if 
		//if (!w.getGameArea().isLessonActive()) {
		
		//}
	
	}
	

}
 
