package arraysAndStrings;

import java.util.Arrays;
import java.util.List;

public class TruckTour {

	public static void main(String[] args) {
		List<List<Integer>> petrolpumps = Arrays.asList(Arrays.asList(1, 5), Arrays.asList(10, 3), Arrays.asList(3, 4));

		System.out.println(solve(petrolpumps));

	}

	private static int solve(List<List<Integer>> petrolpumps) {
		if (petrolpumps.size() == 1) {
			return 0;
		}
		int counter = petrolpumps.size();
		for (int i = 0; i < petrolpumps.size(); i++) {
			List<Integer> eachStation = petrolpumps.get(i);
			counter = petrolpumps.size();
			if (eachStation.get(0) < eachStation.get(1)) {
				continue;
			}
			int petrol = eachStation.get(0);
			int distance = eachStation.get(1);
			int tempIndex = i;
			while (petrol >= distance && counter > 0) {
				int nextIndex = (tempIndex + 1) % petrolpumps.size();
				petrol = petrol - petrolpumps.get(tempIndex).get(1) + petrolpumps.get(nextIndex).get(0);
				distance = petrolpumps.get(nextIndex).get(1);
				tempIndex = (tempIndex + 1) % petrolpumps.size();
				counter--;
			}
			if (counter == 0) {
				return i;
			}
		}
		return -1;
	}

}
