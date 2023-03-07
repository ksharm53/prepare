package CodeSignal;

import java.util.ArrayList;
import java.util.List;

public class GiftCards {
	public static int total;

	public static void main(String[] args) {
		int N = 4;
		int M = 80;
		total = 0;
		int[] coins = { 10, 30, 50 };

		List<List<Integer>> list = new ArrayList<>();
		List<Integer> eachList = new ArrayList<>();

		solve(coins, M, list, eachList, 0, N);

		System.out.println(list);

	}

	private static void solve(int[] coins, int M, List<List<Integer>> list, List<Integer> eachList, int start, int N) {

		if (M < 0) {
			return;
		} else if (M == 0 && N == 0) {
			list.add(new ArrayList<Integer>(eachList));
			return;
		} else {
			for (int i = start; i < coins.length; i++) {
				int value = coins[i];
				eachList.add(value);
				solve(coins, M - value, list, eachList, i, N - 1);
				eachList.remove(eachList.size() - 1);
			}
		}
	}

}
