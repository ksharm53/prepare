package Apr1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MostFrequentEven {

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
		int[] nums = { 4, 4, 4, 9, 2, 4 };
		System.out.println(solve(nums));

	}

	private static int solve(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();
		int[] max = new int[2];
		max[0] = Integer.MAX_VALUE;
		max[1] = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			int each = nums[i];
			if (each % 2 == 0) {
				map.put(each, map.getOrDefault(each, 0) + 1);

				if (max[0] == Integer.MAX_VALUE && max[1] == Integer.MIN_VALUE) {
					max[0] = each;
					max[1] = map.get(each);
					continue;
				}

				if (max[1] <= map.get(each)) {
					if (max[1] < map.get(each)) {
						max[0] = each;
						max[1] = map.get(each);
					} else {
						if (max[0] > each) {
							max[0] = each;
						}
					}
				}
			}
		}

		return max[0] == Integer.MAX_VALUE ? -1 : max[0];
	}

}
