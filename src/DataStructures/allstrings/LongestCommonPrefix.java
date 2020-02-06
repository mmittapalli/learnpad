package DataStructures.allstrings;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = new String[]{"leets", "leetcode", "leet", "leeds"};
		System.out.println(lcp(strs));
	}
//	public static String longestCommonPrefix(String[] strs) {
//		if (strs.length == 0) return "";
//		String prefix = strs[0];
//		for (int i = 1; i < strs.length; i++)
//			while (strs[i].indexOf(prefix) != 0) {
//				prefix = prefix.substring(0, prefix.length() - 1);
//				if (prefix.isEmpty()) return "";
//			}
//		return prefix;
//	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) return "";
		String pref = strs[0];
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(pref) != 0) { //0 means pref is a substring of str[i]
				pref = strs[i].substring(0, pref.length() - 1);
				if (pref.isEmpty()) return "";
			}
		}
		return pref;
	}

	private static String lcp(String[] input) {
		if (input.length == 0) return "";
		String pref = input[0];
		for (int i = 1; i < input.length; i++) {
			while (input[i].indexOf(pref) != 0) {
				pref = input[i].substring(0, pref.length() - 1);
				if (pref.length() == 0) return "";
			}
		}
		return pref;
	}
}
