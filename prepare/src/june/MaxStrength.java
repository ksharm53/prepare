package june;

import java.util.ArrayList;
import java.util.List;

public class MaxStrength {

	public static void main(String[] args) {
		int[] nums = { -2, 0 };
		System.out.println(solve(nums, 0));
	}

	private static long solve(int[] nums, int idx) {
		int minNegative = Integer.MAX_VALUE;
		int countNegativeOne = 0;
		List<Integer> withOutZer0 = new ArrayList<>();

		if (nums.length == 1) {
			return nums[0];
		}

		for (int each : nums) {
			if (each != 0) {
				withOutZer0.add(each);
			}

			if (each < 0) {
				minNegative = Math.min(minNegative, Math.abs(each));
				if (each == -1) {
					countNegativeOne++;
				}
			}

		}

		long prod = 1;

		for (int each : withOutZer0) {
			prod *= each;
		}

		if (prod < 0) {
			prod /= minNegative;
			prod *= -1;

		}

		return prod == 1 ? (withOutZer0.contains(1) || (countNegativeOne > 0 && countNegativeOne % 2 == 0)) ? 1 : 0
				: prod;
	}

}
