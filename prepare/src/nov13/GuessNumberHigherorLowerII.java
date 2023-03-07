package nov13;

public class GuessNumberHigherorLowerII {

	public static void main(String[] args) {
		int n = 10;
		int low = 1;
		int mid = low + (n - low) / 2;
		System.out.println(solve(low, mid, n));

	}

	private static int solve(int low, int mid, int high) {
		if (low > high) {
			return 0;
		}
		if (mid == high) {
			return 0;
		}
		int leftMid = low + (mid - 1 - low) / 2;
		int rightMid = mid + 1 + (high - mid - 1) / 2;
		return Math.max(mid + solve(low, leftMid, mid - 1), mid + solve(mid + 1, rightMid, high));

	}

}
