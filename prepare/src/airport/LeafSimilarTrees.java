package airport;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {

	public static List<Integer> list1;
	public static List<Integer> list2;

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
		TreeNode root1 = new TreeNode(3,
				new TreeNode(5, new TreeNode(6, null, null), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
				new TreeNode(1, new TreeNode(9), new TreeNode(8)));

		TreeNode root2 = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(7)),
				new TreeNode(1, new TreeNode(4), new TreeNode(2, new TreeNode(9), new TreeNode(8))));

		list1 = new ArrayList<>();
		list2 = new ArrayList<>();

		solve1(root1);
		solve2(root2);

		System.out.println(list1);
		System.out.println(list2);

		if (list1.size() != list2.size()) {
			System.out.println(false);
		} else {
			int size = list1.size();
			for (int i = 0; i < size; i++) {
				if (list1.get(i) != list2.get(i)) {
					System.out.println(false);
				}
			}
		}

		System.out.println(true);
	}

	private static void solve2(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			list2.add(root.val);
		}

		solve2(root.left);
		solve2(root.right);
	}

	private static void solve1(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			list1.add(root.val);
		}

		solve1(root.left);
		solve1(root.right);
	}

}
