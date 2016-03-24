package backEnd;

public interface Question {
	
	public enum type {VAR, ARITHMETIC, LIST, FOR, WHILE, CALL}	
	
	public boolean isAnswered();
	
	public String getAnswer();
	
	public int getDifficulty();
	
	@Override
	public abstract String toString();

}
