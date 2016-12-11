package model;

public class TotalScore {
	
	public static final TotalScore instance = new TotalScore();
	private int totalScore;
	
	public TotalScore() {
		this.totalScore = 0;
	}

	public int getTotalScore() {
		return totalScore;
	}
	
	public void increaseTotalScore(int amount){
		this.totalScore += amount;	
	}
}
