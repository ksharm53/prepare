package may1;

public class NumOfSubarrays {

	public static void main(String[] args) {
		int[] arr = { 2, 2, 2, 2, 5, 5, 5, 8 };
		int k = 3;
		int threshold = 4;

		System.out.println(solve(arr, k, threshold));

	}

	private static int solve(int[] arr, int k, int threshold) {
		int i = 0;
		int j = 0;

		int count = 0;
		int res = 0;

		while (j < arr.length) {
			count += arr[j];

			if (j - i + 1 == k) {
				if ((double) count / (double) k >= threshold) {
					res++;
				}
				count -= arr[i];
				i++;
			}

			j++;
		}

		return res;
	}

}
