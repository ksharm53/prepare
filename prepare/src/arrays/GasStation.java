package arrays;

public class GasStation {
	static int circuit;

	public static void main(String[] args) {
		int[] gas = { 3, 3, 4 };
		int[] cost = { 3, 4, 4 };

		System.out.println(solve(gas, cost));
	}

	private static int solve(int[] gas, int[] cost) {

		for (int i = 0; i < gas.length; i++) {
			int temp = i;
			int remaining = gas[i] - cost[i];
			circuit = gas.length;
			circuit--;
			if (remaining < 0) {
				continue;
			}
			while (remaining > 0 && circuit > 0) {
				int next = (temp + 1) % gas.length;
				remaining += gas[next] - cost[next];
				circuit--;
				temp++;
			}
			if (circuit == 0 && remaining >= 0) {
				return i;
			}

		}
		return -1;
	}

}
