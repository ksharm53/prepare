package arraysAndStrings;

public class StringConversion {
	static int[][] matrix;

	public static void main(String[] args) {
		String a = "bBccC";
		String b = "BBC";

		/*
		 * matrix = new int[a.length() + 1][b.length() + 1];
		 * 
		 * for (int[] each : matrix) { Arrays.fill(each, -1); }
		 */

		// int lcs = solve(a, b, a.length(), b.length());
		/*
		 * int countUpper = 0; Map<Character, Integer> mapA = new HashMap<>();
		 * Map<Character, Integer> mapB = new HashMap<>(); for (char each :
		 * a.toCharArray()) { mapA.put(each, mapA.getOrDefault(each, 0) + 1); }
		 * 
		 * for (char each : b.toCharArray()) { mapB.put(each, mapB.getOrDefault(each, 0)
		 * + 1); }
		 * 
		 * for (char each : a.toCharArray()) { int frequency1 = mapA.get(each); int
		 * frequency2 = null == mapB.get(each) ? 0 : mapB.get(each); if
		 * (Character.isUpperCase(each) && frequency1 != frequency2) { countUpper =
		 * countUpper + frequency1 - frequency2; } }
		 * 
		 * if (lcs == b.length() && countUpper == 0) { System.out.println("YES"); } else
		 * { System.out.println("NO"); }
		 */
		System.out.println(abbreviation(a, b));
	}

	static String abbreviation(String a, String b) {
		boolean[][] isValid = new boolean[a.length() + 1][b.length() + 1];
		isValid[0][0] = true;

		for (int i = 1; i <= a.length(); i++) {
			if (Character.isUpperCase(a.charAt(i - 1))) {
				isValid[i][0] = false;
			} else
				isValid[i][0] = true;
		}
		// tabulation from start of string
		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					isValid[i][j] = isValid[i - 1][j - 1];
				} else if (Character.toUpperCase(a.charAt(i - 1)) == b.charAt(j - 1)) {
					isValid[i][j] = isValid[i - 1][j - 1] || isValid[i - 1][j];
				} else if (Character.isUpperCase(a.charAt(i - 1))) {
					isValid[i][j] = false;
				} else {
					isValid[i][j] = isValid[i - 1][j];
				}
			}
		}
		return isValid[a.length()][b.length()] ? "YES" : "NO";

	}

	private static int solve(String a, String b, int aLength, int bLength) {

		if (bLength == 0 || aLength == 0) {
			return 0;
		}

		if (matrix[aLength][bLength] != -1) {
			return matrix[aLength][bLength];
		}

		char charA = a.charAt(aLength - 1);
		char charB = b.charAt(bLength - 1);

		boolean isALower = Character.isLowerCase(charA);
		boolean isBLower = Character.isLowerCase(charB);

		if (!(!isALower && isBLower) && Character.toLowerCase(charA) == Character.toLowerCase(charB)) {
			return matrix[aLength][bLength] = 1 + solve(a, b, aLength - 1, bLength - 1);
		} else {
			return matrix[aLength][bLength] = Math.max(solve(a, b, aLength - 1, bLength),
					solve(a, b, aLength, bLength - 1));
		}

	}

}
