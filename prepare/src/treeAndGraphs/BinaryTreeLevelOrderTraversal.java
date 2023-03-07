package treeAndGraphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));
		// TreeNode root = new TreeNode();

		System.out.println(solve(root));

	}

	private static List<List<Integer>> solve(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> list = new ArrayList<>();

		if (root == null) {
			return list;
		}
		queue.add(root);

		while (!queue.isEmpty()) {

			int level = queue.size();

			List<Integer> tempList = new ArrayList<>();
			for (int i = 0; i < level; i++) {
				if (null != queue.peek().left) {
					queue.add(queue.peek().left);
				}
				if (null != queue.peek().right) {
					queue.add(queue.peek().right);
				}
				tempList.add(queue.poll().val);
								
			}
			
			list.add(tempList);

		}

		return list;
	}

}
