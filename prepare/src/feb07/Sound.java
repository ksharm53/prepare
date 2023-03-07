package feb07;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Sound {

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<>();
		map.put(130, "Threshhold of Pain");
		map.put(120, "Possible hearing damage");
		map.put(100, "Jack hammer at 1 m");
		map.put(90, "Traffic on a busy roadway at 10 m");
		map.put(60, "Normal conversation");
		map.put(30, "Calm library");
		map.put(0, "Light leaf rustling");

		Scanner in = new Scanner(System.in);
		System.out.println("Please input Value");
		int value = in.nextInt();
		System.out.println("Please input unit");
		String unit = in.next();

		if (unit.equals("Pa")) {
			value = (int) (20 * (Math.log10(value / (20 * Math.pow(10, -6)))));
			System.out.println(value);
		}

		if (map.containsKey(value)) {
			System.out.println(map.get(value));
		} else {
			int min = Integer.MAX_VALUE;
			String tempString = "";
			for (Entry<Integer, String> eachVal : map.entrySet()) {
				int temp = Math.abs(value - eachVal.getKey());
				if (temp < min) {
					min = temp;
					tempString = eachVal.getValue();
				}
			}
			System.out.println(tempString);
		}

	}

}
