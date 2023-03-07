package feb07;

public class LeftRigthDifference {

	public static void main(String[] args) {
		int[] nums = { 10, 4, 8, 3 };
		System.out.println(leftRigthDifference(nums));
	}

	public static int[] leftRigthDifference(int[] nums) {
		int[] answer = new int[nums.length];
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				left[i] = 0;
			} else {
				left[i] = sum;
			}
			sum += nums[i];
		}

		sum = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (i == nums.length - 1) {
				right[i] = 0;
			} else {
				right[i] = sum;
			}
			sum += nums[i];
		}

		int len = nums.length;
		for (int i = 0; i < len; i++) {
			answer[i] = Math.abs(left[i] - right[i]);
		}

		return answer;
	}

}
