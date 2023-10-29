package may1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxOperations {

	public static void main(String[] args) {
		int[] nums = { 3, 1, 3, 4, 3 };

		int k = 6;

		System.out.println(solve(nums, k));

	}

	private static int solve(int[] nums, int k) {

		List<Integer> list = new ArrayList<>();

		for (Integer each : nums) {
			list.add(each);
		}

		Collections.sort(list);

		int count = 0;
		for (int i = 0; i < list.size(); i++) { // n
			int serach = k - list.get(i);

			int ret = findOtherVal(serach, list);
			if (ret != -1 && ret != i) {
				list.remove(i);
				if (i < ret) {
					list.remove(ret - 1);
				} else {
					list.remove(ret - 1);
				}
				count++;
				i--;
			}

		}

		return count;
	}

	private static int findOtherVal(int search, List<Integer> list) {
		int start = 0;
		int end = list.size() - 1;

		int res = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (list.get(mid) == search) {
				res = mid;
				start = mid + 1;
			} else if (list.get(mid) > search) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return res;
	}

}
