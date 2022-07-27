package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Waiter {

	public static void main(String[] args) {
		List<Integer> number = Arrays.asList(2, 3, 4, 5, 6, 7);
		int q = 3;

		System.out.println(solve(number, q));

	}

	private static List<Integer> solve(List<Integer> number, int q) {
		List<Integer> list = new ArrayList<>();
		Stack<Integer> stackA = new Stack<>();
		Stack<Integer> stackB = new Stack<>();
		Stack<Integer> stackC = new Stack<>();
		int counter = 0;

		for (int i = 0; i < number.size(); i++) {
			stackA.push(number.get(i));
		}

		while (q > 0) {
			counter++;
			q--;
			int prime = nThPrime(counter);

			while (!stackA.isEmpty()) {
				if (stackA.peek() % prime == 0) {
					stackB.push(stackA.peek());
				} else {
					stackC.push(stackA.peek());
				}
				stackA.pop();
			}
			while (!stackB.isEmpty()) {
				list.add(stackB.pop());
			}
			stackA = (Stack<Integer>) stackC.clone();
			stackC.clear();
		}
		while (!stackA.isEmpty()) {
			list.add(stackA.pop());
		}

		return list;
	}

	static int nThPrime(int n) {
		int i = 2;

		while (n > 0) {
			if (isPrime(i) == 1)
				n--;

			i++;
		}
		i -= 1;
		return i;
	}

	static int isPrime(int k) {
		if (k <= 1)
			return 0;
		if (k == 2 || k == 3)
			return 1;

		if (k % 2 == 0 || k % 3 == 0)
			return 0;

		for (int i = 5; i * i <= k; i = i + 6)
			if (k % i == 0 || k % (i + 2) == 0)
				return 0;

		return 1;
	}

}
