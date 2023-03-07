package novTwentyFour;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	public static boolean flag;
	public static boolean[][] matrix;

	public static void main(String[] args) {
		char[][] board = { { 'X', 'O', 'X', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'X', 'O', 'X' } };
		flag = false;
		matrix = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != 'X') {
					flag = false;
					if (solve(board, i, j)) {
						System.out.println(i + "-" + j + "-" + "Kanav");
						markSection(i, j, board);
					}
				}
			}
		}

		System.out.println(board);

	}

	private static void markSection(int i, int j, char[][] board) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });
		board[i][j] = 'X';

		while (!queue.isEmpty()) {
			int level = queue.size();
			for (int idx = 0; idx < level; idx++) {
				int[] curr = queue.poll();
				int row = curr[0];
				int col = curr[1];
				if (row - 1 > 0 && board[row - 1][col] == 'O') {
					queue.add(new int[] { row - 1, col });
					board[row - 1][col] = 'X';
				}

				if (row + 1 <= board.length && board[row + 1][col] == 'O') {
					queue.add(new int[] { row + 1, col });
					board[row + 1][col] = 'X';
				}

				if (col - 1 > 0 && board[row][col - 1] == 'O') {
					queue.add(new int[] { row, col - 1 });
					board[row][col - 1] = 'X';
				}

				if (col + 1 <= board[0].length && board[row][col + 1] == 'O') {
					queue.add(new int[] { row, col + 1 });
					board[row][col + 1] = 'X';
				}
			}
		}

	}

	private static boolean solve(char[][] board, int row, int col) {
		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
			flag = true;
			return false;
		}

		if (board[row][col] == 'X') {
			return false;
		}

		if (matrix[row][col]) {
			return false;
		} else {
			matrix[row][col] = true;
		}

		solve(board, row + 1, col);
		solve(board, row - 1, col);
		solve(board, row, col + 1);
		solve(board, row, col - 1);

		return flag ? false : true;

	}

}
