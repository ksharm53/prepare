package Apr1;

public class NumRescueBoats {

	public static int lmt;

	public static void main(String[] args) {
		int[] people = { 5, 1, 4, 2 };
		int limit = 6;

		lmt = limit;

		System.out.println(solve(people, limit, 2, people.length - 1));
	}

	private static int solve(int[] people, int limit, int personCount, int size) {
		if (size < 0) {
			return 0;
		}

		if (limit >= people[size] && personCount > 0) {
			int liya = solve(people, limit - people[size], personCount - 1, size - 1) + 1;
			int nahiLiya = solve(people, limit, personCount, size - 1);

			return Math.max(liya, nahiLiya);
		} else {
			return solve(people, lmt, 2, size);
		}
	}

}
