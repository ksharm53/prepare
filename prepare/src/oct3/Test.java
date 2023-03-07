package oct3;

public class Test {

	public static void main(String[] args) {
		String s = "bydizfve";
		System.out.println(robotWithString(s));

	}

	public static String robotWithString(String s) {
		StringBuilder sb = new StringBuilder(s);
		StringBuilder t = new StringBuilder();
		StringBuilder p = new StringBuilder();
		int sCounter = 0;
		int minIdx = 0;

		do {

			// if (sCounter == sb.length() - 1) {
			// minIdx = sb.length() - 1;
			// } else {
			for (int i = sCounter; i < sb.length(); i++) {
				if (sb.charAt(i) <= sb.charAt(minIdx)) {
					minIdx = i;
				}
			}
			// }

			for (int i = sCounter; i <= minIdx; i++) {
				t.append(sb.charAt(i));
				sCounter++;
			}

			for (int i = t.length() - 1; i >= 0; i--) {
				p.append(t.charAt(i));
			}
			t = new StringBuilder();
			minIdx = sCounter;
		} while (sCounter != s.length());

		return p.toString();
	}

}
