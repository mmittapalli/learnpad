package DataStructures.allstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeStringArrays {

	public static void main(String[] args) {
		String[] x = {"a", "b", "h"};
		String[] y = {"b", "c", "j"};

		String[] result = mergeUsingArrys(x, y, 3);
		printArray(result);
	}

	private static String[] merge(String[] x, String[] y, int n) {
		String[] z = new String[n];
		int xi = 0;
		int yi = 0;
		for (int i = 0; i < n; i++) {
			if (x[xi].compareTo(y[yi]) < 0) {
				z[i] = x[xi];
				xi++;
			} else if (x[xi].compareTo(y[yi]) >= 0) {
				z[i] = y[yi];
				yi++;
			} else {
				z[i] = x[xi];
				xi++;
			}
		}
		return z;
	}

	private static String[] mergeUsingArrys(String[] x, String[] y, int n) {
		String[] z = new String[n];
		List<String> combined = new ArrayList<>();
		combined.addAll(Arrays.asList(x));
		combined.addAll(Arrays.asList(y));
		Collections.sort(combined);
		for (int i = 0; i < n; i++) {
			z[i] = combined.get(i);
		}
		return z;
	}

	private static void printArray(String[] xx) {
		for (String aXx : xx) {
			System.out.println(aXx);
		}
	}
}
