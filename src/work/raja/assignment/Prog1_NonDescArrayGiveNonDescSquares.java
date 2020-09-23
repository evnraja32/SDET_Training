package src.work.raja.assignment;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import src.work.raja.SortingLogics;

// 1) Given an array of integers sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
// Input: [-8,-3,4,3,10]
// Output: [9,9,16,64,100]

public class Prog1_NonDescArrayGiveNonDescSquares {

	@Test
	public void test() {
		int[] input = { -8, -3, 4, 3, 10 };
		int[] expecteds = { 9, 9, 16, 64, 100 };
		int[] actuals = calculateSquares(input);
		Assert.assertArrayEquals(expecteds, actuals);
	}

	private int[] calculateSquares(int[] input) {
		
		if (findInputIsInNonDecreasingOrder(input)) {
			
		} else {
			throw new IllegalArgumentException("");
		}
		
		return null;
	}

	private boolean findInputIsInNonDecreasingOrder(int[] input) {
		int[] temp = SortingLogics.simpleSorting(input);
		return (input == temp);
	}

}
