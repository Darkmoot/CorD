package backEnd;

public class ReturnValueQuestion implements Question {
	
	private String question;
	private String answer;
	private int difficulty;
	
	
	public ReturnValueQuestion (String question, String answer, int difficulty) {
		this.question = question;
		this.answer = answer;
		this.difficulty = difficulty;
	}
	
	public String getAnswer() {
		// TODO Auto-generated method stub
		return answer;
	}
	
	public int getDifficulty() {
		return difficulty;
	}
	
	public String toString() {
		return "What will the following code return?\n" + question;
	}

}
