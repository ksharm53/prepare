package oct3;

import java.util.LinkedList;
import java.util.Queue;

public class TwoSumIVInputisaBST {
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
		// TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2), new
		// TreeNode(4)),
		// new TreeNode(6, null, new TreeNode(7)));

		TreeNode root = new TreeNode(1, new TreeNode(0, new TreeNode(-2), null),
				new TreeNode(4, new TreeNode(3), null));

		System.out.println(solve(root, 7));
	}

	private static boolean solve(TreeNode root, int target) {
		if (root == null) {
			return false;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode temp = queue.poll();
				boolean val = false;
				if (target - temp.val != temp.val) {
					val = validate(root, target - temp.val);
				}

				if (val) {
					return true;
				}
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
			}

		}
		return false;

	}

	private static boolean validate(TreeNode root, int abs) {
		if (root == null) {
			return false;
		}
		if (root.val == abs) {
			return true;
		}

		return validate(root.left, abs) || validate(root.right, abs);

	}

}
