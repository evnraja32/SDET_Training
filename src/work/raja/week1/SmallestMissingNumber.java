package src.work.raja.week1;

import org.junit.Assert;
import org.junit.Test;

public class SmallestMissingNumber {

	@Test
	public void test1() {
		int[] input = { 5, 8, 10, 2, 3 };
		int expected = 4;
		int actual = findSamllestMissingNumber(input);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test2() {
		int[] input = { 2, 8, 10, 1, 0, 2, 1 };
		int expected = 3;
		int actual = findSamllestMissingNumber(input);
		Assert.assertEquals(expected, actual);
	}

	private int findSamllestMissingNumber(int[] input) {
		System.out.println();
		int smallNum = -1; // to find the initial number
		for (int i = 0; i < input.length; i++) {
			int currentMin = input[i];
			boolean isNextNumAvailable = false;
			for (int j = i + 1; j < input.length; j++) {
				if ((input[j] >= 0) && (input[j] == (currentMin + 1))) {
					isNextNumAvailable = true;
					break;
				}
//				System.out.println(input[i] + " - " +input[j] + " - " + (currentMin + 1) + " - " + ((input[j] >= 0) && (input[j] == (currentMin + 1))));
			}
			if (isNextNumAvailable == false) {
				++currentMin;
				smallNum = (smallNum < 0) ? (currentMin) : ((currentMin < smallNum) ? currentMin : smallNum);
				System.out.println("Minimum number = " + smallNum);
			}
		}

		return smallNum;
	}

	// Store element and find element + 1 available or not
	// if available then store to map with ele => true as available
	// else check whether it is the smaller one or not and save the smaller result

}
