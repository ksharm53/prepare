package Apr1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.PriorityQueue;

public class MinimizeMax {

	static class Node {
		int val;
		int freq;

		public Node(int val, int freq) {
			super();
			this.val = val;
			this.freq = freq;
		}

		@Override
		public int hashCode() {
			return Objects.hash(freq, val);
		}

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
		}

		public int getFreq() {
			return freq;
		}

		public void setFreq(int freq) {
			this.freq = freq;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			return freq == other.freq && val == other.val;
		}

	}

	public static void main(String[] args) {
		int[] nums = { 4, 0, 2, 1, 2, 5, 5, 3 }; // (0,1) (2,2), (5,5)
		int p = 3;

		System.out.println(solve(nums, p));

	}

	private static int solve(int[] nums, int p) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int each : nums) {
			map.put(each, map.getOrDefault(each, 0) + 1);
		}

		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (o1.getFreq() == o2.getFreq()) {
					return o1.getVal() - o2.getVal();
				} else {
					return o2.getFreq() - o1.getFreq();
				}
			}
		});

		for (Entry<Integer, Integer> each : map.entrySet()) {
			Node node = new Node(each.getKey(), each.getValue());
			pq.add(node);
		}

		for (Node node : pq) {
			System.out.println(node.getVal());
		}

		int max = Integer.MIN_VALUE;

		while (p > 0 && !pq.isEmpty()) {
			Node node = pq.poll();
			int val = node.getVal();
			int freq = node.getFreq();

			if (freq > 1) {
				p -= freq / 2;
				if (p < 0) {
					return 0;
				}

				int rem = freq % 2;
				if (rem > 0) {
					pq.add(new Node(val, rem));
				}
			} else {
				if (!pq.isEmpty()) {
					Node secondnode = pq.poll();
					max = Math.max(max, Math.abs(val - secondnode.getVal()));

					if (secondnode.getFreq() > 1) {
						pq.add(new Node(secondnode.getVal(), secondnode.getFreq() - 1));
					}
					p--;
				}
			}

		}

		return max == Integer.MIN_VALUE ? 0 : max;
	}

}
