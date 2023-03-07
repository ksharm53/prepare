package CodeSignal;

public class CodeSignal_SumOfAllPossibleConcatenatedArrayElement {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4 };
		System.out.println(solve(a));

	}

	private static long solve(int[] a) {
		int sum = 0;
		long total = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}

		for (int i = 0; i < a.length; i++) {
			total += sum * ((long) Math.pow(10, String.valueOf(a[i]).length())) + (a.length * a[i]);
		}
		return total;
	}

}
