package august23;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Packs {

	public static void main(String[] args) {
		int[] packs = { 12, 5, 5 };
		int[] containers = { 5, 4, 15, 3 };
		System.out.println(solve(packs, containers));

	}

	private static int[] solve(int[] packs, int[] containers) {
		int[] result = new int[packs.length];

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		});
		for (int i = 0; i < containers.length; i++) {
			pq.add(new int[] { containers[i], i });
		}

		for (int i = 0; i < packs.length; i++) {
			int[] value = pq.poll();
			if (value[0] >= packs[i]) {
				result[i] = value[1];

			} else {
				result[i] = -1;

			}
		}
		return result;

	}

}
