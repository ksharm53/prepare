package feb07;

public class WateringPlants {

	public static void main(String[] args) {
		int[] plants = { 7, 7, 7, 7, 7, 7, 7 };
		int capacity = 8;
		System.out.println(solve(plants, capacity));

	}

	private static int solve(int[] plants, int capacity) {
		int start = 0;
		int soFarCapacity = capacity;
		int steps = 0;
		while (start < plants.length) {
			if (soFarCapacity < plants[start]) {
				steps += (start - 0) * 2;
				soFarCapacity = capacity;
			}
			soFarCapacity -= plants[start];
			steps++;
			start++;
		}

		return steps;
	}

}
