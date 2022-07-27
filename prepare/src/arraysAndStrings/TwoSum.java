package arraysAndStrings;

public class TwoSum {

	public static void main(String[] args) {
		int [] numbers = {-1,0};
		int target = -1;

		System.out.println(solve(numbers,target));

		System.out.println("test Values");

	}

	private static int[] solve(int[] numbers, int target) {
		int i=0;
		int j=numbers.length-1;
		
		while(i<j) {
			if(numbers[i] + numbers[j] > target) {
				j--;
			}
			else if(numbers[i] + numbers[j] < target) {
				i++;
			}
			else{
				int [] returnValue= {i+1,j+1};
				return returnValue;
						
			}
		}
		return numbers;
	}

}
