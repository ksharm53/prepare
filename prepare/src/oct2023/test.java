package oct2023;

public class test {

	static class Foo {
		public int i = 74;

		public Foo(int i) {
			this.i = i;
		}
	}

	public static void main(String[] args) {
		System.out.println(bar("Kanav"));
		System.out.println(barR("Kanav"));
		int[] list = new int[] { 4, 9, 11, 19, 22, 28, 33, 37, 41, 49, 54, 56, 62, 67, 73 };
		// System.out.println(binarySearch(list, 49));

		Foo x = new Foo(76), y = new Foo(31);
		y = x;
		y.i = 36;
		System.out.println(x.i);

		int[] arr = { 86, 35, 61, 8, 30, 66 };
		System.out.println("Original array:");
		selectionSort(arr);

		System.out.println("\nSorted array:");

	}

	static String bar(String s) {
		String r = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			r += s.charAt(i);
		}

		return r;

	}

	static String barR(String s) {
		if (s.length() < 1) {
			return s;
		}

		return barR(s.substring(1)) + s.charAt(0);
	}

	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;

		while (right >= left) {
			int mid = left + (right - left) / 2;

			if (arr[mid] < target) {
				left = mid + 1;
			} else if (arr[mid] > target) {
				right = mid - 1;
			}
			// Check if the target is present at the middle
			else {
				return mid;
			}

			// If the target is greater, ignore left half

			// If the target is smaller, ignore right half

		}

		// If the target is not present in the array
		return -1;
	}

	public static void selectionSort(int[] arr) {
		int n = arr.length;

		// One by one, move the boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in the unsorted array
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}

			// Swap the found minimum element with the first element
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
	}

}
