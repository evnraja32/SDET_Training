package src.work.raja.wk1_assignment;

import static org.junit.Assert.*;

import org.junit.Test;

//6) Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of 
//all the elements of nums except nums[i].
//
//Input:  [1,2,3,4]
//Output: [24,12,8,6]
//
//Interview Question from Amazon

public class Prog6_ArrayProduct {

	@Test
	public void test1() {
		int[] input = { 1, 2, 3, 4 };
		int[] actuals = { 24, 12, 8, 6 };
		int[] expecteds = calculateArrayProducts_bruteForce(input);
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(expecteds, calculateArrayProducts_recursive(input));
	}

	@Test
	public void test2() {
		int[] input = { 2, 1, 4, 3 };
		int[] actuals = { 12, 24, 6, 8 };
		int[] expecteds = calculateArrayProducts_bruteForce(input);
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(expecteds, calculateArrayProducts_recursive(input));
	}

	@Test
	public void test3() {
		int[] input = { 2, 1, -4, 3 };
		int[] actuals = { 12, 24, 6, 8 };
		int[] expecteds = calculateArrayProducts_bruteForce(input);
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(expecteds, calculateArrayProducts_recursive(input));
	}

	/**
	 * Complexity: O[N^2]
	 * 
	 * @param input
	 * @return
	 */
	private int[] calculateArrayProducts_bruteForce(int[] input) {
		int[] result = new int[input.length];

		for (int i = 0; i < input.length; i++) {
			if (input[i] <= 0)
				throw new IllegalArgumentException("Invalid input, array must contain integers n > 1");
			result[i] = 1;
			for (int j = 0; j < input.length; j++) {
				result[i] *= (i != j) ? input[j] : 1;
			}
		}
		return result;
	}

	/**
	 * Complexity: O[N]
	 * 
	 * @param input
	 * @return
	 */
	private int[] calculateArrayProducts_recursive(int[] input) {
		int[] result = new int[input.length];

		result = _calculateArrayProducts_recursive(input, result, input.length - 1); //O[N]
		return result;
	}

	private int[] _calculateArrayProducts_recursive(int[] input, int[] result, int index) {

		if (index < 0)
			return result;
		
		if (input[index] <= 0)
			throw new IllegalArgumentException("Invalid input, array must contain integers n > 1");
		
		result[index] = 1;
		for (int j = 0; j < input.length; j++) 
			result[index] *= (index != j) ? input[j] : 1;
		
		return _calculateArrayProducts_recursive(input, result, --index);
	}
}
