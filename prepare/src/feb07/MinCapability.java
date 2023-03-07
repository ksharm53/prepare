package feb07;

public class MinCapability {

	public static int minNeeded;

	public static void main(String[] args) {
		int[] nums = { 2, 3, 5, 9 };
		int k = 2;
		System.out.println(solve(nums, k));
	}

	private static int solve(int[] nums, int k) {
		int end = Integer.MIN_VALUE;
		int start = Integer.MAX_VALUE;
		minNeeded = k;
		for (int i : nums) {
			end = Math.max(end, i);
			start = Math.min(start, i);
		}

		while (start <= end) {
			int mid = start + (end - start) / 2;
			boolean res = validate(nums, mid, k);
			if (res) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}

		return start;

	}

	private static boolean validate(int[] nums, int mid, int k) {
		int takes = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= mid) {
				i++;
				takes++;
			}
		}
		if (takes >= k) {
			return true;
		} else {
			return false;
		}
	}

}
