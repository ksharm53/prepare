package arraysAndStrings;

public class PartitioningMinimumNumberOfDeciBinaryNumbers {

	public static void main(String[] args) {
		String n = "27346209830709182346";

		System.out.println(solve(n));

	}

	private static int solve(String n) {

		int max = Integer.MIN_VALUE;

		for (char iterable_element : n.toCharArray()) {
			max = Math.max(max, Integer.valueOf(Character.toString(iterable_element)));
		}

		return max;
	}

}
