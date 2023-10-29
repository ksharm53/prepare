package Apr1;

public class haveConflict {

	public static void main(String[] args) {
		String[] event1 = { "07:22", "18:22" };
		String[] event2 = { "07:22", "14:16" };
		System.out.println(solve(event1, event2));

	}

	public static boolean solve(String[] event1, String[] event2) {
		int val00 = 0;
		int val01 = 0;
		int val10 = 0;
		int val11 = 0;

		StringBuilder sb = new StringBuilder();
		int idx = event1[1].indexOf(':');
		sb.append(event1[1].substring(0, idx));
		sb.append(event1[1].substring(idx + 1, event1[1].length()));
		val01 = Integer.valueOf(sb.toString());

		sb = new StringBuilder();
		idx = event1[0].indexOf(':');
		sb.append(event1[0].substring(0, idx));
		sb.append(event1[0].substring(idx + 1, event1[0].length()));
		val00 = Integer.valueOf(sb.toString());

		sb = new StringBuilder();
		idx = event2[0].indexOf(':');
		sb.append(event2[0].substring(0, idx));
		sb.append(event2[0].substring(idx + 1, event2[0].length()));
		val10 = Integer.valueOf(sb.toString());

		sb = new StringBuilder();
		idx = event2[1].indexOf(':');
		sb.append(event2[1].substring(0, idx));
		sb.append(event2[1].substring(idx + 1, event2[1].length()));
		val11 = Integer.valueOf(sb.toString());

		if (val00 <= val10 && val01 >= val10) {
			return true;
		}

		if (val10 <= val00 && val11 >= val00) {
			return true;
		}

		return false;
	}

}
