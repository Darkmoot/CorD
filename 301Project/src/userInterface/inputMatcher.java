package userInterface;

import java.util.Set;

import javax.swing.JTextArea;

import backEnd.Question;

public class inputMatcher {
	
	private String command;
	
	private Set<Question> currentQuestions;
	
	private Window window; //the players input area
	private JTextArea console;
	
	public inputMatcher(String command, Set<Question> currentQuestions) {
		this.command = command;
		this.currentQuestions = currentQuestions;
		this.console = window.getInputText();
	}
	
	public String getCommand() {
		return this.command;
	}
	
	public void setCommand(String newCommand) {
		this.command = newCommand;
	}
	
	public Set<Question> getCurrentQuestions() {
		return this.currentQuestions;
	}
	
	public void addToCurrentQuestions(Question q) {
		this.currentQuestions.add(q);
	}
	//should fix error
	//rather then remove, keep the question on the screen and just disable it.
	
	public void matchAnswer(String answer) {
		for (Question q: currentQuestions) {
			if (q.getAnswer() == answer) {
				console.append("\nCorrect answer");
				window.setCurrentLinePrompt();
				//disable question
			}
			else {
				console.append("\nIncorrect answer");
				window.setCurrentLinePrompt();
				//don't disable question
			}
		}
	}
}
