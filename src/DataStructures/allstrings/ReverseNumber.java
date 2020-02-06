package DataStructures.allstrings;

public class ReverseNumber {
	public static void main(String[] args) {
		System.out.println(reverse(-123));
	}

	public static int reverse(int x) {
		int rev = 0;
		int temp = 0;
		while (x > 0) {
			temp = x % 10;
			x = x / 10;
			rev = rev * 10 + temp;
		}
		return rev;
	}
}
