package mar01;

import java.util.Arrays;

public class DistMoney {

	public static void main(String[] args) {
		int money = 17;
		int children = 2;

		System.out.println(solve(money, children));

	}

	private static int solve(int money, int children) {
		int pendingMoney = money - children;
		int[] arr = new int[children];
		int count = 0;

		Arrays.fill(arr, 1);

		if (pendingMoney < 0 || (money == 4 && children == 1)) {
			return -1;
		}

		if (pendingMoney < 7) {
			return 0;
		}

		int gandaIndex = -1;

		for (int i = 0; i < children; i++) {
			if (pendingMoney >= 7) {
				arr[i] += 7;
				pendingMoney -= 7;
			} else {
				if (arr[i] + pendingMoney == 4) {
					if (gandaIndex == -1) {
						gandaIndex = findIndex(arr, i);
					}

					arr[gandaIndex] += 1;
					pendingMoney -= 1;
					arr[i] += pendingMoney;
					pendingMoney = 0;
				} else {
					arr[i] += pendingMoney;
					pendingMoney = 0;
				}
			}

		}

		for (int i : arr) {
			if (i == 8) {
				count++;
			}
		}

		return pendingMoney > 0 ? count - 1 : count;
	}

	private static int findIndex(int[] arr, int idx) {
		int ret = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 8 && i != idx) {
				ret = i;
				break;
			}
		}
		if (ret == -1) {
			int last = (idx - 1 + arr.length) % arr.length;
			ret = last;
		}

		return ret;
	}

}
