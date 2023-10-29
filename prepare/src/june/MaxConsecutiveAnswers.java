package june;

import java.util.HashMap;
import java.util.Map;

public class MaxConsecutiveAnswers {

	public static void main(String[] args) {
		String answerKey = "TFFT";
		int k = 1;
		System.out.println(solve(answerKey, k));

	}

	private static int solve(String answerKey, int k) {
		Map<Character, Integer> map = new HashMap<>();
		int i = 0;
		int j = 0;
		int max = Integer.MIN_VALUE;

		while (j < answerKey.length()) {
			map.put(answerKey.charAt(j), map.getOrDefault(answerKey.charAt(j), 0) + 1);

			if (map.containsKey('T') && map.containsKey('F') && Math.min(map.get('T'), map.get('F')) > k) {
				while (i < answerKey.length() && map.containsKey('T') && map.containsKey('F')
						&& Math.min(map.get('T'), map.get('F')) > k) {
					if (answerKey.charAt(i) == 'T') {
						map.put('T', map.get('T') - 1);
						if (map.get('T') == 0) {
							map.remove('T');
						}
					} else {
						map.put('F', map.get('F') - 1);
						if (map.get('F') == 0) {
							map.remove('F');
						}
					}
					i++;
				}
			}

			max = Math.max(max, j - i + 1);
			j++;
		}

		return max;
	}

}
