package SequenceAlignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import InputData.InputData;
import InputData.Suspect;
import adn.CurrentDNA;

public class SequenceAlignment {

    private InputData input;
//  private bufferScores;
    
    public SequenceAlignment(InputData input) {
        this.input = input;
    }

    public List run() {
        List<Integer> results = new ArrayList<Integer>();
        Iterator<Suspect> it = input.suspects.iterator();
        while (it.hasNext()) {
            Suspect suspect = (Suspect)it.next();
            int result = evaluate(input.getEvidence(), suspect.getAdn());
            System.out.println( suspect.toString() + ", best score:" +  result);
            results.add(result);
        }
        return results;
    }

    public int evaluate(String evidence, String suspect) {
    
        List<Integer> scorePerSolution = new ArrayList<Integer>();
        CurrentDNA dna = new CurrentDNA(evidence, suspect);
        
        if ( ! dna.containsEvidence()  && ! dna.containsSuspect() ) {
            return 0;
        } else {
            
            int scoreBetweenBases = 0;

            if (dna.containsEvidence() && dna.containsSuspect()) {      
                scoreBetweenBases = getScoreBetweenBases(dna.evidence.firstBase, dna.suspect.firstBase);
                scorePerSolution.add(evaluate(dna.evidence.remaining, dna.suspect.remaining) + scoreBetweenBases);
            }
            
            if (dna.areTheBasesDifferent()) {
                
                if (dna.containsSuspect()) {
                    scoreBetweenBases = getScoreBetweenBases("-", dna.suspect.firstBase);
                    scorePerSolution.add(evaluate(evidence, dna.suspect.remaining) + scoreBetweenBases);
                }
                
                if (dna.containsEvidence()) {
                    scoreBetweenBases = getScoreBetweenBases(dna.evidence.firstBase, "-");
                    scorePerSolution.add(evaluate(dna.evidence.remaining, suspect) + scoreBetweenBases);
                }
            }
            return getHighestScore(scorePerSolution);
        }
    }


    private int getScoreBetweenBases(String a, String b) {
    	return input.scores.get(a).get(b);
	}
    
    private int getHighestScore(List<Integer> scorePerSolution) {
        return Collections.max(scorePerSolution);
    }
}



