package src.work.raja.wk1_assignment;

import static org.junit.Assert.*;

import org.junit.Test;

//8) Find the peak index in a mountain array
//
//Example 1:
//
//Input: arr = [0,1,0]
//Output: 1

//Example 2:
//
//Input: arr = [0,4,2,0]
//Output: 1
//
//Example 3:
//
//Input: arr = [0,10,5,2]
//Output: 10

public class Prog8_FindPeakElement {

	@Test
	public void test1() {
		int[] input = { 0, 1, 0 };
		int expected = 1;
		assertEquals(expected, findPeakElement(input));
	}

	@Test
	public void test2() {
		int[] input = { 0, 4, 2, 0 };
		int expected = 2;
		assertEquals(expected, findPeakElement(input));
	}

	@Test
	public void test3() {
		int[] input = { 0, 10, 11, 5, 2 };
		int expected = 2;
		assertEquals(expected, findPeakElement(input));
	}

	@Test
	public void test4() {
		int[] input = { 0, 1, 2, 3, 4, 5, 6, 10 };
		int expected = 7;
		assertEquals(expected, findPeakElement(input));
	}

	@Test
	public void test5() {
		int[] input = { 11, 11, 0, 1, 2, 3, 4, 5, 6, 20 };
		int expected = 1;
		assertEquals(expected, findPeakElement(input));
	}

	@Test
	public void test6() {
		int[] input = { 1, 11, 11, 11, 11};
		int expected = 4;
		assertEquals(expected, findPeakElement(input));
	}

	private Object findPeakElement(int[] input) {

		// 0, 10, 5, 2
		for (int i = 1; i < input.length; i++) {
			if (input[i - 1] > input[i]) // 0 > 1 - false | 1 > 2 - true |
//				return input[i - 1];
			return (i - 1);
		}

		return (input.length - 1);
	}

}
