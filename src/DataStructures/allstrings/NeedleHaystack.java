package DataStructures.allstrings;

public class NeedleHaystack {

	public static void main(String[] args) {
		System.out.println(findNeedle("mississippi", "pi"));
	}

	public static int strStr(String haystack, String needle) {
//		if(needle.isEmpty()) return 0;
//		if(haystack.isEmpty()) return -1;
//		if(haystack.startsWith(needle)) return 0;
//
//		for(int i=1; i< haystack.length(); i++){
//			if(haystack.substring(i, haystack.length()).startsWith(needle))
//				return i;
//		}
//		return -1;

		//Time to run => 1ms
		int hl = haystack.length();
		int nl = needle.length();
		if (nl == 0) return 0;
		if (hl == 0) return -1;
		if (haystack.startsWith(needle)) return 0;
		char ns = needle.charAt(0);
		for (int i = 0; i < hl; i++) {
			if (ns == haystack.charAt(i) && i + nl <= hl && haystack.substring(i, hl).startsWith(needle))
				return i;
		}
		return -1;
	}

	private static int findNeedle(String hs, String needle) {
		if (needle.isEmpty()) return 0;
		if (hs.isEmpty()) return -1;
		if (hs.startsWith(needle)) return 0;
		char c = needle.charAt(0);
		for (int i = 0; i < hs.length(); i++) {
			if (c == hs.charAt(i) && i + needle.length() <= hs.length() && hs.substring(i, hs.length()).startsWith(needle)) {
				return i;
			}
		}
		return -1;
	}

}
