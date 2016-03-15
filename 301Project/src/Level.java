import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import userInterface.*;
import backEnd.*;

public class Level {
	
	private Timer timer;
	private TimerTask spawnQuestion;
	private QuestionFactory qc;
	private JTextArea QuestionPage;
	private inputMatcher matcher;
	private GameArea garea;
	
	private ImageIcon icon;
	
	public Level(JTextArea Question, inputMatcher matcher, GameArea gamearea) {
		
		this.garea = gamearea;
		this.QuestionPage = Question;
		this.matcher = matcher;
		timer = new Timer();
		
		spawnQuestion = new TimerTask() {

			@Override
			public void run() {
				spawnQuestion();	
			}
		
		};
		
		
		
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
			qc = new QuestionCreator(doc, xpath);
			
			
			//Generate questions to text
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Create new Question return that question. -> input matcher should change its name, it stores all questions
	//but also sets them up
	public void Question1() {
		timer.schedule (spawnQuestion, 0l, 1000*10);
		
	
	}
	//Add code for other difficulties or add a random function
	
	
	//spawn random questions of a specific difficulty
	public void spawnQuestion(int diff) {
		
			// Compiles XPath expression that gets questions of a certain difficulty
			
			// Uses the Question creator, and passes it the expr, in order to get a random question satisfying the expression
			Question q = qc.getRandomQuestionByDiff(diff);
			
			//add to the matcher
			this.matcher.addToCurrentQuestions(q);
			//add to the question window.
			this.QuestionPage.append("\n" + q.toString() + "\n");
			
			//Can also use Default Caret Bottom.
			QuestionPage.setCaretPosition(QuestionPage.getDocument().getLength());
			
	}
	
	//spawn random questions 
	public void spawnQuestion() {

		// Compiles XPath expression that gets questions of a certain difficulty
		
		// Uses the Question creator, and passes it the expr, in order to get a random question satisfying the expression
		Question q = qc.getRandomQuestion();
		
		//add to the matcher
		this.matcher.addToCurrentQuestions(q);
		//add to the question window.
		this.QuestionPage.append("\n" + q.toString() + "\n");
		System.out.println("the answer is " + q.getAnswer() + "len is " + q.getAnswer().length());
		
		//Can also use Default Caret Bottom.
		QuestionPage.setCaretPosition(QuestionPage.getDocument().getLength());
		
	
	}
	
	public void displayLesson1() {
		//load lesson 1
		/*
		icon = new ImageIcon(this.getClass().getResource("C:\\Users\\HisProdigalSon/Desktop/301/project/project-team10/301Project/graphics/Lessons/lessonOperators.png"));
		JLabel label = new JLabel(icon);
		label.setVisible(true);
		garea.add(label);
		*/
	}
	
	//cancels the input timertask
	public void stopWave(TimerTask t) {
		t.cancel();
		
	}
	
	//give a delay to the in
	public void delayWave(TimerTask t,long l ) throws InterruptedException {
		try {
			t.wait(l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
}
