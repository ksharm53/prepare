package azPcise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author ksharm53
 *
 */
/**
 * @author ksharm53
 *
 */
public class Test {

	public static List<Character> validValues = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
			'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
	public static String SPACE = " ";
	public static int LETTER_COUNT = 26;

	public static void main(String[] args) {

		solve("(A,B) (A,C) (B,D) (D,C)");

	}

	/**
	 * @param input Main function to perform validation of input string and printing
	 *              S Expression if all validations pass.
	 */
	private static void solve(String input) {
		String[] arrayString = input.split(SPACE);
		int[] charValue = new int[LETTER_COUNT];
		Set<String> set = new HashSet<>();
		Map<Character, List<Character>> parentChild = new TreeMap<>();
		boolean duplicatePairs = false;
		boolean isNotBinary = false;

		for (int i = 0; i < arrayString.length; i++) {
			String currentValue = arrayString[i];

			// Validate input format. This validates length, character position, spaces and
			// valid values.
			if (currentValue.length() != 5 || currentValue.charAt(0) != '(' || currentValue.charAt(2) != ','
					|| currentValue.charAt(4) != ')' || !validValues.contains(currentValue.charAt(1))
					|| !validValues.contains(currentValue.charAt(3))) {
				System.out.println("E1");
				return;
			}

			// Validate Duplicate nodes
			if (set.contains(currentValue)) {
				duplicatePairs = true;
			} else {
				set.add(currentValue);
			}

			// Validate more than 2 Child. Keeping parent as key and child node as list
			// values, we can find the size of list of child of each parent.
			List<Character> childList = parentChild.getOrDefault(currentValue.charAt(1), new ArrayList<>());
			childList.add(currentValue.charAt(3));
			parentChild.put(currentValue.charAt(1), childList);

			if (childList.size() > 2) {
				isNotBinary = true;
			}
			char temp = currentValue.charAt(3);
			charValue[temp - 'A']++;
		}

		if (duplicatePairs) {
			System.out.println("E2");
			return;
		}

		if (isNotBinary) {
			System.out.println("E3");
			return;
		}

		Queue<Character> queue = new LinkedList<>();
		int visited = 0;

		for (int i = 0; i < 26; i++) {
			if (charValue[i] == 0 && parentChild.containsKey((char) (i + 'A'))) {
				queue.offer((char) (i + 'A'));
			}
		}

		if (queue.size() > 1) {
			System.out.println("E4");
			return;
		}
		if (queue.size() == 0) {
			System.out.println("E5");
			return;
		}
		while (!queue.isEmpty()) {
			for (int i = 0; i < queue.size(); i++) {
				char eachChar = queue.poll();
				List<Character> children = parentChild.get(eachChar);
				if (children != null) {
					for (char eachChild : children) {
						charValue[eachChild - 'A']--;
						if (charValue[eachChild - 'A'] == 0) {
							queue.offer(eachChild);
							visited++;
						}
					}
				}

			}
		}
		if (visited < arrayString.length) {
			System.out.println("E5");
			return;
		}

		// Section to create S- Expression
		char firstCharacter = 0;
		for (Character eachChar : parentChild.keySet()) {
			firstCharacter = eachChar;
			break;
		}
		printSExpression(parentChild, firstCharacter);

	}

	/**
	 * @param parentChild
	 * @param topChar     Method to print S Expression of a binary tree in
	 *                    lexographical format. This recursive function takes root
	 *                    element and print its value to console. If node have one
	 *                    child, then there is nothing to compare for lexographical
	 *                    order but if it have two child, one in lower order, prints
	 *                    first. TreeSet is used to have ordered keySet.
	 */
	private static void printSExpression(Map<Character, List<Character>> parentChild, char topChar) {

		System.out.print("(" + topChar);
		if (parentChild.get(topChar) != null) {
			int totalChildern = parentChild.get(topChar).size();

			if (totalChildern == 1) {
				printSExpression(parentChild, parentChild.get(topChar).get(0));
			} else if (totalChildern == 2) {
				if (parentChild.get(topChar).get(0) < parentChild.get(topChar).get(1)) {
					printSExpression(parentChild, parentChild.get(topChar).get(0));
					printSExpression(parentChild, parentChild.get(topChar).get(1));
				} else {
					printSExpression(parentChild, parentChild.get(topChar).get(1));
					printSExpression(parentChild, parentChild.get(topChar).get(0));
				}
			}
		}
		System.out.print(")");
	}

}
