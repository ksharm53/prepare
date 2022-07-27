package arraysAndStrings;

public class ContainerWithWaterRecursion {

	public static void main(String[] args) {
		int[] height= {1, 1};

		System.out.println(solve(height,height.length));
	}

	private static int solve(int[] height, int length) {
		int max= Integer.MIN_VALUE;

		if(length <=1) {
			return 0;
		}

		else if(length==2) {
			return Math.min(height[length-1], height[length-2]) * 1;
		}

		int i=0;
		int j=length-1;
		while(i<j) {
			max=Math.max(max, Math.min(height[i], height[j]) * (j-i));
			if(height[i] <= height[j]) {
				i++;
			}
			else {
				j--;
			}
		}

		return max;
	}

}
