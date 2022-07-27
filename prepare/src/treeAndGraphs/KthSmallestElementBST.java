package treeAndGraphs;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class KthSmallestElementBST {

	static PriorityQueue<Integer> pq;
	static int k;

	public static void main(String[] args) {

		pq = new PriorityQueue<Integer>(Comparator.reverseOrder());

		TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
		k = 2;

		//System.out.println(solve(root, k));

		solverecursion(root);

		while (pq.size() > k) {
			pq.poll();
		}
		System.out.println(pq.peek());

	}

	private static int solve(TreeNode root, int k) {

		TreeNode temp = root;
		Stack<TreeNode> stack = new Stack<>();

		while (!stack.empty() || temp != null) {
			if (temp != null) {
				stack.push(temp);
				temp = temp.left;
			} else {
				temp = stack.pop();
				pq.add(temp.val);

				if (pq.size() > k) {
					pq.poll();
				}
				temp = temp.right;
			}
		}

		return pq.peek();
	}

	private static void solverecursion(TreeNode root) {

		TreeNode temp = root;
		if (temp == null) {
			return;
		}

		pq.add(root.val);
		solverecursion(root.left);
		solverecursion(root.right);
	}

}
