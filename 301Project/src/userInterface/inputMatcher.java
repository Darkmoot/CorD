package userInterface;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JTextArea;

import backEnd.Question;

public class inputMatcher {
	
	//the last command input
	private String command;
	
	//the 
	private Set<Question> currentQuestions;
	
	
	private JTextArea console; //the actual console
	
	
	public inputMatcher(String command, HashSet<Question> currentQuestions) {
		this.command = command;
		this.currentQuestions = currentQuestions;
		//this.console = c;
	}
	
	
	public String getCommand() {
		return this.command;
	}
	
	//set the command to a new one
	public void setCommand(String newCommand) {
		this.command = newCommand;
	}
	
	//get the set of questions
	public Set<Question> getCurrentQuestions() {
		return this.currentQuestions;
	}
	
	//Add a newly generated question into the set of current questions
	public void addToCurrentQuestions(Question q) {
		System.out.println(this.currentQuestions.size());
		
		this.currentQuestions.add(q);
	}
	
	public void donothing() {
		System.out.println("nothing");
	}
	
	public void getScore(int score, Question currentQuestion) {
		score += currentQuestion.getDifficulty();
	}
	
	//should fix error
	//rather then remove, keep the question on the screen and just disable it.
	public boolean matchAnswer(String answer, int score) {
		
		System.out.println(answer);
		for (Question q: currentQuestions) {
			if (q.getAnswer().equalsIgnoreCase(answer)) {
				getScore(score, q);
				return true;
				//console.append("\nCorrect answer\n>>> ");
				//window.setCurrentLinePrompt();
				//disable question
			}
			else {
				return false;
				//console.append("\nIncorrect answer\n>>> ");
				//window.setCurrentLinePrompt();
				//don't disable question
			}
		}
		return false;
	}
	
	
	//Could add a piece of code to manage all questions generated in game and then put them 
	//into the question field.
	
}
