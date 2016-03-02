import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JTextArea;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import userInterface.inputMatcher;
import backEnd.Question;
import backEnd.QuestionCreator;


public class LevelGenerator {
	
	private Timer timer;
	private TimerTask spawnQuestion;
	private QuestionCreator qc;
	private JTextArea QuestionPage;
	private inputMatcher matcher;
	
	public LevelGenerator(JTextArea Question, inputMatcher matcher) {
		this.QuestionPage = Question;
		this.matcher = matcher;
		timer = new Timer();
		
		spawnQuestion = new TimerTask() {

			@Override
			public void run() {
				spawnQuestion(1);	
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
			
			
			/*
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
		*/
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
	
	public void spawnQuestion(int diff) {
		
			// Compiles XPath expression that gets questions of a certain difficulty
			
			// Uses the Question creator, and passes it the expr, in order to get a random question satisfying the expression
			Question q = qc.getRandomQuestion(diff);
			
			//add to the matcher
			this.matcher.addToCurrentQuestions(q);
			//add to the question window.
			this.QuestionPage.append("\n" + q.toString() + "\n");
			
	}
	
}
