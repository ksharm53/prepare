package feb07;

public class DivisibilityArray {

	public static void main(String[] args) {
		String word = "529282143571";
		int m = 4;
		System.out.println(divisibilityArray(word, m));
	}

	public static int[] divisibilityArray(String word, int m) {
		int[] ans = new int[word.length()];
		for (int i = 0; i < word.length(); i++) {
			int val = Integer.valueOf(word.substring(0, i + 1));
			if (val % m == 0) {
				ans[i] = 1;
			} else {
				ans[i] = 0;
			}
		}
		return ans;
	}

}
