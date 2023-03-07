package feb07;

public class MainCashiar {

	public static void main(String[] args) {
		int[] prod = { 1, 2, 3, 4, 5, 6, 7 };
		int[] price = { 100, 200, 300, 400, 300, 200, 100 };
		Cashier cashier = new Cashier(3, 50, prod, price);

		System.out.println(cashier.getBill(new int[] { 1, 2 }, new int[] { 1, 2 }));
		System.out.println(cashier.getBill(new int[] { 3, 7 }, new int[] { 10, 10 }));
		System.out.println(cashier.getBill(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[] { 1, 1, 1, 1, 1, 1, 1 }));

		System.out.println(cashier.getBill(new int[] { 4 }, new int[] { 10 }));
		System.out.println(cashier.getBill(new int[] { 7, 3 }, new int[] { 10, 10 }));
		System.out.println(cashier.getBill(new int[] { 7, 5, 3, 1, 6, 4, 2 }, new int[] { 10, 10, 10, 9, 9, 9, 7 }));

		System.out.println(cashier.getBill(new int[] { 2, 3, 5 }, new int[] { 5, 3, 2 }));

	}

}
