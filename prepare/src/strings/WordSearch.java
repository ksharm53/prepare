package strings;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {

	public static Set<String> set;

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCCEE";

		set = new HashSet<>();

		System.out.println(solve(board, word));

	}

	private static boolean solve(char[][] board, String word) {
		if (board.length == 0 || word.length() == 0) {
			return false;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (recursiveSolution(board, i, j, word, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean recursiveSolution(char[][] board, int row, int column, String word, int position) {
		String value = row + "-" + column;

		if (position == word.length()) {
			return true;
		} else if (position > word.length()) {
			return false;
		}
		if (row >= board.length || row < 0 || column < 0 || column >= board[0].length || set.contains(value)) {
			return false;
		}

		set.add(value);

		char eachPosition = word.charAt(position);

		if (board[row][column] != eachPosition) {
			return false;
		}

		if (recursiveSolution(board, row + 1, column, word, position + 1)
				|| recursiveSolution(board, row - 1, column, word, position + 1)
				|| recursiveSolution(board, row, column + 1, word, position + 1)
				|| recursiveSolution(board, row, column - 1, word, position + 1)) {
			return true;
		}

		set.remove(value);
		return false;

	}

}
