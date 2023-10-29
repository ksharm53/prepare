package may1;

public class PredictPartyVictory {
	static int counter;

	public static void main(String[] args) {
		String senate = "DRRDRDRDRDDRDRDR";
		counter = 0;
		System.out.println(solve(senate));
		System.out.println(counter);
	}

	private static String solve(String senate) {
		StringBuilder sb = new StringBuilder(senate);

		System.out.println(senate.length());

		int idx = 0;

		while (sb.length() > 1) {
			counter++;
			if (idx < sb.length() && sb.charAt(idx) == 'R') {
				int dIdx = sb.indexOf("D", idx);
				int dIdxLoop = sb.indexOf("D", 0);

				if (dIdx == -1 && dIdxLoop == -1) {
					return "Radiant";
				} else {
					int consider = dIdx == -1 ? dIdxLoop : dIdx;
					if (consider > idx) {
						idx++;
					}
					sb.deleteCharAt(consider);

				}

			}

			else if (idx < sb.length() && sb.charAt(idx) == 'D') {
				int rIdx = sb.indexOf("R", idx);
				int rIdxLoop = sb.indexOf("R", 0);

				if (rIdx == -1 && rIdxLoop == -1) {
					return "Dire";
				} else {
					int consider = rIdx == -1 ? rIdxLoop : rIdx;
					if (consider > idx) {
						idx++;
					}
					sb.deleteCharAt(consider);
				}

			}

			if (idx == sb.length()) {
				idx = 0;
			}

		}

		return sb.charAt(0) == 'R' ? "Radiant" : "Dire";
	}

}
