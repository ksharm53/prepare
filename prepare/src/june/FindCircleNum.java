package june;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FindCircleNum {

	public static void main(String[] args) {
		int[][] isConnected = { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } };
		System.out.println(solve(isConnected));

	}

	private static int solve(int[][] isConnected) {
		Set<Integer> set = new HashSet<>();
		int count = 0;
		for (int i = 0; i < isConnected.length; i++) {
			if (!set.contains(i)) {
				count++;
				doBfs(i, isConnected, set);
			}
		}

		return count;
	}

	private static void doBfs(int idx, int[][] isConnected, Set<Integer> set) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(idx);
		set.add(idx);

		while (!queue.isEmpty()) {
			int val = queue.poll();
			int[] arr = isConnected[val];

			for (int i = 0; i < arr.length; i++) {
				if (i != val && isConnected[val][i] == 1 && !set.contains(i)) {
					queue.add(i);
					set.add(i);
				}
			}
		}

	}

}
