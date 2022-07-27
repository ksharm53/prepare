package arraysAndStrings;

import java.util.LinkedList;
import java.util.Queue;

public class PartitionList {
	static public class ListNode {
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
		ListNode head = new ListNode(1,
				new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
		int x = 3;

		System.out.println(solve(head, x));

	}

	private static ListNode solve(ListNode head, int x) {
		ListNode result = new ListNode();
		ListNode temp = result;
		boolean flag = false;
		Queue<ListNode> queue = new LinkedList<>();

		if (head == null) {
			return null;
		}

		while (head != null) {
			if (head.val < x) {
				if (!flag) {
					result.val = head.val;
					flag = true;
				} else {
					result.next = new ListNode(head.val, null);
					result = result.next;
				}
			} else {
				queue.add(head);
			}
			head = head.next;
		}
		while (queue.size() > 0) {
			if (!flag) {
				result.val = queue.poll().val;
				flag = true;
			} else {
				result.next = new ListNode(queue.poll().val, null);
				result = result.next;
			}
		}

		return temp;
	}

}
