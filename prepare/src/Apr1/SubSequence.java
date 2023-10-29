package Apr1;

import java.util.List;

public class SubSequence {

	public static void main(String[] args) {

		int sum = 9;
		int count = 15;
		List<Integer> list = List.of(30, 4, 1, 4, 6, 7, 13, 10, 8, 1, 2, 2, 4, 13, 28);

		System.out.println(solve(sum, list, count - 1));

	}

	private static int solve(int sum, List<Integer> list, int idx) {

		if (sum == 0) {
			return 1;
		}
		if (idx < 0) {
			return 0;
		}

		if (list.get(idx) <= sum) {
			return solve(sum - list.get(idx), list, idx - 1) + solve(sum, list, idx - 1);
		} else {
			return solve(sum, list, idx - 1);
		}

	}

}
