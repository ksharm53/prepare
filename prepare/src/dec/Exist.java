package dec;

public class Exist {

	public static void main(String[] args) {
		char[][] board = { { 'a', 'b' }, { 'c', 'd' } };
		String word = "cdba";
		int[][] visited = new int[board.length][board[0].length];
		System.out.println(exist(board, word, visited));
	}

	public static boolean exist(char[][] board, String word, int[][] visited) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0) && visited[i][j] != -1) {
					visited[i][j] = -1;
					if (solve(board, word, 0, i, j, visited)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean solve(char[][] board, String word, int idx, int row, int col, int[][] visited) {

		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || idx >= word.length()) {
			return false;
		}
		if (word.charAt(idx) != board[row][col]) {
			return false;
		}
		if (idx == word.length() - 1) {
			return true;
		}
		boolean upar = false;
		boolean neeche = false;
		boolean left = false;
		boolean right = false;

		if (row - 1 >= 0 && visited[row - 1][col] != -1) {
			visited[row - 1][col] = -1;
			upar = solve(board, word, idx + 1, row - 1, col, visited);
			if (!upar) {
				visited[row - 1][col] = 0;
			}
		}
		if (row + 1 < visited.length && visited[row + 1][col] != -1) {
			visited[row + 1][col] = -1;
			neeche = solve(board, word, idx + 1, row + 1, col, visited);
			if (!neeche) {
				visited[row + 1][col] = 0;
			}
		}

		if (col - 1 >= 0 && visited[row][col - 1] != -1) {
			visited[row][col - 1] = -1;
			left = solve(board, word, idx + 1, row, col - 1, visited);
			if (!left) {
				visited[row][col - 1] = 0;
			}
		}

		if (col + 1 < visited[0].length && visited[row][col + 1] != -1) {
			visited[row][col + 1] = -1;
			right = solve(board, word, idx + 1, row, col + 1, visited);
			if (!right) {
				visited[row][col + 1] = 0;
			}
		}
		return (upar || neeche || left || right);

	}

}
