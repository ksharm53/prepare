package azPcise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class AmazonFreshDeliveries {

	/*
	 * 
	 * Amazon Fresh Deliveries Given allLocations list of co-ordinates (x,y) you
	 * have to find the X - closest locations from truck's location which is (0,0).
	 * Distance is calculated using formula (x^2 + y^2). If the there is tie then
	 * choose the co-ordinate with least x value.
	 */

	public static class Node {

		int distance;
		int[] array;

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

		public int[] getArray() {
			return array;
		}

		public void setArray(int[] array) {
			this.array = array;
		}

		public Node(int distance, int[] array) {
			super();
			this.distance = distance;
			this.array = array;
		}

	}

	public static void main(String[] args) {
		int[][] allLocations = { { 1, 2 }, { 1, -1 }, { 3, 4 } };
		System.out.println(solve(allLocations, 2));

	}

	private static List<List<Integer>> solve(int[][] allLocations, int deliveries) {

		List<List<Integer>> list = new ArrayList<>();

		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o2.distance == o1.distance ? o1.array[0] - o2.array[1] : o2.distance - o1.distance;
			}
		});

		for (int i = 0; i < allLocations.length; i++) {
			int[] eachLocation = allLocations[i];
			int distance = eachLocation[0] * eachLocation[0] + eachLocation[1] * eachLocation[1];

			pq.add(new Node(distance, eachLocation));

			if (pq.size() > deliveries) {
				pq.poll();
			}
		}

		for (Node node : pq) {
			List<Integer> innerList = new ArrayList<>();
			for (int eachInteger : node.getArray()) {
				innerList.add(eachInteger);
			}
			list.add(innerList);
		}

		return list;
	}

}
