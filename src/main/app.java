package main;

import io.FileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import InputData.InputData;
import InputData.Suspect;
import SequenceAlignment.SequenceAlignment;

public class app {

	public static void main(String[] args) throws IOException {
		
		//System.out.println("File" + args[1]);
		InputData input = FileRepository.load(args[0]);
//		input = fakeData(); 
		
//		Iterator it = input.scores.entrySet().iterator();
//		while (it.hasNext()) {
//			Map.Entry<String, Map> e = (Map.Entry)it.next();
//			String letter = e.getKey().toString();
//			Map scores = (Map)e.getValue();
//			Iterator it2 = scores.entrySet().iterator();
//			while (it2.hasNext()) {
//				Map.Entry<String, Integer> e2 = (Map.Entry)it2.next();
//				String l2 = e2.getKey().toString();
//				System.out.println( letter + " " + l2 + " "  + e2.getValue().toString());
//			}
//		}
		
		SequenceAlignment sa = new SequenceAlignment(input);
		sa.run();
		
	}

	private static InputData fakeData() {
		InputData input = new InputData();
		input.evidence = "AGTGATG";
		
		input.scores = new HashMap<String, Map<String, Integer>>();
		Map<String, Integer> s = new LinkedHashMap<String, Integer>();
		s.put("A", 5);
		s.put("C", -1);
		s.put("G", -2);
		s.put("T", -1);
		s.put("-", -3);
		input.scores.put("A", s);
		
		s = new LinkedHashMap<String, Integer>();
		s.put("A", -1);
		s.put("C", 5);
		s.put("G", -3);
		s.put("T", -2);
		s.put("-", -4);
		input.scores.put("C", s);
		
		s = new LinkedHashMap<String, Integer>();
		s.put("A", -2);
		s.put("C", -3);
		s.put("G", 5);
		s.put("T", -2);
		s.put("-", -2);
		input.scores.put("G", s);
		
		s = new LinkedHashMap<String, Integer>();
		s.put("A", -1);
		s.put("C", -2);
		s.put("G", -2);
		s.put("T", 5);
		s.put("-", -1);
		input.scores.put("T", s);
		
		s = new LinkedHashMap<String, Integer>();
		s.put("A", -3);
		s.put("C", -4);
		s.put("G", -2);
		s.put("T", -1);
		s.put("-", 0);
		input.scores.put("-", s);
		
		input.suspects = new ArrayList<Suspect>();
		Suspect s1 = new Suspect(1, "AAATGC");
		Suspect s2= new Suspect(2, "AGGAA");
		Suspect s3= new Suspect(3, "AGTGATA");
		Suspect s4= new Suspect(4, "GATTACA");
		
		input.suspects.add(s1);
		input.suspects.add(s2);
		input.suspects.add(s3);
		input.suspects.add(s4);
		return input;
		
	}

}
