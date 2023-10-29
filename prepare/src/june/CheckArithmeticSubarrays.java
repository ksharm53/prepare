package june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckArithmeticSubarrays {

	public static void main(String[] args) {
		int[] nums = { 4, 6, 5, 9, 3, 7 };
		int[] l = { 0, 0, 2 };
		int[] r = { 2, 3, 5 };

		System.out.println(solve(nums, l, r));

	}

	private static List<Boolean> solve(int[] nums, int[] l, int[] r) {
		int size = l.length;
		List<Boolean> res = new ArrayList<>();

		outer: for (int i = 0; i < size; i++) {
			int[] val = Arrays.copyOfRange(nums, l[i], r[i] + 1);
			if (val.length < 2) {
				res.add(false);
				continue;
			}

			Arrays.sort(val);

			int diff = val[1] - val[0];
			for (int j = 1; j < val.length - 1; j++) {
				if (val[j + 1] - val[j] != diff) {
					res.add(false);
					continue outer;
				}
			}

			res.add(true);
		}

		return res;
	}

}
