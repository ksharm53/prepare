package mar01;

public class Compress {

	public static void main(String[] args) {
		char[] chars = { 'a', 'a', 'a', 'b', 'b', 'a', 'a' };
		System.out.println(compress(chars));
	}

	public static int compress(char[] chars) {
		if (chars.length == 1) {
			return 1;
		}
		int val = 0;
		for (int i = 0; i < chars.length; i++) {
			int innerCount = 1;
			int temp = i;
			while (temp + 1 < chars.length && chars[temp + 1] == chars[temp]) {
				innerCount++;
				temp++;
			}
			chars[val++] = chars[i];
			if (innerCount > 1) {
				StringBuilder sb = new StringBuilder(String.valueOf(innerCount));
				val = i + 1;
				while (sb.length() > 0) {
					chars[val++] = sb.charAt(0);
					sb.deleteCharAt(0);
				}

			}
			i = temp;
		}
		return val;
	}

	public static int compressCopy(char[] chars) {
		int i = 0, res = 0;
		while (i < chars.length) {
			int groupLength = 1;
			while (i + groupLength < chars.length && chars[i + groupLength] == chars[i]) {
				groupLength++;
			}
			chars[res++] = chars[i];
			if (groupLength > 1) {
				for (char c : Integer.toString(groupLength).toCharArray()) {
					chars[res++] = c;
				}
			}
			i += groupLength;
		}
		return res;
	}

}
