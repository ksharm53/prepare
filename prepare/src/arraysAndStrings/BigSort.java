package arraysAndStrings;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BigSort {

	public static void main(String[] args) {
		List<String> unsorted = Arrays.asList("31415926535897932384626433832795", "1", "3", "10", "3", "5");

		System.out.println(solve(unsorted));

		System.out.println(solveAgain(unsorted));

	}

	private static List<String> solveAgain(List<String> unsorted) {

		Collections.sort(unsorted, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() > o2.length())
					return 1;
				if (o1.length() < o2.length())
					return -1;
				for (int i = 0; i < o1.length(); i++) {
					if ((int) o1.charAt(i) > (int) o2.charAt(i))
						return 1;
					if ((int) o1.charAt(i) < (int) o2.charAt(i))
						return -1;
				}
				return 0;
			}
		});

		return unsorted;
	}

	private static List<String> solve(List<String> unsorted) {
		BigInteger[] array = new BigInteger[unsorted.size()];
		List<String> result = new ArrayList<>();

		for (int i = 0; i < unsorted.size(); i++) {
			array[i] = new BigInteger(unsorted.get(i));
		}

		Arrays.sort(array);

		for (BigInteger l : array) {
			result.add(String.valueOf(l));
		}

		return result;
	}

}
