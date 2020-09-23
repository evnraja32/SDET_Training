package src.work.raja.wk1_assignment;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import src.work.raja.SortingLogics;

// 4) Find the kth largest element in an unsorted array. 
// Note: It is kth largest element in the sorted order, not the kth distinct element.
//
// Input: [3,2,3,1,2,4,5,5,6] and k = 3
// Output: 5

public class Prog4_FindKthLargestNumber {

	@Test
	public void test1() {
		int[] input = { 3, 2, 3, 1, 2, 7, 8, 4, 5, 5, 6, 1 };
		int k = 3;
		int expected = 6;
		int actual = findKthLargestNumber(input, k);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test2() {
		int[] input = { 3, 2, 3, 1 };
		int k = 5;
		int expected = 6;
		int actual = findKthLargestNumber(input, k);
		Assert.assertEquals(expected, actual);
	}

	private int findKthLargestNumber(int[] input, int k) {
		
		if(input.length < k)
			throw new IllegalArgumentException("Input length is not sufficient");
		
		SortingLogics.simpleSorting(input);
		return input[input.length - k];
	}

}
