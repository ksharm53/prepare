package Oct21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumNumberofOperationstoSortaBinaryTreebyLevel {

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
		TreeNode root = new TreeNode(1, new TreeNode(4, new TreeNode(7), new TreeNode(6)),
				new TreeNode(3, new TreeNode(8, new TreeNode(9), null), new TreeNode(5, new TreeNode(10), null)));

		System.out.println(solve(root));

	}

	public static int minimumSwaps(List<Integer> a) {

		int[] lst = new int[a.size()];

		for (int i = 0; i < a.size(); i++) {
			lst[i] = a.get(i);
		}
		int[] copyArr = Arrays.copyOf(lst, lst.length);
		Arrays.sort(copyArr);

		int moves = 0;
		for (int i = 0; i < lst.length; i++) {
			if (lst[i] != copyArr[i]) {
				int index = findIndex(lst, copyArr[i]);
				int temp = lst[i];
				lst[i] = lst[index];
				lst[index] = temp;
				moves++;
			}
		}
		return moves;
	}

	private static int findIndex(int[] lst, int val) {
		for (int i = 0; i < lst.length; i++) {
			if (lst[i] == val) {
				return i;
			}
		}
		return -1;
	}

	private static int solve(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int mxOps = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int level = queue.size();
			List<Integer> list = new ArrayList<>();

			for (int i = 0; i < level; i++) {
				TreeNode curr = queue.poll();
				list.add(curr.val);
				if (curr.left != null) {
					queue.add(curr.left);

				}
				if (curr.right != null) {
					queue.add(curr.right);

				}
			}

			mxOps += minimumSwaps(list);

		}
		return mxOps;
	}

}
