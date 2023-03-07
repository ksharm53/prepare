package Oct13;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SenderWithLargestWordCount {

	public static void main(String[] args) {
		// String[] messages = { "Hello userTwooo", "Hi userThree", "Wonderful day
		// Alice", "Nice day userThree" };
		// String[] senders = { "Alice", "userTwo", "userThree", "Alice" };

		String[] messages = { "How is leetcode for everyone", "Leetcode is useful for practice" };
		String[] senders = { "Bob", "Charlie" };

		System.out.println(solve(messages, senders));

	}

	private static String solve(String[] messages, String[] senders) {
		Map<String, Integer> map = new HashMap<>();
		int length = messages.length;
		for (int i = 0; i < length; i++) {
			String[] arr = messages[i].split(" ");
			map.put(senders[i], map.getOrDefault(senders[i], 0) + arr.length);
		}
		int max = Integer.MIN_VALUE;
		String res = "";
		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() >= max) {
				if (entry.getValue() == max) {
					if (entry.getKey().compareTo(res) > 0) {
						res = entry.getKey();
					}
				} else {
					res = entry.getKey();
				}
				max = entry.getValue();
			}
		}

		return res;
	}

}
