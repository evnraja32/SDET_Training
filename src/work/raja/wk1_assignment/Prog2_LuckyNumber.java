package src.work.raja.wk1_assignment;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

// 2) Given an array of integers, a lucky integer is an integer which has a frequency in the array equal to its value.

// Return a lucky integer in the array. If there are multiple lucky integers return the largest of them. If there is no lucky integer return -1.

// Input: [1,2,3,3,4,4,4,4,5]
// Output: 4
// Explanation: 1, 2 and 4 are all lucky numbers, but 4 is the largest
public class Prog2_LuckyNumber {

	@Test
	public void test1() {
		int[] input = { 1, 2, 3, 3, 4, 4, 4, 4, 5 };
		int expected = 4;
		int actual = findLuckyNumber_brueteForce(input);
		Assert.assertEquals(expected, actual);
		assertEquals(expected, findLuckyNumber_hash(input));
	}

	@Test
	public void test2() {
		int[] input = { 1, 1, 2, 3, 3, 4, 4, 4, 4, 4, 5 };
		int expected = -1;
		int actual = findLuckyNumber_brueteForce(input);
		Assert.assertEquals(expected, actual);
		assertEquals(expected, findLuckyNumber_hash(input));
	}

	@Test
	public void test3() {
		int[] input = { 1, 2, 3, 3, 3, 4, 4, 4, 4, 5 };
		int expected = 4;
		int actual = findLuckyNumber_brueteForce(input);
		Assert.assertEquals(expected, actual);
		assertEquals(expected, findLuckyNumber_hash(input));
	}

	@Test
	public void test4() {
		int[] input = { 4, 4, 2, 4, 5, 3, 1, 3, 3, 4 };
		int expected = 4;
		int actual = findLuckyNumber_brueteForce(input);
		Assert.assertEquals(expected, actual);
		assertEquals(expected, findLuckyNumber_hash(input));
	}

	@Test
	public void test5() {
		int[] input = { 3, 3, 3, 4, 5, 4, 5, 4, 5, 4, 5, 6, 5, 6, 7, 6, 8, 6, 9, 6, 9, 6, 10, 11, 12 };
		int expected = 6;
		int actual = findLuckyNumber_brueteForce(input);
		Assert.assertEquals(expected, actual);
		assertEquals(expected, findLuckyNumber_hash(input));
	}

	private int findLuckyNumber_brueteForce(int[] input) {
		int luckyNumber = -1;
		int count = 0;
		int tempNum = 0;
		for (int i = 0; i < input.length; i++) {
			count = 0;
			tempNum = input[i];
			for (int j = 0; j < input.length; j++)
				if (tempNum == input[j])
					count += 1;
			if (tempNum == count) {
				count += 1;
				luckyNumber = Math.max(luckyNumber, tempNum);
			}
		}
		return luckyNumber;
	}

	private int findLuckyNumber_hash(int[] input) {
		int luckyNumber = -1;

		HashMap<Integer, Integer> set = new HashMap<Integer, Integer>();
		for (int i = 0; i < input.length; i++) {
			int key = input[i];
			int value = (set.containsKey(key)) ? set.get(key) + 1 : 1;
			set.put(key, value);
			if (key == value) {
				luckyNumber = Math.max(luckyNumber, key);
			}
		}

		return (set.get(luckyNumber) == luckyNumber)? luckyNumber : -1;
	}
}
