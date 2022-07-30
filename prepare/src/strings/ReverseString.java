package strings;

public class ReverseString {

	public static void main(String[] args) {
		char[] s = { 'h', 'e', 'l', 'l', 'o' };
		reverseString(s, s.length);
	}

	public static void reverseString(char[] s, int length) {
		if (length <= 0) {
			return;
		}
		System.out.println(s[length - 1]);
		reverseString(s, length - 1);
	}

}
