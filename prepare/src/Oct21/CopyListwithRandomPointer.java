package Oct21;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {

	public static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(7);
		Node first = new Node(13);
		Node sec = new Node(11);
		Node thi = new Node(10);
		Node Fri = new Node(1);

		head.next = first;
		first.next = sec;
		sec.next = thi;
		thi.next = Fri;
		Fri.next = null;

		head.random = null;
		first.random = head;
		sec.random = Fri;
		thi.random = sec;
		Fri.random = head;

		/*
		 * Node head = new Node(3); Node first = new Node(3); Node sec = new Node(3);
		 * Node thi = new Node(10); Node Fri = new Node(1);
		 * 
		 * head.next = first; first.next = sec; sec.next = thi; thi.next = Fri; Fri.next
		 * = null;
		 * 
		 * head.random = null; first.random = head; sec.random = Fri; thi.random = sec;
		 * Fri.random = head;
		 */

		System.out.println(solve(head));

	}

	private static Node solve(Node head) {
		Map<Node, Node> map = new HashMap<>();
		Node last = new Node(0);
		Node runHead = last;

		Node orgHead = head;
		int counter = 0;

		while (head != null) {
			last.val = head.val;
			if (head.next == null) {
				last.next = null;
			} else {
				last.next = new Node(head.next.val);
			}
			map.put(head, last);
			last = last.next;
			head = head.next;
			counter++;
		}

		head = orgHead;
		last = runHead;

		counter = 0;
		while (head != null) {
			if (head.random == null) {
				last.random = null;
			} else {
				last.random = map.get(head.random);
			}
			head = head.next;
			last = last.next;
			counter++;
		}
		return runHead;
	}

}
