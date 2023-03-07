package feb07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZag {

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
		TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		System.out.println(solve(root));

	}

	private static List<List<Integer>> solve(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean flag = false;
		while (!queue.isEmpty()) {
			List<Integer> innerList = new ArrayList<>();
			int level = queue.size();
			for (int i = 0; i < level; i++) {
				TreeNode temp = queue.poll();
				innerList.add(temp.val);
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
			}
			if (flag) {
				Collections.reverse(innerList);
			}
			list.add(innerList);
			flag = !flag;
		}
		return list;
	}

}
