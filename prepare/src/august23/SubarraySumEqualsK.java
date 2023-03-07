package august23;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 7;

		System.out.println(solveAgain(nums, k));

	}

	public static int solveAgain(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0;
		int answer = 0;
		for (int i : arr) {
			sum += i;
			if (map.containsKey(sum - k)) {
				answer += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);

		}
		return answer;

	}
}
