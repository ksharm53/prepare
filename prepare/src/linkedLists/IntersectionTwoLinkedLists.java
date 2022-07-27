package linkedLists;

public class IntersectionTwoLinkedLists {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		ListNode headA = new ListNode(4);
		ListNode headB = new ListNode(4);

		System.out.println(solve(headA, headB));

	}

	private static ListNode solve(ListNode headA, ListNode headB) {

		ListNode tempA = headA;
		int counterA = 0;

		ListNode tempB = headB;
		int counterB = 0;

		while (tempA != null) {
			counterA++;
			tempA = tempA.next;
		}

		while (tempB != null) {
			counterB++;
			tempB = tempB.next;
		}

		tempA = headA;
		tempB = headB;

		if (counterA < counterB) {
			int diff = counterB - counterA;
			while (diff > 0) {
				tempB = tempB.next;
				diff--;
			}
		}

		else if (counterA > counterB) {
			int diff = counterA - counterB;
			while (diff > 0) {
				tempA = tempA.next;
				diff--;
			}
		}

		while (tempA != null && tempB != null) {
			if (tempA == tempB) {
				return tempA;
			}
			tempA=tempA.next;
			tempB=tempB.next;
		}
		return null;
	}

}
