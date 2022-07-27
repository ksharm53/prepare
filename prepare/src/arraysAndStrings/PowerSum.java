package arraysAndStrings;

import linkedLists.ListNode;

public class PowerSum {

	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(2);
		list1.next.next = new ListNode(4);

		ListNode list2 = new ListNode(1);
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(4);

		solve(list1, list2);
	}

	private static ListNode solve(ListNode list1, ListNode list2) {

		ListNode finalList = new ListNode();
		ListNode head1 = list1;
		ListNode head2 = list2;

		while (head1 != null && head2 != null) {
			if (head1.val <= head2.val) {
				if (finalList.val == 0) {
					finalList = head1;
				} else {
					finalList.next = head1;
					finalList = finalList.next;
				}
				head1 = head1.next;

			} else {
				if (finalList.val == 0) {
					finalList = head2;
				} else {
					finalList.next = head2;
					finalList = finalList.next;
				}
				head2 = head2.next;
			}
		}
		return finalList;
	}

}
