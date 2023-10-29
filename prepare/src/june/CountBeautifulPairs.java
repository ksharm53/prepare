package june;

public class CountBeautifulPairs {

	public static void main(String[] args) {
		System.out.println(countBeautifulPairs(new int[] { 756, 1324, 2419, 495, 106, 111, 1649, 1474, 2001, 1633, 273,
				1804, 2102, 1782, 705, 1529, 1761, 1613, 111, 186, 412 }));

	}

	public static int countBeautifulPairs(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int firstDigit = nums[i];
			while (firstDigit > 10) {
				firstDigit = firstDigit / 10;
			}
			for (int j = i + 1; j < nums.length; j++) {
				int lastDigit = nums[j] % 10;
				if (gcd(firstDigit, lastDigit) == 1) {
					count++;
				}
			}
		}
		return count;
	}

	static int gcd(int a, int b) {
		if (a == 0 || b == 0)
			return 0;

		if (a == b)
			return a;

		if (a > b)
			return gcd(a - b, b);

		return gcd(a, b - a);
	}

}
