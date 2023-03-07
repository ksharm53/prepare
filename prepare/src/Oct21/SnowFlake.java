package Oct21;

import java.util.Arrays;
import java.util.List;

public class SnowFlake {
	public static int[][] preSum;

	public static void main(String[] args) {
		List<List<Integer>> mat = Arrays.asList(Arrays.asList(1, 1, 1, 1), Arrays.asList(2, 2, 2, 2),
				Arrays.asList(3, 3, 3, 3), Arrays.asList(4, 4, 4, 4));
		preSum = new int[mat.size()][mat.get(0).size()];
		System.out.println(largestSubgrid(mat, 39));

	}

	public static int getSum(int row, int col) {
		if (row < 0 || col < 0)
			return 0;
		return preSum[row][col];
	}

	public static int sumRegion(int row1, int col1, int row2, int col2) {
		return getSum(row2, col2) - getSum(row1 - 1, col2) - getSum(row2, col1 - 1) + getSum(row1 - 1, col1 - 1);
	}

	public static int largestSubgrid(List<List<Integer>> grid, int k) {
		int n = grid.size();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				preSum[i][j] = getSum(i - 1, j) + getSum(i, j - 1) - getSum(i - 1, j - 1) + grid.get(i).get(j);
			}
		}
		int low = 0, high = n, ans = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid == 0)
				return 0;
			boolean stop = false;
			for (int i = mid - 1; i < n && !stop; i++) {
				for (int j = mid - 1; j < n && !stop; j++) {
					int subSum = sumRegion(i - mid + 1, j - mid + 1, i, j);
					if (subSum > k) {
						stop = true;
					}
				}
			}
			if (stop) {
				high = mid - 1;
			} else {
				ans = mid;
				low = mid + 1;
			}
		}
		return ans;
	}

}
