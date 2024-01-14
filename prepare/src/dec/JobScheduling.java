package dec;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class JobScheduling {

	public static void main(String[] args) {
		int[] startTime = { 1, 2, 3, 3 };
		int[] endTime = { 3, 4, 5, 6 };
		int[] profit = { 50, 10, 40, 70 };
		System.out.println(jobScheduling(startTime, endTime, profit));

	}

	static class Node {
		int startTime;
		int endTime;
		int profit;

		public Node(int startTime, int endTime, int profit) {
			this.startTime = startTime;
			this.endTime = endTime;
			this.profit = profit;
		}
	}

	public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		Node[] arrNode = new Node[startTime.length];

		for (int i = 0; i < startTime.length; i++) {
			Node node = new Node(startTime[i], endTime[i], profit[i]);
			arrNode[i] = node;
		}

		Arrays.sort(arrNode, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.startTime == o2.startTime ? o1.endTime - o2.endTime : o1.startTime - o2.startTime;
			}
		});

		return solve(arrNode, 0, 0);
	}

	public static int solve(Node[] arrNode, int lastVal, int idx) {
		if (idx >= arrNode.length) {
			return 0;
		}

		Node currNode = arrNode[idx];
		int nextIdx = findNextNode(arrNode, currNode.endTime);

		int liya = currNode.profit + solve(arrNode, currNode.endTime, nextIdx);
		int naiLiya = solve(arrNode, lastVal, idx + 1);
		return Math.max(liya, naiLiya);
	}

	private static int findNextNode(Node[] arrNode, int endTime) {
		int low = 0;
		int high = arrNode.length - 1;
		int mila = arrNode.length;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arrNode[mid].startTime >= endTime) {
				mila = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return mila;
	}

}
