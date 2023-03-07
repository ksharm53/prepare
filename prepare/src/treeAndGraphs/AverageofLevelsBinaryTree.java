package treeAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		TreeNode root3 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

		System.out.println(solve(root3));

	}

	private static List<Double> solve(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<Double> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int level = queue.size();
			double sum = 0;
			for (int i = 0; i < level; i++) {
				if (queue.peek().left != null) {
					queue.add(queue.peek().left);
				}
				if (queue.peek().right != null) {
					queue.add(queue.peek().right);
				}
				TreeNode temp = queue.poll();
				sum += temp.val;
			}
			list.add(sum / (double) level);
		}
		return list;

	}

}
