package may1;

import java.util.ArrayList;
import java.util.List;

public class PairSum {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		ListNode root = new ListNode(5, new ListNode(4, new ListNode(2, new ListNode(1))));

		System.out.println(solve(root));

	}

	private static int solve(ListNode root) {
		List<Integer> list = new ArrayList<>();
		int max = Integer.MIN_VALUE;

		ListNode temp = root;

		while (temp != null) {
			list.add(temp.val);
			temp = temp.next;
		}

		for (int i = 0; i < (list.size() / 2) + 1; i++) {
			int twin = list.size() - 1 - i;
			// System.out.println("i: " + i + " twin: " + twin);
			max = Math.max(max, list.get(i) + list.get(twin));
		}
		return max;
	}

}
