package azPcise;

public class NetPriceChange {

	public static void main(String[] args) {
		int[] stckPrice = { 1, 3, 2, 4, 5 };

		System.out.println(solve(stckPrice));

	}

	private static int solve(int[] stckPrice) {
		int total = 0;
		int totalLeft = 0;
		int min = Integer.MAX_VALUE;
		int result = -1;

		for (int i : stckPrice) {
			total = total + i;
		}

		for (int i = 0; i < stckPrice.length; i++) {
			totalLeft = totalLeft + stckPrice[i];
			int averageLeft = totalLeft / (i + 1);
			int averageRight = (total - totalLeft)
					/ (stckPrice.length - (i + 1) == 0 ? 1 : (stckPrice.length - (i + 1)));
			if (min > Math.abs(averageRight - averageLeft)) {
				min = Math.abs(averageRight - averageLeft);
				result = i;
			}
		}
		return result + 1;
	}

}
