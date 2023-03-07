package TikTok;

import java.util.HashSet;
import java.util.Set;

public class SmallestPositiveInteger {

	public static void main(String[] args) {
		int m = 100, n = 3, r = 1;
		System.out.println(solve(m, n, r));
	}

	private static int solve(int m, int n, int r) {
		if (r >= n) {
			return -1;
		}

		Set<Integer> visited = new HashSet<>();
		int target = r % m;
		visited.add(target);
		int current = 0;
		int ret = 0;

		while (!visited.contains(current)) {
			visited.add(current);
			int difference = n - current;
			int moves = difference;
			moves = difference / m;
			int left = difference % m;
			if (left > 0) {
				moves++;
			}
			ret = ret + moves;
			current = (current + (m * moves)) % n;
		}

		if (current == target) {
			return ret + (r / m);
		}

		else {
			return -1;
		}

	}

}
