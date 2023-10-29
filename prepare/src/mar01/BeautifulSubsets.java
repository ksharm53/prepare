package mar01;

import java.util.HashSet;
import java.util.Set;

public class BeautifulSubsets {

	public static void main(String[] args) {
		int[] nums = { 2, 4, 6 };
		int k = 2;

		System.out.println(solve(nums, k));

	}

	private static int solve(int[] nums, int k) {
		int counter = 0;
		Set<String> set = new HashSet<>();
		int i;
		int l;
		for (i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				boolean flag = false;
				for (l = i; l <= j; l++) {
					if (Math.abs(nums[i] - nums[l]) == 2) {
						flag = true;
						break;
					}
				}
				if (!flag && !set.contains(i + "-" + j)) {
					System.out.println(i + "-" + j);
					set.add(i + "-" + j);
					counter++;
				}
			}
		}
		return counter;
	}

}
