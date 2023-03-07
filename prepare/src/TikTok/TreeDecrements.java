package TikTok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeDecrements {
	public static int ans;

	public static void main(String[] args) {
		int nodes = 3;
		int[] from = { 1, 1 };
		int[] to = { 2, 3 };
		int[] val = { 3, 1, 2 };
		System.out.println(getMinCost(val, nodes, from, to));

	}

	private static int getMinCost(int[] val, int nodes, int[] from, int[] to) {

		int n = val.length;
		ans = 0;

		Map<Integer, List<Integer>> adjmap = new HashMap<>();

		for (int i = 0; i < n - 1; ++i) {
			--from[i];
			--to[i];

			adjmap.putIfAbsent(from[i], new ArrayList<>());
			adjmap.get(from[i]).add(to[i]);

			adjmap.putIfAbsent(to[i], new ArrayList<>());
			adjmap.get(to[i]).add(from[i]);

		}

		depthFirstSearch(0, -1, val, adjmap);

		return ans;
	}

	private static int depthFirstSearch(int cur, int parent, int[] val, Map<Integer, List<Integer>> adjmap) {
		int cnt = val[cur] & 1;
		for (int next : adjmap.get(cur))
			if (next != parent) {
				int res = depthFirstSearch(next, cur, val, adjmap);
				ans += res;
				cnt ^= res;
			}
		return cnt;

	}

}
