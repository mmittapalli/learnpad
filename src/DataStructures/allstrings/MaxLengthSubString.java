package DataStructures.allstrings;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MaxLengthSubString {

	public static void main(String[] args) {
		Consumer<String> print = System.out::println;
		print.accept("bbbbb:" + lengthOfLongestSubstring("bbbbb"));
		print.accept("abcabcbb:" + lengthOfLongestSubstring("abcabcbb"));
	}

	public static int lengthOfLongestSubstring(String s) {
		List<Character> list = new ArrayList<>();
		//maintain two pointers, left and right..slide the right until you see a dup, max=right-left+1
		int l = 0, r = 0;
		int len = s.length();
		int maxLen = 1;
		while (r < len) {
			char c = s.charAt(r);
			if (!list.contains(c)) {
				list.add(c);
				r++;
				if (r == len && r - l > maxLen) maxLen = r - l + 1;
			} else {
				list = new ArrayList<>();
				if (r - l > maxLen)
					maxLen = r - l;
				l++;
				r = l;

			}
		}
		return maxLen;
	}
}
