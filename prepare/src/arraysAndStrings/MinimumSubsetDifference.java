package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSubsetDifference {

	public static void main(String[] args) {

		List<Integer> list= Arrays.asList(68, 35, 1, 70, 25, 79, 59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83, 22, 17, 19, 96, 48, 27, 72, 39, 70, 13, 68, 100, 36, 95, 4, 12, 23, 34, 74, 65, 42, 12, 54, 69, 48, 45);
		System.out.println(solution(list));
	}

	private static int solution(List<Integer> list) {
		int vertical= list.size();
		int horizontal=0; 

		for (Integer integer : list) {
			horizontal= horizontal+integer;
		}	

		int matrix [][]= new int [vertical+1][horizontal+1];	


		for(int i=0; i<vertical+1; i++) {
			matrix[i][0]=1;
		}

		for(int i=0; i<horizontal+1; i++) {
			matrix[0][i]=0;
		}

		for(int i=1; i<vertical+1; i++) {
			for(int j=1; j < horizontal+1; j++) {

				if(list.get(i-1)<=j) {
					matrix[i][j]= matrix[i-1][j-list.get(i-1)] + matrix[i-1][j];
				}
				else {
					matrix[i][j]= matrix[i-1][j];
				}
			}
		}


		List<Integer> listLastRow= new ArrayList<>();

		for(int i=0; i<horizontal+1; i++) {
			listLastRow.add(matrix[vertical][i]);
		}
		
		int min= Integer.MAX_VALUE;
		
		for (int i=0; i<(horizontal/2)+1; i++) {
			if(listLastRow.get(i) !=0) {
				min=Math.min(horizontal-(2*i),min);	
			}
		}

		System.out.println(listLastRow);

		return min;
	}
}
