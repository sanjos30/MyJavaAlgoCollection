package com.sanjos30.helper;
/**
 * 
 * A helper class for String.
 */
import java.util.LinkedHashMap;
import java.util.Map;

public class StringHelper {

	public static void main(String args[]) {
		System.out.println(isSubSequence("apples", "abplesc"));
	}

	/**
	 * Check if the string is numeric - returns true if yes
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isNumeric(String s) {
		return s != null && s.matches("[-+]?\\d*\\.?\\d+");
	}

	public static boolean isAlphaNumericString(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isDigit(c))
				return true;
		}

		return false;
	}

	public static Character findFirstNonRepeatingCharInString(String str) {

		Map<Character, Integer> charCountMap = charCountInInputString(str);

		for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return null;
	}

	public static Map<Character, Integer> charCountInInputString(String str) {
		Map<Character, Integer> charCountMap = new LinkedHashMap<Character, Integer>();
		int max_so_far = 0;
		char max_char = ' ';
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!charCountMap.containsKey(c)) {
				charCountMap.put(c, 1);
				if (max_so_far < 1) {
					max_so_far = 1;
					max_char = c;
				}
			} else {
				int curCount = charCountMap.get(c) + 1;
				charCountMap.put(c, curCount);
				if (max_so_far < curCount) {
					max_so_far = curCount;
					max_char = c;
				}
			}
		}

		System.out.println("Max count " + max_so_far);
		return charCountMap;
	}

	public static int[] findUniqueCharPrefixSum(String str) {
		int[] strPrefixSum = new int[str.length()];

		return strPrefixSum;
	}

	public static boolean isAnagram(String s1, String s2) {
		boolean isAnagram = true;
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		int[] letterCount = new int[26];
		// int[] letterCount2 = new int[26];
		for (char c : s1.toCharArray()) {
			letterCount[c]++;
		}

		for (char c : s2.toCharArray()) {
			letterCount[c]--;
		}

		for (int i : letterCount) {
			if (i != 0)
				return false;
		}
		return isAnagram;
	}

	public static void printAnagram(String str) {
		anagram(str, "");
	}

	public static void anagram(String str, String prefix) {
		if (str.length() == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < str.length(); i++) {
				String rem = str.substring(0, i) + str.substring(i + 1);
				anagram(rem, prefix + str.charAt(i));
			}
		}
	}

	public static boolean isStringPalindrome(String word) {
		int n = word.length();
		for (int i = 0; i < n; i++, n--) {
			if (word.charAt(i) != word.charAt(n - 1)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSubSequence(String word, String inputStr) {
		int m = word.length();
		int n = inputStr.length();
		char[] dictArray = word.toCharArray();
		char[] inputArr = inputStr.toCharArray();

		int j = 0;

		for (int i = 0; i < n && j < m; i++) {
			char d1 = dictArray[j];
			char i1 = inputArr[i];
			if (dictArray[j] == inputArr[i])
				j++;

		}
		// If all characters of str1 were found in str2
		return (j == m);
	}

}
