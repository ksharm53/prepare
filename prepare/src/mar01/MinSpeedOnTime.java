package mar01;

public class MinSpeedOnTime {

	public static void main(String[] args) {
		int[] dist = { 1, 3, 2 };
		double hour = 2.7;
		System.out.println(solve(dist, hour));

	}

	private static int solve(int[] dist, double hour) {
		int min = 1;
		int max = 10000000;

		while (min <= max) {
			int mid = min + (max - min) / 2;
			if (validate(mid, dist, hour)) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}

		return min == 10000001 ? -1 : min;
	}

	private static boolean validate(int speed, int[] dist, double hour) {
		int time = 0;
		for (int i = 0; i < dist.length - 1; i++) {
			time += Math.ceil((double) dist[i] / speed);
		}
		return time + (double) dist[dist.length - 1] / speed <= hour;
	}

}
