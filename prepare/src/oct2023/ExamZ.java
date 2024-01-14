package oct2023;

public class ExamZ {

	public static void main(String[] args) {
		System.out.println(solveIterative("value"));
		System.out.println(solverecursive("value"));
	}

	private static String solverecursive(String string) {
		if (string.length() < 1) {
			return string;
		}

		return string.charAt(0) + solverecursive(string.substring(1));

	}

	private static String solveIterative(String string) {
		String r = "";
		for (int i = string.length() - 1; i >= 0; i--) {
			r += string.charAt(i);
		}

		return r;

	}

}
