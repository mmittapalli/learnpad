package DataStructures.allstrings;

import java.util.function.Consumer;

public class Anagram {

	public static void main(String[] args) {
		Consumer<String> print = System.out::println;
		print.accept("" + isAnagram("test", "testt"));
		print.accept("" + isAnagram("anagram", "nagaram"));
	}

	//	private static boolean isAnagram(String s, String t) {
//		if (s.length() != t.length()) return false;
//		int[] counter = new int[26];
//		for (int i = 0; i < s.length(); i++) {
//			counter[s.charAt(i) - 'a']++;
//			counter[t.charAt(i) - 'a']--;
//		}
//		for (int count : counter) {
//			if (count != 0) return false;
//		}
//		return true;
//	}
	//
	static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) return false;
		int[] counter = new int[26];
		for (int i = 0; i < s.length(); i++) {
			counter[s.charAt(i) - 'a']++;
			counter[t.charAt(i) - 'a']--;
		}
		for (int count : counter) {
			if (count != 0) return false;
		}
		return true;
	}
}
