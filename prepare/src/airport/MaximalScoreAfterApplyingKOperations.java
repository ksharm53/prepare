package airport;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximalScoreAfterApplyingKOperations {

	public static void main(String[] args) {

		int[] nums = { 881784984, 829998714, 730002802, 56524562, 120336848, 548306998, 801116106, 828640251, 519131180,
				819176153, 476262254, 15904939, 540793851, 53572296, 259044378, 491129827, 561147559, 205793082,
				967833729 };
		int k = 16;

		System.out.println(solve(nums, k));

	}

	private static long solve(int[] nums, int k) {
		long max = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (Integer integer : nums) {
			pq.add(integer);
		}

		while (k > 0) {
			int top = pq.poll();
			max += top;
			double s = (double)top/3;
            pq.add((int)Math.ceil(s));
			k--;
		}

		return max;
	}

}
