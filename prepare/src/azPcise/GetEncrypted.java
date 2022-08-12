package azPcise;

public class GetEncrypted {

	public static void main(String[] args) {
		int[] numbers = { 3, 4, 8, 9, 6, 7 };
		System.out.println(solve(numbers));
	}

	private static String solve(int[] numbers) {
		if (numbers.length == 0) {
			return "";
		}
		if (numbers.length == 2) {
			StringBuilder sb = new StringBuilder();
			for (int i : numbers) {
				sb.append(i);
			}
			return sb.toString();
		}

		int[] recurse = new int[numbers.length - 1];
		for (int i = 1; i < numbers.length - 1; i++) {
			int previousSum = numbers[i] + numbers[i - 1];
			int rightMost = previousSum % 10;
			recurse[i - 1] = rightMost;
			int Nextsum = numbers[i] + numbers[i + 1];
			recurse[i] = Nextsum % 10;
		}
		return solve(recurse);
	}

}
