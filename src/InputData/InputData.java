package InputData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InputData {
	
	public String evidence;
	public Map<String, Map<String, Integer>> scores;
	public List<Suspect> suspects;

	public InputData() {
		suspects = new ArrayList<Suspect>();
	}
	
	public String getEvidence() {
		return evidence;
	}
	public void setEvidence(String evidence) {
		this.evidence = evidence;
	}
	public Map<String, Map<String, Integer>> getScores() {
		return scores;
	}
	public void setScores(Map<String, Map<String, Integer>> scores) {
		this.scores = scores;
	}
	public List<Suspect> getSuspects() {
		return suspects;
	}
	public void setSuspects(List<Suspect> suspects) {
		this.suspects = suspects;
	}
	
}
