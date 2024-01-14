package oct2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class OAIBM {
	static int maxRating;
	static int maxVotes;

	public static void main(String[] args) {
		maxRating = Integer.MIN_VALUE;
		maxVotes = Integer.MIN_VALUE;
		System.out.println(finestFoodOutlet("Seattle", 500));

	}

	private static final String RESTURL = "https://jsonmock.hackerrank.com/api/food_outlets";

	public static String finestFoodOutlet(String city, int votes) {
		int page = 1;
		String outlet = "";
		try {
			outlet = getOutlet(city, page, votes);
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
		return outlet;
	}

	public static String getOutlet(String city, int page, int votes) throws Exception {

		String cityName = null;
		String response = getResponsePerPage(RESTURL, city, page);

		JsonObject jsonResponse = new Gson().fromJson(response, JsonObject.class);
		int totalPages = jsonResponse.get("total_pages").getAsInt();
		JsonArray data = jsonResponse.getAsJsonArray("data");

		for (JsonElement e : data) {
			JsonObject outlet = e.getAsJsonObject();
			int tempVotes = outlet.getAsJsonObject("user_rating").get("votes").getAsInt();
			int tempAverageRating = outlet.getAsJsonObject("user_rating").get("average_rating").getAsInt();
			if (tempVotes >= votes) {
				if (tempAverageRating > maxRating || (tempAverageRating == maxRating && tempVotes > maxVotes)) {
					maxRating = tempAverageRating;
					maxVotes = tempVotes;
					cityName = outlet.get("name").getAsString();
				}
			}

		}
		return totalPages == page ? cityName : getOutlet(city, page + 1, votes);
	}

	public static String getResponsePerPage(String endpoint, String city, int page)
			throws MalformedURLException, IOException, ProtocolException {

		String newurl = endpoint + "?city=" + city + "&page=" + page;
		URL url = new URL(newurl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.addRequestProperty("Content-Type", "application/json");

		int status = con.getResponseCode();
		if (status < 200 || status >= 300) {
			throw new IOException("Error in reading data with status:" + status);
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String response;
		StringBuilder sb = new StringBuilder();
		while ((response = br.readLine()) != null) {
			sb.append(response);
		}

		br.close();
		con.disconnect();

		return sb.toString();
	}

}
