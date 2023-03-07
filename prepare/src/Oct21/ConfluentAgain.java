package Oct21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConfluentAgain {
	private static HttpURLConnection con;

	public static void main(String[] args) throws IOException {
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;

		
		for (int i = 1; i <= 10; i++) {
			try {
				String url = "https://jsonmock.hackerrank.com/api/medical_records?page=" + i;
				var myurl = new URL(url);
				con = (HttpURLConnection) myurl.openConnection();

				con.setRequestMethod("GET");
				try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {

					String line;
					String name = "Dr Allysa Ellis";
					int disgId = 2;

					while ((line = in.readLine()) != null) {

						int idx = line.indexOf("diagnosis");
						while (idx != -1) {
							String val = line.substring(idx + 17, line.indexOf(",", idx));
							int intVal = Integer.valueOf(val);

							int tempratureIdx = line.indexOf("bodyTemperature", idx);
							String temprature = line.substring(tempratureIdx + 17, line.indexOf("}", tempratureIdx));
							double intTemp = Double.valueOf(temprature);

							int doctorIdx = line.indexOf("doctor", idx);
							String doctor = line.substring(doctorIdx + 24, line.indexOf("}", doctorIdx) - 1);
							if (intVal == disgId && doctor.equals(name)) {
								min = Math.min(min, intTemp);
								max = Math.max(max, intTemp);
							}
							idx = line.indexOf("diagnosis", idx + 9);
						}
					}
				}

			} finally {

				con.disconnect();
			}
		}
		System.out.println("min: " + (int) min);
		System.out.println("max: " + (int) max);
	}

}
