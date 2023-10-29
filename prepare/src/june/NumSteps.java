package june;

public class NumSteps {

	public static void main(String[] args) {
		String s = "1101";
		System.out.println(solve(s));

	}

	private static int solve(String s) {
		int val = Integer.parseInt(s, 2);
		int steps = 0;
		while (val > 1) {
			steps++;
			if (val % 2 == 0) {
				val /= 2;

			} else {
				val++;
			}
		}
		return steps;
	}

}
