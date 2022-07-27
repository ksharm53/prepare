package arraysAndStrings;

import java.util.Stack;

public class StockSpan {

	public static void main(String[] args) {
		int n = 7;
		int[] price = { 100, 80, 60, 70, 60, 75, 85 };

		System.out.println(solve(price, n));
	}

	private static int[] solve(int[] price, int n) {
		int[] result = new int[price.length];
		Stack<int[]> s = new Stack<>();

		for (int i = 0; i < price.length; i++) {
			if (s.size() == 0) {
				result[i] = i + 1;
			} else if (s.size() > 0 && price[i] >= s.peek()[0]) {
				while (s.size() > 0 && price[i] >= s.peek()[0]) {
					s.pop();
				}
				if (s.size() == 0) {
					result[i] = i + 1;
				} else if (s.size() > 0 && price[i] < s.peek()[0]) {
					result[i] = i - s.peek()[1];
				}
			} else if (s.size() > 0 && price[i] < s.peek()[0]) {
				result[i] = i - s.peek()[1];
			}

			s.add(new int[] { price[i], i });
		}
		return result;
	}

}
