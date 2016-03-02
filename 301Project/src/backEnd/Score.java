package backEnd;

import backEnd.Question;

public class Score {
	
	public int getScore(int score, String inputAnswer, Question currentQuestion) {
		
		if (inputAnswer.equalsIgnoreCase(currentQuestion.getAnswer())) {
			score += currentQuestion.getDifficulty();
		}
		
		return score;
	}
}
