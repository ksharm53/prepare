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
		// String exchange = "USD,CAD,1.3;USD,GBP,0.71;USD,JPY,109;GBP,JPY,155";
		String exchange = "USD,GBP,0.7;USD,JPY,109;GBP,JPY,155;CAD,CNY,5.27;CAD,KRW,921";
		String from = "USD";
		String to = "CNY";
		// System.out.println(solve(exchange, from, to));

		System.out.println(solveAgain(exchange, from, to));
	}

	private static double solveAgain(String exchange, String from, String to) {
		Map<String, Map<String, Double>> currencyMap = parseRates(exchange);

		// Calculate the maximum amount of the target currency
		double result = calculateMaximumAmount(from, to, currencyMap);

		return result;

	}

	private static Map<String, Map<String, Double>> parseRates(String rates) {
		Map<String, Map<String, Double>> currencyMap = new HashMap<>();
		String[] ratePairs = rates.split(";");

		for (String ratePair : ratePairs) {
			String[] currencies = ratePair.trim().split(",");
			String sourceCurrency = currencies[0].trim();
			String targetCurrency = currencies[1].trim();
			double exchangeRate = Double.parseDouble(currencies[2].trim());

			currencyMap.putIfAbsent(sourceCurrency, new HashMap<>());
			currencyMap.get(sourceCurrency).put(targetCurrency, exchangeRate);

			currencyMap.putIfAbsent(targetCurrency, new HashMap<>());
			currencyMap.get(targetCurrency).put(sourceCurrency, 1 / exchangeRate);
		}

		return currencyMap;
	}

	private static double calculateMaximumAmount(String selectedCurrency, String targetCurrency,
			Map<String, Map<String, Double>> currencyMap) {
		if (!currencyMap.containsKey(selectedCurrency) || !currencyMap.containsKey(targetCurrency)) {
			return -1.0;
		}

		if (selectedCurrency.equals(targetCurrency)) {
			return 1.0;
		}

		Set<String> visitedCurrencies = new HashSet<>();
		return dfs(selectedCurrency, targetCurrency, currencyMap, 1.0, visitedCurrencies);
	}

	private static double dfs(String currentCurrency, String targetCurrency,
			Map<String, Map<String, Double>> currencyMap, double amount, Set<String> visitedCurrencies) {
		if (currentCurrency.equals(targetCurrency)) {
			return amount;
		}

		Map<String, Double> exchangeRates = currencyMap.get(currentCurrency);
		double maxAmount = -1.0;

		visitedCurrencies.add(currentCurrency); // Mark the current currency as visited

		for (String nextCurrency : exchangeRates.keySet()) {
			if (visitedCurrencies.contains(nextCurrency)) {
				continue; // Skip currencies that have been visited already (to avoid loops)
			}

			double rate = exchangeRates.get(nextCurrency);
			double nextAmount = amount * rate;
			double result = dfs(nextCurrency, targetCurrency, currencyMap, nextAmount, visitedCurrencies);

			if (result != -1.0 && result > maxAmount) {
				maxAmount = result;
			}
		}

		visitedCurrencies.remove(currentCurrency); // Remove the current currency from visited currencies

		return maxAmount;
	}

}
