package dec;

import java.util.Arrays;

public class MinCost1 {

	static int[][] matrix;

	public static void main(String[] args) {
		String colors = "abaac";
		int[] neededTime = { 1, 2, 3, 4, 5 };
		matrix = new int[neededTime.length][neededTime.length];
		for (int[] each : matrix) {
			Arrays.fill(each, -1);
		}
		if (neededTime.length == 1) {
			System.out.println("0");
		}
		// System.out.println(solve(colors, neededTime, 0, 1));

		System.out.println(solveAgain(colors, neededTime));

	}

	private static int solveAgain(String colors, int[] neededTime) {
		if (neededTime.length == 1) {
			return 0;
		}
		int res = 0;
		int sum = neededTime[0];
		int max = neededTime[0];
		for (int i = 1; i < neededTime.length; i++) {
			boolean entered = false;
			while (i < neededTime.length && colors.charAt(i) == colors.charAt(i - 1)) {
				entered = true;
				sum += neededTime[i];
				max = Math.max(max, neededTime[i]);
				i++;
			}
			if (entered) {
				res += sum - max;
				i--;
			}
			sum = neededTime[i];
			max = neededTime[i];

		}
		return res;
	}

	private static int solve(String colors, int[] neededTime, int idx, int next) {
		if (idx >= neededTime.length || next >= neededTime.length) {
			return 0;
		}

		if (matrix[idx][next] != -1) {
			return matrix[idx][next];
		}

		if (colors.charAt(idx) == colors.charAt(next)) {
			int leftLiya = neededTime[next] + solve(colors, neededTime, idx, next + 1);
			int rightLiya = neededTime[idx] + solve(colors, neededTime, next, next + 1);
			return matrix[idx][next] = Math.min(leftLiya, rightLiya);
		} else {
			return matrix[idx][next] = solve(colors, neededTime, next, next + 1);
		}
	}

}
