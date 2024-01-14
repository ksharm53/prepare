package oct2023;

import java.util.SortedMap;
import java.util.TreeMap;

public class CodeSignal {

	public static void main(String[] args) {
		String[][] queries = { { "SET", "A", "BC", "E" }, { "SET", "A", "BD", "F" }, { "SET", "A", "C", "G" },
				{ "SCAN_BY_PREFIX", "A", "B" }, { "SCAN", "A" }, { "SCAN_BY_PREFIX", "B", "B" } };

		System.out.println(solution(queries));

	}

	static String[] solution(String[][] queries) {

		TreeMap<String, String> outerMap = new TreeMap<>();

		String[] res = new String[queries.length];

		for (int i = 0; i < queries.length; i++) {
			String[] eachString = queries[i];
			if (eachString[0].equals("SET")) {
				outerMap.put(eachString[1] + "-" + eachString[2], eachString[3]);
				res[i] = "";

			} else if (eachString[0].equals("GET")) {
				if (!outerMap.containsKey(eachString[1] + "-" + eachString[2])) {
					res[i] = "";
					continue;
				}

				res[i] = outerMap.get(eachString[1] + "-" + eachString[2]);

			} else if (eachString[0].equals("DELETE")) {
				if (!outerMap.containsKey(eachString[1] + "-" + eachString[2])) {
					res[i] = "false";
					continue;
				}
				outerMap.remove(eachString[1] + "-" + eachString[2]);
				res[i] = "true";

			} else if (eachString[0].equals("SCAN_BY_PREFIX")) {
				StringBuilder sb = new StringBuilder();
				SortedMap<String, String> temp = getByPrefix(outerMap, eachString[1]);

				for (String keyVal : temp.keySet()) {
					String subString = keyVal.substring(keyVal.indexOf('-') + 1, keyVal.length());
					if (subString.startsWith(eachString[2])) {
						sb.append(subString + "(" + temp.get(keyVal) + ")");
						sb.append(", ");
					}
				}
				if (!sb.isEmpty()) {
					sb.deleteCharAt(sb.length() - 1);
					sb.deleteCharAt(sb.length() - 1);
				}

				res[i] = sb.toString();
			}

			else if (eachString[0].equals("SCAN")) {
				StringBuilder sb = new StringBuilder();
				SortedMap<String, String> temp = getByPrefix(outerMap, eachString[1]);

				for (String keyVal : temp.keySet()) {

					String subString = keyVal.substring(keyVal.indexOf('-') + 1, keyVal.length());

					sb.append(subString + "(" + temp.get(keyVal) + ")");
					sb.append(", ");
				}

				if (!sb.isEmpty()) {
					sb.deleteCharAt(sb.length() - 1);
					sb.deleteCharAt(sb.length() - 1);
				}
				res[i] = sb.toString();
			}
		}

		return res;
	}

	public static SortedMap<String, String> getByPrefix(TreeMap<String, String> myMap, String prefix) {
		return myMap.subMap(prefix, prefix + Character.MAX_VALUE);
	}

}
