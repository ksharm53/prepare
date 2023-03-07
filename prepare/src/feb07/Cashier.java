package feb07;

import java.util.HashMap;
import java.util.Map;

public class Cashier {

	int n;
	int discount;
	Map<Integer, Integer> map;
	int counter;

	public Cashier(int n, int discount, int[] products, int[] prices) {
		this.n = n;
		this.discount = discount;
		this.counter = 1;
		map = new HashMap<>();

		int size = products.length;

		for (int i = 0; i < size; i++) {
			map.put(products[i], map.getOrDefault(products[i], prices[i]));
		}
	}

	public double getBill(int[] product, int[] amount) {
		int size = product.length;
		double total = 0.0;
		if (this.counter == this.n) {
			for (int i = 0; i < size; i++) {
				int price = this.map.get(product[i]);
				double interme = ((double) amount[i] * (double) price);
				interme = interme - ((this.discount * interme) / 100);
				total += interme;
			}
			this.counter = 0;
		} else {
			for (int i = 0; i < size; i++) {
				int price = this.map.get(product[i]);
				total += ((double) amount[i] * (double) price);
			}
		}
		this.counter = this.counter + 1;

		return total;
	}

}
