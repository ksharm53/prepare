package newBeginning;

public class Partition {

	public static void main(String[] args) {
		int A = 5;
		int[] B = { 1, 2, 3, 0, 3 };

		System.out.println(solve(A, B));
		System.out.println(usingSuffixArray(A, B));

	}

	private static int usingSuffixArray(int a, int[] b) {
		int total = 0;
		for (int i : b) {
			total += i;
		}
		if (total % 3 != 0) {
			return 0;
		}
		int counter = 0;
		int[] suffixArray = new int[b.length];

		int oneThird = total / 3;
		int tempTotal = 0;

		for (int i = suffixArray.length - 1; i >= 0; i--) {
			tempTotal += b[i];
			if (tempTotal == oneThird) {
				suffixArray[i] = 1;
			}
		}

		tempTotal = 0;
		for (int i = 0; i < b.length; i++) {
			tempTotal += b[i];
			if (tempTotal == oneThird) {
				for (int j = i + 2; j < suffixArray.length; j++) {
					if (j < suffixArray.length && suffixArray[j] == 1) {
						counter++;
					}
				}
			}
		}
		return counter;

	}

	private static int solve(int a, int[] b) {

		int total = 0;
		for (int i : b) {
			total += i;
		}
		int counter = 0;

		int first = 0;
		for (int i = 0; i < b.length; i++) {
			first += b[i];
			int second = 0;
			for (int j = i + 1; j < b.length - 1; j++) {
				second += b[j];
				if (first == second && second == (total - first - second)) {
					counter++;
				}
			}
		}
		return counter;
	}

}
