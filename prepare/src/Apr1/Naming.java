package Apr1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Naming {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Map<String, Integer> map = new HashMap<>();

		int count = sc.nextInt();

		for (int i = 1; i <= count; i++) {
			String fName = sc.next();
			String lName = sc.next();

			StringBuilder sb = new StringBuilder();
			sb.append(fName.charAt(0));

			int temp = 0;
			while (temp < 4 && temp < lName.length()) {
				sb.append(lName.charAt(temp));
				temp++;
			}
			StringBuilder tempS = new StringBuilder(sb);

			if (map.containsKey(sb.toString())) {
				sb.append(map.get(sb.toString()) + 1);
			}

			map.put(tempS.toString(), map.getOrDefault(tempS.toString(), 0) + 1);

			System.out.println(sb.toString());
		}

	}

}
