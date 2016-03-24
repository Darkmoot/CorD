package backEnd;

public class ReturnValueQuestion implements Question {
	
	private String question;
	private String answer;
	private int difficulty;
	private boolean isAnswered;
	
	public ReturnValueQuestion (String question, String answer, int difficulty) {
		this.question = question;
		this.answer = answer;
		this.difficulty = difficulty;
		this.isAnswered = false;
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

	@Override
	public boolean isAnswered() {
		
		return this.isAnswered;
	}
	
	public void setAnswered() {
		this.isAnswered = true;
	}

}
