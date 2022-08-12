package azPcise;

public class MaxProfit {

	public static void main(String[] args) {
		int[] profit = { 1, 5, 1, 3, 7, -3 };
		System.out.println(efficientHarvest(profit, 2));
	}

	public static int efficientHarvest(int[] arr, int k) {
		int ans = Integer.MIN_VALUE, i = 0, j = 0, sum = 0;
		while (j < arr.length) {
			sum += arr[j] + arr[(j + arr.length / 2) % arr.length];
			if (j - i + 1 == k) {
				ans = Math.max(ans, sum);
				sum -= arr[i] + arr[(i + arr.length / 2) % arr.length];
				++i;
			}
			++j;
		}
		return ans;
	}

}
