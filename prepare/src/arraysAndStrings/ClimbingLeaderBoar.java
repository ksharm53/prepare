package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class ClimbingLeaderBoar {

	static class Pair {
		int key;
		int value;

		Pair(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		List<Integer> ranked = Arrays.asList(100, 100, 50, 40, 40, 20, 10);
		List<Integer> player = Arrays.asList(5, 25, 50, 120);

		System.out.println(solve(ranked, player));

	}

	private static List<Integer> solve(List<Integer> ranked, List<Integer> player) {
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				if (o2.key == o1.key) {
					return o2.value - o1.value;
				}
				return o2.key - o1.key;
			}
		});
		List<Integer> result = new ArrayList<>();
		Stack<Pair> stack = new Stack<>();

		Set<Integer> set = new HashSet<>(ranked);
        List<Integer> list = new ArrayList<>();

        for (Integer integer : set) {
            list.add(integer);
        }

		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			int first = list.size() - i;
			int second = list.get(i);
			pq.add(new Pair(first, second));
		}

		for (int i = 0; i < player.size(); i++) {
			if (pq.isEmpty()) {
				result.add(1);
				pq.add(new Pair(1, player.get(i)));
			} else if (pq.peek().value > player.get(i)) {
				result.add(pq.peek().key + 1);
				pq.add(new Pair(pq.peek().key + 1, player.get(i)));
			} else if (pq.peek().value == player.get(i)) {
				result.add(pq.peek().key);
				pq.add(new Pair(pq.peek().key, player.get(i)));
			} else {
				while (!pq.isEmpty() && pq.peek().value < player.get(i)) {
					//stack.push(pq.poll());
					pq.poll();
				}
				if (pq.isEmpty()) {
					result.add(1);
					pq.add(new Pair(1, player.get(i)));
				} else if (pq.peek().value > player.get(i)) {
					result.add(pq.peek().key + 1);
					pq.add(new Pair(pq.peek().key + 1, player.get(i)));
				} else if (pq.peek().value == player.get(i)) {
					result.add(pq.peek().key);
					pq.add(new Pair(pq.peek().key, player.get(i)));
				}
			}
		}
		return result;
	}
}
