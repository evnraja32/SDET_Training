package src.work.raja.week1;

import org.junit.Test;
import org.junit.Assert;

public class HighestSumOfK {

	@Test
	public void test1() {
		int[] input = { 2, 4, 1, 3, 5, 6, 0, 1, 3, 1 };
		int expected = 14;
		int k = 3;
		int actual = calculateMaxSum(k, input);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test2() {
		int[] input = { 2, 4, 1, 3, 5, 6, 0, 1, 3, 1 };
		int expected = 19;
		int k = 5;
		int actual = calculateMaxSum(k, input);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test3() {
		int[] input = { -2, -4, -1, -3, -5, -6, 0, -1, -3, -1 };
		int expected = 0;
		int k = 5;
		int actual = calculateMaxSum(k, input);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test4() {
		int[] input = { -2, -4, -1, -3, -5, -6, 0, -1, -3, -1 };
		int expected = 0;
		int k = input.length + 1;
		int actual = calculateMaxSum(k, input);
//		Assert.assertThrows(message, expectedThrowable, runnable)
	}

	private int calculateMaxSum1(int k, int[] input) {

		int index = 0;
		int sum = 0;
		for (int i = 0 + k; i < input.length; i++) {
			int temp = 0;
			for (int j = index; j < i; j++) {
				temp += input[j];
			}
			if (temp > sum)
				sum = temp;
			++index;
		}
		return sum;
	}

	private int calculateMaxSum(int k, int[] input) {

		if (k > input.length)
			throw new IllegalArgumentException("K value is not feasible...");

		int maxNumber = 0;
		int sum = 0;
		for (int i = 0; i < k; i++)
			sum += input[i];

		for (int i = k; i < input.length; i++) {
			sum += (input[i] - input[i - k]);
//			if (sum > maxNumber)
//				maxNumber = sum;
			maxNumber = Math.max(sum, maxNumber);
		}

		return maxNumber;
	}

}
