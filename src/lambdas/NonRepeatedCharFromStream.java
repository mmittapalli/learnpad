package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepeatedCharFromStream {

	public static void main(String[] args) {
		//find the first non-repeating character from stream of characters
		String s = "williams sonoma";
		List<Character> DLL = new LinkedList<>();
		boolean[] repeated = new boolean[256];

		for (char i = 0; i < s.length(); i++) {
			char x = s.charAt(i);
			System.out.println("Reading " + x + " from stream s");
			//only if it is not in the repeated
			if (!repeated[x]) {
				if (!DLL.contains(x)) {
					DLL.add(x);
				} else {
					DLL.remove((Character) x);
					repeated[x] = true;
				}

			}
		}
		System.out.println(DLL.get(0));
	}

}
