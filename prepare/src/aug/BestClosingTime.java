package aug;

public class BestClosingTime {

	public static void main(String[] args) {
		String customers = "YYYY";
		System.out.println(solve(customers));

	}

	private static int solve(String customers) {
		int yCountRight = 0;
		int nCountleft = 0;

		int idxRes = -1;

		int min = Integer.MAX_VALUE;
		for (char eachChar : customers.toCharArray()) {
			if (eachChar == 'Y') {
				yCountRight++;
			}
		}

		for (int i = 0; i < customers.length(); i++) {
			int penality = yCountRight + nCountleft;
			if (penality < min) {
				min = penality;
				idxRes = i;
			}
			if (customers.charAt(i) == 'Y') {
				yCountRight--;
			} else {
				nCountleft++;
			}

			if (i == customers.length() - 1) {
				penality = yCountRight + nCountleft;
				if (penality < min) {
					min = penality;
					idxRes = i + 1;
				}
			}
		}
		return idxRes;
	}

}
