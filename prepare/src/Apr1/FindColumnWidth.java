package Apr1;

public class FindColumnWidth {

	public static void main(String[] args) {
		int[][] grid = { { -15, 1, 3 }, { 15, 7, 12 }, { 5, 6, -2 } };
		System.out.println(findColumnWidth(grid));

	}

	public static int[] findColumnWidth(int[][] grid) {
		int[] res = new int[grid[0].length];
		for (int i = 0; i < grid[0].length; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < grid.length; j++) {
				String val = String.valueOf(grid[j][i]);
				// int len = grid[j][i] < 0 ? val.length() + 1 : val.length();
				max = Math.max(max, val.length());

			}
			res[i] = max;
		}

		return res;
	}

}
