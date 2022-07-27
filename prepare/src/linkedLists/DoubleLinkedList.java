package linkedLists;

import java.util.Stack;

public class DoubleLinkedList {
	static class DoublyLinkedListNode {
		public int data;
		public DoublyLinkedListNode next;
		public DoublyLinkedListNode prev;

		public DoublyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
			this.prev = null;
		}

		public DoublyLinkedListNode(int nodeData, DoublyLinkedListNode next, DoublyLinkedListNode prev) {
			this.data = nodeData;
			this.next = next;
			this.prev = prev;
		}
	}

	public static void main(String[] args) {
		DoublyLinkedListNode first = new DoublyLinkedListNode(1);
		DoublyLinkedListNode second = new DoublyLinkedListNode(2);
		DoublyLinkedListNode third = new DoublyLinkedListNode(3);
		DoublyLinkedListNode fourth = new DoublyLinkedListNode(4);

		first.next = second;
		second.prev = first;

		second.next = third;
		third.prev = second;

		third.next = fourth;
		fourth.prev = third;

		solve(first);
	}

	private static DoublyLinkedListNode solve(DoublyLinkedListNode head) {
		DoublyLinkedListNode result = new DoublyLinkedListNode(0);
		DoublyLinkedListNode temp = result;
		Stack<DoublyLinkedListNode> stack = new Stack<>();
		boolean flag = false;

		while (head != null) {
			stack.push(head);
			head = head.next;
		}

		while (!stack.isEmpty()) {
			DoublyLinkedListNode node = stack.pop();
			if (!flag) {
				DoublyLinkedListNode next = node.prev;
				DoublyLinkedListNode prev = node.next;
				result.data = node.data;
				result.next = next;
				result.prev = prev;
				result = result.next;
				flag = true;
			} else {
				DoublyLinkedListNode next = node.prev;
				DoublyLinkedListNode prev = node.next;
				result.next = next;
				result.prev = prev;
				result = result.next;
			}

		}
		return temp;
	}

}
