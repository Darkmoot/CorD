package backEnd;

import backEnd.Question.type;

public interface QuestionFactory {

	public Question getQuestionByExpr(String strexpr);
	
	public Question getRandomQuestion();
	
	public Question getRandomQuestionByDiff(int difficulty);
	
	public Question getRandomQuestionByType(type t);
}
