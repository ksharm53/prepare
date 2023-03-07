package novTwentyFour;

public class PerfectNumber {

	public static void main(String[] args) {
		int num = 28;
		int sum = findDivisors(num);
		System.out.println(sum);
		System.out.println(sum == num);

	}

	public static int findDivisors(int num) {
		int sum = 0;
		for (int i = 1; i <= (int) Math.sqrt(num); i++) {
			if (num % i == 0) {
				if (i == num / i) {
					if (i != num) {
						sum += i;
					}
				} else {
					if (i != num) {
						sum += i;
					}
					if (num / i != num) {
						sum += num / i;
					}

				}
			}
		}
		return sum;
	}

}
