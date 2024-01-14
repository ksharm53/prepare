package july;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test {
	private static final String BASE_URL = "https://jsonmock.hackerrank.com/api/universities";

	public static void main(String[] args) throws Exception {
		String country = "United Kingdom";
		String bestUniversity = bestUniversityByCountry(country);
		if (!bestUniversity.isEmpty()) {
			System.out.println("Best university in " + country + ": " + bestUniversity);
		} else {
			System.out.println("No university found in " + country);
		}
	}

	public static String bestUniversityByCountry(String country) throws Exception {
		String url = BASE_URL;
		int page = 1;
		String bestUniversity = "";
		int totalPages = Integer.MAX_VALUE; // Initialize with a large value
		int minRank = Integer.MAX_VALUE;

		while (page <= totalPages) {

			String fullUrl = url + "?page=" + page;
			HttpURLConnection con = (HttpURLConnection) new URL(fullUrl).openConnection();
			con.setRequestMethod("GET");

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String line;

				while ((line = in.readLine()) != null) {
					if (line.contains("\"university\":\"")) {
						String university = extractValue(line, "\"university\":\"", "\"");
						String rankStr = extractValue(line, "\"rank_display\":\"", "\"");
						String lineCountry = extractValue(line, "\"country\":\"", "\"");
						try {
							int rank = Integer.parseInt(rankStr);

							if ((lineCountry != null && lineCountry.equalsIgnoreCase(country))
									&& (bestUniversity.isEmpty() || rank < minRank)) {
								System.out.println(rank);
								minRank = rank;
								bestUniversity = university;
							}
						} catch (NumberFormatException e) {
							// Handle invalid rank as needed
						}

					}
					totalPages = extractIntValue(line, "\"total_pages\":");
					if (page >= totalPages) {
						break;
					}
				}

				page++;
			} else {
				System.out.println("GET request failed with response code: " + responseCode);
				break;
			}
		}

		return bestUniversity;
	}

	private static String extractValue(String input, String startPattern, String endPattern) {
		int startIndex = input.indexOf(startPattern);
		if (startIndex != -1) {
			int endIndex = input.indexOf(endPattern, startIndex + startPattern.length());
			if (endIndex != -1) {
				return input.substring(startIndex + startPattern.length(), endIndex);
			}
		}
		return null;
	}

	private static int extractIntValue(String input, String pattern) {
		int startIndex = input.indexOf(pattern);
		if (startIndex != -1) {
			int endIndex = input.indexOf(",", startIndex);
			if (endIndex != -1) {
				try {
					return Integer.parseInt(input.substring(startIndex + pattern.length(), endIndex));
				} catch (NumberFormatException e) {

				}
			}
		}
		return -1;
	}

}
