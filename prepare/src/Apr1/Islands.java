package Apr1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Islands {

	static boolean[][] set;

	static class Node {
		int distance;
		int xCoor;
		int yCoor;
		int size;

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

		public int getxCoor() {
			return xCoor;
		}

		public void setxCoor(int xCoor) {
			this.xCoor = xCoor;
		}

		public int getyCoor() {
			return yCoor;
		}

		public void setyCoor(int yCoor) {
			this.yCoor = yCoor;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public Node(int distance, int xCoor, int yCoor, int size) {
			super();
			this.distance = distance;
			this.xCoor = xCoor;
			this.yCoor = yCoor;
			this.size = size;
		}

	}

	public static void main(String[] args) {
		char[][] matrix = { { 'X', 'X', 'X', 'X', 'T', 'X', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'R', 'X', 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, { 'T', 'T', 'T', 'X', 'X', 'X', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

		set = new boolean[matrix.length][matrix[0].length];

		solve(matrix);

	}

	private static void solve(char[][] matrix) {
		int[] coor = new int[2];

		List<Node> pq = new ArrayList<>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 'R') {
					coor[0] = i;
					coor[1] = j;
					break;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 'T' && set[i][j] != true) {
					pq.add(bfs(matrix, i, j, coor));
				}
			}
		}

		Collections.sort(pq, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if (o1.getDistance() != o2.getDistance()) {
					return o1.getDistance() - o2.getDistance();
				} else {
					if (o1.getxCoor() != o2.getxCoor()) {
						return o1.getxCoor() - o2.getxCoor();
					} else {
						if (o1.getyCoor() != o2.getyCoor()) {
							return o1.getyCoor() - o2.getyCoor();
						} else {
							return o1.getSize() - o2.getSize();
						}
					}
				}
			}

		});

		int idx = 0;
		while (idx < pq.size()) {
			Node each = pq.get(idx);
			StringBuilder sb = new StringBuilder();
			sb.append(each.getDistance());
			sb.append(":");
			sb.append(" ");
			sb.append(each.getxCoor());
			sb.append(" ");
			sb.append(each.getyCoor());
			sb.append(" ");
			sb.append(each.getSize());

			System.out.println(sb.toString());
			idx++;
		}
	}

	private static Node bfs(char[][] matrix, int row, int col, int[] rob) {
		int minDistance = Integer.MAX_VALUE;

		int xMin = Integer.MAX_VALUE;
		int xMax = Integer.MIN_VALUE;
		int yMin = Integer.MAX_VALUE;
		int yMax = Integer.MIN_VALUE;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { row, col });

		int calMin = Math.abs(rob[0] - row) + Math.abs(rob[1] - col);
		minDistance = Math.min(minDistance, calMin);

		xMin = Math.min(xMin, row);
		xMax = Math.max(xMax, row);
		yMin = Math.min(yMin, col);
		yMax = Math.max(yMax, col);

		set[row][col] = true;

		int count = 1;

		while (!queue.isEmpty()) {
			int[] val = queue.poll();
			int valRow = val[0];
			int valCol = val[1];
			if (valRow - 1 >= 0 && matrix[valRow - 1][valCol] == 'T' && set[valRow - 1][valCol] != true) {
				count++;
				queue.add(new int[] { valRow - 1, valCol });

				calMin = Math.abs(rob[0] - valRow + 1) + Math.abs(rob[1] - valCol);
				minDistance = Math.min(minDistance, calMin);

				xMin = Math.min(xMin, valRow - 1);
				xMax = Math.max(xMax, valRow - 1);
				yMin = Math.min(yMin, valCol);
				yMax = Math.max(yMax, valCol);

				set[valRow - 1][valCol] = true;
			}

			if (valRow + 1 < matrix.length && matrix[valRow + 1][valCol] == 'T' && set[valRow + 1][valCol] != true) {
				count++;
				queue.add(new int[] { valRow + 1, valCol });

				calMin = Math.abs(rob[0] - valRow - 1) + Math.abs(rob[1] - valCol);
				minDistance = Math.min(minDistance, calMin);

				xMin = Math.min(xMin, valRow + 1);
				xMax = Math.max(xMax, valRow + 1);
				yMin = Math.min(yMin, valCol);
				yMax = Math.max(yMax, valCol);

				set[valRow + 1][valCol] = true;
			}

			if (valCol - 1 >= 0 && matrix[valRow][valCol - 1] == 'T' && set[valRow][valCol - 1] != true) {
				count++;
				queue.add(new int[] { valRow, valCol - 1 });

				calMin = Math.abs(rob[0] - valRow) + Math.abs(rob[1] - valCol + 1);
				minDistance = Math.min(minDistance, calMin);

				xMin = Math.min(xMin, valRow);
				xMax = Math.max(xMax, valRow);
				yMin = Math.min(yMin, valCol - 1);
				yMax = Math.max(yMax, valCol - 1);

				set[valRow][valCol - 1] = true;
			}

			if (valCol + 1 < matrix[0].length && matrix[valRow][valCol + 1] == 'T' && set[valRow][valCol + 1] != true) {
				count++;
				queue.add(new int[] { valRow, valCol + 1 });

				calMin = Math.abs(rob[0] - valRow) + Math.abs(rob[1] - valCol - 1);
				minDistance = Math.min(minDistance, calMin);

				xMin = Math.min(xMin, valRow);
				xMax = Math.max(xMax, valRow);
				yMin = Math.min(yMin, valCol + 1);
				yMax = Math.max(yMax, valCol + 1);

				set[valRow][valCol + 1] = true;
			}
		}

		Node node = new Node(minDistance, (xMin + xMax) / 2, (yMin + yMax) / 2, count);

		return node;

	}

}
