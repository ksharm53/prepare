package aug;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MinimumSum {

	public static void main(String[] args) {
		int n = 2, k = 6;
		System.out.println(solve(n, k));

	}

	private static int solve(int n, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int val = 1;
		while (map.size() < n) {
			if (!map.containsKey(k - val)) {
				map.put(val, 1);

			}
			val++;
		}

		int sum = 0;

		for (Entry<Integer, Integer> eachEntry : map.entrySet()) {
			sum += eachEntry.getKey();
		}

		return sum;
	}

}
