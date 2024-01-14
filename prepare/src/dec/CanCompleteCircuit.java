package dec;

public class CanCompleteCircuit {

	public static void main(String[] args) {
		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 3, 4, 5, 1, 2 };

		System.out.println(solve(gas, cost));

	}

	private static int solve(int[] gas, int[] cost) {
		int gasAccumulated = 0;

		for (int i = 0; i < gas.length; i++) {
			int start = i;
			int curr = i;
			boolean flag = false;

			while (gasAccumulated >= 0) {
				if (flag && start == curr) {
					return start;
				}
				gasAccumulated += gas[curr] - cost[curr];
				curr = (curr + 1) % gas.length;
				flag = true;
			}
			gasAccumulated = 0;
			int tempIdx = (curr - 1 + gas.length) % gas.length;
			if (tempIdx < i) {
				return -1;
			} else {
				i = tempIdx;
			}
		}

		return -1;
	}

}
