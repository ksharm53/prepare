package arraysAndStrings;

import java.util.Scanner;

public class Main {

	public static boolean main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int first = scan.nextInt();
		while(scan.hasNext()) {

			String value= scan.next();
			return validate(value);
		}
		
		return false;

	}

	private static boolean validate(String value) {
		if (validateConstraints(value) && validateLength(value) && validateUpperCase(value)) {
			return true;
		}
		return false;

	}

	private static boolean validateUpperCase(String value) {
		char[] charArray= value.toCharArray();
		for(int i=1; i< charArray.length-1; i++) {
			if (Character.isUpperCase(charArray[i])) {
				return true;
			}
		}
		return false;
		
	}

	private static boolean validateLength(String value) {
		return value.length() >= 8 ? true: false;
		
	}

	private static boolean validateConstraints(String value) {
		char[] array= value.toCharArray();

		for(int i=0; i< array.length ; i++) {
			if(array[i] =='#' || array[i] =='%' || array[i] =='&' || array[i] =='?');
			return true;
		}
		return false;

	}


}
