package may1;

import java.util.HashMap;
import java.util.Map;

public class TaskSchedulerII {

	static Map<Integer, Long> map;

	public static void main(String[] args) {
		int[] tasks = { 961, 208, 548, 600, 359, 548, 313, 544, 548, 548, 548, 977, 875, 368, 25, 365, 364, 368, 151,
				794, 394, 368, 259, 208, 368, 945, 232, 25, 586, 961, 961, 471, 548, 313, 135, 961, 365, 394, 586, 930,
				544, 491, 975, 151, 930, 364, 838, 151, 600, 135, 930, 364, 259, 313, 314, 975 };

		int space = 43;

		map = new HashMap<>();

		System.out.println(solve(tasks, space) - 1);

	}

	private static long solve(int[] tasks, int space) {
		long days = 1;
		for (int i = 0; i < tasks.length; i++) {
			if (map.containsKey(tasks[i])) {
				long delta = (days - map.get(tasks[i]) - 1);

				System.out.println("tasks[i]: " + tasks[i] + " i: " + i + " Last Idx: " + map.get(tasks[i])
						+ " spaceDiyaGaya: " + (space - delta));

				if (delta < space) {
					days += space - delta;
				}
				map.put(tasks[i], days);

			} else {
				map.put(tasks[i], days);
			}
			days++;
		}

		return days;
	}

}
