package dec;

import java.util.ArrayList;
import java.util.List;

public class MyStack {

	static List<Integer> list;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public MyStack() {
		list = new ArrayList<>();
	}

	public void push(int x) {
		list.add(x);
	}

	public int pop() {

		if (!list.isEmpty()) {
			return list.remove(list.size() - 1);
		} else {
			return -1;
		}
	}

	public int top() {
		if (!list.isEmpty()) {
			return list.get(list.size() - 1);
		} else {
			return -1;
		}
	}

	public boolean empty() {
		return list.isEmpty();
	}

}
