package dec;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MinCost {

	public static void main(String[] args) {
		int[] basket1 = { 4, 4, 4, 4, 3 };
		int[] basket2 = { 5, 5, 5, 5, 3 };
		System.out.println(solve(basket1, basket2));

	}

	private static long solve(int[] basket1, int[] basket2) {
		Arrays.sort(basket1);
		Arrays.sort(basket2);
		long count = 0;

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < basket1.length; i++) {
			if (basket1[i] != basket2[i]) {
				map.put(basket1[i] + "-" + basket2[i], map.getOrDefault(basket1[i] + "-" + basket2[i], 0) + 1);
			}
		}

		for (Entry<String, Integer> eachEntry : map.entrySet()) {
			if (eachEntry.getValue() % 2 != 0) {
				return -1;
			}
			String key = eachEntry.getKey();
			String[] arr = key.split("-");
			int min = Math.min(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]));
			count += min * (eachEntry.getValue() / 2);
		}
		return count;
	}

}
