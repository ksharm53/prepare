package august23;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrimeFactorVisitation {

	public static void main(String[] args) {
		int[] initialStates = { 0, 1, 1, 0, 1, 1, 0, 1, 1, 1 };
		int[] numbers = { 3, 8, 6 };

		System.out.println(solve(initialStates, numbers));

	}

	private static int[] solve(int[] initialStates, int[] numbers) {

		for (int i = 0; i < numbers.length; i++) {
			int eachValue = numbers[i];
			List<Integer> primes = findPrime(eachValue);
			for (Integer integer : primes) {
				for (int j = integer; j <= initialStates.length; j = j + integer) {
					if (initialStates[j - 1] == 1) {
						initialStates[j - 1] = 0;
					} else {
						initialStates[j - 1] = 1;
					}
				}
			}

		}
		return initialStates;

	}

	private static List<Integer> findPrime(int eachValue) {
		Set<Integer> list = new HashSet<>();

		for (int i = 2; i < eachValue; i++) {
			while (eachValue % i == 0) {
				list.add(i);
				eachValue = eachValue / i;
			}
		}
		if (eachValue > 2) {
			list.add(eachValue);
		}
		return new ArrayList<>(list);

	}

}
