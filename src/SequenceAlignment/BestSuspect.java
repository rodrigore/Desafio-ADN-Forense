package SequenceAlignment;

import InputData.Suspect;

public class BestSuspect {

	Suspect suspect;
	int score;
	
	public BestSuspect(Suspect suspect, int score) {
		this.suspect = suspect;
		this.score = score;
	}
	
	public Suspect getSuspect() {
		return suspect;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "BestSuspect [suspect=" + suspect + ", score=" + score + "]";
	}
	
	
}
