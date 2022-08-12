package azPcise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLowestPrice {

	public static void main(String[] args) {
		List<List<String>> products = Arrays.asList(Arrays.asList("10", "d0", "d1"),
				Arrays.asList("15", "EMPTY", "EMPTY"), Arrays.asList("20", "d1", "EMPTY"));
		List<List<String>> discounts = Arrays.asList(Arrays.asList("d0", "1", "27"), Arrays.asList("d1", "2", "5"));

		System.out.println(solve(products, discounts));

	}

	private static int solve(List<List<String>> products, List<List<String>> discounts) {
		int totalFinal = 0;
		Map<String, Map<String, String>> map = new HashMap<>();
		Map<String, String> innerMap;
		for (List<String> eachDiscount : discounts) {
			innerMap = new HashMap<>();
			innerMap.put(eachDiscount.get(1), eachDiscount.get(2));
			map.put(eachDiscount.get(0), innerMap);
		}

		for (List<String> eachProduct : products) {
			int currentPrice = Integer.valueOf(eachProduct.get(0));
			int minSoFar = Integer.MAX_VALUE;

			for (int i = 1; i < eachProduct.size(); i++) {
				String eachTag = eachProduct.get(i);

				int total = 0;
				if (eachTag == "EMPTY") {
					continue;
				}
				Map<String, String> fetchedMap = map.get(eachTag);
				if (null != fetchedMap) {
					if (fetchedMap.containsKey("0")) {
						total += Integer.valueOf(fetchedMap.get("0"));
					} else if (fetchedMap.containsKey("1")) {
						int percetage = Integer.valueOf(fetchedMap.get("1"));
						total += Math.floor(currentPrice - (float) currentPrice * (float) percetage / 100);
					} else if (fetchedMap.containsKey("2")) {
						total += currentPrice - Integer.valueOf(fetchedMap.get("2"));
					}
				}
				minSoFar = Math.min(total, minSoFar);
			}
			totalFinal += minSoFar == Integer.MAX_VALUE ? currentPrice : minSoFar;

		}
		return totalFinal;
	}

}
