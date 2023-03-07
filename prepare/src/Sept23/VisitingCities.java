package Sept23;

import java.util.ArrayList;
import java.util.List;

public class VisitingCities {

	public static void main(String[] args) {
		int[] red = { 2, 3, 4 };
		int[] blue = { 3, 1, 1 };
		int blueCost = 2;

		System.out.println(solve(red, blue, blueCost));

	}

	private static int[] solve(int[] red, int[] blue, int blueCost) {

		int n = red.length;

		int[][] dp = new int[n + 1][2];
		dp[0][0] = 0;
		dp[0][1] = blueCost;
		int[] ans = new int[n + 1];

		for (int i = 1; i <= n; i++) {

			dp[i][0] = Math.min(dp[i - 1][0] + red[i - 1], dp[i - 1][1] + red[i - 1]);
			dp[i][1] = Math.min(dp[i - 1][1] + blue[i - 1], dp[i - 1][0] + blue[i - 1] + blueCost);
			ans[i] = Math.min(dp[i][1], dp[i][0]);

		}
		return ans;

	}

}
