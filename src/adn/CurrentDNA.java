package adn;

public class CurrentDNA {

	public DNA evidence;
	public DNA suspect;
	
	public CurrentDNA(String evidence, String suspect) {
		this.evidence = new DNA(evidence);
		this.suspect = new DNA(suspect);
	}

	public boolean containsEvidence() {
		return evidence.existDNA();
	}
	
	public boolean containsSuspect() {
		return suspect.existDNA();
	}

	
	public boolean areTheBasesDifferent() {
		return evidence.firstBase != suspect.firstBase;
	}
	
}