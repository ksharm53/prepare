package Sept23;

public class CountingBits {

	public static void main(String[] args) {
		int n = 5;
		System.out.println(solve(n));

	}

	private static int[] solve(int n) {
		int[] result = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			result[i] = Integer.bitCount(i);
		}
		return result;
	}

}
