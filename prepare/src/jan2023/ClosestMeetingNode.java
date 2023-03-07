package jan2023;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ClosestMeetingNode {

	public static void main(String[] args) {

		int[] edges = { 4, 4, 4, 5, 1, 2, 2 };
		int node1 = 1;
		int node2 = 1;

		System.out.println(solve(edges, node1, node2));

	}

	private static int solve(int[] edges, int node1, int node2) {
		int dist1[] = new int[edges.length];
		int dist2[] = new int[edges.length];
		Arrays.fill(dist1, -1);
		Arrays.fill(dist2, -1);
		int min = Integer.MAX_VALUE;
		int result = -1;

		bfs(edges, dist1, node1);
		bfs(edges, dist2, node2);

		for (int i = 0; i < dist1.length; i++) {
			if (dist1[i] == -1 || dist2[i] == -1) {
				continue;
			}
			int max = Math.max(dist1[i], dist2[i]);
			if (max < min) {
				min = max;
				result = i;
			}

		}
		return result;
	}

	private static void bfs(int[] edges, int[] dist1, int node1) {
		Set<Integer> set = new HashSet<>();
		dist1[node1] = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node1);
		int counter = 0;
		while (!queue.isEmpty()) {
			counter++;
			int level = queue.size();
			for (int i = 0; i < level; i++) {
				int val = queue.poll();
				set.add(val);
				if (val < edges.length && edges[val] != -1 && edges[val] < dist1.length && !set.contains(edges[val])) {
					dist1[edges[val]] = counter;
					queue.add(edges[val]);
				}
			}
		}

	}

}
