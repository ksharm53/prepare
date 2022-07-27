package arraysAndStrings;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortRecursion {

	public static void main(String[] args) {

		int [] array= {10, 2, 5, 2, 1, 79, 29, 18, 9};		

		List<Integer> list= IntStream.of(array)
				.boxed()
				.collect(Collectors.toList());

		solve(list);

		System.out.println(list);
	}

	private static void solve(List<Integer> list) {

		int length=list.size()-1;

		if(list.size() <=1) {
			return;
		}

		int temp= list.get(length);
		list.remove(length);
		solve(list);
		insert(list,temp);		

	}

	private static void insert(List<Integer> list, int temp) {

		int length=list.size()-1;
		if(list.size() ==0 || list.get(length) <= temp) {
			list.add(temp);
			return;
		}
		
		else {
			int insertTemp=list.remove(length);			
			insert(list, temp);
			list.add(insertTemp);
			return;
		}

	}

}
