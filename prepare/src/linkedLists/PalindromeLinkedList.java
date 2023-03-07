package linkedLists;

import java.util.Stack;

public class PalindromeLinkedList {

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
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1, null))));

		System.out.println(solve(head));

	}

	private static boolean solve(ListNode head) {
		Stack<ListNode> stack = new Stack<>();
		ListNode temp = head;

		while (temp != null) {
			stack.push(temp);
			temp = temp.next;
		}
		temp = head;
		while (!stack.isEmpty() && temp != null) {
			ListNode current = stack.pop();
			if (Integer.compare(current.val, temp.val) != 0) {
				return false;
			}
			temp = temp.next;
		}

		return true;
	}

}
