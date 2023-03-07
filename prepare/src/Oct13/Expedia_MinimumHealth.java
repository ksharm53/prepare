package Oct13;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Expedia_MinimumHealth {

	public static void main(String[] args) {
		int[] initial_players = { 1, 1, 3 };
		int[] new_players = { 2, 2, 4 };
		int rank = 2;
		System.out.println(solve(initial_players, new_players, rank));

	}

	private static int solve(int[] arr, int[] new_players, int rank) {
		Arrays.sort(arr);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int total = 0;

		for (int i = arr.length - 1; i >= 0; i--) {
			pq.add(arr[i]);
			if (pq.size() == rank) {
				total += pq.poll();
				break;
			}
		}

		for (Integer integer : new_players) {
			pq.add(integer);
			if (pq.size() == rank) {
				total += pq.poll();
			}
		}
		return total;
	}

}
