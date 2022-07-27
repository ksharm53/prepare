package arraysAndStrings;

public class RunningSum {

	public static void main(String[] args) {
		int[] nums = {3,1,2,10,1};

		System.out.println(solve(nums));

	}

	private static int[] solve(int[] nums) {
		int currentSum = 0;

		int[] result = new int[nums.length];

		result[0] = nums[0];
		currentSum = currentSum + nums[0];

		for (int i = 1; i < nums.length; i++) {
			currentSum = currentSum + nums[i];
			result[i] = currentSum;
		}
		return result;
	}

}
