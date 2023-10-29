package mar01;

public class CanPlaceFlowers {

	public static void main(String[] args) {
		int[] arr = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		System.out.println(canPlaceFlowers(arr, 1));
	}

	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		int count = 0;
		int i = 0;
		while (i < flowerbed.length - 1) {
			if (flowerbed[i] == 0) {
				int zeroCounter = 0;
				while (i < flowerbed.length && flowerbed[i] == 0) {
					zeroCounter++;
					i++;
				}

				if (i == flowerbed.length) {
					count += countVal(zeroCounter);
				} else {
					count += (zeroCounter) / 2;
				}
			} else {
				int zeroCounter = 0;
				while (i < flowerbed.length && flowerbed[i] == 0) {
					zeroCounter++;
					i++;
				}

				if (i == flowerbed.length) {
					count += countVal(zeroCounter);
				} else {
					count += (zeroCounter) / 2;
				}
			}

		}
		System.out.println(count);
		return count >= n;
	}

	public static int countVal(int val) {
		if (val <= 2) {
			return 0;
		}

		return countVal(val - 2) + 1;
	}

}
