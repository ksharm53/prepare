package Apr1;

public class AddMinimum {

	public static void main(String[] args) {
		String word = "aaaaac";

		System.out.println(solve(word));

	}

	private static int solve(String word) {

		int count = 0;

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == 'a') {
				if (i + 1 < word.length() && word.charAt(i + 1) == 'b') {
					if (i + 2 < word.length() && word.charAt(i + 2) == 'c') {
						i = i + 2;
					} else {
						count++;
						i = i + 1;
					}
				} else if (i + 1 < word.length() && word.charAt(i + 1) == 'c') {
					count++;
					i++;
				} else {
					count += 2;
				}
			}

			else if (word.charAt(i) == 'b') {
				count++;
				if (i + 1 < word.length() && word.charAt(i + 1) == 'c') {
					i = i + 1;
				} else {
					count++;
				}

			}

			else if (word.charAt(i) == 'c') {
				count += 2;
			}
		}
		return count;
	}

}
