package arraysAndStrings;

import java.util.Stack;

public class StockSpanner {

	Stack<Integer> stack;

	public StockSpanner() {
		stack = new Stack<>();
	}

	public int next(int price) {
		int counter = 1;
		if (stack.size() == 0) {
			counter = 1;
		} else if (stack.size() > 0 && price >= stack.peek()) {
			while (stack.size() > 0 && price >= stack.peek()) {
				counter++;
			}
		} else if (stack.size() > 0 && price < stack.peek()) {
			counter = 1;
		}
		
		stack.add(price);
		return counter;
	}
}
