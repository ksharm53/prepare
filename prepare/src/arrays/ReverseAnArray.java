package arrays;

public class ReverseAnArray {

	public static void main(String[] args) {
		int arr[] = { 4, 5, 1, 2 };
		String value = "Geeks";
		System.out.println(solve(arr));
		System.out.println(solveString(value));
	}

	private static String solveString(String value) {

		char[] array = value.toCharArray();
		char[] result = new char[array.length];
		StringBuilder sb = new StringBuilder();

		int start = 0;
		int end = value.length() - 1;

		while (start <= end) {
			if (start == end) {
				result[start] = array[end];
			} else {
				result[start] = array[end];
				result[end] = array[start];
			}

			start++;
			end--;
		}

		for (char c : result) {
			sb.append(c);
		}
		return sb.toString();

	}

	private static int[] solve(int[] arr) {

		int[] result = new int[arr.length];
		int start = 0;
		int end = arr.length - 1;

		if (arr.length % 2 != 0) {
			result[arr.length / 2] = arr[arr.length / 2];
		}

		while (start < end) {
			result[start] = arr[end];
			result[end] = arr[start];
			start++;
			end--;
		}
		return result;
	}

}
