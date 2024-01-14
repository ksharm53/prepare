package jan2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Scripting {

	public static void main(String[] args) {
		String file = "C:\\Users\\ksharm53\\Downloads\\sample_data.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String temp = br.readLine();
			String[] tempArr = temp.split(",");
			String line = "";
			double[] maxArr = new double[tempArr.length];
			Arrays.fill(maxArr, Double.MIN_VALUE);
			double[] minArr = new double[tempArr.length];
			Arrays.fill(minArr, Double.MAX_VALUE);
			double[] sumArr = new double[tempArr.length];

			int count = 0;
			while ((line = br.readLine()) != null) {
				String[] arr = line.split(",");
				for (int i = 0; i < arr.length; i++) {
					double val = Double.valueOf(arr[i]);
					maxArr[i] = Math.max(maxArr[i], val);
					minArr[i] = Math.min(minArr[i], val);
					sumArr[i] += val;
				}
				count++;
			}

			for (int i = 0; i < tempArr.length; i++) {
				System.out.println("Row: " + (i + 1));
				System.out.println(maxArr[i]);
				System.out.println(minArr[i]);
				System.out.println(sumArr[i] / count);
				System.out.println("===================================================");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
