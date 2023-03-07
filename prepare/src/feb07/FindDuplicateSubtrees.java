package feb07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicateSubtrees {

	public static Set<Integer> set;
	public static Set<TreeNode> list;

	public static void main(String[] args) {

		TreeNode root = new TreeNode(0, new TreeNode(0, new TreeNode(0), null),
				new TreeNode(0, null, new TreeNode(0, new TreeNode(0), null)));
		set = new HashSet<>();
		list = new HashSet<>();
		List<TreeNode> res = new ArrayList<>();

		solve(root);
		for (TreeNode each : list) {
			boolean flag = false;
			for (TreeNode inner : res) {
				if (inner.val == each.val) {
					flag = true;
				}
			}
			if (!flag) {
				res.add(each);
			}
		}

		System.out.println(res);
	}

	private static void solve(TreeNode root) {
		if (root == null) {
			return;
		}
		solve(root.left);
		solve(root.right);

		if (set.contains(root.val)) {
			list.add(root);
		} else {
			set.add(root.val);
		}
	}

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

}
