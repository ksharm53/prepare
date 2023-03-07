package newBeginning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exam {

	static Map<String, Boolean> map;

	public static class Pair {
		int carPosition;
		int time;

		public Pair(int carPosition, int time) {
			super();
			this.carPosition = carPosition;
			this.time = time;
		}

		public int getCarPosition() {
			return carPosition;
		}

		public void setCarPosition(int carPosition) {
			this.carPosition = carPosition;
		}

		public int getTime() {
			return time;
		}

		public void setTime(int time) {
			this.time = time;
		}

	}

	public static void main(String[] args) {
		int c = 1;
		int x1 = 1;
		int y1 = 1;
		int x2 = 5;
		int y2 = 4;

		map = new HashMap<>();
		System.out.println(solve(c, x1, y1, x2, y2));

		List<Integer> arrival = Arrays.asList(0, 0, 1, 4);
		List<Integer> street = Arrays.asList(0, 1, 1, 0);

		System.out.println(solveIntersection(arrival, street));

	}

	private static List<Integer> solveIntersection(List<Integer> arrival, List<Integer> street) {
		if (arrival.size() == 0 || street.size() == 0) {
			return new ArrayList<>();
		}

		List<Integer> result = new ArrayList<>();
		int[] resultArray = new int[arrival.size()];

		List<Pair> queueMain = new ArrayList<>();
		List<Pair> queuefisrtAve = new ArrayList<>();
		List<Integer> lastCarPassed = new ArrayList<>();

		int maxHour = Math.max(arrival.size() - 1, arrival.get(arrival.size() - 1));

		for (int i = 0; i <= maxHour; i++) {
			int indexCar1 = arrival.indexOf(i);
			int indexCar2 = arrival.lastIndexOf(i);

			for (int k = 0; k < queueMain.size(); k++) {
				Pair tempPair = queueMain.get(k);
				int tempTime = tempPair.getTime();
				int tempPosition = tempPair.getCarPosition();
				queueMain.remove(k);
				queueMain.add(k, new Pair(tempPosition, tempTime + 1));
			}

			for (int k = 0; k < queuefisrtAve.size(); k++) {

				Pair tempPair = queuefisrtAve.get(k);
				int tempTime = tempPair.getTime();
				int tempPosition = tempPair.getCarPosition();
				queuefisrtAve.remove(k);
				queuefisrtAve.add(k, new Pair(tempPosition, tempTime + 1));

			}

			for (int j = indexCar1; j <= indexCar2 && indexCar1 != -1 && indexCar2 != -1; j++) {
				if (street.get(j) == 0) {
					queueMain.add(new Pair(j, i));
				} else if (street.get(j) == 1) {
					queuefisrtAve.add(new Pair(j, i));
				}

			}
			// 0 for no car, 1 for 1 Ave, 2 for main street
			if (lastCarPassed.size() == 0 || lastCarPassed.get(lastCarPassed.size() - 1) == 0) {
				if (!queuefisrtAve.isEmpty()) {
					Pair temp = queuefisrtAve.get(0);
					int time = temp.getTime();
					resultArray[temp.getCarPosition()] = time;
					queuefisrtAve.remove(0);
					lastCarPassed.add(1);
				} else if (!queueMain.isEmpty()) {
					Pair temp = queueMain.get(0);
					int time = temp.getTime();
					resultArray[temp.getCarPosition()] = time;
					queueMain.remove(0);
					lastCarPassed.add(2);
				} else {
					lastCarPassed.add(0);
				}

			} else if (lastCarPassed.get(lastCarPassed.size() - 1) == 1) {
				if (!queuefisrtAve.isEmpty()) {
					Pair temp = queuefisrtAve.get(0);
					int time = temp.getTime();
					resultArray[temp.getCarPosition()] = time;
					queuefisrtAve.remove(0);
					lastCarPassed.add(1);
				} else if (!queueMain.isEmpty()) {
					Pair temp = queueMain.get(0);
					int time = temp.getTime();
					resultArray[temp.getCarPosition()] = time;
					queueMain.remove(0);
					lastCarPassed.add(2);
				} else {
					lastCarPassed.add(0);
				}
			} else if (lastCarPassed.get(lastCarPassed.size() - 1) == 2) {
				if (!queueMain.isEmpty()) {
					Pair temp = queueMain.get(0);
					int time = temp.getTime();
					resultArray[temp.getCarPosition()] = time;
					queueMain.remove(0);
					lastCarPassed.add(2);
				} else if (!queuefisrtAve.isEmpty()) {
					Pair temp = queuefisrtAve.get(0);
					int time = temp.getTime();
					resultArray[temp.getCarPosition()] = time;
					queuefisrtAve.remove(0);
					lastCarPassed.add(1);
				} else {
					lastCarPassed.add(0);
				}

			} else {
				lastCarPassed.add(0);
			}

		}

		for (Integer integer : resultArray) {
			result.add(integer);
		}
		return result;

	}

	private static boolean solve(int c, int x1, int y1, int x2, int y2) {
		String value = x1 + " " + y1;

		if (map.containsKey(value)) {
			return map.get(value);
		}

		double sqrt = Math.sqrt(x1 + y1);

		if (Math.floor(sqrt) == sqrt) {
			map.put(value, false);
			return false;
		}

		if (x1 == x2 && y1 == y2) {
			map.put(value, true);
			return true;
		}
		if (x1 > x2 || y1 > y2) {
			map.put(value, false);
			return false;
		}
		if (solve(c, x1 + y1, y1, x2, y2) || solve(c, x1, y1 + x1, x2, y2) || solve(c, x1 + c, y1 + c, x2, y2)) {
			map.put(value, true);
			return true;
		}
		return false;

	}

}
