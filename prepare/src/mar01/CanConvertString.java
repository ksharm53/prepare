package mar01;

import java.util.HashMap;
import java.util.Map;

public class CanConvertString {

	public static void main(String[] args) {
		String s = "jicfxaa";
		String t = "ocxltbp";
		int k = 15;

		System.out.println(solve(s, t, k));

	}

	private static boolean solve(String s, String t, int k) {

		if (s.length() != t.length()) {
			return false;
		}
		Map<Integer, Integer> map = new HashMap<>();

		int size = s.length();
		for (int i = 0; i < size; i++) {
			char sChar = s.charAt(i);
			char tChar = t.charAt(i);
			if (sChar != tChar) {
				int temp = 0;
				if (tChar < sChar) {
					temp = ((26 - (sChar - 'a')) + (tChar - 'a')) % 26;
				} else {
					temp = tChar - sChar;
				}

				if (temp > k) {
					return false;
				}

				if (map.get(temp) != null) {
					int val = map.get(temp) * 26 + temp;
					if (val > k) {
						return false;
					}
				}

				map.put(temp, map.getOrDefault(temp, 0) + 1);
			}

		}
		return true;
	}

}
