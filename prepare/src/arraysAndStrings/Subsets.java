package arraysAndStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Subsets {
	
	static List<List<Integer>> outputFinal= new ArrayList<>();

	public static void main(String[] args) {
		outputFinal= new ArrayList<>();
		int[] nums = {1,2,3};

		List<Integer> input= IntStream.of(nums).boxed().collect(Collectors.toList());

		List<Integer> output= new ArrayList<>();

		solve(input,output);
		
		System.out.println(outputFinal);

	}

	private static void solve(List<Integer> input, List<Integer> output) {

		if(input.size() ==0) {
			outputFinal.add(output);
			return;
		}
		
		List<Integer> op1=new ArrayList<>(output);
		List<Integer> op2=new ArrayList<>(output);
		
		op2.add(input.get(0));		
		input.remove(0);
		
		solve(new ArrayList<Integer>(input), op1);
		solve(new ArrayList<Integer>(input), op2);

	}

}
