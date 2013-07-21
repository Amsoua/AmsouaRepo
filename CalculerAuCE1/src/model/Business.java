package model;

public class Business {

	private static Business instance;

	private static final int TOTALQUESTIONS = 3;
	
	private int scoreAddition;
	private int scoreSoustraction;
	private int scoreDivision;
	private int scoreEncadrement;
	private int scoreMultiplication;

	private int scoreLettres;
	private Business() {
		instance = this;
	}

	public static Business getInstance() {
		return instance;
	}

	public static void createBusiness() {
		instance = new Business();
	}

	public static int getTotalQuestions() {
		return TOTALQUESTIONS;
	}
	
	public int getScoreAddition() {
		return scoreAddition;
	}

	public void setScoreAddition(int scoreAddition) {
		this.scoreAddition = scoreAddition;
	}

	public int getScoreSoustraction() {
		return scoreSoustraction;
	}

	public void setScoreSoustraction(int scoreSoustraction) {
		this.scoreSoustraction = scoreSoustraction;
	}

	public int getScoreMultiplication() {
		return scoreMultiplication;
	}

	public void setScoreMultiplication(int scoreMultiplication) {
		this.scoreMultiplication = scoreMultiplication;
	}
	public int getScoreEncadrement() {
		return scoreEncadrement;
	}

	public void setScoreEncadrement(int scoreEncadrement) {
		this.scoreEncadrement = scoreEncadrement;
	}

	public int getScoreLettres() {
		return scoreLettres;
	}

	public void setScoreLettres(int scoreLettres) {
		this.scoreLettres = scoreLettres;
	}

	public int getScoreDivision() {
		return scoreDivision;;
	}

	public void setScoreDivision(int scoreDivision) {
		this.scoreDivision = scoreDivision;
		
	}
}