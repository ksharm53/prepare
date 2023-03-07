package Sept23;

import java.util.HashMap;
import java.util.Map;

public class CourseSchedule {

	public static class UnionFind {
		Map<Integer, Integer> leaderMap;
		Map<Integer, Integer> rankMap = new HashMap<>();
		int countSet = 0;

		public UnionFind(int countSet) {
			leaderMap = new HashMap<>();
			rankMap = new HashMap<>();
			this.countSet = countSet;

			for (int i = 0; i < countSet; i++) {
				leaderMap.put(i, i);
				rankMap.put(i, 1);
			}
		}

		private int find(int value) {
			while (leaderMap.get(value) != value) {
				value = leaderMap.get(value);
			}
			return value;
		}

		private void union(int first, int second) {
			int leaderFirst = this.find(first);
			int leaderSecond = this.find(second);
			if (leaderFirst == leaderSecond) {
				return;
			} else {
				leaderMap.put(leaderFirst, leaderSecond);
				int totalRank = rankMap.get(leaderFirst) + rankMap.get(leaderSecond);
				rankMap.put(leaderSecond, totalRank);
				countSet--;
			}
		}

		private boolean haveSameParent(int first, int second) {
			int parentFirst = this.find(first);
			int parentSecond = this.find(second);
			if (parentFirst == parentSecond) {
				return true;
			}
			return false;
		}

	}

	public static void main(String[] args) {
		int n = 5;

		int[][] prerequisites = { { 1, 4 }, { 2, 4 }, { 3, 1 }, { 3, 2 } };
		System.out.println(solve(n, prerequisites));
	}

	private static boolean solve(int n, int[][] prerequisites) {
		UnionFind uf = new UnionFind(n);

		for (int[] each : prerequisites) {
			if (uf.haveSameParent(each[0], each[1])) {
				return false;
			} else {
				uf.union(each[0], each[1]);
			}
		}
		return true;
	}

}
