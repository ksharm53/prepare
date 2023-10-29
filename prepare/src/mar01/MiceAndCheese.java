package mar01;

public class MiceAndCheese {

	public static void main(String[] args) {
		int[] reward1 = { 1 };
		int[] reward2 = { 4 };
		int k = 1;

		System.out.println(solve(reward1, reward2, k, reward1.length - 1));

	}

	public static int solve(int[] reward1, int[] reward2, int k, int size) {
		if (size < 0) {
			return 0;
		}

		if (k > 0) {
			int khaya = solve(reward1, reward2, k - 1, size - 1) + reward1[size];
			int naikhaya = solve(reward1, reward2, khaya, size - 1) + reward2[size];

			return Math.max(khaya, naikhaya);
		} else {
			return solve(reward1, reward2, k, size - 1) + reward2[size];
		}
	}

}
