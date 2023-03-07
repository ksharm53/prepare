package CodeSignal;

public class DocString {

	public static void main(String[] args) {
		String docString = "Function `some_function` has two arguments `short_arg very_long_argument`. The `very_long_argument` has a default value of `CONSTANT_VALUE`.";
		System.out.println(solve(docString));
	}

	private static String solve(String docString) {
		String[] array = docString.split(" ");

		for (int i = 0; i < array.length; i++) {
			String eachString = array[i];
			if (!eachString.startsWith("`") && !eachString.contains("_")) {
				continue;
			} else {
				if (Character.isUpperCase(eachString.charAt(1))) {
					continue;
				} else {
					StringBuilder sb = new StringBuilder();
					sb.append(eachString.charAt(0));
					sb.append(eachString.charAt(1));
					for (int inner = 2; inner < eachString.length(); inner++) {
						if (eachString.charAt(inner) == '_') {
							continue;
						} else if (eachString.charAt(inner - 1) == '_') {
							sb.append(Character.toUpperCase(eachString.charAt(inner)));
						} else {
							sb.append(eachString.charAt(inner));
						}
					}
					array[i] = sb.toString();
				}
			}
		}

		StringBuilder sb1 = new StringBuilder();

		for (String string : array) {
			sb1.append(string);
			sb1.append(" ");
		}
		return sb1.toString();
	}

}
