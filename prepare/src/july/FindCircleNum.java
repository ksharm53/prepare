package july;

import java.util.HashSet;
import java.util.Set;

public class FindCircleNum {

	public static class UnionFind {
		int[] root;
		int[] rank;

		public UnionFind(int size) {
			root = new int[size];
			rank = new int[size];

			for (int i = 0; i < size; i++) {
				root[i] = i;
				rank[i] = 1;
			}
		}

		public int find(int val) {
			if (this.root[val] == val) {
				return val;
			}
			int leader = find(this.root[val]);
			this.root[val] = leader;
			return leader;
		}

		public void union(int one, int sec) {
			int leader1 = find(one);
			int leader2 = find(sec);

			if (this.rank[leader1] < this.rank[leader2]) {
				this.root[leader2] = root[leader1];
			} else if (this.rank[leader1] > this.rank[leader2]) {
				this.root[leader1] = root[leader2];
			} else {
				this.root[leader2] = root[leader1];
				this.rank[leader1]++;
			}
		}

		public boolean isConnected(int first, int sec) {
			return find(first) == find(sec);
		}

	}

	public static void main(String[] args) {
		int[][] isConnected = { { 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0 },
				{ 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1 }, { 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 } };

		System.out.println(solve(isConnected));
		System.out.println("");

	}

	private static int solve(int[][] isConnected) {
		UnionFind uf = new UnionFind(isConnected.length);
		for (int i = 0; i < isConnected.length; i++) {
			for (int j = 0; j < isConnected[i].length; j++) {
				if (i == j) {
					continue;
				}
				if (isConnected[i][j] == 1) {
					uf.union(i, j);
				}
			}
		}

		int[] root = uf.root;
		Set<Integer> set = new HashSet<>();
		for (int each : root) {
			set.add(uf.find(each));
		}

		return set.size();
	}

}
