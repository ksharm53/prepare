package Oct21;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class LargestPalindromicNumber {

	public static void main(String[] args) {
		String num = "000000";
		System.out.println(solve(num));

	}

	private static String solve(String num) {
		Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
		for (char eachChar : num.toCharArray()) {
			map.put(Character.getNumericValue(eachChar), map.getOrDefault(Character.getNumericValue(eachChar), 0) + 1);
		}
		StringBuilder sb = new StringBuilder();
		int startIdx = 0;
		boolean flag = false;
		int mid = Integer.MIN_VALUE;
		for (Entry<Integer, Integer> eachEntry : map.entrySet()) {
			if (eachEntry.getValue() % 2 == 0) {
				StringBuilder temp = new StringBuilder();
				for (int i = 1; i <= eachEntry.getValue() / 2; i++) {
					temp.append(eachEntry.getKey());
				}

				sb.insert(startIdx, temp);
				startIdx += temp.length();

				if (startIdx > sb.length()) {
					sb.append(temp);
				} else {
					sb.insert(startIdx, temp);
				}

			} else {
				StringBuilder temp = new StringBuilder();
				for (int i = 1; i <= (eachEntry.getValue() - 1) / 2; i++) {
					temp.append(eachEntry.getKey());
				}

				sb.insert(startIdx, temp);
				startIdx += temp.length();

				if (startIdx > sb.length()) {
					sb.append(temp);
				} else {
					sb.insert(startIdx, temp);
				}
				mid = Math.max(mid, eachEntry.getKey());
				flag = true;
			}
		}

		if (flag) {
			sb.insert(startIdx, mid);
		}
		while (sb.length() > 1 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.isEmpty() ? "0" : sb.toString();
	}

}
