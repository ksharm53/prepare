package jan2024;

public class WordSquares {

	public static void main(String[] args) {
		String queryIP = "1.0.1.";
		System.out.println(validIPAddress(queryIP));
	}

	public static String validIPAddress(String queryIP) {
		return solve(queryIP);
	}

	public static String solve(String queryIP) {
		if (queryIP.contains(".")) {
			String[] arr = queryIP.split("\\.", -1);
			if (arr.length == 4) {
				for (String each : arr) {
					if (!validateipv4(each)) {
						return "Neither";
					}
				}
				return "IPv4";
			} else {
				return "Neither";
			}
		} else if (queryIP.contains(":")) {
			String[] arr = queryIP.split("\\:", -1);
			if (arr.length == 8) {
				for (String each : arr) {
					if (each.length() < 1 || each.length() > 4) {
						return "Neither";
					}
					if (!validateipv6(each)) {
						return "Neither";
					}
				}
				return "IPv6";
			} else {
				return "Neither";
			}
		}
		return "Neither";

	}

	public static boolean validateipv6(String str) {
		for (char eachChar : str.toCharArray()) {
			if (!(Character.isAlphabetic(eachChar) || Character.isDigit(eachChar))) {
				return false;
			}

			if ((Character.toLowerCase(eachChar) == 'g' || Character.toLowerCase(eachChar) == 'h'
					|| Character.toLowerCase(eachChar) == 'i' || Character.toLowerCase(eachChar) == 'j'
					|| Character.toLowerCase(eachChar) == 'k' || Character.toLowerCase(eachChar) == 'l'
					|| Character.toLowerCase(eachChar) == 'm' || Character.toLowerCase(eachChar) == 'n'
					|| Character.toLowerCase(eachChar) == 'o' || Character.toLowerCase(eachChar) == 'p'
					|| Character.toLowerCase(eachChar) == 'q' || Character.toLowerCase(eachChar) == 'r'
					|| Character.toLowerCase(eachChar) == 's' || Character.toLowerCase(eachChar) == 't'
					|| Character.toLowerCase(eachChar) == 'u' || Character.toLowerCase(eachChar) == 'v'
					|| Character.toLowerCase(eachChar) == 'w' || Character.toLowerCase(eachChar) == 'x'
					|| Character.toLowerCase(eachChar) == 'y' || Character.toLowerCase(eachChar) == 'z')) {
				return false;
			}
		}
		return true;
	}

	public static boolean validateipv4(String str) {
		boolean flag = true;

		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}

		int intVal = Integer.parseInt(str);
		if (intVal < 0 || intVal > 255) {
			return false;
		}
		for (char eachChar : str.toCharArray()) {

			if (flag && eachChar == '0') {
				return false;
			}

			if (eachChar != '0') {
				flag = false;
			}
		}
		return true;
	}

}
