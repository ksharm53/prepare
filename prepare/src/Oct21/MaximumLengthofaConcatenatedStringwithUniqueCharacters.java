package Oct21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumLengthofaConcatenatedStringwithUniqueCharacters {

	public static void main(String[] args) {
		List<String> arr = Arrays.asList("un", "iq", "ue");
		System.out.println(solve(arr, 0, new ArrayList<>()));

	}

	private static boolean ifValid(List<String> stringSoFar, String string) {
		Set<Character> set = new HashSet<>();
		for (String each : stringSoFar) {
			for (char eachChar : each.toCharArray()) {
				set.add(eachChar);
			}
		}

		for (char eachChar : string.toCharArray()) {
			if (!set.add(eachChar)) {
				return false;
			}
		}
		return true;
	}

	private static int solve(List<String> arr, int start, List<String> stringSoFar) {
		if (start >= arr.size()) {
			int size = 0;
			for (int i = 0; i < stringSoFar.size(); i++) {
				size += stringSoFar.get(i).length();
			}
			return size;
		}

		if (ifValid(stringSoFar, arr.get(start))) {
			stringSoFar.add(arr.get(start));
			int include = solve(arr, start + 1, stringSoFar);
			stringSoFar.remove(stringSoFar.size() - 1);
			int exclude = solve(arr, start + 1, stringSoFar);
			return Math.max(include, exclude);

		} else {
			return solve(arr, start + 1, stringSoFar);
		}

	}

}
