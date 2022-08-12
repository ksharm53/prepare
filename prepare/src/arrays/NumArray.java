package arrays;

public class NumArray {

	static int[] nums;

	public static void main(String[] args) {
		NumArray numArray = new NumArray(new int[] { 1, 3, 5 });
		numArray.sumRange(0, 2);
		numArray.update(1, 2);
		numArray.sumRange(0, 2);
	}

	public NumArray(int[] nums) {
		this.nums = nums;
	}

	public void update(int index, int val) {
		nums[index] = val;
	}

	public int sumRange(int left, int right) {
		int sum = 0;
		for (int i = left; i <= right; i++) {
			sum = sum + nums[i];
		}
		System.out.println(sum);
		return sum;
	}

}
