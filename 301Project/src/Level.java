import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
	
	//private TimerTask spawnQuestion;
	private QuestionFactory qc;
	private JTextArea QuestionPage;
	private inputMatcher matcher;
	private GameArea garea;
	private long length;
	private int numQuestions;
	
	
	private ImageIcon icon;
	
	public Level(JTextArea Question, inputMatcher matcher, /*GameArea gamearea,*/ QuestionCreator qc) {
		
		//this.garea = gamearea;
		this.QuestionPage = Question;
		this.matcher = matcher;
		//timer = new Timer();
		this.qc = qc;
		
		this.length = 20000; // 5 secs in millisec
		this.numQuestions = 0;
		// TODO: change this to parameter to allow variable level duration
		
		
	}
	
	// return the system time in millis each question will be spawned at -  should 
	// be able to use this to spawn enemies at  same time?
	
	public List<Long> startLevel() {
		
		long start_time = System.currentTimeMillis();
		
		Timer t = new Timer();
		
		long previous = 0;
		
		List<Long> sl = new ArrayList<>();
		
		while (previous <= this.length) {
			
			TimerTask spawner = new TimerTask() {
				@Override
				public void run() {
					spawnQuestion();	
				}
			};
			
			
			long delay = new Random().nextInt(4000) + 1000; // random int between 0 and 4000 (0 and 4 seconds)
			// add 1000 to this so qs are spawned randomly every 1 to 5 secs
			// TODO: Find apropriate delay, maybe based on level/dificulty
			long curDelay = delay + previous;
			t.schedule(spawner, curDelay);
			sl.add(curDelay + start_time);
			previous = curDelay;
			this.numQuestions ++;
			
		}
		
		return sl;
	}
	
	
	//Create new Question return that question. -> input matcher should change its name, it stores all questions
	//but also sets them up
	//public void Question1() {
	//	timer.schedule (spawnQuestion, 0l, 1000*10);
		
	
	//}
	//Add code for other difficulties or add a random function
	
	
	public int getNumQuestions() {
		return numQuestions;
	}

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
