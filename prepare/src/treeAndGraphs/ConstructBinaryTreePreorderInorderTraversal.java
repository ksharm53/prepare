package treeAndGraphs;

import java.util.List;
import java.util.stream.IntStream;

public class ConstructBinaryTreePreorderInorderTraversal {

	static int preOrderIndex = 0;

	public static void main(String[] args) {
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };

		List<Integer> inorderList = IntStream.of(inorder).boxed().toList();

		System.out.println(solve(preorder, inorderList, 0, preorder.length - 1));

	}

	private static TreeNode solve(int[] preorder, List<Integer> inorder, int start, int end) {
		if (start > end) {
			return null;
		}

		TreeNode node = new TreeNode(preorder[preOrderIndex]);
		int index = inorder.indexOf(preorder[preOrderIndex]);
		preOrderIndex++;

		node.left = solve(preorder, inorder, start, index - 1);
		node.right = solve(preorder, inorder, index + 1, end);

		return node;
	}

}
