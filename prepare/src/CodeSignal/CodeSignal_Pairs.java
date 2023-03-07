package CodeSignal;

import java.util.HashMap;
import java.util.Map;

public class CodeSignal_Pairs {

	public static void main(String[] args) {
		int[] a = { 857910, 819589, 924892, 903743, 258550, 372448, 806750, 766606, 990597, 206447 };
		int k = 1;
		System.out.println(solution(a, k));

	}

	private static long solution(int[] a, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		long counter = 0;

		for (int i = 0; i < a.length; i++) {
			int rem = (a[i] + k) % k;
			map.put(rem, map.getOrDefault(rem, 0) + 1);
		}

		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(k - (a[i] % k))) {
				counter += map.get(k - (a[i] % k));
			}
		}
		if (map.containsKey(0)) {
			int val = map.get(0);
			counter += (val * (val - 1)) / 2;
		}

		return counter;
	}

}
