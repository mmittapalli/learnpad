package lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {

		List<City> cities = Arrays.asList(new City("Austin", "TX", 10000), new City("Houston", "TX", 20000),
		                                  new City("Pittsburgh", "PA", 15000), new City("Phoenix", "AZ", 50000));


		cities.sort(Comparator.comparing(City::getName));
		cities.sort(Comparator.comparing(City::getPopulation));
//		cities.sort(Comparator.reversed());

		System.out.println(cities);

		List<City> txCities = cities.stream()
		                            .filter(x -> x.population > 10000)
		                            .collect(Collectors.toList());

		txCities.forEach(System.out::println);

		System.out.println(cities.stream()
		                         .collect(Collectors.toMap(City::getName, Function.identity())));

		Arrays.asList("red", "blue", "green").stream()
		      .sorted()
		      .findFirst()
		      .ifPresent(System.out::println);

		Stream.of("apple", "banana", "apricot", "orange")

//		      .filter(fruit-> fruit.startsWith("a"))
          .filter(fruit -> {
	          System.out.println("in filter:" + fruit);
	          return fruit.startsWith("a");
          })
          .forEach(fruit -> System.out.println("fruits starting with a:" + fruit));

		List<String> coll = Stream.of("Java", "Rocks")
		                          .map(String::toUpperCase)
		                          .collect(Collectors.toList());

		System.out.println(coll.toString());

		IntStream.range(1, 4)
		         .forEach(System.out::println);

		IntStream.of(new int[]{3, 4, 6, 8})
		         .map(n -> n * n)
		         .average()
		         .ifPresent(System.out::println);

		Stream.of(3.5, 6.2, 3.7, 8.0, 1.2)
		      .mapToInt(Double::intValue)
		      .forEach(System.out::println);
	}

	static class City {
		String name;
		String state;
		double population;

		public City(String name, String state, double population) {
			this.name = name;
			this.state = state;
			this.population = population;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public double getPopulation() {
			return population;
		}

		public void setPopulation(double population) {
			this.population = population;
		}

		@Override
		public String toString() {
			return this.getName() + " " + this.getState() + " " + this.getPopulation();
		}
	}
}
