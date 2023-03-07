package novTwentyFour;

public class LengthofLastWord {

	public static void main(String[] args) {
		String s = "a";
		System.out.println(lengthOfLastWord(s));

	}

	public static int lengthOfLastWord(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int val = 0;
		int pos = s.length() - 1;
		char last = s.charAt(pos);
		while (pos >= 0 && last == ' ') {
			pos = pos - 1;
			if (pos >= 0) {
				last = s.charAt(pos);
			}
		}
		while (pos >= 0 && last != ' ') {
			val++;
			pos = pos - 1;
			if (pos >= 0) {
				last = s.charAt(pos);
			}

		}
		return val;
	}

}
