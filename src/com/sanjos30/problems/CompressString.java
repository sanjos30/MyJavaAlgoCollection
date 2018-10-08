package com.sanjos30.problems;

import java.util.ArrayList;
import java.util.List;

public class CompressString {

	public static void main(String[] args) {
		String word = "wwwwaaadexxxxxw"; // “Expected compressed outcome:
											// w4a3d1e1x5w1”
		System.out.println("Compressing word " + "(" + word + ") .......");
		String wordCompressed = compressWord(word);
		System.out.println("Word compressed: " + wordCompressed);
		System.out.println("Descompresing word  " + "(" + wordCompressed + ") .......");
		String wordDescompressed = descompressWord(wordCompressed);
		System.out.println("Descompressed word: " + "(" + wordDescompressed + ")");
	}

	public static String compressWord(String word) {

                List<Character> chars = new ArrayList<Character>(); // Variable stores characters
		List<Integer> numberChars = new ArrayList<Integer>(); // Variable stores number of
												// repetition of characters
		int subN = 0;
		int repetitions = 0;
		int index = 0;
		String compressedWord = "";

		for (int i = subN; i < word.length(); i = subN) {
			char charToFind = word.charAt(i); // Character to find
			for (int j = i; j < word.length(); j++) {
				if (charToFind != word.charAt(j)) {
					break;
				} else {
					subN++; // String iterator
					repetitions++; // Counts how many times character is
									// repeated
				}
			}
			chars.add(charToFind);
			numberChars.add(repetitions);
			repetitions = 0; // reset repetitions
		}

		while (index < chars.size()) {
			compressedWord = compressedWord + chars.get(index) + numberChars.get(index);
			index++;
		}

		return compressedWord;
	}

	public static String descompressWord(String word) {
		String wordDescompressed = "";
		int num = 0;
		int index = 0;
		List<Integer> number = new ArrayList<Integer>();
		List<Character> chars = new ArrayList<Character>();

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) > '0' && word.charAt(i) < '9') {
				num = Integer.parseInt(""+word.charAt(i));
				number.add(num);
			} else {
				chars.add(word.charAt(i));
			}
		}

		while (index < chars.size()) {
			for (int i = 0; i < number.get(index); i++) {
				wordDescompressed = wordDescompressed + chars.get(index);
			}
			index++;
		}
		
		return wordDescompressed;
	}
}