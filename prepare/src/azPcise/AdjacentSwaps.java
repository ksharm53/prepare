package azPcise;

public class AdjacentSwaps {

	public static void main(String[] args) {
		String s = "00110";
		System.out.println(minFlipsMonoIncr(s));
	}

	public static int minFlipsMonoIncr(String S) {

		int one = 0;
		int flip = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '1')
				one++;
			else
				flip++;
			flip = Math.min(one, flip);
		}
		return flip;
	}
}
