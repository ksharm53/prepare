package july;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinimumString {

	static StringBuilder finalRes;

	public static void main(String[] args) {
		String a = "ca", b = "a", c = "a";
		List<String> list = new ArrayList<>();
		list.add(a);
		list.add(b);
		list.add(c);

		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});

		System.out.println(solve(list));

	}

	private static String solve(List<String> list) {
		StringBuilder sb = new StringBuilder();
		for (String each : list) {
			if (sb.isEmpty()) {
				sb.append(each);
			} else {
				int i;
				StringBuilder temp = new StringBuilder(sb);
				for (i = 0; i < sb.length(); i++) {
					if (each.startsWith(sb.substring(i, sb.length()))) {
						break;
					}

				}

				if (i == sb.length()) {
					sb.append(each);
				} else {
					sb.append(each.substring(sb.length() - i, each.length()));
				}

				for (i = 0; i < temp.length(); i++) {
					if (each.endsWith(temp.substring(i, temp.length()))) {
						break;
					}
				}

				if (i == temp.length()) {
					sb.append(each);
				} else {
					sb.append(each.substring(sb.length() - i, each.length()));
				}
			}
		}

		return sb.toString();
	}

}
