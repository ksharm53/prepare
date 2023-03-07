package oct3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public class BlackRockCurrencyExchange {
	

	public static class Pair {
		String from;
		double rate;

		public Pair(String from, double rate) {
			this.from = from;
			this.rate = rate;
		}

		public String getFrom() {
			return from;
		}

		public void setFrom(String from) {
			this.from = from;
		}

		public double getRate() {
			return rate;
		}

		public void setRate(double rate) {
			this.rate = rate;
		}

	}

	public static void main(String[] args) {
		String exchange = "USD,CAD,1.3;USD,GBP,0.71;USD,JPY,109;GBP,JPY,155";
		// String exchange =
		// "USD,GBP,0.7;USD,JPY,109;GBP,JPY,155;CAD,CNY,5.27;CAD,KRW,921";
		String from = "USD";
		String to = "JPY";
		System.out.println(solve(exchange, from, to));
	}

	private static double solve(String exchange, String from, String to) {
		String[] exchangeArray = exchange.split(";");

		Map<String, Map<String, Double>> graph = createGraph(exchangeArray);

		return fetchData(graph, from, to);
	}

	private static double fetchData(Map<String, Map<String, Double>> graph, String from, String to) {
		double rate = -1.0;
		if (!graph.containsKey(from) || !graph.containsKey(to)) {
			return rate;
		}
		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(from, 1.0));

		Set<String> set = new HashSet<>();

		while (!stack.isEmpty()) {
			Pair each = stack.pop();
			String currency = each.getFrom();
			double exch = each.getRate();

			if (currency.equals(to)) {
				rate = Math.max(rate, exch);
			}
			if (set.contains(currency)) {
				continue;
			}
			set.add(currency);

			for (Entry<String, Double> eachEntry : graph.get(currency).entrySet()) {
				if (!set.contains(eachEntry.getKey())) {
					stack.push(new Pair(eachEntry.getKey(), exch * eachEntry.getValue()));
				}
			}
		}

		return rate;

	}

	private static Map<String, Map<String, Double>> createGraph(String[] exchangeArray) {
		Map<String, Map<String, Double>> map = new HashMap<>();

		for (String eachExchange : exchangeArray) {
			String[] innerArray = eachExchange.split(",");
			map.putIfAbsent(innerArray[0], new HashMap<>());
			map.get(innerArray[0]).put(innerArray[1], Double.valueOf(innerArray[2]));

			map.putIfAbsent(innerArray[1], new HashMap<>());
			map.get(innerArray[1]).put(innerArray[0], 1 / Double.valueOf(innerArray[2]));
		}
		return map;
	}

}
