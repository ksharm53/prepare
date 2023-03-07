package CodeSignal;

public class CodeSignal_DaisyRose {

	public static void main(String[] args) {
		String[] arr = { "Daisy", "Rose", "Hyacinth", "Poppy" };
		System.out.println(solve(arr));

	}

	private static String solve(String[] arr) {
		StringBuilder sb = new StringBuilder();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i].length());
		}

		int counter = 0;
		while (max > 1) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i].length() > counter) {
					sb.append(arr[i].charAt(counter));
				}
			}
			max--;
		}
		return sb.toString();
	}

}
