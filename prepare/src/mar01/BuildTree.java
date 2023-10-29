package mar01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import mar01.SumNumbers.TreeNode;

public class BuildTree {

	public static List<Integer> list;

	public static int index;

	public static void main(String[] args) {
		int[] inorder = { 9, 3, 15, 20, 7 };
		int[] postorder = { 9, 15, 7, 20, 3 };

		list = new ArrayList<>();
		index= postorder.length - 1;

		list = IntStream.of(inorder).boxed().toList();

		System.out.println(solve(inorder, postorder, 0, inorder.length - 1));

	}

	private static TreeNode solve(int[] inorder, int[] postorder, int start, int end) {
		if (start > end || index < 0) {
			return null;
		}

		int splitIndex = list.indexOf(postorder[index]);
		index--;

		TreeNode root = new TreeNode(inorder[splitIndex]);

		TreeNode right = solve(inorder, postorder, splitIndex + 1, end);
		TreeNode left = solve(inorder, postorder, start, splitIndex - 1);

		root.right = right;
		root.left = left;

		return root;

	}

}
