package dec;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

	public class Node {
		Node next;
		Node prev;
		int value;
		int key;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

		public Node() {
		}

	}

	Node head;
	Node tail;
	Map<Integer, Node> map;
	int capacity;

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));
		cache.put(3, 3);
		System.out.println(cache.get(2));
		cache.put(4, 4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
	}

	public LRUCache(int capacity) {
		head = new Node();
		tail = new Node();
		head.next = tail;
		head.prev = null;
		tail.prev = head;
		tail.next = null;

		map = new HashMap<>();
		this.capacity = capacity;
		System.out.println("null");

	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			deleteNode(node);
			addtoHead(node);
			return node.value;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		Node lastNode = map.get(key);
		Node newNode = new Node(key, value);
		if (lastNode == null) {
			addtoHead(newNode);
		} else {
			deleteNode(lastNode);
			addtoHead(newNode);
		}
		map.put(key, newNode);

		if (map.size() > this.capacity) {
			deleteTail();
		}
		System.out.println("null");
	}

	private void deleteTail() {
		Node tempPrev = tail.prev.prev;
		Node toBeDeleted = tail.prev;
		tempPrev.next = tail;
		tail.prev = tempPrev;

		map.remove(toBeDeleted.key);
	}

	private void deleteNode(Node lastNode) {
		Node tempNext = lastNode.next;
		Node tempPrev = lastNode.prev;
		tempNext.prev = tempPrev;
		tempPrev.next = tempNext;
	}

	private void addtoHead(Node newNode) {
		Node temp = head.next;
		head.next = newNode;
		newNode.prev = head;
		newNode.next = temp;
		temp.prev = newNode;
	}
}