package sevenJuly;

import java.util.HashSet;
import java.util.Set;

public class Pangram {

	public static void main(String[] args) {
		String s = "YaCoVaGAaXxrzUvZ ZaHyacbUZCZUbZxzAYb YefxAwV yyABAdVatYazC TuyYYedxSf aA XBvSg EvYcl badDxvaZXWCyCUAaZvJcyc YdVbDYAdObgc FeCyxpdXxffubDbGAbFBxnzzT WzZ WcBZAaYCgYzseZb PYXbswxchtYIedhyaXtvzVxZSwWBLxxEaAaYAfGzybZzQo AH tCBcszyXZaAgwzYB QdVZBvwzAYbwwAVysxCRdTTT bXzxtWwyXZebEBYNBaDCLbZbwsEAB YTFBAcD bybU axAZAhhay ZkWydfxyGAeAYaZlabazUZssGTBcCXBr dWs XzyZAEzAAZyclC bCGzPfXcCccAFyvazX ZzYAB zAbsuCZADkeWwUuAbaZ zWCtYzgZZBzXXD c VsrbEaG aYYFZJBUlW iXqZxxswaWTJvb Y xuwebj CF zyZYZVdYYdaRyZ bTatyzYZw wVfaZEZauyZ A yo afJeCBAyVDXWBbAxYBzYyiNuWxBbexEcbeVaAqYz XAjawBzEqDzaafz bTaUaAzWYBxXWZzbazbUwYhqCdV DdzyWafztJajczbt CtYVVfzBgdtvXEGyBxy bdZz C xtczZ SZVfW ZCAx aZYDaa cCyZuVUEBGZ ACbawWXdxxLXa EawAgzOABYFbzTf TszVYaDc fACydzZYdAazSaaygBAYbGzdz yyYBYa Vasay xAz A AVWeYXY aTdYCcZIVxxHcWazZyaWaeYZybYUVZ Bu zXwgACWwzXzBaCwAVddb YB aYBBoGXUAcBZPbzVUGtX DeVduXZGXXtOBwagbXZAcDZIDZvTzA yyuUb AZ";

		System.out.println(solve(s));

	}

	private static String solve(String s) {
		if (s.length() == 0) {
			return "not pangram";
		}

		char[] arr = s.toCharArray();
		Set<Character> set = new HashSet<>();

		for (Character each : arr) {
			if (each != ' ')
				set.add(Character.toLowerCase(each));
		}
		if (set.size() < 26) {
			return "not pangram";
		} else {
			return "pangram";
		}
	}

}
