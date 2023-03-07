package oct3;

import java.util.HashMap;
import java.util.Map;

public class PairDivideK {

	public static void main(String[] args) {
		int[] A = { 857910, 819589, 924892, 903743, 258550, 372448, 806750, 766606, 990597, 206447 };
		int K = 1;
		System.out.println(solve(A, K));
	}

	public static int solve(int[] array, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			int rem = array[i] % k;
			if (map.containsKey((k - rem) % k)) {
				sum += map.get((k - rem) % k);
			}
			map.put(rem, map.getOrDefault(rem, 0) + 1);
		}
		return sum;
	}

}
