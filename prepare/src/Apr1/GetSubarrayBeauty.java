package Apr1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class GetSubarrayBeauty {

	public static void main(String[] args) {

		int[] nums = { -48, -4, -15, -48, 44 };
		int k = 3;
		int x = 1;

		System.out.println(solve(nums, k, x));

	}

	private static int[] solve(int[] nums, int k, int x) {
		int length = nums.length;
		int[] res = new int[length - k + 1];
		int idx = 0;

		int i = 0;
		int j = 0;

		PriorityQueue<Integer> negativeList = new PriorityQueue<>(Collections.reverseOrder());
		List<Integer> temp = new ArrayList<>();

		while (j < nums.length) {
			if (nums[j] < 0) {
				negativeList.add(nums[j]);
				temp.add(nums[j]);
				if (negativeList.size() > x) {
					negativeList.poll();
				}
			}
			if (j - i + 1 == k) {
				if (negativeList.isEmpty()) {
					res[idx] = 0;

				} else {
					if (negativeList.size() < x) {
						res[idx] = 0;
					} else {
						res[idx] = negativeList.peek();
					}

				}

				idx++;

				if (nums[i] < 0) {
					if (!negativeList.isEmpty()) {
						negativeList.remove(nums[i]);

						temp.remove(temp.indexOf(nums[i]));

						if (!temp.isEmpty() && temp.size() != negativeList.size()) {
							negativeList.add(temp.get(0));
						}

					}

				}

				i++;
			}
			j++;

		}
		return res;
	}

	private static int[] solveArray(int[] nums, int k, int x) {
		int length = nums.length;
		int[] res = new int[length - k + 1];
		int idx = 0;

		int i = 0;
		int j = 0;

		List<Integer> temp = new ArrayList<>();

		while (j < nums.length) {
			if (nums[j] < 0) {
				temp.add(nums[j]);
			}
			if (j - i + 1 == k) {
				if (temp.isEmpty()) {
					res[idx] = 0;

				} else {
					if (temp.size() < x) {
						res[idx] = 0;
					} else {
						Collections.sort(temp);
						res[idx] = temp.get(x - 1);
					}

				}

				idx++;

				if (nums[i] < 0) {
					if (!temp.isEmpty()) {
						temp.remove(temp.indexOf(nums[i]));
					}

				}

				i++;
			}
			j++;

		}
		return res;
	}

}
