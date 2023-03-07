package nov13;

import java.util.TreeSet;

public class ObstaclesAndBlocks {

	// NOT CORRECT
	public static TreeSet<Integer> blocks;

	public static void main(String[] args) {
		int[][] operations = { { 1, 2 }, { 1, 5 }, { 2, 3, 2 }, { 2, 3, 3 }, { 2, 1, 1 }, { 2, 1, 2 } };
		blocks = new TreeSet<>();
		System.out.println(solve(operations));
	}

	private static String solve(int[][] operations) {
		int[] obstacles = new int[operations.length];
		String res = "";
		boolean flag = false;

		for (int i = 0; i < operations.length; i++) {
			if (operations[i].length == 2) {
				obstacles[i] = operations[i][1];
			} else {
				flag = true;
				for (int j = 0; j < obstacles.length; j++) {
					int ob = obstacles[j];
					if (operations[i][1] <= ob && ob <= operations[i][1] + operations[i][2] - 1) {
						res += "0";
						flag = false;
						break;

					}
					if (flag) {
						res += "1";
					}

				}
			}

		}

		return res;
	}

}
