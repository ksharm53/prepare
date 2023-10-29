package aug;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestEqualSubarray {

	public static void main(String[] args) {
		List<Integer> nums = List.of(1, 1, 2, 2, 1, 1);
		int k = 2;

		System.out.println(solve(nums, k));

	}

	private static int solve(List<Integer> nums, int k) {
		int maxLength = 0;
		int maxCount = 0;
		Map<Integer, Integer> countMap = new HashMap<>();

		for (int right = 0; right < nums.size(); right++) {
			int num = nums.get(right);
			countMap.put(num, countMap.getOrDefault(num, 0) + 1);
			maxCount = Math.max(maxCount, countMap.get(num));

			int windowSize = right + 1;
			int remainingElements = windowSize - maxCount;

			while (remainingElements > k) {
				int leftNum = nums.get(right - windowSize + 1);
				countMap.put(leftNum, countMap.get(leftNum) - 1);
				maxCount = Math.max(maxCount, countMap.get(leftNum));
				windowSize--;
				remainingElements = windowSize - maxCount;
			}

			maxLength = Math.max(maxLength, windowSize);
		}

		return maxLength - k;
	}

}
