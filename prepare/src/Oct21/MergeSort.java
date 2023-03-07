package Oct21;

public class MergeSort {

	public static void main(String[] args) {
		int[] nums = { 2, 0, 2, 1, 1, 0 };
		solve(nums, 0, nums.length - 1);
		System.out.println(nums);
		System.out.println("print");
	}

	private static void solve(int[] nums, int start, int end) {
		if (start > end) {
			return;
		}

		int mid = (start + end) / 2;
		solve(nums, start, mid - 1);
		solve(nums, mid + 1, end);

		merge(nums, start, mid, end);
	}

	private static void merge(int[] nums, int start, int mid, int end) {
		int leftSize = mid - start + 1;
		int right = end - mid;

		int[] leftArray = new int[leftSize];
		int[] rightArray = new int[right];

		int leftCounter = 0;
		for (int i = start; i <= mid; i++) {
			leftArray[leftCounter] = nums[i];
			leftCounter++;
		}

		int rightCounter = 0;
		for (int j = mid + 1; j < end; j++) {
			rightArray[rightCounter] = nums[j];
			rightCounter++;
		}

		int i = 0;
		int j = 0;
		int k = start;

		while (i < leftSize && j < right) {
			if (leftArray[i] <= rightArray[j]) {
				nums[k] = leftArray[i];
				i++;
			} else {
				nums[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while (i < leftSize) {
			nums[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < right) {
			nums[k] = rightArray[j];
			j++;
			k++;
		}

	}

}
