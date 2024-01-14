package dec;

import java.util.ArrayList;
import java.util.List;

public class DeleteNode {
	static List<Integer> inorder;
	static List<Integer> preorder;
	static boolean flag;

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
		TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)),
				new TreeNode(6, null, new TreeNode(7)));

		inorder = new ArrayList<>();
		preorder = new ArrayList<>();
		flag = false;
		System.out.println(solve(root, 3));
	}

	private static TreeNode solve(TreeNode root, int key) {
		TreeNode temp = root;
		createSortedList(temp, key);
		createPreOrder(temp, key);
		if (!flag) {
			return temp;
		}

		return null;
	}

	private static void createPreOrder(TreeNode root, int key) {
		if (root == null) {
			return;
		}

		if (root.val != key) {
			preorder.add(root.val);
		}

		createPreOrder(root.left, key);
		createPreOrder(root.right, key);

	}

	private static void createSortedList(TreeNode root, int key) {
		if (root == null) {
			return;
		}

		createSortedList(root.left, key);
		if (root.val != key) {
			inorder.add(root.val);
		}
		if (root.val == key) {
			flag = true;
		}
		createSortedList(root.right, key);

	}

}
