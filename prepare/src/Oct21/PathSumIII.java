package Oct21;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {

	public static int countFinal;

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
		countFinal = 0;
		/*
		 * TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(3, new
		 * TreeNode(3, null, null), new TreeNode(-2, null, null)), new TreeNode(2, null,
		 * new TreeNode(1))), new TreeNode(-3, null, new TreeNode(11)));
		 */
		TreeNode root = new TreeNode(1000000000,
				new TreeNode(1000000000, new TreeNode(294967296,
						new TreeNode(1000000000, new TreeNode(1000000000, new TreeNode(1000000000), null), null), null),
						null),
				null);
		Map<Long, Integer> map = new HashMap<>();
		map.put(0L, 1);
		solve(root, 0, map, 0L);
		System.out.println(countFinal);
	}

	private static void solve(TreeNode root, int target, Map<Long, Integer> map, long curCount) {
		if (root == null) {
			return;
		}

		curCount += root.val;
		if (map.containsKey(curCount - target)) {
			countFinal += map.get(curCount - target);
		}

		map.put(curCount, map.getOrDefault(curCount, 0) + 1);

		solve(root.left, target, map, curCount);
		solve(root.right, target, map, curCount);
		map.put(curCount, map.getOrDefault(curCount, 0) - 1);

	}

}
