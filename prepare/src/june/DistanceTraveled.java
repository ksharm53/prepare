package june;

public class DistanceTraveled {

	public static void main(String[] args) {
		int mainTank = 5;
		int additionalTank = 10;

		System.out.println(solve(mainTank, additionalTank));

	}

	private static int solve(int mainTank, int additionalTank) {
		int count = 0;
		int res = 0;
		while (additionalTank > 0 && mainTank >= 5) {
			count++;
			mainTank -= 4;
			additionalTank--;
		}

		res += count * 5 * 10;

		res += mainTank * 10;

		return res;
	}

}
