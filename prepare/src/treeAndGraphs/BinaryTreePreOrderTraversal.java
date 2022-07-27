package treeAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));
		List<Integer> list = new ArrayList<>();
		System.out.println(solve(root, list));

	}

	private static List<Integer> solve(TreeNode root, List<Integer> arrayList) {

		if (root == null) {
			return arrayList;
		}

		arrayList.add(root.val);
		solve(root.left, arrayList);
		solve(root.right, arrayList);

		return arrayList;
	}

}
