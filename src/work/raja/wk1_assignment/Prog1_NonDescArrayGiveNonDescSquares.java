package src.work.raja.wk1_assignment;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import src.work.raja.SortingLogics;

// 1) Given an array of integers sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
// Input: [-8,-3,4,3,10]
// Output: [9,9,16,64,100]

public class Prog1_NonDescArrayGiveNonDescSquares {

	@Test
	public void test1() {
		int[] input = { -8, -3, 4, 3, 10 };
		int[] expecteds = { 9, 9, 16, 64, 100 };
		int[] actuals = calculateSquares(input);
		Assert.assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test2() {
		int[] input = { -8, -3, 3, 4, 10 };
		int[] expecteds = { 9, 9, 16, 64, 100 };
		int[] actuals = calculateSquares(input);
		Assert.assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test3() {
		int[] input = { -8, -3, -3, 4, 10 };
		int[] expecteds = { 9, 9, 16, 64, 100 };
		int[] actuals = calculateSquares(input);
		Assert.assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test4() {
		int[] input = { -8, -3, -3, 0, 4, 10 };
		int[] expecteds = { 0, 9, 9, 16, 64, 100 };
		int[] actuals = calculateSquares(input);
		Assert.assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test5() {
		int[] input = { 1, -8, -3, -3, 0, 4, 10 };
		int[] expecteds = { 0, 1, 9, 9, 16, 64, 100 };
		int[] actuals = calculateSquares(input);
		Assert.assertArrayEquals(expecteds, actuals);
	}

	/**
	 * Complexity : O[N^2]
	 * 
	 * @param input
	 * @return
	 */
	private int[] calculateSquares(int[] input) {
		int[] result = new int[input.length];

//		if (!findInputIsInNonDecreasingOrder1(input)) // O[N^2]
		if (!findInputIsInNonDecreasingOrder2(input)) // O[N^2]
			throw new IllegalArgumentException("Given input is not in Non-Decreasing Order");

		for (int i = 0; i < input.length; i++) // O[N]
			result[i] = (input[i] * input[i]); // O[1]

		result = SortingLogics.simpleSorting(result); // O[n^2]

		return result;
	}

	/**
	 * Complexity: O[N]
	 * 
	 * @param input
	 * @return
	 */
	private boolean findInputIsInNonDecreasingOrder2(int[] input) {
		for (int i = 1; i < input.length; i++)
			if (!(input[i - 1] <= input[i]))
				return false;
		return true;
	}

	/**
	 * Complexity : O[N^2]
	 * 
	 * @param input
	 * @return
	 */
	private boolean findInputIsInNonDecreasingOrder1(int[] input) {

		int[] temp = Arrays.copyOfRange(input, 0, input.length - 1);
		SortingLogics.simpleSorting(temp); // O[N^2]

		for (int i = 0; i < temp.length; i++)
			if (input[i] != temp[i])
				return false;

		return true;
	}

}
