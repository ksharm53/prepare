package may1;

public class PunishmentNumber {

	public static void main(String[] args) {
		int n = 37;
		System.out.println(solve(n));

	}

	private static long solve(int n) {
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			long prod = i * i;
			String prodString = String.valueOf(prod);
			for (int j = 0; j < prodString.length(); j++) {
				String firstHalf = prodString.substring(0, j + 1) == "" ? "0" : prodString.substring(0, j + 1);
				String secondHalf = prodString.substring(j + 1, prodString.length()) == "" ? "0"
						: prodString.substring(j + 1, prodString.length());
				if (Integer.valueOf(firstHalf) + Integer.valueOf(secondHalf) == i) {
					sum += prod;
				}
			}
		}

		return sum;
	}

}
