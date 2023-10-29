package may1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestPathBinaryMatrix {

	static Map<String, List<int[]>> map;

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
		map = new HashMap<>();
		solve(grid);

	}

	static class Pair {
		int xCoord;
		int yCoord;
		int distance;

		public Pair(int xCoord, int yCoord, int distance) {
			super();
			this.xCoord = xCoord;
			this.yCoord = yCoord;
			this.distance = distance;

		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			return xCoord == other.xCoord && yCoord == other.yCoord;
		}

	}

	private static void solve(int[][] grid) {
		makeGraph(grid);

		List<Pair> pq = new ArrayList<>();
		pq.add(new Pair(0, 0, Integer.MAX_VALUE));
		int row = 0;
		int col = 0;
		int distance = 0;

		while (true) {
			if (row == grid.length - 1 && col == grid[0].length - 1) {
				break;
			}

			List<int[]> list = map.get(row + "-" + col);
			for (int[] each : list) {
				if (pq.contains(new Pair(each[0], each[1], 0))) {
					int idx = pq.indexOf(new Pair(each[0], each[1], 0));
					Pair val = pq.get(idx);
					pq.remove(idx);
					pq.add(new Pair(val.xCoord, val.yCoord, Math.min(distance + 1, val.distance)));
				} else {
					pq.add(new Pair(each[0], each[1], distance + 1));
				}
			}

			int min = Integer.MAX_VALUE;
			for (Pair each : pq) {
				if (each.distance < min) {
					min = each.distance;
					row = each.xCoord;
					col = each.yCoord;
					distance = min;
				}
			}

		}
	}

	private static void makeGraph(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					List<int[]> list = map.getOrDefault(i + "-" + j, new ArrayList<>());
					if (i - 1 >= 0 && grid[i - 1][j] == 0) {
						list.add(new int[] { i - 1, j });
					}
					if (i - 1 >= 0 && j + 1 < grid[0].length && grid[i - 1][j + 1] == 0) {
						list.add(new int[] { i - 1, j + 1 });
					}
					if (j + 1 < grid[0].length && grid[i][j + 1] == 0) {
						list.add(new int[] { i, j + 1 });
					}
					if (i + 1 < grid.length && j + 1 < grid[0].length && grid[i + 1][j + 1] == 0) {
						list.add(new int[] { i + 1, j + 1 });
					}

					if (i + 1 < grid.length && grid[i + 1][j] == 0) {
						list.add(new int[] { i + 1, j });
					}

					if (i + 1 < grid.length && j - 1 >= 0 && grid[i + 1][j - 1] == 0) {
						list.add(new int[] { i + 1, j - 1 });
					}

					if (j - 1 >= 0 && grid[i][j - 1] == 0) {
						list.add(new int[] { i, j - 1 });
					}

					if (i - 1 >= 0 && j - 1 >= 0 && grid[i - 1][j - 1] == 0) {
						list.add(new int[] { i - 1, j - 1 });
					}

					map.put(i + "-" + j, list);
				}
			}
		}

	}

}
