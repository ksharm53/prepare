package Oct13;

public class countTime {

	public static void main(String[] args) {
		String time = "??:??";
		System.out.println(solve(time));

	}

	public static long solve(String time) {
		long val = 1l;
		for (int i = 0; i < time.length(); i++) {
			if (time.charAt(i) == ':') {
				continue;
			} else if (time.charAt(i) == '?') {
				if (i == 0) {
					if (time.charAt(i + 1) == '?') {
						val = val * 24;
						i++;
					} else if (Character.getNumericValue(time.charAt(i + 1)) <= 3) {
						val = val * 3;
					} else if (Character.getNumericValue(time.charAt(i + 1)) > 3) {
						val = val * 2;
					}
				} else if (i == 1) {
					if (Character.getNumericValue(time.charAt(i - 1)) <= 1) {
						val = val * 10;
					} else if (Character.getNumericValue(time.charAt(i - 1)) > 1) {
						val = val * 4;
					}
				} else if (i == 3) {
					if (time.charAt(i + 1) == '?') {
						val = val * 60;
						i++;
					} else {
						val = val * 6;
					}
				} else if (i == 4) {
					val = val * 10;
				}

			}
		}
		return val;
	}

}
