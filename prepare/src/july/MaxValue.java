package july;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MaxValue {

	public static void main(String[] args) {
		List<Integer> nums = List.of(3, 3, 3, 3, 7, 2, 2);

		System.out.println(solve(nums));

	}

	private static int solve(List<Integer> nums) {
		Map<Integer, Integer> freq = new HashMap<>();
		for (int i : nums) {
			freq.put(i, freq.getOrDefault(i, 0) + 1);
		}
		int listDominants = -1;
		for (Entry<Integer, Integer> each : freq.entrySet()) {
			if ((each.getValue() * 2) > nums.size()) {
				listDominants = each.getKey();
				break;
			}
		}
		int left = 0;
		int right = freq.get(listDominants);

		for (int i = 0; i < nums.size(); i++) {
			if (nums.get(i) == listDominants) {
				left++;
				right--;
			}
			if (((left * 2) > i + 1) && (right * 2) > nums.size() - i - 1) {
				return i;
			}

		}

		return -1;
	}

}
