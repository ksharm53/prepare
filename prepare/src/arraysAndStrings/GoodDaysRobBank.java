package arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class GoodDaysRobBank {

	public static void main(String[] args) {
		int[] security = {1,2,3,4,5,6};
		int time = 0;

		System.out.println(solve(security, time));

	}

	private static List<Integer> solve(int[] security, int time) {
		List<Integer> list = new ArrayList<>();
		boolean left = false;
		boolean right = false;

		int frame = (time * 2) + 1;

		if (security.length < frame) {
			return list;
		}

		for (int i = time; i < security.length - time; i++) {
			int temp = i;
			int forwardTemp = i;
			int forwardlimit = forwardTemp + time;
			int backLimit = temp - time;
			if (left) {
				if (temp - 1 >= 0 && security[temp] <= security[temp - 1]) {
					temp = backLimit;
				} else {
					left = false;
				}
			} else {
				while (temp - 1 >= 0 && temp > backLimit) {
					if (security[temp] <= security[temp - 1]) {
						temp--;
						continue;
					} else {
						break;
					}
				}
			}
			if (right) {
				if (forwardlimit - 1 < security.length && security[forwardlimit-1] <= security[forwardlimit]) {
					forwardTemp = forwardlimit;
				} else {
					right = false;
				}
			} else {
				while (forwardTemp + 1 < security.length && forwardTemp < forwardlimit) {
					if (security[forwardTemp] <= security[forwardTemp + 1]) {
						forwardTemp++;
						continue;
					} else {
						break;
					}
				}
			}
			if (temp == backLimit && forwardTemp == forwardlimit) {
				list.add(i);
				left = true;
				right = true;
			} else {
				left = false;
				right = false;
			}
		}
		return list;
	}

}
