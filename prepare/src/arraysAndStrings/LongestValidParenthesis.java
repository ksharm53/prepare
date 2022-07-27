package arraysAndStrings;

public class LongestValidParenthesis {

	static int matrix[];

	public static void main(String[] args) {
		String s = ")()())";
		matrix=new int[s.length()+1];
		System.out.println(solve(s,s.length()));

	}

	private static int solve(String s, int length) {
		int max= 0;
		int accumulate=0;

		if(s.charAt(0) =='(') {
			matrix[0]=1;
			accumulate++;
			max=Math.max(max, matrix[0]);
		}
		else {
			matrix[0]=0;
		}

		for(int i=1; i<length;i++) {
			if(s.charAt(i) == ')' && max==0 && accumulate ==0) {
				continue;
			}
			else if(s.charAt(i)==')' && accumulate > 0) {
				matrix[i]=1+matrix[i-1];
				accumulate--;
				max=Math.max(max, matrix[i]);
			}
			else if(s.charAt(i)=='(' && s.charAt(i-1) !=')') {
				matrix[i]= 1+matrix[i-1];
				accumulate++;
			}
		}

		return max;
	}

}
