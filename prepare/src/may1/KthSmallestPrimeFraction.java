package may1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {

	public static void main(String[] args) {
		int[] arr = { 1, 29, 47 };
		int k = 1;
		int[] res = solve(arr, k);
		System.out.println("[" + res[0] + "," + res[1] + "]");
	}

	private static int[] solve(int[] arr, int k) {

		PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() {

			@Override
			public int compare(double[] o1, double[] o2) {
				return Double.compare(o2[0], o1[0]);
			}
		});

		for (int i = 0; i < arr.length; i++) {
			for (int j = arr.length - 1; j > i; j--) {

				if (pq.isEmpty() || pq.size() <= k || (!pq.isEmpty() && arr[i] / arr[j] <= pq.peek()[0])) {
					pq.add(new double[] { (double) arr[i] / (double) arr[j], arr[i], arr[j] });
					if (pq.size() > k) {
						pq.poll();
					}
				} else {
					break;
				}

			}

		}

		return new int[] { (int) pq.peek()[1], (int) pq.peek()[2] };
	}

}
