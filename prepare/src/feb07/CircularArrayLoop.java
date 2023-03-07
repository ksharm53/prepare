package feb07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CircularArrayLoop {

	public static void main(String[] args) {
		int[] nums = { 2, -1, 1, -2, -2 };
		System.out.println(solve(nums));

	}

	private static boolean solve(int[] nums) {
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			int temp = i;
			Set<Integer> set = new HashSet<>();
			List<Integer> list = new ArrayList<>();
			set.add(i);
			list.add(i);
			while (set.size() < length) {
				int next = (temp + nums[temp] + length) % length;
				if (set.contains(next)) {
					int prev = list.get(list.size() - 1);
					if (prev != next && !((nums[prev] < 0 && nums[next] > 0) || (nums[next] < 0 && nums[prev] > 0))) {
						return true;
					} else {
						break;
					}
				}
				temp = next;
				set.add(next);
				if (!list.contains(next)) {
					list.add(next);
				}
			}
		}
		return false;
	}

}
