package jan2023;

import java.util.HashSet;
import java.util.Set;

public class Exam1 {

	public static void main(String[] args) {
		int n = 5;
		System.out.println(distinctIntegers(n));

	}

	private static int distinctIntegers(int n) {
		Set<Integer> set = new HashSet<>();
		Set<Integer> innerSet = new HashSet<>();
		innerSet.add(n);
		set.add(n);
		upper: while (true) {
			int size = set.size();
			for (int each : set) {
				for (int j = 1; j <= n; j++) {
					if (each % j == 1) {
						innerSet.add(j);
					}
				}

			}
			if (size == innerSet.size()) {
				break upper;
			}
			set.addAll(innerSet);
		}
		return set.size();
	}

}
