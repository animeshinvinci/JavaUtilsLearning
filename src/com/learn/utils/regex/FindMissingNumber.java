package com.learn.utils.regex;

public class FindMissingNumber {

	
		int[] originalArray;
		int [] changedArray;
	
	public FindMissingNumber(int[] originalArray, int[] changedArray) {
			super();
			this.originalArray = originalArray;
			this.changedArray = changedArray;
		}

	public  int getMissingNumber(int[] originalArray, int[] changedArray) {
		// TODO Auto-generated method stub
		if (originalArray.length==0){
			System.out.println("Array Size is Zero");
			return 0;
		}
		else if (originalArray.length == 1){
			return originalArray[0];
		}
		return getSum(originalArray) - getSum(changedArray);
	}
	
	public int getSum(int[] arr){
		int sum = 0;
		for(int i=0;i<=arr.length-1;i++){
			sum = sum + arr[i];
		}
		return sum;
	}
	
	
}
