package sevenJuly;

import java.util.Stack;

public class RverseLinkedList {

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
		ListNode head = new ListNode(1);
		int left = 1;
		int right = 1;

		System.out.println(solve(head, left, right));

	}

	private static ListNode solve(ListNode head, int left, int right) {
		ListNode node = new ListNode();
		ListNode f = node;
		boolean flag = false;
		int counter = 0;
		int innerCounter = left;
		Stack<ListNode> stack = new Stack<>();
		while (null != head) {
			counter++;
			if (counter == left) {
				while (innerCounter <= right && null != head) {
					stack.push(head);
					innerCounter++;
					head = head.next;
				}
				while (stack.size() > 0) {
					if (!flag) {
						node.val = stack.pop().val;
						flag = true;
					} else {
						node.next = new ListNode(stack.pop().val, null);
						node = node.next;
					}
				}
			} else {
				if (!flag) {
					node.val = head.val;
					flag = true;
				} else {
					node.next = new ListNode(head.val, null);
					node = node.next;
				}
				head = head.next;
			}

		}
		return f;
	}

}
