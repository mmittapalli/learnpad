/*
 * Sample program to introduce functional interfaces with lambda notation
 */
package lambdas;


import java.util.function.*;

import static java.lang.System.*;

/**
 * @author MFisher
 */
public class Lambdas_01_01 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		Consumer<String> print = out::println;

		Supplier<String> austinHo = () -> "Austin is a fun city";

		//using the test method of Predicate
		Predicate<String> stringLen = (s) -> s.length() < 10;
		print.accept(stringLen.test("Apples") + " - Apples is less than 10");
		;

		Predicate<String> stringContainsNumbers = (s) -> s.matches(".*[0-9].*");
		System.out.println(stringContainsNumbers.test("gh123hello") + " - has numbers");

		//Consumer example uses accept method
		Consumer<String> consumerStr = (s) -> System.out.println(s.toLowerCase());
		consumerStr.accept("ABCDefghijklmnopQRSTuvWxyZ");

		Consumer<String> sayHello = Lambdas_01_01::sayHelloMethod;
		sayHello.accept("Mahendar");

		//Function example
		Function<Integer, String> converter = (num) -> Integer.toString(num);
		System.out.println("length of 26: " + converter.apply(26).length());

		//Supplier example
		Supplier<String> s = () -> "Java is fun";
		System.out.println(s.get());

		//Binary Operator example
		BinaryOperator<Integer> add = (a, b) -> a + b;
		System.out.println("add 10 + 25: " + add.apply(10, 25));

		//Unary Operator example
		UnaryOperator<String> str = (msg) -> msg.toUpperCase();
		System.out.println(str.apply("This is my message in upper case"));
	}

	public static void sayHelloMethod(String s) {
		System.out.println("Hello " + s);
	}
}
