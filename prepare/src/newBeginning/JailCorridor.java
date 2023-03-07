package newBeginning;

import java.util.Arrays;
import java.util.List;

public class JailCorridor {

	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(1, 1, 0, 0, 1, 1);
		int B = 1;

		System.out.println(solve(A, B));
		System.out.println(solveAgain(A, B));

	}

	public static int solve(List<Integer> A, int B) {
		int ans = 0;
		int n = A.size();
		int i = 0;
		while (i < n) {
			int l = Math.max(0, i - B + 1);
			int r = Math.min(n - 1, i + B - 1);
			boolean bulb_found = false;
			for (int j = r; j >= l; j--) {
				if (A.get(j) == 1) {
					bulb_found = true;
					ans++;
					i = j + B;
					break;
				}
			}
			if (bulb_found == false)
				return -1;
		}
		return ans;
	}

	private static int solveAgain(List<Integer> a, int b) {
		int i = 0;
		int counter = 0;

		while (i < a.size()) {
			int min = Math.max(0, i - b + 1);
			int max = Math.min(i + b - 1, a.size() - 1);
			boolean flag = false;

			for (int j = max; j >= min; j--) {
				if (a.get(j) == 1) {
					counter++;
					flag = true;
					i = j + b;
					break;
				}
			}
			if (!flag) {
				return -1;
			}
		}
		return counter == 0 ? -1 : counter;
	}

}
