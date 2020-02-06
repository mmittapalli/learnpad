package lambdas;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class CollectionsTest {

	//
	public static void main(String[] args) {
		Consumer<String> print = System.out::println;
		List<String> names = asList("Raj", "Sundar", "Nawab", "Sudeer");
		Optional<Book> optionalBook = Optional.empty();

		optionalBook.ifPresent(System.out::println);
		print.accept("optional book=>" + optionalBook);

		Optional<String> s = Optional.of("test");
		List<List<String>> list = asList(
				asList("a"),
				asList("b"));
		System.out.println("before list:" + list);
		list.stream().flatMap(Collection::stream).collect(Collectors.toList());
		System.out.println("after list:" + list);

		Set<Integer> numbers = new HashSet<>(asList(1, 2, 2, 4, 54, 4));
		print.accept("set:" + numbers.toString());


		//prior to Lambda expressions
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return b.compareTo(a);
			}
		});

		//with lambda
		Collections.sort(names, (String a, String b) -> {
			return b.compareTo(a);
		});

		//lambda with inference
		Collections.sort(names, (a, b) -> b.compareTo(a));

		Book book1 = new Book("Harry Potter", 321, "John", "Smith");
		Book book2 = new Book("Children's songs", 150, "Alex", "Carey");
		Book book3 = new Book("The cat in the hat", 254, "Chris", "Husband");

		Person p1 = new Person("vivek", 43, "M");
		Person p2 = new Person("aboo", 54, "M");
		Person p3 = new Person("lasya", 23, "F");

		//lets get averate age
		List<Person> ppl = asList(p1, p2, p3);
		print.accept("Average Age:" + ppl.stream().mapToInt(Person::getAge).average());

		List<Person> onlyMales = ppl.stream().filter(p -> p.getGender().equals("M")).collect(Collectors.toList());
		print.accept("Only males:" + onlyMales);

		List<Person> onlyFemales = ppl.stream().filter(p -> p.getGender().equals("F")).collect(Collectors.toList());
		print.accept("Only Females:" + onlyFemales);

		List<Book> books = asList(book1, book2, book3);
		int totalPages = books.stream().collect(Collectors.summingInt(Book::getPages));
		int pages = books.stream().mapToInt(Book::getPages).sum();
		System.out.println("totalPages:" + totalPages);
		System.out.println("pages:" + pages);
		List<String> authorFirstNames = books.stream().map(Book::getAuthFirstName).collect(Collectors.toList());
		System.out.println(authorFirstNames);


	}
}
