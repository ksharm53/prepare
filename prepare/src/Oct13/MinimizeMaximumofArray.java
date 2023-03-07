package Oct13;

import java.util.HashMap;
import java.util.Map;

public class MinimizeMaximumofArray {

	public static void main(String[] args) {
		int[] nums = { 3, 7, 1, 6 };
		solve(nums);

	}

	private static void solve(int[] nums) {
		Map<int[], Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (i + 1 < nums.length && nums[i] < nums[i + 1]) {
				map.put(new int[] { nums[i], nums[i + 1] }, nums[i + 1] - nums[i]);
			}
		}
		
		
		System.out.println(map.size());
	}

}
