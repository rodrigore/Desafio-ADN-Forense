package main;

import io.FileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import InputData.InputData;
import InputData.Suspect;
import SequenceAlignment.BestSuspect;
import SequenceAlignment.SequenceAlignment;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class app {

	public static void main(String[] args) throws IOException, InterruptedException {

		int cores = Runtime.getRuntime().availableProcessors();
		List<SequenceAlignment> s = new ArrayList<SequenceAlignment>();
		Map<String, BestSuspect> bufferBestSuspect = new HashMap<String, BestSuspect>();
		Table<String,String,Integer> scoresDNA = HashBasedTable.create();
		
		InputData input = FileRepository.load(args[0]);
	
		for (int i = 0; i < cores; i++) {
			InputData id = new InputData();	
			id.setEvidence( input.getEvidence() );
			id.setScores( input.getScores() );
			s.add( new SequenceAlignment(id, bufferBestSuspect, scoresDNA) );
		}
		
		//  Round Robbin
		Iterator<Suspect> it = input.suspects.iterator();
		int j = 0;
		while (it.hasNext()) {
			Suspect su = it.next();
			SequenceAlignment sa = s.get(j);
			sa.input.suspects.add(su);
			j++;
			if ( j == cores ) {
				j = 0;
			}
		}
       
        for (int i = 0; i < cores; i++) {
        	Thread th = new Thread(s.get(i) , String.valueOf(i));
            th.start();
            th.join();
        }
        
        boolean first = true;
        Iterator<Entry<String, BestSuspect>> itBestScores = bufferBestSuspect.entrySet().iterator();
        BestSuspect best = null;
        while (itBestScores.hasNext()) {
        	Map.Entry<String,  BestSuspect> e =  itBestScores.next();
        	BestSuspect b = e.getValue();  
        	if (first) {
        		best = new BestSuspect(b.getSuspect(), b.getScore());
        		first = false;
        	} else if ( best.getScore() < b.getScore()) {
        		best = b;        		
        	}
        }
        
        System.out.println( "El culpable es el numero:" + best.getSuspect().getId() + " (" + best.getSuspect().getAdn() + ")");
		
	}



}
