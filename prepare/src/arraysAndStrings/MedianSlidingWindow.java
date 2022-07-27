package arraysAndStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianSlidingWindow {

	public static void main(String[] args) {

		int[] nums = {5,2,2,7,3,7,9,0,2,3};
		int k = 9;

		System.out.println(solve(nums,k));
		
		//calculateMedian(nums, k, k, k);

	}


	private static double[] solve(int[] nums, int k) {

		List<Double> list= new ArrayList<>();
		int i=0;
		int j=0;
		int size= nums.length;
		double [] ansArray= new double[size-k +1];

		while(j<size) {
			list.add((double) nums[j]);
			if(j-i+1 < k) {
				j++;
			}
			
			else if(j-i+1 == k) {
				//List<Double> tempList=new ArrayList<>(list);
				Collections.sort(list);			
				
				if(k % 2 !=0) {
					int sizeTemp=list.size();
					int position=sizeTemp/2;
					if(sizeTemp==1) {
						position=0;
					}					
					double data=list.get(position);
					ansArray[i]=data;
				}
				else {					
					int second=list.size()/2;
					int first=second-1;
					double median= (list.get(second) + list.get(first))/2;
					ansArray[i]=median;
				}
				
				for(int t=0;t<list.size();t++){
	                if(list.get(t)== nums[i]){
	                    list.remove(t);
	                    break;
	                }
	            }
				j++;
				i++;
			}
			
		}
		return ansArray;
	}

}
