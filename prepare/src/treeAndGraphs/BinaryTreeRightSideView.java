package treeAndGraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(4, new TreeNode(5), null)),
				new TreeNode(6, new TreeNode(7, new TreeNode(8), null), new TreeNode(9)));

		List<Integer> list = new ArrayList<>();
		solve(root, list, 0);
		System.out.println(solveStack(root));
		System.out.println(list);

	}

	private static void solve(TreeNode root, List<Integer> list, int i) {

		if (root == null) {
			return;
		}

		if (list.size() == i) {
			list.add(root.val);
		}
		solve(root.right, list, i + 1);

		solve(root.left, list, i + 1);

	}

	private static List<Integer> solveStack(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		Stack<Integer> stackLevel = new Stack<>();

		int level = 0;

		TreeNode temp = root;
		while (!stack.empty() || temp != null) {
			if (temp != null) {
				if (level == list.size()) {
					list.add(temp.val);
				}
				stack.push(temp);
				stackLevel.push(level);
				temp = temp.right;
				level = level + 1;

			} else {
				TreeNode tempL = stack.pop();
				Integer var = stackLevel.pop();
				level = var;
				temp = tempL.left;
				level = level + 1;

			}
		}

		return list;
	}

}
