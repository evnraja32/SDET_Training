package work.raja.week1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseArray {

	@Test
	public void test1() {
		int[] input = { 1, 2, 4, 5, 9 };
		int[] expected = { 9, 5, 4, 2, 1 };
		int[] actual = reverseArray(input);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void test2() {
		int[] input = { 1, 2, 4, 2, 1 };
		int[] expected = { 1, 2, 4, 2, 1 };
		int[] actual = reverseArray(input);
		assertArrayEquals(expected, actual);
	}

	public int[] reverseArray(int[] input) {
		int temp = 0;
		for (int i = 0; i < (input.length / 2); i++) {
			temp = input[i];
			input[i] = input[(input.length - 1) - i];
			input[(input.length - 1) - i] = temp;
		}
		return input;
	}

}