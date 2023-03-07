package Sept23;

import java.util.HashMap;
import java.util.Map;

public class ReorderList {

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
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

		System.out.println(solve(head));
	}

	private static ListNode solve(ListNode head) {
		Map<Integer, Integer> map = new HashMap<>();
		int counter = 0;
		while (head != null) {
			map.put(counter, head.val);
			head = head.next;
			counter++;
		}

		int first = 0;
		int last = counter - 1;
		ListNode dummy = new ListNode(0);
		ListNode rukJa = dummy;

		while (first <= last) {
			if (first == last) {
				dummy.next = new ListNode(map.get(first));
				dummy = dummy.next;
				first++;
				last--;
			} else {
				dummy.next = new ListNode(map.get(first), new ListNode(map.get(last)));
				dummy = dummy.next.next;
				first++;
				last--;
			}

		}
		head = rukJa.next;
		return head;

	}

}
