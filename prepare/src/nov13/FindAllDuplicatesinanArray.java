package nov13;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesinanArray {

	public static void main(String[] args) {
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println(findDuplicates(nums));
	}

	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int val = Math.abs(nums[i]) - 1;
			if (nums[val] < 0) {
				res.add(Math.abs(val + 1));
			}
			nums[val] = -nums[val];

		}
		return res;
	}

}
