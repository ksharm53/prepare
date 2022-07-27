package linkedLists;

public class InsertInLinkedList {

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		SinglyLinkedListNode head = new SinglyLinkedListNode(1);
		SinglyLinkedListNode second = new SinglyLinkedListNode(2);
		SinglyLinkedListNode third = new SinglyLinkedListNode(3);
		head.next = second;
		second.next = third;
		third.next = null;

		int data = 4;
		int position = 2;

		solve(head, data, position);

	}

	private static SinglyLinkedListNode solve(SinglyLinkedListNode head, int data, int position) {
		SinglyLinkedListNode node = new SinglyLinkedListNode(0);
		SinglyLinkedListNode temp = node;
		boolean flag = false;
		int counter = -1;
		while (head != null) {
			counter++;
			if (position == counter) {
				if (!flag) {
					node.data = data;
					flag = true;
				} else {
					node.next = new SinglyLinkedListNode(data);
					node = node.next;
				}
			} else {
				if (!flag) {
					node.data = head.data;
					flag = true;
				} else {
					node.next = new SinglyLinkedListNode(head.data);
					node = node.next;
				}
				head = head.next;
			}

		}
		return temp;

	}

}
