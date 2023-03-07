package CodeSignal;

public class CodeSignalPatternSource {

	public static void main(String[] args) {
		String pattern = "010";
		String source = "amazing";
		System.out.println(solution(pattern, source));

	}

	public static int solution(String pattern, String source) {

		int length = pattern.length();

		if (pattern.length() > source.length()) {
			return 0;
		}
		int counter = 0;
		int i = 0;
		int j = 0;

		while (j < source.length()) {
			if (j - i + 1 < length) {
				j++;
			} else if (j - i + 1 == length) {
				boolean flag = false;
				int idx = 0;
				while (i + idx <= j && i + idx < source.length()) {
					if (pattern.charAt(idx) == '0'
							&& !((source.charAt(i + idx) == 'a') || (source.charAt(i + idx) == 'e')
									|| (source.charAt(i + idx) == 'i') || (source.charAt(i + idx) == 'o')
									|| (source.charAt(i + idx) == 'u') || (source.charAt(i + idx) == 'y'))) {
						flag = true;
						break;
					}

					else if (pattern.charAt(idx) == '1'
							&& ((source.charAt(i + idx) == 'a') || (source.charAt(i + idx) == 'e')
									|| (source.charAt(i + idx) == 'i') || (source.charAt(i + idx) == 'o')
									|| (source.charAt(i + idx) == 'u') || (source.charAt(i + idx) == 'y'))) {
						flag = true;
						break;
					}
					idx++;
				}
				if (!flag) {
					counter++;
				}
				i++;
				j++;
			}
		}

		return counter;
	}

}
