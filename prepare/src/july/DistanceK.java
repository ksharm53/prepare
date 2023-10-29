package july;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class DistanceK {

	static Map<Integer, List<Integer>> map;

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		public TreeNode(int val, TreeNode left, TreeNode right) {

			this.val = val;
			this.left = left;
			this.right = right;
		}

	}

	public static void main(String[] args) {
		/*
		 * TreeNode root = new TreeNode(3, new TreeNode(5, new TreeNode(6), new
		 * TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new
		 * TreeNode(0), new TreeNode(8)));
		 */

		TreeNode root = new TreeNode(0,
				new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4)))), null);
		int target = 3, k = 0;

		map = new HashMap<>();

		System.out.println(solve(root, target, k));

	}

	private static List<Integer> solve(TreeNode root, int target, int k) {
		createMap(root);

		if (!map.keySet().contains(target)) {
			return new ArrayList<>();
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { target, 0 });

		return doBFS(queue, k);
	}

	private static Map<Integer, List<Integer>> createMap(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			List<Integer> list = map.getOrDefault(curr.val, new ArrayList<>());

			if (curr.left != null) {
				list.add(curr.left.val);

				List<Integer> listReverse = map.getOrDefault(curr.left.val, new ArrayList<>());
				listReverse.add(curr.val);
				map.put(curr.left.val, listReverse);

				queue.add(curr.left);
			}

			if (curr.right != null) {
				list.add(curr.right.val);

				List<Integer> listReverse = map.getOrDefault(curr.right.val, new ArrayList<>());
				listReverse.add(curr.val);
				map.put(curr.right.val, listReverse);

				queue.add(curr.right);
			}

			map.put(curr.val, list);
		}
		return map;

	}

	private static List<Integer> doBFS(Queue<int[]> queue, int k) {
		List<Integer> list = new ArrayList<>();
		Set<Integer> set = new HashSet<>();

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			if (curr[1] == k) {
				list.add(curr[0]);
				continue;
			}

			List<Integer> siblings = map.getOrDefault(curr[0], new ArrayList<>());
			for (int each : siblings) {
				if (!set.contains(each)) {
					queue.add(new int[] { each, curr[1] + 1 });
				}
			}

			set.add(curr[0]);
		}
		return list;
	}

}
