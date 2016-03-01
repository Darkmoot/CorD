package userInterface;

import java.util.Set;

import backEnd.Question;

public class inputMatcher {
	
	private String command;
	
	private Set<Question> currentQuestions;
	
	public inputMatcher(String command, Set<Question> currentQuestions) {
		this.command = command;
		this.currentQuestions = currentQuestions;
		
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
	
	//rather then remove, keep the question on the screen and just disable it.
}
