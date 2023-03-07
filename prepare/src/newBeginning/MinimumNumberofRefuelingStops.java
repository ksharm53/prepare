package newBeginning;

public class MinimumNumberofRefuelingStops {

	public static void main(String[] args) {
		int target = 100;
		int startFuel = 50;
		int[][] stations = { { 25, 50 }, { 50, 25 } };

		System.out.println(solve(target, startFuel, stations));
	}

	private static int solve(int target, int startFuel, int[][] stations) {
		int result = 0;
		int previous = 0;

		if (startFuel == target) {
			return 0;
		}
		if (stations.length == 0 && startFuel < target) {
			return -1;
		}

		for (int i = 0; i < stations.length; i++) {
			int fuelNeede = stations[i][0];
			int fuelRefuel = stations[i][1];

			if (startFuel < (fuelNeede - previous)) {
				return -1;
			}

			startFuel -= fuelNeede - previous;
			previous = fuelNeede;

			if (i + 1 < stations.length && startFuel >= (stations[i + 1][0] - previous)
					|| (startFuel >= (target - previous))) {
				continue;
			} else {
				startFuel += fuelRefuel;
				result++;
			}

		}
		if (startFuel < (target - previous)) {
			return -1;
		}
		return result;

	}

}
