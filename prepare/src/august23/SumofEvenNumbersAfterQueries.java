package august23;

public class SumofEvenNumbersAfterQueries {

	public static void main(String[] args) {
		int[] nums = { 1 };
		int[][] queries = { { 4, 0 } };
		System.out.println(solve(nums, queries));
	}

	private static int[] solve(int[] nums, int[][] queries) {
		int[] result = new int[nums.length];
		int sumEven = 0;

		for (int i : nums) {
			if (i % 2 == 0) {
				sumEven += i;
			}
		}

		for (int i = 0; i < queries.length; i++) {
			int[] eachQuery = queries[i];
			int previous = nums[eachQuery[1]];

			nums[eachQuery[1]] += eachQuery[0];
			int next = nums[eachQuery[1]];

			if (previous % 2 == 0 && next % 2 == 0) {
				int diff = Math.abs(previous - next);
				if (previous < next) {
					sumEven += diff;
				} else if (previous > next) {
					sumEven -= diff;
				}
			} else if (previous % 2 == 0 && next % 2 != 0) {
				sumEven -= previous;
			} else if (previous % 2 != 0 && next % 2 == 0) {
				sumEven += next;
			}
			result[i] = sumEven;
		}
		return result;

	}

}
