package mar01;

public class SortedSquares {

	public static void main(String[] args) {
		int[] nums = { -5, -3, -2, -1 };
		System.out.println(sortedSquares(nums));
	}

	public static int[] sortedSquares(int[] nums) {
		int right = 0;
		int[] arr = new int[nums.length];
		int counter = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= 0) {
				right = i;
				break;
			}
		}

		int left = right - 1;
		while (left >= 0 && right < nums.length) {
			if ((nums[left] * nums[left]) < (nums[right] * nums[right])) {
				arr[counter] = (nums[left] * nums[left]);
				left--;
				counter++;
			}

			else if ((nums[right] * nums[right]) < (nums[left] * nums[left])) {
				arr[counter] = (nums[right] * nums[right]);
				right++;
				counter++;
			} else if ((nums[right] * nums[right]) == (nums[left] * nums[left])) {
				arr[counter] = (nums[left] * nums[left]);
				counter++;
				left--;
				arr[counter] = (nums[right] * nums[right]);
				counter++;
				right++;
			}
		}

		while (left >= 0) {
			arr[counter] = (nums[left] * nums[left]);
			left--;
			counter++;
		}

		while (right < nums.length) {
			arr[counter] = (nums[right] * nums[right]);
			right++;
			counter++;
		}
		return arr;
	}

}
