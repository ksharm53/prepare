package azPcise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestEfficiency {

	public static void main(String[] args) {
		int[] skill = { 3, 1, 3, 5 };
		int k = 3;
		System.out.println(solve(skill, k));
		System.out.println(solveAgain(skill, k));
	}

	private static List<Integer> solve(int[] skill, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
		List<Integer> list = new ArrayList<>();
		if (skill.length <= 1) {
			return new ArrayList<>();
		}

		for (int i = 0; i < skill.length; i++) {
			for (int j = i + 1; j < skill.length; j++) {
				queue.add(Math.abs(skill[i] - skill[j]));
				if (queue.size() > k) {
					queue.poll();
				}
			}
		}

		for (Integer eachElement : queue) {
			list.add(eachElement);
		}
		Collections.sort(list);
		return list;
	}

	static int[] solveAgain(int[] A, int k) {
		Arrays.sort(A);
		int lo = 0, hi = (int) 1e8;
		while (lo < hi) { 
			int mid = (lo + hi + 1) >> 1, cnt = 0;
			for (int i = 0, j = 0; i < A.length; i++) {
				while (A[i] - A[j] > mid) {
					++j;
				}
				cnt += i - j;
			}
			if (cnt <= k) {
				lo = mid;
			} else {
				hi = mid - 1;
			}
		}
		int[] ans = new int[k];
		for (int i = 0, j = 0; i < A.length; i++) {
			while (A[i] - A[j] > lo) {
				++j;
			}
			for (int s = j; s < i; s++) {
				ans[--k] = A[i] - A[s];
			}
		}
		while (k > 0) {
			ans[--k] = lo + 1;
		}
		Arrays.sort(ans);
		return ans;
	}

}
