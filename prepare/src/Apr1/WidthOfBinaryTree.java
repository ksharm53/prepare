package Apr1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class WidthOfBinaryTree {

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
		TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(5, new TreeNode(6), null), null),
				new TreeNode(2, null, new TreeNode(9, new TreeNode(7), null)));

		System.out.println(solve(root));

	}

	private static int solve(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		Map<TreeNode, Integer> map = new HashMap<>();

		queue.add(root);
		map.put(root, 1);

		int max = Integer.MIN_VALUE;

		while (!queue.isEmpty()) {
			int size = queue.size();
			int start = 0;
			int end = 0;

			for (int i = 0; i < size; i++) {
				TreeNode tmp = queue.poll();

				if (i == 0) {
					start = map.get(tmp);
				}

				if (i == size - 1) {
					end = map.get(tmp);
				}

				if (tmp.left != null) {
					queue.add(tmp.left);
					map.put(tmp.left, 2 * map.get(tmp));
				}

				if (tmp.right != null) {
					queue.add(tmp.right);
					map.put(tmp.right, 2 * map.get(tmp) + 1);
				}

			}

			max = Math.max(max, end - start + 1);

		}

		return max;
	}

}
