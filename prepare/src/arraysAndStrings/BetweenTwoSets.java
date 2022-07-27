package arraysAndStrings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BetweenTwoSets {

	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(2, 4);
		List<Integer> b = Arrays.asList(16, 32, 96);

		System.out.println(solve(a, b));

	}

	private static int solve(List<Integer> a, List<Integer> b) {
		Collections.sort(a);
		Collections.sort(b);
		int counter = 0;

		for (int i = a.get(a.size() - 1); i <= b.get(0); i++) {
			if (isA(i, a) && isB(i, b)) {
				counter++;
			}
		}
		return counter;
	}

	private static boolean isB(int i, List<Integer> b) {
		for (Integer integer : b) {
			if (integer % i != 0) {
				return false;
			}
		}
		return true;
	}

	private static boolean isA(int i, List<Integer> a) {
		for (Integer integer : a) {
			if (i % integer != 0) {
				return false;
			}
		}
		return true;
	}

	private static int lcm(Integer first, Integer second) {
		return (first * second) / gcd(first, second);
	}

	private static int gcd(Integer first, Integer second) {
		int gcd = 1;

		for (int i = 1; i <= first && i <= second; i++) {
			if (first % i == 0 && second % i == 0) {
				gcd = i;
			}
		}
		return gcd;
	}

}
