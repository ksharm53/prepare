package CodeSignal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CodeSIgnalMatrixPractice {
	public static int[][] result;
	public static Set<String> visited;

	public static void main(String[] args) {
		boolean[][] field = { { false, true, true }, { true, false, true }, { false, false, true } };

		result = new int[field.length][field[0].length];
		visited = new HashSet<>();

		result = new int[field.length][field[0].length];

		for (int[] bs : result) {
			Arrays.fill(bs, -1);
		}

		solve(field, 1, 1);

		System.out.println(result);

	}

	public static int solve(boolean[][] field, int x, int y) {
		if (x >= field.length || x < 0 || y < 0 || y > field[0].length) {
			return 0;
		}

		String val = x + "-" + y;
		if (visited.contains(val)) {
			return 0;
		}
		visited.add(val);

		if (field[x][y] == false) {
			return result[x][y] = 1 + solve(field, x + 1, y) + 1 + solve(field, x, y + 1) + 1 + solve(field, x - 1, y)
					+ 1 + solve(field, x, y - 1) + 1 + solve(field, x - 1, y - 1) + 1 + solve(field, x - 1, y + 1) + 1
					+ solve(field, x + 1, y - 1) + 1 + solve(field, x + 1, y = 1);
		}

		return 0;

	}

}
