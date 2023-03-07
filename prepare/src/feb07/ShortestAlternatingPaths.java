package feb07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ShortestAlternatingPaths {

	public static void main(String[] args) {
		int n = 5;
		int[][] redEdges = { { 3, 2 }, { 4, 1 }, { 1, 4 }, { 2, 4 } };
		int[][] blueEdges = { { 2, 3 }, { 0, 4 }, { 4, 3 }, { 4, 4 }, { 4, 0 }, { 1, 0 } };

		System.out.println(solve(n, redEdges, blueEdges));

	}

	private static int[] solve(int n, int[][] redEdges, int[][] blueEdges) {
		Map<Integer, List<int[]>> map = new HashMap<>();
		boolean[][] visited = new boolean[n][2];

		int[] res = new int[n];
		Arrays.fill(res, Integer.MAX_VALUE);

		// blue 0 red 1
		for (int[] eachEdge : blueEdges) {
			List<int[]> list = map.getOrDefault(eachEdge[0], new ArrayList<>());
			list.add(new int[] { eachEdge[1], 0 });
			map.put(eachEdge[0], list);
		}

		for (int[] eachEdge : redEdges) {
			List<int[]> list = map.getOrDefault(eachEdge[0], new ArrayList<>());
			list.add(new int[] { eachEdge[1], 1 });
			map.put(eachEdge[0], list);
		}

		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { 0, 0, -1 });
		res[0] = 0;
		visited[0][0] = true;
		visited[0][1] = true;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			if (curr[2] != -1) {
				visited[curr[0]][curr[2]] = true;
			}

			if (map.get(curr[0]) == null) {
				continue;
			}

			for (int[] each : map.get(curr[0])) {

				if (each[1] != curr[2] && !visited[each[0]][each[1]]) {
					res[each[0]] = Math.min(res[each[0]], curr[1] + 1);
					queue.offer(new int[] { each[0], curr[1] + 1, each[1] });
				}
			}
		}

		for (int i = 0; i < res.length; i++) {
			if (res[i] == Integer.MAX_VALUE) {
				res[i] = -1;
			}
		}
		return res;
	}

}
