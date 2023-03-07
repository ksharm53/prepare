package Oct21;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumGeneticMutation {

	public static Set<String> set;
	public static List<String> list;
	public static int val;

	public static void main(String[] args) {
		String start = "AACCGGTT";
		String end = "AACCGCTA";
		String[] bank = { "AACCGGTA", "AACCGCTA", "AAACGGTA" };
		list = new ArrayList<>();
		set = new HashSet<>();
		val = Integer.MAX_VALUE;

		for (String each : bank) {
			list.add(each);
		}
		solve(start, end, 0);
		System.out.println(val == Integer.MAX_VALUE ? -1 : val);

	}

	private static int solve(String start, String end, int steps) {
		if (start.equals(end)) {
			val = Math.min(val, steps);
			return steps;
		}

		for (int i = 0; i < start.length(); i++) {
			for (int j = 1; j <= 4; j++) {
				StringBuilder sb = new StringBuilder(start);
				// 1 = A
				if (j == 1) {
					sb.setCharAt(i, 'A');
					if (list.contains(sb.toString()) && !set.contains(sb.toString())) {
						if (start.charAt(i) != 'A') {
							set.add(sb.toString());
							solve(sb.toString(), end, steps + 1);
						}
					}

				}
				// 2 = C
				else if (j == 2) {
					sb.setCharAt(i, 'C');
					if (list.contains(sb.toString()) && !set.contains(sb.toString())) {
						if (start.charAt(i) != 'C') {
							set.add(sb.toString());
							solve(sb.toString(), end, steps + 1);
						}
					}
				}

				// 3 = G
				else if (j == 3) {
					sb.setCharAt(i, 'G');
					if (list.contains(sb.toString()) && !set.contains(sb.toString())) {
						if (start.charAt(i) != 'G') {
							set.add(sb.toString());
							solve(sb.toString(), end, steps + 1);
						}
					}
				}

				// 4 = T
				else if (j == 4) {
					sb.setCharAt(i, 'T');
					if (list.contains(sb.toString()) && !set.contains(sb.toString())) {
						if (start.charAt(i) != 'T') {
							set.add(sb.toString());
							solve(sb.toString(), end, steps + 1);
						}
					}
				}
			}

		}
		return steps;
	}
}
