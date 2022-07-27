package arraysAndStrings;

public class RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,1,2,3,3};

		System.out.println(solve(nums));

	}

	private static int solve(int[] nums) {
		int counter = 0;
		for (int i = 0; i < nums.length; i++) {
			if(i+2 >= nums.length || nums[i] != nums[i+2]) {
				counter ++;
			}			
		}
		return counter;
	}
}
