package mar01;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import treeAndGraphs.TreeNode;

public class KthLargestLevelSum {

	public static void main(String[] args) {

	}

	public static long kthLargestLevelSum(TreeNode root, int k) {
		if (root == null) {
			return -1;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int level = 0;
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			int count = 0;
			level++;
			for (int i = 0; i < size; i++) {
				TreeNode each = queue.poll();
				count += each.val;
				if (each.left != null) {
					queue.add(each.left);
				}
				if (each.right != null) {
					queue.add(each.right);
				}
			}
			pq.add(count);
			if (pq.size() > k) {
				pq.poll();
			}
		}

		return level >= k ? pq.poll() : -1;
	}

}
