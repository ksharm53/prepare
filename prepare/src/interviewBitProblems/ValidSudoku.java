package interviewBitProblems;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	public static void main(String[] args) {
		String[][] board = { { "8", "3", ".", ".", "7", ".", ".", ".", "." },
				{ "6", ".", ".", "1", "9", "5", ".", ".", "." }, { ".", "9", "8", ".", ".", ".", ".", "6", "." },
				{ "8", ".", ".", ".", "6", ".", ".", ".", "3" }, { "4", ".", ".", "8", ".", "3", ".", ".", "1" },
				{ "7", ".", ".", ".", "2", ".", ".", ".", "6" }, { ".", "6", ".", ".", ".", ".", "2", "8", "." },
				{ ".", ".", ".", "4", "1", "9", ".", ".", "5" }, { ".", ".", ".", ".", "8", ".", ".", "7", "9" } };
		System.out.println(solve(board));

	}

	private static boolean solve(String[][] board) {
		if (board.length == 0) {
			return false;
		}

		for (int i = 0; i < 9; i++) {
			Set<String> setRow = new HashSet<>();
			Set<String> setColumn = new HashSet<>();
			Set<String> setBlock = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != "." && setRow.contains(board[i][j])) {
					return false;
				}
				setRow.add(board[i][j]);

				if (board[j][i] != "." && setColumn.contains(board[j][i])) {
					return false;
				}
				setColumn.add(board[j][i]);

				int nextColumn = (3 * (i % 3)) + (j % 3);
				int nextRow = (3 * (i / 3)) + (j / 3);

				if (board[nextRow][nextColumn] != "." && setBlock.contains(board[nextRow][nextColumn])) {
					return false;
				}

				setBlock.add(board[nextRow][nextColumn]);
			}
		}
		return true;

	}
}
