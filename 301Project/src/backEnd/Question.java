package backEnd;

public interface Question {
	
	
	public String getAnswer();
	
	public int getDifficulty();
	
//	public String getHint();
	
	@Override
	public abstract String toString();

}
