package novTwentyFour;

public class AddBinary {
	public static StringBuilder sb;
	public static int carry;

	public static void main(String[] args) {
		String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
		String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
		sb = new StringBuilder();
		carry = 0;
		solve(a, b);
		System.out.println(sb.reverse().toString());
	}

	private static void solve(String a, String b) {

		int posa = a.length() - 1;
		int posb = b.length() - 1;

		while (posa >= 0 || posb >= 0) {
			if (posa >= 0 && posb >= 0) {
				int aVal = Integer.parseInt(String.valueOf(a.charAt(posa)));
				int bVal = Integer.valueOf(String.valueOf(b.charAt(posb)));
				appendToSB(aVal, bVal);
				posa--;
				posb--;
			} else if (posa < 0) {
				int bVal = Integer.valueOf(String.valueOf(b.charAt(posb)));
				appendToSB(0, bVal);
				posb--;
			} else if (posb < 0) {
				int aVal = Integer.parseInt(String.valueOf(a.charAt(posa)));
				appendToSB(aVal, 0);
				posa--;
			}
		}
		if (carry == 1) {
			sb.append(carry);
		}
	}

	private static void appendToSB(int aVal, int bVal) {
		if (aVal == 1 && bVal == 1 && carry == 1) {
			sb.append("1");
			carry = 1;
		} else if (aVal == 0 && bVal == 0 && carry == 0) {
			sb.append("0");
			carry = 0;
		} else if (aVal == 1 && bVal == 1 && carry == 0) {
			sb.append("0");
			carry = 1;
		} else if (aVal == 0 && bVal == 0 && carry == 1) {
			sb.append("1");
			carry = 0;
		} else if (aVal == 0 && bVal == 1 && carry == 0) {
			sb.append("1");
			carry = 0;
		} else if (aVal == 1 && bVal == 0 && carry == 0) {
			sb.append("1");
			carry = 0;
		} else if (aVal == 0 && bVal == 1 && carry == 1) {
			sb.append("0");
			carry = 1;
		} else if (aVal == 1 && bVal == 0 && carry == 1) {
			sb.append("0");
			carry = 1;
		}

	}

}
