package august23;

public class PushDominoes {

	public static class Pair {
		int index;
		char value;

		public Pair(int index, char value) {
			this.index = index;
			this.value = value;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public char getValue() {
			return value;
		}

		public void setValue(char value) {
			this.value = value;
		}

	}

	public static void main(String[] args) {
		String dominoes = ".L.R...LR..L..";
		System.out.println(solve(dominoes));

	}

	private static String solve(String dominoes) {
		if (dominoes.length() == 0) {
			return dominoes;
		}

		StringBuilder sb = new StringBuilder(dominoes);

		for (int i = 1; i < sb.length(); i++) {
			if (sb.charAt(i) == 'L') {
				int cursor = i;
				while (cursor - 1 >= 0 && sb.charAt(cursor - 1) == '.') {
					sb.replace(cursor - 1, cursor, "L");
					cursor--;
				}
				if (cursor - 1 >= 0 && sb.charAt(cursor - 1) == 'R') {
					sb.replace(cursor - 1, cursor, ".");
				}
			} else if (sb.charAt(i) == 'R') {
				int cursor = i;
				while (cursor + 2 < sb.length() && sb.charAt(cursor + 1) == '.') {
					sb.replace(cursor + 1, cursor + 2, "R");
					cursor++;
				}
				if (cursor + 1 < sb.length() && sb.charAt(cursor + 1) == 'L') {
					sb.replace(cursor + 1, cursor + 2, ".");
				}
			}

		}
		return sb.toString();
	}

}
