package CodeSignal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

class CodeSIgnal {

	static int N;

	static int printMaxSumSub(int[][] mat, int k) {
		
		Math.sqrt(k);

		Map<Integer, List<int[]>> map = new TreeMap<>(Collections.reverseOrder());
		Set<Integer> set = new HashSet<>();
		int sumFinal = 0;

		if (k > N)
			return 0;

		int[][] stripSum = new int[N][N];

		for (int j = 0; j < N; j++) {

			int sum = 0;
			for (int i = 0; i < k; i++)
				sum += mat[i][j];
			stripSum[0][j] = sum;

			for (int i = 1; i < N - k + 1; i++) {
				sum += (mat[i + k - 1][j] - mat[i - 1][j]);
				stripSum[i][j] = sum;
			}
		}

		int max_sum = Integer.MIN_VALUE;

		for (int i = 0; i < N - k + 1; i++) {

			int sum = 0;
			for (int j = 0; j < k; j++)
				sum += stripSum[i][j];
			if (sum >= max_sum) {
				max_sum = sum;
				List<int[]> temp = map.getOrDefault(max_sum, new ArrayList<>());
				temp.add(new int[] { i, 0 });
				map.put(max_sum, temp);
			}

			for (int j = 1; j < N - k + 1; j++) {
				sum += (stripSum[i][j + k - 1] - stripSum[i][j - 1]);

				if (sum >= max_sum) {
					max_sum = sum;
					List<int[]> temp = map.getOrDefault(max_sum, new ArrayList<>());
					temp.add(new int[] { i, j });
					map.put(max_sum, temp);
				}
			}
		}

		for (Entry<Integer, List<int[]>> eachEntry : map.entrySet()) {
			for (int[] eachValue : eachEntry.getValue()) {
				int startX = eachValue[0];
				int startY = eachValue[1];
				for (int i = 0; i < k; i++) {
					for (int j = 0; j < k; j++) {
						System.out.print(mat[i + startX][j + startY] + " ");
						set.add(mat[i + startX][j + startY]);
					}

				}
				System.out.println("--");
			}
		}

		for (int is : set) {
			sumFinal += is;
		}

		return sumFinal;

	}

	public static void main(String[] args) {
		N = 5;
		int[][] mat = { { 9, 7, 8, 9, 2 }, { 6, 9, 9, 6, 1 }, { 4, 10, 1, 3, 10 }, { 18, 2, 3, 9, 3 },
				{ 4, 6, 8, 5, 21 } };
		int k = 3;

		System.out.println("Maximum sum 3 x 3 matrix is");
		System.out.println(printMaxSumSub(mat, k));

	}
}
