package jan2023;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindSubsequences {

	public static Set<List<Integer>> list;

	public static void main(String[] args) {
		int[] nums = { 4, 6, 7, 7 };

		list = new HashSet<>();
		List<Integer> init = new ArrayList<>();
		solve(nums, 0, init);
		System.out.println(list);
	}

	private static void solve(int[] ip, int len, List<Integer> op) {
		if (len == ip.length) {
			return;
		}
		if (!op.isEmpty() && ip[len] < op.get(op.size() - 1)) {
			return;
		}

		for (int i = len; i < ip.length; i++) {
			if (op.isEmpty() || ip[i] >= op.get(op.size() - 1)) {
				op.add(ip[i]);
			}

			if (op.size() > 1) {
				list.add(new ArrayList<>(op));
			}
			solve(ip, i + 1, op);
			if (!op.isEmpty()) {
				op.remove(op.size() - 1);
			}

		}

	}

}
