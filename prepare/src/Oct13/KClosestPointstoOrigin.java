package Oct13;

import java.util.PriorityQueue;

public class KClosestPointstoOrigin {

	public static class Node {
		Double distance;
		int[] point;

		public Node(Double distance, int[] point) {
			this.distance = distance;
			this.point = point;
		}

		public Double getDistance() {
			return distance;
		}

		public void setDistance(Double distance) {
			this.distance = distance;
		}

		public int[] getPoint() {
			return point;
		}

		public void setPoint(int[] point) {
			this.point = point;
		}
	}

	public static void main(String[] args) {
		int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		int k = 2;
		System.out.println(solve(points, k));

	}

	private static int[][] solve(int[][] points, int k) {
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.getDistance().compareTo(a.getDistance()));

		for (int[] entry : points) {
			double distance = Math.sqrt((entry[0] * entry[0]) + (entry[1] * entry[1]));
			pq.add(new Node(distance, entry));
			if (pq.size() > k) {
				pq.poll();
			}
		}

		int[][] result = new int[pq.size()][2];
		int counter = 0;
		while (!pq.isEmpty()) {
			result[counter] = pq.poll().getPoint();
			counter++;
		}
		return result;
	}

}
