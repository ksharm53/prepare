package dec;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimizeArrayValue {

	static Map<Integer, Node> mapNode;

	public static void main(String[] args) {
		int[] nums = { 3, 7, 1, 6 };
		mapNode = new HashMap<>();
		System.out.println(solve(nums));
	}

	public static class Node {
		int value;
		int idx;

		public Node(int value, int idx) {

			this.value = value;
			this.idx = idx;
		}

	}

	private static int solve(int[] nums) {
		int max = Integer.MIN_VALUE;
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o2.value - o1.value;
			}
		});

		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
			Node node = new Node(nums[i], i);
			pq.add(node);
			mapNode.put(i, node);
		}

		while (!pq.isEmpty()) {
			Node poll = pq.poll();
			if (poll.value != 0 && poll.idx - 1 >= 0 && nums[poll.idx - 1] + 1 <= max) {
				max = Math.min(poll.value - 1, max);
				Node newNode = new Node(poll.value - 1, poll.idx);
				pq.add(newNode);

				mapNode.put(poll.idx, newNode);

				Node removeNode = mapNode.get(poll.idx - 1);
				pq.remove(removeNode);
				removeNode.value += 1;

				mapNode.put(poll.idx - 1, removeNode);
				pq.add(removeNode);

			}
		}
		return max;
	}

}
