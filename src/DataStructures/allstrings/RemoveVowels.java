package DataStructures.allstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RemoveVowels {

	public static void main(String[] args) {
		System.out.println(removeVowels("hello balvinder"));

	}

	public static String removeVowels(String str) {
		List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");

		Predicate<String> isVowel = c -> !vowels.contains(c);

		return Arrays.stream(str.split("")).filter(isVowel).collect(Collectors.joining());
	}
}
