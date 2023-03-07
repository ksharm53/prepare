package CodeSignal;

public class CodeSignal_MakeIncreasing {

	public static void main(String[] args) {
		int[] num = { 13, 31, 30 };
		System.out.println(solve(num));

	}

	private static boolean solve(int[] num) {
		int voilations = 0;
		int index = -1;

		for (int i = 0; i < num.length; i++) {
			if (i - 1 >= 0 && num[i] < num[i - 1]) {
				voilations++;
				index = i - 1;
			}
		}

		if (voilations == 0) {
			return true;
		}
		if (voilations > 1) {
			return false;
		}

		String val = String.valueOf(num[index]);
		for (int i = 0; i < val.length(); i++) {
			for (int j = i + 1; j < val.length(); j++) {
				StringBuilder sb = new StringBuilder(val);
				char temp = sb.charAt(j);
				sb.replace(j, j + 1, String.valueOf(sb.charAt(i)));
				sb.replace(i, i + 1, String.valueOf(temp));

				int number = Integer.valueOf(sb.toString());
				if (index - 1 >= 0 && index + 1 < num.length && num[index - 1] < number && number < num[index + 1]) {
					return true;
				}
			}
		}
		if (index + 1 < num.length) {
			val = String.valueOf(num[index + 1]);
			for (int i = 0; i < val.length(); i++) {
				for (int j = i + 1; j < val.length(); j++) {
					StringBuilder sb = new StringBuilder(val);
					char temp = sb.charAt(j);
					sb.replace(j, j + 1, String.valueOf(sb.charAt(i)));
					sb.replace(i, i + 1, String.valueOf(temp));

					int number = Integer.valueOf(sb.toString());
					if (index + 2 < num.length && num[index] < number && number < num[index + 2]) {
						return true;
					}
				}
			}
		}

		return false;
	}

}
