package DataStructures.allstrings;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DuplicateStrings {
	public static void main(String[] args) {
		String[] input = {"mahee", "mitta", "mahee"};
		duplicates(input);
		//String[] str = {"mahee", "mitta", "mahee"};
		//String[] out = {}
	}

	public static void duplicates(String[] input) {
		Set<String> ll = new HashSet<>();
		for (int i = 0; i < input.length; i++) {
			if (ll.contains(input[i])) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
				ll.add(input[i]);
			}
		}

	}
}
