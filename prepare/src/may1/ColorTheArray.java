package may1;

public class ColorTheArray {

	public static void main(String[] args) {
		int n = 4;
		int[][] queries = { { 0, 2 }, { 1, 2 }, { 3, 1 }, { 1, 1 }, { 2, 1 } };

		System.out.println(solve(n, queries));

	}

	private static int[] solve(int n, int[][] queries) {
		int[] arr = new int[n];
		int[] res = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {
			int[] each = queries[i];

			if (i == 0) {
				res[i] = 0;

			} else {
				int sumBefore = 0;
				if (each[0] - 1 >= 0 && arr[each[0] - 1] == arr[each[0]]
						&& (arr[each[0] - 1] != 0 && arr[each[0]] != 0)) {
					sumBefore++;
				}
				if (each[0] + 1 < arr.length && arr[each[0] + 1] == arr[each[0]]
						&& (arr[each[0]] != 0 && arr[each[0] + 1] != 0)) {
					sumBefore++;
				}

				int sumAfter = 0;

				if (each[0] - 1 >= 0 && arr[each[0] - 1] == each[1] && (arr[each[0] - 1] != 0 && each[1] != 0)) {
					sumAfter++;
				}
				if (each[0] + 1 < arr.length && arr[each[0] + 1] == each[1]
						&& (arr[each[0] + 1] != 0 && each[1] != 0)) {
					sumAfter++;
				}

				int dif = Math.abs(sumAfter - sumBefore);

				if (sumBefore > sumAfter) {
					res[i] = res[i - 1] - dif;
				} else if (sumBefore < sumAfter) {
					res[i] = res[i - 1] + dif;
				} else {
					res[i] = res[i - 1];
				}

			}
			arr[each[0]] = each[1];
		}

		return res;
	}

}
