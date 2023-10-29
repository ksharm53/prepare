package june;

public class MinMoves {

	public static void main(String[] args) {
		int target = 1000000000;
		int maxDoubles = 0;

		System.out.println(solve(target, maxDoubles));
	}

	private static int solve(int target, int maxDoubles) {
		int events = 0;
		while (target > 1) {
			if (maxDoubles > 0) {
				if (target % 2 == 0) {
					target /= 2;
					maxDoubles--;
					events++;
				} else {
					target--;
					events++;
				}
			} else {
				events += target-1;
				target = 0;
			}

		}

		return events;
	}

}
