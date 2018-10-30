package com.sanjos30.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class CommonAncestor {
	static String recentCommonAncestor(String[] commitHashes, String[][] ancestors, String strID, String strID1)
	{
	    HashSet<String> setOfAncestorsLower = new HashSet<String>();
	    HashSet<String> setOfAncestorsUpper = new HashSet<String>();
	    String[] arrPair= {strID, strID1};
	    Arrays.sort(arrPair);
	    Comparator<String> comp = new Comparator<String>(){
	        @Override
	        public int compare(String s1, String s2) {
	           return s2.compareTo(s1);
	        }};
	    int indexUpper = Arrays.binarySearch(commitHashes, arrPair[0], comp);
	    int indexLower = Arrays.binarySearch(commitHashes, arrPair[1], comp);
	    setOfAncestorsLower.addAll(Arrays.asList(ancestors[indexLower]));
	    setOfAncestorsUpper.addAll(Arrays.asList(ancestors[indexUpper]));
	    HashSet<String>[] sets = new HashSet[] {setOfAncestorsLower, setOfAncestorsUpper};
	    for (int i = indexLower + 1; i < commitHashes.length; i++)
	    {
	        for (int j = 0; j < 2; j++)
	        {
	            if (sets[j].contains(commitHashes[i]))
	            {
	                if (i > indexUpper)
	                    if(sets[1 - j].contains(commitHashes[i]))
	                        return commitHashes[i];
	                sets[j].addAll(Arrays.asList(ancestors[i]));
	            }
	        }
	    }
	    return null;
	}

}
