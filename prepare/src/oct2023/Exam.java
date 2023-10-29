package oct2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exam {

	public static void main(String[] args) {
		List<String> ip = new ArrayList<>();

		ip.add("BUY googl 20");
		ip.add("BUY aapl 50");
		ip.add("CHANGE googl 6");
		ip.add("QUERY");
		ip.add("SELL aapl 10");
		ip.add("CHANGE aapl -2");
		ip.add("QUERY");

		System.out.println(getNetProfit(ip));

	}

	public static List<Long> getNetProfit(List<String> events) {
		List<Long> result = new ArrayList<>();
		Map<String, Integer> holdings = new HashMap<>();
		Map<String, Integer> prices = new HashMap<>();
		long netProfit = 0;

		for (String event : events) {
			String[] eventParts = event.split(" ");
			String action = eventParts[0];

			if (action.equals("BUY")) {
				String stock = eventParts[1];
				int quantity = Integer.parseInt(eventParts[2]);
				holdings.put(stock, holdings.getOrDefault(stock, 0) + quantity);
				netProfit -= quantity * prices.getOrDefault(stock, 0);
			} else if (action.equals("SELL")) {
				String stock = eventParts[1];
				int quantity = Integer.parseInt(eventParts[2]);
				if (holdings.containsKey(stock) && holdings.get(stock) >= quantity) {
					holdings.put(stock, holdings.get(stock) - quantity);
					netProfit += quantity * prices.getOrDefault(stock, 0);
				}
			} else if (action.equals("CHANGE")) {
				String stock = eventParts[1];
				int priceChange = Integer.parseInt(eventParts[2]);
				prices.put(stock, prices.getOrDefault(stock, 0) + priceChange);
			} else if (action.equals("QUERY")) {
				long queryProfit = 0;
				for (Map.Entry<String, Integer> entry : holdings.entrySet()) {
					String stock = entry.getKey();
					int quantity = entry.getValue();
					if (prices.containsKey(stock)) {
						queryProfit += quantity * prices.get(stock);
					}

				}
				result.add(queryProfit + netProfit);
			}
		}

		return result;
	}

}
