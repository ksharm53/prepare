package jan2024;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Scription1 {

	public static void main(String[] args) {
		String url = "https://www.google.com";
		try {
			URL urlVal = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) urlVal.openConnection();

			connection.setRequestMethod("GET");
			connection.setRequestProperty("content_type", "application/json");
			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("");
			}

			InputStreamReader ir = new InputStreamReader(connection.getInputStream());
			BufferedReader br = new BufferedReader(ir);
			String line = "";
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

			connection.disconnect();

			// System.out.println(sb.toString());

			JsonObject object = JsonParser.parseString(sb.toString()).getAsJsonObject();
			System.out.println(object.toString());

		} catch (Exception ex) {

		}

	}

}
