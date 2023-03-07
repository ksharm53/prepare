package feb07;

public class AddStrings {

	public static void main(String[] args) {
		String s1 = "11";
		String s2 = "123";

		System.out.println(addStrings(s1, s2));

	}

	public static String addStrings(String num1, String num2) {
		int carry = 0;
		int idx1 = num1.length() - 1;
		int idx2 = num2.length() - 1;
		StringBuilder sb = new StringBuilder();

		while (idx1 >= 0 || idx2 >= 0) {
			int val = -1;
			if (idx1 < 0 && idx2 >= 0) {
				val = Character.getNumericValue(num2.charAt(idx2)) + carry;
			} else if (idx2 < 0 && idx1 >= 0) {
				val = Character.getNumericValue(num1.charAt(idx1)) + carry;
			} else if (idx2 >= 0 && idx1 >= 0) {
				val = Character.getNumericValue(num1.charAt(idx1)) + Character.getNumericValue(num2.charAt(idx2))
						+ carry;
			}

			sb.append(val % 10);
			carry = val / 10;
			idx1--;
			idx2--;
		}
		if (carry > 0) {
			sb.append(carry);
		}
		return sb.reverse().toString();
	}

}
