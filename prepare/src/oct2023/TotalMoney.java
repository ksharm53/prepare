package oct2023;

public class TotalMoney {

	public static void main(String[] args) {
		int n = 20;
		System.out.println(totalMoney(n));
	}

	public static int totalMoney(int n) {
		int count = 0;
		int div = n / 7;
		int rem = n % 7;
		for (int i = 0; i < div; i++) {
			count += (28 + (7 * i));
		}

		for (int i = 1; i <= rem; i++) {
			count += div + i;
		}

		return count;
	}

}
