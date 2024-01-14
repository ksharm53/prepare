package dec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindCheapestPrice {

	static Map<Integer, List<int[]>> map;

	public static void main(String[] args) {
		int n = 11;
		int[][] flights = { { 0, 3, 3 }, { 3, 4, 3 }, { 4, 1, 3 }, { 0, 5, 1 }, { 5, 1, 100 }, { 0, 6, 2 },
				{ 6, 1, 100 }, { 0, 7, 1 }, { 7, 8, 1 }, { 8, 9, 1 }, { 9, 1, 1 }, { 1, 10, 1 }, { 10, 2, 1 },
				{ 1, 2, 100 } };
		int src = 0, dst = 2, k = 4;

		map = new HashMap<>();
		System.out.println(solve(n, flights, src, dst, k));

	}

	private static int solve(int n, int[][] flights, int src, int dst, int k) {
		Set<Integer> set = new HashSet<>();
		createGraph(flights);
		int[] dist = new int[n];
		Arrays.fill(dist, -1);

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { src, 0, 0 });
		set.add(src);
		dist[src] = 0;
		int minDistance = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			int[] polled = queue.poll();
			List<int[]> list = map.get(polled[0]);
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					if (!set.contains(list.get(i)[0])
							|| (set.contains(list.get(i)[0]) && dist[list.get(i)[0]] > polled[1] + list.get(i)[1])) {
						queue.add(new int[] { list.get(i)[0], polled[1] + list.get(i)[1], polled[2] + 1 });
						set.add(list.get(i)[0]);
						dist[list.get(i)[0]] = polled[1] + list.get(i)[1];
					}
					if (list.get(i)[0] == dst) {
						if (polled[2] + 1 <= k + 1) {
							minDistance = Math.min(minDistance, polled[1] + list.get(i)[1]);
						}
					}
				}
			}
		}

		return minDistance;
	}

	private static void createGraph(int[][] flights) {
		for (int[] eachFlight : flights) {
			List<int[]> eachList = map.getOrDefault(eachFlight[0], new ArrayList<>());
			eachList.add(new int[] { eachFlight[1], eachFlight[2] });
			map.put(eachFlight[0], eachList);
		}

	}

}
