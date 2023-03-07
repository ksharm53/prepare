package newBeginning;

public class Flip {

	public static void main(String[] args) {
		String A = "010";
		System.out.println(flip(A));

	}

	public static int[] flip(String A) {

		int[] ans = new int[2];
		int[] arr = new int[A.length()];
		int oneCount = 0;

		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == '1') {
				arr[i] = -1;
				oneCount++;
			} else
				arr[i] = 1;
		}
		if (oneCount == A.length())
			return new int[] {};

		int max = 0, currentSum = 0;
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			currentSum += arr[i];
			if (currentSum < 0) {
				currentSum = 0;
				j = i + 1;
			}
			if (currentSum > max) {
				ans[0] = j + 1;
				ans[1] = i + 1;
				max = currentSum;
			}

		}
		return ans;
	}
}
