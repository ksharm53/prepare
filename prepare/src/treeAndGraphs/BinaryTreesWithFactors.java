package treeAndGraphs;

import java.util.Arrays;

public class BinaryTreesWithFactors {

	public static void main(String[] args) {
		int[] arr = { 2, 4, 5, 10 };
		System.out.println(solve(arr));
	}

	private static int solve(int[] arr) {
		Arrays.sort(arr);
		int counter = 0;

		if (arr.length == 0) {
			return 0;
		}
		outer: for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[0] * arr[j] > arr[i]) {
					continue outer;
				} else if (arr[0] * arr[j] == arr[i]) {
					counter++;
				}
			}
		}
		return counter + arr.length;
	}

}
