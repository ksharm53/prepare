package may1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class IsEscapePossible {

	static Set<String> set;
	static Set<String> blockedSet;

	public static void main(String[] args) {
		int[][] blocked = { { 5, 20 }, { 10, 10 }, { 15, 10 }, { 10, 30 }, { 15, 30 }, { 20, 30 } };
		int[] source = { 10, 20 };
		int[] target = { 20, 30 };

		set = new HashSet<>();
		blockedSet = new HashSet<>();

		System.out.println(solve(blocked, source, target) && solve(blocked, target, source));

	}

	private static boolean solve(int[][] blocked, int[] source, int[] target) {

		if (blocked.length == 0)
			return true;

		buildMap(blocked);

		Queue<int[]> queue = new LinkedList<>();
		queue.add(source);
		set.add(source[0] + "-" + source[1]);
		int count = 0;
		while (!queue.isEmpty()) {
			if (count > 200)
				return true;

			for (int i = 0; i < queue.size(); i++) {
				int[] each = queue.poll();

				int x = each[0];
				int y = each[1];

				String one = (x + 1) + "-" + y;
				if (x + 1 < 1000000 && !blockedSet.contains(one) && !set.contains(one)) {
					if (x + 1 == target[0] && y == target[1]) {
						return true;
					}
					queue.add(new int[] { x + 1, y });
					set.add(one);
				}

				String two = (x - 1) + "-" + y;
				if (x - 1 >= 0 && !blockedSet.contains(two) && !set.contains(two)) {
					if (x - 1 == target[0] && y == target[1]) {
						return true;
					}
					queue.add(new int[] { x - 1, y });
					set.add(two);
				}

				String three = x + "-" + (y + 1);
				if (y + 1 < 1000000 && !blockedSet.contains(three) && !set.contains(three)) {
					if (x == target[0] && y + 1 == target[1]) {
						return true;
					}
					queue.add(new int[] { x, y + 1 });
					set.add(three);
				}

				String four = x + "-" + (y - 1);
				if (y - 1 >= 0 && !blockedSet.contains(four) && !set.contains(four)) {
					if (x == target[0] && y - 1 == target[1]) {
						return true;
					}
					queue.add(new int[] { x, y - 1 });
					set.add(four);
				}
			}

			count++;

		}

		return false;
	}

	private static void buildMap(int[][] blocked) {
		for (int[] each : blocked) {
			blockedSet.add(each[0] + "-" + each[1]);
		}

	}

}
