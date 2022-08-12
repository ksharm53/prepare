package azPcise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxGreyNess {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("011", "101", "001");
		System.out.println(solve(list));

	}

	private static int solve(List<String> list) {
		Map<String, Map<String, Integer>> map = new HashMap<>();
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < list.size(); i++) {
			String eachRow = list.get(i);

			Map<String, Integer> innerRowMap = new HashMap<>();

			int blackCount = 0;
			int whiteCount = 0;
			for (int j = 0; j < eachRow.length(); j++) {
				char eachChar = eachRow.charAt(j);
				if (eachChar == '1') {
					blackCount++;
				} else {
					whiteCount++;
				}
			}
			innerRowMap.put("black", blackCount);
			innerRowMap.put("white", whiteCount);
			map.put("row" + i, innerRowMap);
		}

		for (int i = 0; i < list.get(0).length(); i++) {
			int blackCount = 0;
			int whiteCount = 0;
			Map<String, Integer> innerColumnMap = new HashMap<>();
			for (int j = 0; j < list.size(); j++) {
				char eachChar = list.get(j).charAt(i);
				if (eachChar == '1') {
					blackCount++;
				} else {
					whiteCount++;
				}
			}

			innerColumnMap.put("black", blackCount);
			innerColumnMap.put("white", whiteCount);
			map.put("column" + i, innerColumnMap);
		}

		for (int i = 0; i < list.size(); i++) {
			Map<String, Integer> resultant = map.get("row" + i);
			String eachRow = list.get(i);
			for (int j = 0; j < eachRow.length(); j++) {
				Map<String, Integer> resultantColumn = map.get("column" + j);
				max = Math.max(max, Math.abs((resultant.get("black") + resultantColumn.get("black"))
						- (resultant.get("white") + resultantColumn.get("white"))));
			}
		}

		return max;
	}

}
