package aug;

public class ConvertToTitle {

	public static void main(String[] args) {
		int columnNumber = 701;
		System.out.println(solve(columnNumber));
	}

	private static String solve(int columnNumber) {
		StringBuilder sb = new StringBuilder();
		for (int i = 6; i >= 1; i--) {
			double val = Math.pow(26, i);
			if (val <= columnNumber) {
				int temp = i;
				while (temp > 0) {
					sb.append("Z");
				}
			}
		}

		return sb.toString();
	}

}
