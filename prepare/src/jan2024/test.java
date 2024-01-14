package jan2024;

import java.util.HashMap;
import java.util.Map;

public class test {

	public static void main(String[] args) {
		String str = "gffg";
		System.out.println(solve(str));
	}

	private static int solve(String str) {
		int i = 0;
		int j = 0;
		Map<Character, Integer> map = new HashMap<>();
		int count = 0;
		while (j < str.length()) {
			map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);

			if (j - i + 1 != map.size()) {
				while (map.get(str.charAt(j)) > 1) {
					map.put(str.charAt(i), map.get(str.charAt(i)) - 1);
					if (map.get(str.charAt(i)) == 0) {
						map.remove(str.charAt(i));
					}
					i++;
				}
				j--;

			} else {
				count += j - i + 1;
			}
			j++;
		}
		return count;
	}

}
