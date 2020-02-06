package lambdas;

@FunctionalInterface
public interface Calculate {
	public int calculate(int x, int y);

	default double add(double x, double y) {
		return x + y;
	}

	default float multiply(int x, int y) {
		return x * y;
	}
}
