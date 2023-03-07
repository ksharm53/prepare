package arrays09162022;

public class IsAdmissibleOverpayment {

	public static void main(String[] args) {
		double[] prices = { 220 };
		String[] notes = { "120.0000% higher than in-store" };
		double x = 120;
		System.out.println(solve(prices, notes, x));
	}

	static boolean solve(double[] prices, String[] notes, double x) {
		int size = prices.length;
		double sum = 0.00d;
		for (int i = 0; i < size; i++) {
			String value = notes[i];
			double price = prices[i];
			double per;
			if (value.contains("higher")) {
				per = Double.parseDouble(value.substring(0, value.indexOf("%")));
				double costPrice = price * 100 / (100 + per);
				sum += price - costPrice;
				System.out.println(sum);

			} else if (value.contains("lower")) {
				per = Double.parseDouble(value.substring(0, value.indexOf("%")));
				double costPrice = price * per / 100;
				sum -= costPrice - price;
				System.out.println(sum);
			}

		}
		System.out.println(sum);
		return sum <= x ? true : false;

	}

}
