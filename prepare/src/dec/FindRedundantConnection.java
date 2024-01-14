package dec;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindRedundantConnection {

	public static void main(String[] args) {
		int[][] edges = { { 9, 10 }, { 5, 8 }, { 2, 6 }, { 1, 5 }, { 3, 8 }, { 4, 9 }, { 8, 10 }, { 4, 10 }, { 6, 8 },
				{ 7, 9 } };
		System.out.println(findRedundantConnection(edges));
		System.out.println("");

	}

	public static int[] findRedundantConnection(int[][] edges) {
		Set<Integer> vertices = new HashSet<>();
		for (int[] each : edges) {
			vertices.add(each[0]);
			vertices.add(each[1]);
		}
		UnionFind uf = new UnionFind(vertices.size());
		int[] res = new int[2];
		for (int[] each : edges) {
			if (uf.find(each[0]) == uf.find(each[1])) {
				res = each;
				break;
			} else {
				uf.union(each[0], each[1]);
			}
		}
		return res;
	}

	static class UnionFind {
		Map<Integer, Integer> leader;
		Map<Integer, Integer> rank;
		int count;

		public UnionFind(int size) {
			leader = new HashMap<>();
			rank = new HashMap<>();
			count = size;
			for (int i = 1; i <= size; i++) {
				leader.put(i, i);
				rank.put(i, 1);
			}
		}

		public void union(int a, int b) {
			int aParent = find(a);
			int bParent = find(b);

			if (aParent == bParent) {
				return;
			}

			int aRank = rank.get(aParent);
			int bRank = rank.get(bParent);

			if (aRank >= bRank) {
				leader.put(bParent, aParent);
				rank.put(aParent, aRank + bRank);
			} else {
				leader.put(aParent, bParent);
				rank.put(bParent, aRank + bRank);
			}
			count--;
		}

		public int find(int val) {
			if (leader.get(val) == val) {
				return val;
			}

			int tempLeader = find(leader.get(val));
			leader.put(val, tempLeader);
			return tempLeader;
		}
	}

}
