package Apr1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ReplaceValueInTree {

	public static Map<Pos, Integer> map;

	public static class Pos {
		int level;
		int parent;
		int data;
		boolean isLeft;

		public Pos(int level, int parent, int data, boolean isLeft) {
			super();
			this.level = level;
			this.parent = parent;
			this.data = data;
			this.isLeft = isLeft;
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

	public static class Node {
		TreeNode val;
		int parent;

		public Node(TreeNode val, int parent) {
			super();
			this.val = val;
			this.parent = parent;
		}

	}

	public static void main(String[] args) {
		/*
		 * TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(1), new
		 * TreeNode(10)), new TreeNode(9, null, new TreeNode(7)));
		 */

		TreeNode root = new TreeNode(904, new TreeNode(416, new TreeNode(705), null), new TreeNode(765, null,
				new TreeNode(14, new TreeNode(821, new TreeNode(774, new TreeNode(905, null, null),
						new TreeNode(879, new TreeNode(327,
								new TreeNode(703, new TreeNode(41, null, new TreeNode(365)), new TreeNode(895)), null),
								new TreeNode(414))),
						new TreeNode(30, new TreeNode(363), new TreeNode(130))),
						new TreeNode(754, null, new TreeNode(548, new TreeNode(494, new TreeNode(41), null), null)))));

		map = new HashMap<>();

		System.out.println(solve(root));

	}

	private static TreeNode solve(TreeNode root) {

		TreeNode ghumao = root;

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(ghumao, -1));
		int level = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Node> list = new ArrayList<>();
			int sum = 0;
			level++;

			Node poppedVal = null;
			for (int i = 0; i < size; i++) {
				poppedVal = queue.poll();
				list.add(poppedVal);

				sum += poppedVal.val.val;

				if (poppedVal.val.left != null) {
					queue.add(new Node(poppedVal.val.left, poppedVal.val.val));
				}

				if (poppedVal.val.right != null) {
					queue.add(new Node(poppedVal.val.right, poppedVal.val.val));
				}
			}

			if (list.size() < 2) {
				if (poppedVal != null) {
					map.put(new Pos(level, -1, poppedVal.val.val, false), 0);
				}

				continue;
			}

			for (int j = 0; j < list.size(); j++) {
				int tempSum = sum;
				for (Node node : list) {
					if (list.get(j).parent == node.parent) {
						tempSum -= node.val.val;
					}
				}
				map.put(new Pos(level, poppedVal.val.val, list.get(j).val.val, false), tempSum);
			}
		}

		TreeNode res = findDepth(root);

		return res;
	}

	private static TreeNode findDepth(TreeNode root) {
		TreeNode temp = root;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode res = queue.poll();
			res.val = map.get(res.val);

			if (res.left != null) {
				queue.add(res.left);
			}

			if (res.right != null) {
				queue.add(res.right);
			}
		}

		return temp;

	}

}
