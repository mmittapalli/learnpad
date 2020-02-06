package lambdas;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;

public class TerminalOpEx {

	public static void main(String[] args) {
		Consumer<String> print = System.out::println;
		int sum = Arrays.stream(new int[]{1, 3, 4}).map(i -> i * 2).sum();

		print.accept("=>" + Arrays.stream(new int[]{4, 2, 1}).map(i -> i * 3).sum());

		Arrays.stream(new int[]{10, 15, 20, 21, 44}).filter(i -> i % 5 == 0).forEach(i -> print.accept("" + i));


		print.accept("sum:" + sum);

		Map<String, List<String>> people = new HashMap<>();
		people.put("John", Arrays.asList("555-1123", "555-3389"));
		people.put("Mary", Arrays.asList("555-2243", "555-5264"));
		people.put("Steve", Arrays.asList("555-6654", "555-3242"));

		List<String> newList = people.values().stream()
		                             .flatMap(Collection::stream).collect(Collectors.toList());

		print.accept("people:" + newList);
	}
}
