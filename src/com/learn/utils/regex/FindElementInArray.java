package com.learn.utils.regex;

import java.util.Random;

public class FindElementInArray {
	int[] originalArray;
	int[] changedArray;
	
	
	public FindElementInArray(int[] originalArray) {
		super();
		this.originalArray = originalArray;
	}
	
	public int[] getChangedArray() {
		return changedArray;
	}
	
	
	
	public int[] changeOriginalArray(int[]originalArray){
		Random random = new Random();
		int firstPos = random.nextInt(originalArray.length);
		int secPos = random.nextInt(originalArray.length);
		int[] shuffledArr = swapArrayData(originalArray,firstPos,secPos);
		setchangedArray(shuffledArr);
		return this.changedArray;
	}

	private void setchangedArray(int[] shuffledArr) {
		// TODO Auto-generated method stub
		
		this.changedArray = new int[shuffledArr.length -1];
		
	}

	private int[] swapArrayData(int[] arr, int firstPos, int secPos) {
		// TODO Auto-generated method stub
		
		
		return null;
	}
	
	
}
