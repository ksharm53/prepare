package strings;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DaysBetweenDates {
	public static int[] month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		String date1 = "2020-01-15";
		String date2 = "2019-12-31";

		System.out.println(solve(date1, date2));
		System.out.println(solveAPI(date1, date2));

	}

	private static int solveAPI(String date1, String date2) {
		if (date1.equalsIgnoreCase(date2)) {
			return 0;
		}

		return (int) Math.abs(ChronoUnit.DAYS.between(LocalDate.parse(date1), LocalDate.parse(date2)));
	}

	private static int solve(String date1, String date2) {
		if (date1.equalsIgnoreCase(date2)) {
			return 0;
		}

		String[] valueDate1 = date1.split("-");
		String[] valueDate2 = date2.split("-");

		int days1 = findDays(valueDate1[0], valueDate1[2]);

		for (int i = 0; i < Integer.valueOf(valueDate1[1]) - 1; i++) {
			days1 += month[i];
		}

		int leapYearDays = calculateLeapYears(valueDate1[0], valueDate1[1], valueDate1[2]);
		days1 += leapYearDays;

		int days2 = findDays(valueDate2[0], valueDate2[2]);

		for (int i = 0; i < Integer.valueOf(valueDate2[1]) - 1; i++) {
			days2 += month[i];
		}

		int leapYearDays2 = calculateLeapYears(valueDate2[0], valueDate2[1], valueDate2[2]);
		days2 += leapYearDays2;

		return Math.abs(days1 - days2);

	}

	private static int calculateLeapYears(String yearIp, String month, String day) {
		int year = Integer.valueOf(yearIp);
		int counter = 0;
		int monthVal = Integer.valueOf(month);
		int dayVal = Integer.valueOf(day);

		if ((monthVal == 2 && dayVal > 28) || monthVal > 2) {
			for (int i = 1; i <= year; i++) {
				if (i % 4 != 0) {
					continue;
				} else if (i % 400 == 0) {
					counter++;
				} else if (i % 100 == 0) {
					continue;
				} else {
					counter++;
				}
			}
		} else {
			for (int i = 1; i < year; i++) {
				if (i % 4 != 0) {
					continue;
				} else if (i % 400 == 0) {
					counter++;
				} else if (i % 100 == 0) {
					continue;
				} else {
					counter++;
				}
			}
		}

		return counter;

	}

	private static int findDays(String year, String day) {
		int days = Integer.valueOf(year) * 365;
		return days + Integer.valueOf(day);

	}

}
