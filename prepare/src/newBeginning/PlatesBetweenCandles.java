package newBeginning;

public class PlatesBetweenCandles {

	public static void main(String[] args) {
		String s = "***";
		int[][] queries = { { 2, 2 } };

		System.out.println(solve(s, queries));
	}

	private static int[] solve(String s, int[][] queries) {
		int[] arr = new int[s.length()];
		int[] res = new int[queries.length];
		int[] nearestRightCandle = new int[s.length()];
		int[] nearestLeftCandle = new int[s.length()];

		int val = 0;
		while (val < s.length() && s.charAt(val) != '|') {
			arr[val] = -1;
			val++;
		}
		val++;
		int soFar = 0;
		for (int idx = val; idx < s.length(); idx++) {
			if (s.charAt(idx) == '*') {
				arr[idx] = ++soFar;
			}
		}

		int candleIdx = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '|') {
				candleIdx = i;
			}
			nearestLeftCandle[i] = candleIdx;
		}

		candleIdx = -1;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '|') {
				candleIdx = i;
			}
			nearestRightCandle[i] = candleIdx;
		}

		for (int i = 0; i < queries.length; i++) {
			int[] eachQuery = queries[i];
			int low = eachQuery[0];
			int high = eachQuery[1];

			int findLeft = nearestRightCandle[low];

			int findRight = nearestLeftCandle[high];

			while (findRight >= 0 && findRight < s.length() && s.charAt(findRight) != '*') {
				findRight--;
			}

			while (findLeft >= 0 && findLeft < s.length() && s.charAt(findLeft) != '*') {
				findLeft++;
			}

			if (findLeft < 0 || findRight < 0 || findLeft > findRight) {
				res[i] = 0;
				continue;
			}

			res[i] = (arr[findRight] - arr[findLeft] + 1) > 0 ? (arr[findRight] - arr[findLeft] + 1) : 0;
		}
		return res;
	}

}
