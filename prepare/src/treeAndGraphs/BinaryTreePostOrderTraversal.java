package treeAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostOrderTraversal {
	static List<Integer> list;

	public static void main(String[] args) {
		list = new ArrayList<>();
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));

		System.out.println(solve(root));

	}

	private static List<Integer> solve(TreeNode root) {

		if (root == null) {
			return list;
		}

		solve(root.left);
		solve(root.right);
		list.add(root.val);

		return list;
	}

}
