package june;

import java.util.ArrayList;
import java.util.List;

public class SpecialPerm {

	public static void main(String[] args) {
		int[] nums = { 1, 4, 3 };

		List<Integer> list = new ArrayList<>();
		for (int each : nums) {
			list.add(each);
		}
		List<Integer> prepare = new ArrayList<>();
		solve(prepare, list, 0);
	}

	private static void solve(List<Integer> prepare, List<Integer> list, int idx) {
		if (prepare.size() == list.size()) {
			System.out.println(prepare);
			if (prepare.size() > 0)
				prepare.remove(prepare.size() - 1);
			return;
		}

		for (int i = idx; i < list.size(); i++) {
			prepare.add(list.get(i));
			solve(prepare, list, i + 1);
		}
		if (prepare.size() > 0)
			prepare.remove(prepare.size() - 1);
	}

}
