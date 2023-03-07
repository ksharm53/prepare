package arrays09162022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FindDuplicateFileInSystem {

	public static void main(String[] args) {
		String[] paths = { "root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)",
				"root 4.txt(efgh)" };
		System.out.println(solve(paths));
	}

	private static List<List<String>> solve(String[] paths) {
		Map<String, List<String>> visited = new HashMap<>();
		List<List<String>> listResult = new ArrayList<>();

		for (String eachPath : paths) {
			String[] inner = eachPath.split(" ");
			String first = "";
			for (int i = 0; i < inner.length; i++) {
				if (i == 0) {
					first = inner[0];
					continue;
				}
				String temp = inner[i];
				String substring = temp.substring(temp.indexOf("(") + 1, temp.indexOf(")"));
				String restString = temp.substring(0, temp.indexOf("("));
				List<String> tempList = visited.getOrDefault(substring, new ArrayList<String>());
				tempList.add(first + "/" + restString);
				visited.put(substring, tempList);
			}

		}

		for (Entry<String, List<String>> eachEntry : visited.entrySet()) {
			if (eachEntry.getValue().size() > 1) {
				listResult.add(eachEntry.getValue());
			}
		}
		return listResult;
	}

}
