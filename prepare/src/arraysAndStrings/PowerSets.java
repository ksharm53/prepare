package arraysAndStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PowerSets {

	static Set<List<Integer>> outputFinal= new HashSet<>();

	public static void main(String[] args) {
		outputFinal= new HashSet<>();
		int[] nums = {4,4,4,1,4};

		List<Integer> input= IntStream.of(nums).boxed().collect(Collectors.toList());

		List<Integer> output= new ArrayList<>();

		solve(input,output);

		List<List<Integer>> aList = new ArrayList<>(outputFinal);

		System.out.println(outputFinal);

		System.out.println(aList);

	}

	private static void solve(List<Integer> input, List<Integer> output) {

		if(input.size() ==0) {			
			Collections.sort(output);
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
