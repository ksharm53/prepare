package july;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class FindNumberOfLIS {

	static int[][] matrix;

	public static void main(String[] args) {
		int[] nums = { 2, 2, 2, 2, 2 };
		Set<Integer> set = new TreeSet<>();
		for (int each : nums) {
			set.add(each);
		}
		int[] copyArr = new int[set.size()];
		int cou = 0;
		for (int each : set) {
			copyArr[cou] = each;
			cou++;
		}

		matrix = new int[nums.length][copyArr.length];
		for (int[] i : matrix) {
			Arrays.fill(i, -1);
		}
		solve(nums, copyArr, nums.length - 1, copyArr.length - 1);
		System.out.println(findPaths(matrix, nums, copyArr));
	}

	private static int findPaths(int[][] matrix, int[] nums, int[] copyArr) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { matrix.length - 1, matrix[0].length - 1 });
		int counter = 0;

		while (!queue.isEmpty()) {
			int[] each = queue.poll();
			if (each[0] == 0 && each[1] == 0) {
				counter++;
			}
			if (each[0] - 1 >= 0 && each[1] - 1 >= 0 && nums[each[0]] == copyArr[each[1]]) {
				queue.add(new int[] { each[0] - 1, each[1] - 1 });
			} else {
				int maxInner = Math.max(each[0] - 1 >= 0 ? matrix[each[0] - 1][each[1]] : Integer.MIN_VALUE,
						each[1] - 1 >= 0 ? matrix[each[0]][each[1] - 1] : Integer.MIN_VALUE);
				if (each[0] - 1 >= 0 && matrix[each[0] - 1][each[1]] == maxInner) {
					queue.add(new int[] { each[0] - 1, each[1] });
				}

				if (each[1] - 1 >= 0 && matrix[each[0]][each[1] - 1] == maxInner) {
					queue.add(new int[] { each[0], each[1] - 1 });
				}
			}
		}

		return counter;
	}

	private static int solve(int[] nums, int[] copyArr, int idxNums, int idxCopy) {
		if (idxCopy < 0 || idxNums < 0) {
			return 0;
		}

		if (matrix[idxNums][idxCopy] != -1) {
			return matrix[idxNums][idxCopy];
		}

		if (nums[idxNums] == copyArr[idxCopy]) {
			return matrix[idxNums][idxCopy] = 1 + solve(nums, copyArr, idxNums - 1, idxCopy - 1);
		} else {
			int leftliya = solve(nums, copyArr, idxNums - 1, idxCopy);
			int rightLiya = solve(nums, copyArr, idxNums, idxCopy - 1);
			return matrix[idxNums][idxCopy] = Math.max(leftliya, rightLiya);
		}

	}

}
