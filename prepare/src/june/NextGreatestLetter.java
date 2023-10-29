package june;

import java.util.TreeSet;

public class NextGreatestLetter {

	public static void main(String[] args) {
		char[] letters = { 'c', 'f', 'j' };
		char target = 'c';
		System.out.println(solve(letters, target));
	}

	private static char solve(char[] letters, char target) {
		TreeSet<Character> set = new TreeSet<>();
		for (char each : letters) {
			set.add(each);
		}
		Character val = set.ceiling(target);
		if (val != null && val == target) {
			int idx = binarySearch(val, letters);
			if (idx + 1 >= letters.length) {
				return letters[0];
			} else {
				return letters[idx + 1];
			}
		}

		return val == null ? letters[0] : val;
	}

	private static int binarySearch(char val, char[] letters) {
		int start = 0;
		int end = letters.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (letters[mid] == val) {
				start = mid + 1;
			} else if (letters[mid] < val) {
				start = mid + 1;
			} else if (letters[mid] > val) {
				end = mid - 1;
			}
		}
		return end;
	}

}
