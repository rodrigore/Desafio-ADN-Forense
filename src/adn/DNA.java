package adn;

public class DNA {

	public int length;
	public String firstBase;
	public String remaining;

	
	public DNA(String dna) {
//		System.out.println("dna:" + dna)
		this.length = dna.length();
		this.firstBase = length > 0 ? dna.substring(0, 1) : "";
		this.remaining = length > 0 ? dna.substring(1) : "";
	}
	
	public boolean existDNA() {
		return length  > 0;
	}
	
	public String getFirstBase() {
		return firstBase;
	}

	public String getRemaining() {
		return remaining;
	}
	
	
	
//	public String getDNAFromIndex(String dna, int index) {
//		return dna.substring(index);
//	}
	
	
}
