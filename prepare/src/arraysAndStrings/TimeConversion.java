package arraysAndStrings;

public class TimeConversion {

	public static void main(String[] args) {
		String s = "12:45:54PM";
		System.out.println(timeConversion(s));
	}

	public static String timeConversion(String s) {
		StringBuilder sb = new StringBuilder(s);
		if (s.charAt(s.length() - 2) == 'A' && s.charAt(0) == '1' && s.charAt(1) == '2') {
			sb.replace(0, 2, "00");
		} else if (s.charAt(s.length() - 2) == 'P') {
			int value = Character.getNumericValue(s.charAt(0)) * 10 + Character.getNumericValue(s.charAt(1));
			value = (value + 12) % 24;
			if (value == 0) {
				sb.replace(0, 2, "12");
			} else {
				sb.replace(0, 2, String.valueOf(value));
			}
		}
		sb.delete(s.length() - 2, s.length());
		return sb.toString();
	}

}
