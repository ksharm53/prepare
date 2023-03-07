package CodeSignal;

import java.util.HashSet;
import java.util.Set;

public class CodeSignal_StringQuestionA {

	public static void main(String[] args) {
		String s = "4u05q";
		String t = "ed0r7";
		System.out.println(solve(s, t));

	}

	private static int solve(String s, String t) {
		Set<Integer> setS = new HashSet<>();
		Set<Integer> setT = new HashSet<>();
		int counter = 0;

		for (int i = 0; i < s.length(); i++) {
			char each = s.charAt(i);
			if (!Character.isAlphabetic(each)) {
				setS.add(i);
			}
		}

		for (int i = 0; i < t.length(); i++) {
			char each = t.charAt(i);
			if (!Character.isAlphabetic(each)) {
				setT.add(i);
			}
		}

		for (Integer integer : setS) {
			StringBuilder sb = new StringBuilder(s);
			sb.deleteCharAt(integer);
			boolean ret = sb.toString().compareTo(t) < 0 ? true : false;
			if (ret) {
				counter++;
			}
		}

		for (Integer integer : setT) {
			StringBuilder sb = new StringBuilder(t);
			sb.deleteCharAt(integer);
			boolean ret = s.compareTo(sb.toString()) < 0 ? true : false;

			if (ret) {
				counter++;
			}
		}
		return counter;
	}

}
