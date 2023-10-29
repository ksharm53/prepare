package Apr1;

public class MakeSubKSumEqual {

	public static void main(String[] args) {
		int[] arr = { 1, 7, 9, 6 };
		int k = 2;
		System.out.println(solve(arr, k));
	}

	private static long solve(int[] arr, int k) {

		if (k == 1) {
			int kSum = 0;
			int res = 0;
			double min = Double.MAX_VALUE;
			int median = -1;
			for (int i : arr) {
				kSum += i;
			}

			double avg = kSum / arr.length;
			for (int i = 0; i < arr.length; i++) {
				double temp = Math.abs((double) arr[i] - avg);
				if (temp < min) {
					min = temp;
					median = arr[i];
				}
			}

			for (int i : arr) {
				res += Math.abs(i - median);
			}

			return res;

		}

		long max = Long.MIN_VALUE;
		long min = Long.MAX_VALUE;

		long sum = 0;
		int idx = 0;

		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {

				while (idx < arr.length && k > 0) {
					sum += arr[idx];
					idx++;
					k--;
				}

				max = Math.max(max, sum);
				min = Math.min(min, sum);
			} else {
				sum -= arr[i - 1];
				int next = idx % arr.length;
				idx++;

				sum += arr[next];

				max = Math.max(max, sum);
				min = Math.min(min, sum);
			}
		}
		return max - min;
	}

}
