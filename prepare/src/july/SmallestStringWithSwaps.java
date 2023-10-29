package july;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallestStringWithSwaps {

	static class UnionFind {
		int[] root;
		int[] rank;

		public UnionFind(int size) {
			root = new int[size];
			for (int i = 0; i < root.length; i++) {
				root[i] = i;
			}

			rank = new int[size];
			for (int i = 0; i < rank.length; i++) {
				rank[i] = 1;
			}
		}

		public int find(int val) {
			if (root[val] == val) {
				return val;
			}

			int leader = find(root[val]);

			return leader;
		}

		public void union(int first, int second) {
			int leader_One = find(first);
			int leader_Second = find(second);

			if (leader_One != leader_Second) {
				if (rank[leader_One] < rank[leader_Second]) {
					root[leader_One] = leader_Second;
				} else if (rank[leader_One] > rank[leader_Second]) {
					root[leader_Second] = leader_One;
				} else {
					root[leader_One] = leader_Second;
					rank[leader_Second]++;
				}
			}
		}
	}

	public static void main(String[] args) {
		String s = "dcab";
		int[][] pairs = { { 0, 3 }, { 1, 2 }, { 0, 2 } };

		System.out.println(solve(s, pairs));

	}

	private static String solve(String s, int[][] pairs) {
		UnionFind uf = new UnionFind(s.length());
		StringBuilder res = new StringBuilder();

		for (int[] each : pairs) {
			uf.union(each[0], each[1]);
		}

		int[] rootVal = uf.root;
		Map<Integer, List<Character>> map = new HashMap<>();

		for (int i = 0; i < rootVal.length; i++) {
			int leader = uf.find(rootVal[i]);
			rootVal[i] = leader;
			List<Character> sb = map.getOrDefault(leader, new ArrayList<>());
			sb.add(s.charAt(i));
			map.put(leader, sb);
		}

		for (int each : map.keySet()) {
			Collections.sort(map.get(each));
		}

		for (int i = 0; i < s.length(); i++) {
			res.append(map.get(rootVal[i]).get(0));
			map.get(rootVal[i]).remove(0);
			if (map.get(rootVal[i]).size() == 0) {
				map.remove(rootVal[i]);
			}
		}
		return res.toString();
	}

}
