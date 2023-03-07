package treeAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

	public static List<List<Integer>> list;

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
		// TreeNode head = new TreeNode(5, new TreeNode(4, new TreeNode(11, new
		// TreeNode(7), new TreeNode(2)), null),
		// new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new
		// TreeNode(1))));

		// TreeNode head = new TreeNode(-2, null, new TreeNode(-3));

		// [1,0,1,1,2,0,-1,0,1,-1,0,-1,0,1,0]
		// 1 0 1
		// 1 2 0 -1
		// 01 -10 -10 10

		TreeNode head = new TreeNode(1,
				new TreeNode(0, new TreeNode(1, new TreeNode(0), new TreeNode(1)),
						new TreeNode(2, new TreeNode(-1), new TreeNode(0))),
				new TreeNode(1, new TreeNode(0, new TreeNode(-1), new TreeNode(0)),
						new TreeNode(-1, new TreeNode(1), new TreeNode(0))));

		list = new ArrayList<>();
		int targetSum = 2;
		solve(head, 0, targetSum, new ArrayList<>());
		System.out.println(list);

	}

	private static void solve(TreeNode head, int sum, int target, List<Integer> currentList) {
		if (head == null) {
			return;
		}

		sum += head.val;
		currentList.add(head.val);

		if (sum == target && (head.left == null || head.right == null)) {
			list.add(new ArrayList<>(currentList));
			int value = currentList.get(currentList.size() - 1);
			currentList.remove(currentList.size() - 1);
			sum -= value;
			return;
		}
		/*
		 * if ((target > 0 && sum > target) || (target < 0 && sum < target)) { int value
		 * = currentList.get(currentList.size() - 1);
		 * currentList.remove(currentList.size() - 1); sum -= value; return; }
		 */

		solve(head.left, sum, target, currentList);
		solve(head.right, sum, target, currentList);
		if (!currentList.isEmpty()) {
			currentList.remove(currentList.size() - 1);
		}

	}

}
