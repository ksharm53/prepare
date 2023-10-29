package may1;

public class MaxDistToClosest {

	public static void main(String[] args) {
		int[] seats = { 0, 1 };
		System.out.println(solve(seats));

	}

	private static int solve(int[] seats) {
		int max = Integer.MIN_VALUE;
		int start = 0;

		if (seats[start] == 0) {
			while (start < seats.length && seats[start] == 0) {
				start++;
			}
			max = Math.max(max, (start - 0));
		}

		int end = seats.length - 1;

		if (seats[end] == 0) {
			while (end >= 0 && seats[end] == 0) {
				end--;
			}
			max = Math.max(max, (seats.length - 1 - end));
		}

		for (int i = start + 1; i < end; i++) {
			int count = 0;
			while (i < end && seats[i] == 0) {
				count++;
				i++;
			}
			if (count % 2 == 0) {
				max = Math.max(max, count / 2);
			} else {
				max = Math.max(max, (count / 2) + 1);
			}
		}

		return max;

	}

}
