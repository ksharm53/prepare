package newBeginning;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class LargestTimeFromDigits {

	public static void main(String[] args) {
		int[] arr = { 5, 5, 5, 5 };
		System.out.println(solve(arr));

	}

	private static String solve(int[] arr) {
		StringBuilder badaSb;
		Set<String> list = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				for (int k = 0; k < arr.length; k++) {
					for (int l = 0; l < arr.length; l++) {
						if (!(i == j || j == k || k == l || l == i || i == k || j == l)) {
							StringBuilder sb = new StringBuilder();
							badaSb = new StringBuilder();
							sb.append(arr[i]);
							sb.append(arr[j]);

							StringBuilder sb1 = new StringBuilder();
							sb1.append(arr[k]);
							sb1.append(arr[l]);

							if (Integer.valueOf(sb.toString()) < 24 && Integer.valueOf(sb1.toString()) < 60) {
								badaSb.append(sb.toString());
								badaSb.append(":");
								badaSb.append(sb1.toString());
								list.add(badaSb.toString());
							}
						}
					}
				}
			}
		}
		if (list.isEmpty())
			return "";
		SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
		Date max = null;
		try {

			max = parser.parse("00:00");
			for (String eachString : list) {
				Date eachDate = parser.parse(eachString);
				if (eachDate.after(max)) {
					max = eachDate;
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return parser.format(max);

	}

}
