package CodeSignal;

import java.util.HashMap;
import java.util.Map;

public class CodeSignal_UniquePairsWithEqualDigitNumber {

	public static void main(String[] args) {
		int[] num = { 1, 151, 241, 1, 9, 22, 351 , 351, 351, 851, 651};
		System.out.println(solve(num));

	}

	private static int solve(int[] num) {
		Map<String, Integer> set = new HashMap<>();
		int res = 0;

		for (int i = 0; i < num.length; i++) {
			String val = String.valueOf(num[i]);

			for (int j = 0; j < val.length(); j++) {
				StringBuilder sb = new StringBuilder(val);
				sb.replace(j, j + 1, "X");
				if (set.containsKey(sb.toString())) {
					res += set.get(sb.toString());
				}
				set.put(sb.toString(), set.getOrDefault(sb.toString(), 0) + 1);
			}
			if (set.containsKey(val)) {
				res -= val.length() * set.get(val);
			}
			set.put(val, set.getOrDefault(val, 0) + 1);

		}
		return res;
	}

}
