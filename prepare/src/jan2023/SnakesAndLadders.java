package jan2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakesAndLadders {

	public static int count;

	public static void main(String[] args) {
		int[][] board = { { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 },
				{ -1, 35, -1, -1, 13, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, 15, -1, -1, -1, -1 } };
		count = 1;
		solve(board, board.length);

	}

	private static void solve(int[][] board, int length) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		boolean dir = true;
		for (int i = board.length - 1; i >= 0; i--) {
			if (dir) {
				for (int j = 0; j < board[0].length; j++) {
					
				}
			} else {
				for (int j = board[0].length - 1; j >= 0; j--) {
					
				}
			}
		}
		System.out.println(map);
	}

}
