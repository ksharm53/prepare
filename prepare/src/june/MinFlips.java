package june;

public class MinFlips {

	public static void main(String[] args) {
		int a = 8;
		int b = 3;
		int c = 5;

		System.out.println(solve(a, b, c));

	}

	private static int solve(int a, int b, int c) {
		String aVal = Integer.toBinaryString(a);
		String bVal = Integer.toBinaryString(b);
		String cVal = Integer.toBinaryString(c);

		int max = Math.max(Math.max(aVal.length(), bVal.length()), cVal.length());
		if (cVal.length() < max) {
			StringBuilder sb = new StringBuilder(cVal);
			while (sb.length() < max) {
				sb.insert(0, '0');
			}

			cVal = sb.toString();
		}

		int idxA = aVal.length() - 1;
		int idxB = bVal.length() - 1;
		int idxC = cVal.length() - 1;

		int count = 0;

		while (idxC >= 0) {
			if (cVal.charAt(idxC) == '1') {
				if ((idxB < 0 || bVal.charAt(idxB) == '0') && (idxA < 0 || aVal.charAt(idxA) == '0')) {
					count++;
				}
			}

			else {
				if (idxB >= 0 && bVal.charAt(idxB) == '1') {
					count++;
				}
				if (idxA >= 0 && aVal.charAt(idxA) == '1') {
					count++;
				}
			}
			idxC--;
			idxA--;
			idxB--;
		}

		return count;
	}

}
