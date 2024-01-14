package jan2024;

import java.util.Arrays;
import java.util.HashSet;

public class MinMovesToCaptureTheQueen {
	static int min;
	static int[][] matrix;

	public static void main(String[] args) {
		int a = 1, b = 1, c = 8, d = 8, e = 2, f = 3;
		matrix = new int[9][9];
		for (int[] each : matrix) {
			Arrays.fill(each, -1);
		}
		min = Integer.MAX_VALUE;
		System.out.println(solve(a, b, c, d, e, f));
	}

	// a, b hathi
	// c, d ghoda
	// e, f queen
	private static int solve(int a, int b, int c, int d, int e, int f) {
		findMin(a, b, e, f, new HashSet<>(), 0);
		System.out.println(min);
		return 0;
	}

	private static void findMin(int a, int b, int e, int f, HashSet<String> visited, int count) {
		if (a > 8 || b > 8 || a < 1 || b < 1) {
			return;
		}

		if (matrix[a][b] != -1) {
			min = Math.min(min, matrix[a][b]);
			return;
		}

		if (a == e && b == f) {
			System.out.println(count);
			min = Math.min(min, count);
		}
		visited.add(a + "-" + b);
		// upar
		if (!visited.contains((a - 1) + "-" + b)) {
			// visited.add((a - 1) + "-" + b);
			findMin(a - 1, b, e, f, visited, count + 1);
			// visited.remove((a - 1) + "-" + b);
		}

		// neeche
		if (!visited.contains((a + 1) + "-" + b)) {
			// visited.add((a + 1) + "-" + b);
			findMin(a + 1, b, e, f, visited, count + 1);
			// visited.remove((a + 1) + "-" + b);
		}

		// left
		if (!visited.contains(a + "-" + (b - 1))) {
			// visited.add(a + "-" + (b - 1));
			findMin(a, b - 1, e, f, visited, count + 1);
			// visited.remove(a + "-" + (b - 1));
		}

		// right
		if (!visited.contains(a + "-" + (b + 1))) {
			visited.add(a + "-" + (b + 1));
			findMin(a, b + 1, e, f, visited, count + 1);
			visited.remove(a + "-" + (b + 1));
		}

		visited.remove(a + "-" + b);

	}

}
