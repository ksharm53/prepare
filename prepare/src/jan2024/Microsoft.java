package jan2024;

public class Microsoft {
	static int max;

	public static void main(String[] args) {
		String[] matrix = new String[] {
				".XX..X..X.X.X..XX..X.XX.......XX..X.XXX.XX.XXX.X.XXX.XXXXXXX..XXX.....XX.XXXXXX...XX....X..XX.X.X...XX.....X.X.XX.X..X..XX.X...XX.X.XXXX..XX.X..X.XX.X.....XXXX.X.......XX..X.XXX.XXX..X....XX....XXX.XX",
				".XX.XX.X.....XXXX.XX..XX.........XX..XXX.X..X.XXX.XX....X..XXXXXX.X..XXXX.XXX.X.......XX.XX...X.XXX.X.X..X...X.X.X..X.....XXXXXX..XXXXXX.XX....XX.X.X.X..XX..XXXX.X.XXX.XXX.XX........X.XXX.....X..X.XXX",
				".X......XXXXX.XX.........XXXXX.XX...XXX..XXXX.XX...XX..XXXX........X.X.X.X...X.XX..X.XX..XXX.XX...XX..X...XX..XXXX.XX..XXXX...X..XXX.X...X.X..XX....X.X.X.X..XX..XXX....XX.X.X.X.XXX.X.X.X...XXXX.XX...X",
				"..XXX.X....X...X....XX...XX.XXXX.X..X....XX.XXXX.X..X..X....XX.X.XXXXX.XX..X.X.XXX..X..X......X...XXXXXX....X..X.XX.XXXXXX..XXX..X.X.XX...XX.X..X............X.X.XXX.XXX.XX...X.X.....XXXXX.XX.XXXXXX..X",
				"XX..X...XX..XXXX...XX..X.XX.X.X..X..XX..XXX..X...XXXXX.X...XX.XX..XX..X.X..X....XX..X.X.X....X.XXXXXXX.XX...XX.X..XXXXXX.XXXXX.X...XXXX....XXXXX.XX.XX..X..X.X.XX.X.X..X..XX.X...X....X...XXX.XX.XX.XX.." };
		max = Integer.MIN_VALUE;
		solve(matrix, 0, 0, new boolean[matrix.length][matrix[0].length()], 0);
		System.out.println(max);
	}

	private static void solve(String[] matrix, int row, int col, boolean[][] visited, int dist) {
		if (row == matrix.length - 1 && col == matrix[0].length() - 1) {
			max = Math.max(max, dist);
			return;
		}

		if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length()) {
			return;
		}
		visited[row][col] = true;
		if (row + 1 < matrix.length && !visited[row + 1][col] && matrix[row + 1].charAt(col) != 'X') {
			solve(matrix, row + 1, col, visited, dist + 1);
		}

		if (col + 1 < matrix[0].length() && !visited[row][col + 1] && matrix[row].charAt(col + 1) != 'X') {
			solve(matrix, row, col + 1, visited, dist + 1);
		}

		if (col - 1 >= 0 && !visited[row][col - 1] && matrix[row].charAt(col - 1) != 'X') {
			solve(matrix, row, col - 1, visited, dist + 1);
		}

		visited[row][col] = false;

	}

}
