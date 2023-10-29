package Apr1;

public class AddDigits {

	public static void main(String[] args) {
		int num = 38;
		System.out.println(addDigits(num));

	}

	public static int addDigits(int num) {
		while (num > 9) {
			int sum = 0;
			while (num > 0) {
				sum += num % 10;
				num = num / 10;
			}
			num = sum;
		}
		return num;
	}

}
