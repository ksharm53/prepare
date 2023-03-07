package feb07;

public class MinMaxDifference {

	public static void main(String[] args) {
		int num = 90;
		System.out.println(minMaxDifference(num));

	}

	public static int minMaxDifference(int num) {

		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			sb.append(num % 10);
			num = num / 10;
		}
		sb.reverse();
		System.out.println(sb.toString());

		int i = 0;
		while (sb.charAt(i) == '9') {
			i++;
		}
		char max = sb.charAt(i);
		StringBuilder sb1 = new StringBuilder(sb);
		while (sb1.indexOf(String.valueOf(max)) != -1) {
			int idx = sb1.indexOf(String.valueOf(max));
			sb1.replace(idx, idx + 1, "9");
		}

		i = 0;
		while (sb.charAt(i) == '0') {
			i++;
		}
		char min = sb.charAt(i);
		while (sb.indexOf(String.valueOf(min)) != -1) {
			int idx = sb.indexOf(String.valueOf(min));
			sb.replace(idx, idx + 1, "0");
		}

		long maxFirst = Long.valueOf(sb1.toString());
		long minSecond = Long.valueOf(sb.toString());

		return (int) (maxFirst - minSecond);
	}

}
