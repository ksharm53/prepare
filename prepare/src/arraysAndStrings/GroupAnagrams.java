package arraysAndStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {

	public static void main(String[] args) {
		String [] strs = {"eat","tea","tan","ate","nat","bat"};

		System.out.println(sample(strs));
	}

	private static List<List<String>> sample(String[] strs) {

		List<List<String>> result= new ArrayList<>();
		List<Integer> blackListedList= new ArrayList<>();
		List<String> tempList;

		if(strs.length ==0) {
			return result;
		}

		if (strs.length ==1) {
			result.add(Arrays.asList(strs[0]));	
			return result;
		}
		else {
			for(int i=0; i<strs.length; i++) {

				if(blackListedList.contains(i)) {
					continue;
				}
				tempList= new ArrayList<>();
				
				/*
				 * char[] charArray=strs[i].toCharArray(); Arrays.sort(charArray); String
				 * tempString= new String(charArray);
				 */
				
				String tempString=sortString(strs[i]);
				tempList.add(tempString);
				int pointer=tempList.indexOf(tempString);

				for(int j=i+1; j<strs.length; j++) {
					
					if(blackListedList.contains(j)) {
						continue;
					}
					
					/*
					 * char[] charArrayJ=strs[j].toCharArray(); Arrays.sort(charArrayJ); String
					 * tempStringJ= new String(charArrayJ);
					 * 
					 * if(tempList.contains(tempStringJ)) {
					 */
					if(tempList.contains(sortString(strs[j]))) {
						tempList.add(strs[j]);
						blackListedList.add(j);
					}
				}
				tempList.remove(pointer);
				tempList.add(strs[i]);
				result.add(tempList);
			}

		}
		return result;

	}

	private static String sortString(String string) {

		char[] charArray=string.toCharArray();
		Arrays.sort(charArray);
		return String.valueOf(charArray);

	}

}
