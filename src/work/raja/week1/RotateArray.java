package src.work.raja.week1;

import org.junit.Assert;
import org.junit.Test;

public class RotateArray {

	@Test
	public void testMethod1() {
		int[] input = { 1, 2, 3, 4, 5, 6 };
		int counter = 3;
		int[] expected = { 4, 5, 6, 1, 2, 3 };
		int[] actual = rotateAnArray(input, counter);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testMethod2() {
		int[] input = { 1, 2, 3, 4, 5, 6 };
		int counter = 1;
		int[] expected = { 2, 3, 4, 5, 6, 1 };
		int[] actual = rotateAnArray(input, counter);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testMethod3() {
		int[] input = { 1, 2, 3, 4, 5, 6 };
		int counter = 5;
		int[] expected = { 6, 1, 2, 3, 4, 5 };
		int[] actual = rotateAnArray(input, counter);
		Assert.assertArrayEquals(expected, actual);
	}

	private int[] rotateAnArray(int[] input, int counter) {

		if (counter == 0)
			return input;

		int temp = input[0];
		for (int i = 1; i < input.length; i++) {
			input[i - 1] = input[i];
		}
		input[input.length - 1] = temp;

		return rotateAnArray(input, --counter);
	}
}
