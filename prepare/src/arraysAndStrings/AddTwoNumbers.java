package arraysAndStrings;

import java.math.BigInteger;

public class AddTwoNumbers {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public static void main(String[] args) {

		System.out.println(addTwoNumbers(99));
	}

	public static ListNode addTwoNumbers(int num) {

		ListNode l1= new ListNode(1);
		
		ListNode temp= new ListNode();
		for(int i=0; i< num-1; i++) {
			temp= new ListNode(9, temp);
		}
		
		ListNode l2=new ListNode(9, temp);
		
		/*
		 * ListNode l2= new ListNode(1,new ListNode(9, new ListNode(9, new ListNode(9,
		 * new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new
		 * ListNode(9, new ListNode(9))))))))));
		 */

		StringBuilder sbFirst= new StringBuilder();
		StringBuilder sbSecond= new StringBuilder();
		ListNode head= l1;
		ListNode head2= l2;
		while(head !=null){
			sbFirst.append(head.val);
			head= head.next;
		}

		while(head2 !=null){
			sbSecond.append(head2.val);
			head2= head2.next;
		}

		sbFirst.reverse();
		sbSecond.reverse();

		BigInteger first = new BigInteger(sbFirst.toString());
		BigInteger second = new BigInteger(sbSecond.toString());
		BigInteger result= first.add(second);

		//long first=Long.parseLong(sbFirst.toString());
		//long second=Long.parseLong(sbSecond.toString());
		//long result= first + second;

		System.out.println(first);
		System.out.println(second);

		System.out.println(result);

		ListNode resultant=null;
		ListNode headre=null;
		ListNode lFirst=null;


		while(result.compareTo(BigInteger.ZERO) >= 1){

			BigInteger digit= result.mod(BigInteger.valueOf(10));
			lFirst= new ListNode(digit.intValue());
			if(resultant ==null){
				resultant=lFirst;
				headre=resultant;
			}
			else{
				resultant.next=lFirst;   
				resultant= resultant.next;
			}

			result= result.divide(BigInteger.valueOf(10));    
		}
		return headre!=null? headre:new ListNode(0);
	}

}
