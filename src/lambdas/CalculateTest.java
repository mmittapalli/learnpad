package lambdas;

import java.util.function.Consumer;

public class CalculateTest {


	public static void main(String[] args) {
		Consumer<String> print = System.out::println;

		Calculate add = (x, y) -> x + y;
		Calculate divide = (x, y) -> y == 0 ? 0 : x / y;

		print.accept("Addition of 2, 3=>" + add.calculate(2, 3));
		print.accept("10 divide by 5=>" + divide.calculate(10, 5));
		print.accept("5 divide by 0=>" + divide.calculate(5, 0));
	}
}
