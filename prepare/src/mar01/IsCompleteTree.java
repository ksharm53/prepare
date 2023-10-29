package mar01;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree {

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
		TreeNode root = new TreeNode(1, null, null);

		System.out.println(solve(root));

	}

	private static boolean solve(TreeNode root) {
		int height = findHeight(root);

		if (height == 1) {
			return true;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		int level = 1;

		while (!queue.isEmpty()) {
			int quota = queue.size();
			if (level == height - 1) {
				TreeNode each = null;
				int val = -1;
				while (!queue.isEmpty()) {
					each = queue.poll();

					// left 0, right 1
					if (each.left == null) {
						val = 0;
						break;
					}

					if (each.right == null) {
						val = 1;
						break;
					}

				}

				if (val != -1) {
					if (val == 0 && each.right != null) {
						return false;
					}

					while (!queue.isEmpty()) {
						TreeNode eachAgain = queue.poll();
						if (eachAgain.left != null || eachAgain.right != null) {
							return false;
						}

					}
				}

			} else {
				for (int i = 0; i < quota; i++) {
					TreeNode each = queue.poll();
					if (each.left == null || each.right == null) {
						return false;
					} else {
						if (each.left != null) {
							queue.add(each.left);
						}

						if (each.right != null) {
							queue.add(each.right);
						}
					}
				}
			}
			level++;
		}

		return true;
	}

	private static int findHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return Math.max(findHeight(root.left) + 1, findHeight(root.right) + 1);
	}

}
