package may1;

import java.util.ArrayList;
import java.util.List;

public class CircularGameLosers {

	public static void main(String[] args) {
		int n = 5;
		int k = 2;

		System.out.println(circularGameLosers(n, k));

	}

	public static int[] circularGameLosers(int n, int k) {
		int[] arr = new int[n];
		List<Integer> list = new ArrayList<>();
		int pos = 0;
		int iter = 1;
		arr[pos] = -1;
		while (true) {
			int nextPos = (pos + (iter * k)) % n;
			if (nextPos - 1 < 0 || nextPos - 1 >= arr.length) {
				break;
			}
			if (arr[nextPos] == -1) {
				break;
			} else {
				arr[nextPos] = -1;
			}
			pos = nextPos;
			iter++;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				list.add(i + 1);
			}
		}
		int[] res = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

}
