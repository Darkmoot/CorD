package backEnd;

public class TrueFalseQuestion implements Question {

	private String question;
	private String answer;
	private int difficulty;
	

	public TrueFalseQuestion (String question, String answer, int difficulty) {
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


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Is the following statement true or false?\n" + question;
	}


}
