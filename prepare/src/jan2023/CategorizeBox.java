package jan2023;

public class CategorizeBox {

	public static void main(String[] args) {

		int length = 2909;
		int width = 3968;
		int height = 3272;
		int mass = 727;

		System.out.println(categorizeBox(length, width, height, mass));

	}

	public static String categorizeBox(int length, int width, int height, int mass) {
		long volume = (long) length * (long) width * (long) height;

		String isBulky = "";
		String isHeavy = "";
		
		String cat = "";
		if (length >= 10000 || width >= 10000 || height >= 10000 || volume >= 1000000000) {
			isBulky = "Bulky";
		}
		if (mass >= 100) {
			isHeavy = "Heavy";
		}
		if (isBulky == "Bulky" && isHeavy == "Heavy") {
			cat = "Both";
		} else if (isBulky != "Bulky" && isHeavy != "Heavy") {
			cat = "Neither";
		} else if (isBulky == "Bulky" && isHeavy != "Heavy") {
			cat = "Bulky";
		} else if (isBulky != "Bulky" && isHeavy == "Heavy") {
			cat = "Heavy";
		}
		return cat;
	}

}
