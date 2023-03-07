package feb07;

public class Reverse {

	public static void main(String[] args) {
		String s = "World   Hello";
		System.out.println(reverseWords(s));

	}

	public static String reverseWords(String sentence) {
		String[] arr = sentence.split(" ");
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			String tempI = arr[i].trim();
			if (tempI.isBlank()) {
				i++;
				continue;
			}
			String tempJ = arr[j].trim();
			if (tempJ.isBlank()) {
				j--;
				continue;
			}

			String temp = arr[j].trim();
			arr[j] = arr[i].trim();
			arr[i] = temp;
			i++;
			j--;

		}
		StringBuilder sb = new StringBuilder();
		for (int idx = 0; idx < arr.length; idx++) {
			if (!arr[idx].isBlank()) {
				sb.append(arr[idx]);
				if (idx != arr.length - 1) {
					sb.append(" ");
				}
			}
		}

		return sb.toString();
	}

}
