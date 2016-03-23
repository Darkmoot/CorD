package userInterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JTextArea;

import backEnd.Question;

public class inputMatcher {
	
	//the last command input
	private String command;
	
	//the 
	private List<Question> currentQuestions;
	
	
	
	private JTextArea console; //the actual console
	
	//game score variable
	private int score = 0;
	
	
	public inputMatcher(String command, ArrayList<Question> currentQuestions) {
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
	public List<Question> getCurrentQuestions() {
		return this.currentQuestions;
	}
	
	public int getScore() {
		return this.score;
	}
	
	//Add a newly generated question into the set of current questions
	public void addToCurrentQuestions(Question q) {
		System.out.println(this.currentQuestions.size());
		
		this.currentQuestions.add(q);
	}
	
	public void donothing() {
		System.out.println("nothing");
	}
	
	//should fix error
	//rather then remove, keep the question on the screen and just disable it.
	public String matchAnswer(String answer) {
		try {
		if (!answer.contains("at")){
			return "bad syntax!";
		}
		
		String input = answer.split("at")[0].trim();
		int index;
	
			index = Integer.parseInt(answer.split("at")[1].trim());
		
		
		System.out.println("the input is: "+ input);
		System.out.println("the index is " + index);
		if (index > this.currentQuestions.size() -1) {
			return "index out of bounds";
		}
		Question q = this.currentQuestions.get(index);
		if (q.getAnswer().equals(input)) {
			score += q.getDifficulty();
			return "correct";
		}
		else {
			return "incorrect";
		}
		/*
		for (Question q: currentQuestions) {
			if (q.getAnswer().equalsIgnoreCase(answer)) {
				// if correct answer, increase score
				score += q.getDifficulty();
				return true;
				//console.append("\nCorrect answer\n>>> ");
				//window.setCurrentLinePrompt();
				//disable question
			}
			else {
				System.out.println("false");
				return false;
				//console.append("\nIncorrect answer\n>>> ");
				//window.setCurrentLinePrompt();
				//don't disable question
			}
		}
		return false;
		*/
		}
		catch (Exception e) {
			return e.toString();
		}
	}
	
	
	//Could add a piece of code to manage all questions generated in game and then put them 
	//into the question field.
	
}
