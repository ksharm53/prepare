package may1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxProfitAssignment {

	public static void main(String[] args) {
		int[] difficulty = { 68, 35, 52, 47, 86 };
		int[] profit = { 67, 17, 1, 81, 3 };
		int[] worker = { 92, 10, 85, 84, 82 };

		System.out.println(solve(difficulty, profit, worker));

	}

	private static int solve(int[] difficulty, int[] profit, int[] worker) {
		List<int[]> list = new ArrayList<>();
		int count = 0;

		for (int i = 0; i < profit.length; i++) {
			list.add(new int[] { profit[i], difficulty[i] });
		}

		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0];
			}

		});

		List<Integer> diff = new ArrayList<>();
		List<Integer> profitL = new ArrayList<>();

		for (int[] each : list) {
			diff.add(each[1]);
			profitL.add(each[0]);
		}

		for (Integer each : worker) {
			for (int i = 0; i < diff.size(); i++) {
				if (diff.get(i) <= each) {
					count += profitL.get(i);
					break;
				}
			}
		}

		return count;
	}

}
