package june;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class KSmallestPairs {

	public static void main(String[] args) {
		int[] nums1 = { 1, 1, 2 };
		int[] nums2 = { 1, 2, 3 };
		int k = 10;

		System.out.println(solve(nums1, nums2, k));

	}

	private static List<List<Integer>> solve(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> res = new ArrayList<>();
		Set<String> set = new HashSet<>();

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		pq.add(new int[] { nums1[0] + nums2[0], 0, 0 });
		set.add(0 + "-" + 0);

		while (k > 0 && !pq.isEmpty()) {
			int[] val = pq.poll();
			res.add(List.of(nums1[val[1]], nums2[val[2]]));

			if (val[2] + 1 < nums2.length && !set.contains(val[1] + "-" + (val[2] + 1))) {
				pq.add(new int[] { nums1[val[1]] + nums2[val[2] + 1], val[1], val[2] + 1 });
				set.add(val[1] + "-" + (val[2] + 1));
			}

			if (val[1] + 1 < nums1.length && !set.contains((val[1] + 1) + "-" + val[2])) {
				pq.add(new int[] { nums1[val[1] + 1] + nums2[val[2]], val[1] + 1, val[2] });
				set.add((val[1] + 1) + "-" + val[2]);
			}

			k--;
		}

		return res;
	}

}
