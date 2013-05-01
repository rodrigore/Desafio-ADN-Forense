package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import InputData.InputData;
import InputData.Suspect;
import SequenceAlignment.SequenceAlignment;

public class SequenceAlignmentTest {


	@Test
	public void test() {
		InputData input = fakeData(); 
		SequenceAlignment sa = new SequenceAlignment(input);
		List results = sa.run();
		Assert.assertEquals(11, results.get(0));
		Assert.assertEquals(16, results.get(1));
		Assert.assertEquals(28, results.get(2));
		Assert.assertEquals(5, results.get(3));
	}
	
	private static InputData fakeData() {
		InputData input = new InputData();
		input.evidence = "AGTGATG";
		input.scores = new HashMap<String, Map<String, Integer>>();
		Map<String, Integer> s = new HashMap<String, Integer>();
		s.put("A", 5);
		s.put("C", -1);
		s.put("G", -2);
		s.put("T", -1);
		s.put("-", -3);
		input.scores.put("A", s);
		
		s = new HashMap<String, Integer>();
		s.put("A", -1);
		s.put("C", 5);
		s.put("G", -3);
		s.put("T", -2);
		s.put("-", -4);
		input.scores.put("C", s);
		
		s = new HashMap<String, Integer>();
		s.put("A", -2);
		s.put("C", -3);
		s.put("G", 5);
		s.put("T", -2);
		s.put("-", -2);
		input.scores.put("G", s);
		
		s = new HashMap<String, Integer>();
		s.put("A", -1);
		s.put("C", -2);
		s.put("G", -2);
		s.put("T", 5);
		s.put("-", -1);
		input.scores.put("T", s);
		
		s = new HashMap<String, Integer>();
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
