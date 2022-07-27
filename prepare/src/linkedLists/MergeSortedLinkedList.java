package linkedLists;

public class MergeSortedLinkedList {
	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData, SinglyLinkedListNode next) {
			this.data = nodeData;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		SinglyLinkedListNode headA = new SinglyLinkedListNode(1,
				new SinglyLinkedListNode(3, new SinglyLinkedListNode(7, null)));

		SinglyLinkedListNode headB = new SinglyLinkedListNode(1, new SinglyLinkedListNode(2, null));

		solve(headA, headB);

	}

	private static SinglyLinkedListNode solve(SinglyLinkedListNode headA, SinglyLinkedListNode headB) {
		SinglyLinkedListNode result = new SinglyLinkedListNode(0, null);
		SinglyLinkedListNode temp = result;
		boolean flag = false;

		while (headA != null && headB != null) {
			if (headA.data < headB.data) {
				if (!flag) {
					result.data = headA.data;
					flag = true;
				} else {
					result.next = new SinglyLinkedListNode(headA.data, null);
					result = result.next;
				}
				headA = headA.next;
			} else if (headA.data == headB.data) {
				if (!flag) {
					result.data = headA.data;
					result.next = new SinglyLinkedListNode(headB.data, null);
					result = result.next;
					flag = true;
				} else {
					result.next = new SinglyLinkedListNode(headA.data, null);
					result = result.next;
					result.next = new SinglyLinkedListNode(headB.data, null);
					result = result.next;
				}
				headA = headA.next;
				headB = headB.next;
			} else {
				if (!flag) {
					result.data = headB.data;
					flag = true;
				} else {
					result.next = new SinglyLinkedListNode(headB.data, null);
					result = result.next;
				}
				headB = headB.next;
			}
		}
		while (headA != null) {
			result.next = new SinglyLinkedListNode(headA.data, null);
			result = result.next;
			headA = headA.next;
		}
		
		while (headB != null) {
			result.next = new SinglyLinkedListNode(headB.data, null);
			result = result.next;
			headB = headB.next;
		}
		return temp;

	}

}
