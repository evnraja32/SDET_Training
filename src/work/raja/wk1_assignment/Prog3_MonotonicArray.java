package src.work.raja.wk1_assignment;

import org.junit.Assert;
import org.junit.Test;

// 3) Given an array, return true if and only if the given array A is monotonic.

// An array is monotonic if it is either monotone increasing or monotone decreasing.

// Input: [1,2,3,3,4,4,4,4,5]
// Output: true

// Input: [1,2,5,3,4,4,4,4,5]
// Output: false

// Input: [5,4,4,2,1]
// Output: true

public class Prog3_MonotonicArray {

	/**
	 * Sliding window approach. Each iteration takes 2 elements at a time and
	 * compare its differences and then proceeds for next set of 2 elements
	 * 
	 * @param input
	 * @return
	 */
	private boolean findMonotonicArray_SlidingWindow(int[] input) {
		boolean result = false;
		int flag = 0; // decision variable
		for (int i = 1; i < input.length; i++) {

			// if same number encounter back to back no need for additional checks
			if (input[i - 1] == input[i])
				continue;

			// one-time alteration for decision making on array sequence order is increasing
			// or decreasing
			if (flag == 0)
				flag = (input[i - 1] - input[i]);

			// flag < 0 represents - to check for increasing sequence other wise
			// decreasing sequence
			result = ((flag < 0) ? (input[i - 1] < input[i]) : (input[i - 1] > input[i]));
			if (result == false)
				return false;
		}
		return result;
	}

	@Test
	public void test1() {
		int[] input = { 5, 5, 6, 7, 7, 8 };
		boolean expected = true;
		boolean actual = findMonotonicArray_SlidingWindow(input);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test2() {
		int[] input = { 5, 5, 4, 3, 2, 1 };
		boolean expected = true;
		boolean actual = findMonotonicArray_SlidingWindow(input);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test6() {
		int[] input = { 1, 1, 1, 1, 1, 1, 2 };
		boolean expected = true;
		boolean actual = findMonotonicArray_SlidingWindow(input);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test3() {
		int[] input = { 1, 1, 1, 1, 1, 1 };
		boolean expected = false;
		boolean actual = findMonotonicArray_SlidingWindow(input);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test4() {
		int[] input = { 1, 1, 2, 3, 2, 1 };
		boolean expected = false;
		boolean actual = findMonotonicArray_SlidingWindow(input);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test5() {
		int[] input = { 7, 8, 9, 10, 11, 1 };
		boolean expected = false;
		boolean actual = findMonotonicArray_SlidingWindow(input);
		Assert.assertEquals(expected, actual);
	}

}
