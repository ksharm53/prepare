package arraysAndStrings;

public class FirstLastPositionElementSorted {

	public static void main(String[] args) {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 8;

		System.out.println(solveleft(nums, target));
		
		System.out.println(solveRight(nums, target));

	}

	private static int solveRight(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int right=-1;
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(nums[mid] == target) {
				right=mid;
				start= mid + 1;
			}
			
			else if(nums[mid] < target) {
				start= mid +1;
			}
			else if(nums[mid] > target) {
				end = mid -1;
			}
		}
		return right;
	
	}

	private static int solveleft(int[] nums, int target) {

		int start = 0;
		int end = nums.length - 1;
		int left=-1;
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(nums[mid] == target) {
				left=mid;
				end= mid -1;
			}
			
			else if(nums[mid] < target) {
				start= mid +1;
			}
			else if(nums[mid] > target) {
				end = mid -1;
			}
		}
		return left;
	}

}
