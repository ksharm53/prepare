package airport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class MaximizetheTopmostElementAfterKMoves {

	public static void main(String[] args) {

		int[] nums = { 99, 95, 68, 24, 18 };
		int k = 69;

		System.out.println(solve(nums, k));

	}

	private static int solve(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		List<Integer> list = new ArrayList<>(IntStream.of(nums).boxed().toList());
		while (k > 0) {
			if (k == 1) {
				if (!pq.isEmpty() && pq.peek() > list.get(0)) {
					list.add(0, pq.poll());
				} else {
					pq.add(list.get(0));
					list.remove(0);
				}
			} else {
				pq.add(list.get(0));
				list.remove(0);
			}
			k--;
		}
		return list.isEmpty() ? -1 : list.get(0);
	}

}
