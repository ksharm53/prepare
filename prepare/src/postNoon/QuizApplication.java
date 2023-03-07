package postNoon;

import java.util.PriorityQueue;

public class QuizApplication {

	public static void main(String[] args) {
		int[] answered = { 24, 27, 0 };
		int[] needed = { 51, 52, 100 };
		int q = 100;
		System.out.println(solve(answered, needed, q));
	}

	private static int solve(int[] answered, int[] needed, int q) {
		if (answered.length == 0 || needed.length == 0 || answered.length != needed.length) {
			return 0;
		}
		int length = answered.length;

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < length; i++) {
			pq.add(needed[i] - answered[i]);
		}
		int initialSize = pq.size();

		while (q > 0) {
			if (pq.peek() <= q) {
				q -= pq.poll();
			} else {
				break;
			}
		}
		return initialSize - pq.size();
	}

}
