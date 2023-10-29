package Apr1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class TrashIslands {
	static class TrashIsland implements Comparable<TrashIsland> {
		int d, x, y, s;

		public TrashIsland(int d, int x, int y, int s) {
			this.d = d;
			this.x = x;
			this.y = y;
			this.s = s;
		}

		public int compareTo(TrashIsland other) {
			if (d != other.d)
				return d - other.d;
			if (x != other.x)
				return x - other.x;
			return y - other.y;
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		char[][] grid = new char[n][n];
		for (int i = 0; i < n; i++) {
			String line = input.next();
			for (int j = 0; j < n; j++) {
				grid[i][j] = line.charAt(j);
			}
		}
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		List<TrashIsland> islands = new ArrayList<>();
		boolean[][] visited = new boolean[n][n];
		int[][] dist = new int[n][n];
		Queue<Integer> rowQueue = new LinkedList<>();
		Queue<Integer> colQueue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 'R') {
					rowQueue.offer(i);
					colQueue.offer(j);
					visited[i][j] = true;
				} else if (grid[i][j] == 'T' && !visited[i][j]) {
					int size = 0;
					int xsum = 0, ysum = 0;
					int minDist = Integer.MAX_VALUE;
					while (!rowQueue.isEmpty()) {
						int row = rowQueue.poll();
						int col = colQueue.poll();
						if (grid[row][col] == 'T' && !visited[row][col]) {
							size++;
							xsum += row;
							ysum += col;
							visited[row][col] = true;
							minDist = Math.min(minDist, dist[row][col]);
						}
						for (int k = 0; k < 4; k++) {
							int newRow = row + dr[k];
							int newCol = col + dc[k];
							if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited[newRow][newCol]
									&& grid[newRow][newCol] != 'X') {
								rowQueue.offer(newRow);
								colQueue.offer(newCol);
								visited[newRow][newCol] = true;
								dist[newRow][newCol] = dist[row][col] + 1;
							}
						}
					}
					int cx = xsum / size;
					int cy = ysum / size;
					islands.add(new TrashIsland(minDist, cx, cy, size));
				}
			}
		}
		Collections.sort(islands);
		for (TrashIsland island : islands) {
			System.out.println(island.d + ": " + island.x + " " + island.y + " " + island.s);
		}
	}
}
