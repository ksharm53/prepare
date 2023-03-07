package august23;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class School {

	public static void main(String[] args) {
		String[] emails = { "b@harvard.edu", "c@harvard.edu", "d@harvard.edu", "e@harvard.edu", "f@harvard.edu",
				"a@student.spbu.ru", "b@student.spbu.ru", "c@student.spbu.ru", "d@student.spbu.ru", "e@student.spbu.ru",
				"f@student.spbu.ru", "g@student.spbu.ru" };
		System.out.println(solution(emails));

	}

	public static class Pair {
		int key;
		String value;

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		Pair(int key, String value) {
			this.key = key;
			this.value = value;
		}
	}

	public static String[] solution(String[] emails) {
		String[] result;
		Map<String, Integer> map = new HashMap<>();
		for (String string : emails) {
			String eachValue = string.split("@")[1];
			map.put(eachValue, map.getOrDefault(eachValue, 0) + 1);
		}

		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o2.getKey() == o1.getKey() ? o1.getValue().compareTo(o2.getValue()) : o2.getKey() - o1.getKey();
			}
		});

		for (Map.Entry<String, Integer> is : map.entrySet()) {
			int totalPoints = is.getValue() * 20;
			int valueF = 0;
			if (totalPoints >= 500) {
				valueF = 25;
			} else if (totalPoints >= 300) {
				valueF = 15;
			} else if (totalPoints >= 200) {
				valueF = 8;
			} else if (totalPoints >= 100) {
				valueF = 3;
			}

			pq.add(new Pair(valueF, is.getKey()));
		}

		result = new String[pq.size()];
		int n = pq.size();

		for (int i = 0; i < n; i++) {
			result[i] = pq.poll().getValue();
		}
		return result;
	}

}
