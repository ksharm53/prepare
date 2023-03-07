package august23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrderTraversal {

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
		TreeNode root = new TreeNode(3, new TreeNode(9, null, null),
				new TreeNode(20, new TreeNode(15), new TreeNode(7)));

		System.out.println(solve(root));

	}

	private static List<List<Integer>> solve(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();

		if (root == null) {
			return list;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int flag = 0;

		while (!queue.isEmpty()) {
			int level = queue.size();
			flag++;
			List<Integer> listtemp = new ArrayList<>();

			for (int i = 0; i < level; i++) {

				if (queue.peek().left != null) {
					queue.add(queue.peek().left);
				}

				if (queue.peek().right != null) {
					queue.add(queue.peek().right);
				}
				listtemp.add(queue.poll().val);
			}

			if (flag % 2 == 0) {
				Collections.reverse(listtemp);
			}

			list.add(listtemp);

		}
		return list;

	}

}
