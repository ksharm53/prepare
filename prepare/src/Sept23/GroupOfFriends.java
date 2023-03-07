package Sept23;

import java.util.HashMap;
import java.util.Map;

public class GroupOfFriends {

	public static class UnionFind {
		Map<Integer, Integer> leaderMap;
		Map<Integer, Integer> rankMap;
		int totalSets;

		public UnionFind(int n) {
			this.leaderMap = new HashMap<>();
			this.rankMap = new HashMap<>();
			totalSets = n;

			for (int i = 1; i <= n; i++) {
				leaderMap.put(i, i);
				rankMap.put(i, 1);
			}
		}

		private int find(int value) {
			int leader = leaderMap.get(value);
			if (leader != value) {
				leader = find(leader);
				leaderMap.put(value, leader);
				return leader;
			}
			return value;
		}

		private void union(int first, int second) {
			int firstParent = this.find(first);
			int secondParent = this.find(second);

			if (firstParent == secondParent) {
				return;
			} else {
				if (rankMap.get(firstParent) > rankMap.get(secondParent)) {
					leaderMap.put(secondParent, firstParent);
					int total = rankMap.get(firstParent) + rankMap.get(secondParent);
					rankMap.put(firstParent, total);
					totalSets--;

				} else {
					leaderMap.put(firstParent, secondParent);
					int total = rankMap.get(firstParent) + rankMap.get(secondParent);
					rankMap.put(secondParent, total);
					totalSets--;
				}
			}
		}

	}

	public static void main(String[] args) {
		int n = 4;
		String[] queryType = { "Friend", "Friend", "Total" };
		int[] student1 = { 1, 2, 1 };
		int[] student2 = { 2, 3, 4 };

		solve(n, queryType, student1, student2);

	}

	private static void solve(int n, String[] queryType, int[] student1, int[] student2) {
		UnionFind uf = new UnionFind(n);
		for (int i = 0; i < queryType.length; i++) {
			String eachQuery = queryType[i];
			if (eachQuery.equals("Friend")) {
				uf.union(student1[i], student2[i]);
			} else {
				System.out.println(uf.rankMap.get(uf.find(student1[i])) + uf.rankMap.get(uf.find(student2[i])));
			}
		}

	}

}
