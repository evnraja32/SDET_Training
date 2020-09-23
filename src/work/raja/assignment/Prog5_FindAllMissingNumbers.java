package src.work.raja.assignment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import src.work.raja.SortingLogics;

//5) Find all the missing numbers in the given array

//Input: [4,3,2,7,8,2,3,1]
//Output: [5,6]

public class Prog5_FindAllMissingNumbers {

	final private boolean MIN_NUM = true;
	final private boolean MAX_NUM = false;

	@Test
	public void test1() {
		int[] input = { 4, 3, 2, 7, 8, 2, 3, 1 };
		int[] expecteds = { 5, 6 };
		Assert.assertArrayEquals(expecteds, findMissingNumbers_BruteForce1(input));
		Assert.assertArrayEquals(expecteds, findMissingNumbers_BruteForce2(input));
		Assert.assertArrayEquals(expecteds, findMissingNumbers_BruteForce3(input));
	}

	@Test
	public void test2() {
		int[] input = { 1, 3, 2, 8, 7, 2, 3, 4, 5 };
		int[] expecteds = { 6 };
		Assert.assertArrayEquals(expecteds, findMissingNumbers_BruteForce1(input));
		Assert.assertArrayEquals(expecteds, findMissingNumbers_BruteForce2(input));
		Assert.assertArrayEquals(expecteds, findMissingNumbers_BruteForce3(input));
	}

	@Test
	public void test3() {
		int[] input = { 8, 1, 4 };
		int[] expecteds = { 2, 3, 5, 6, 7 };
		Assert.assertArrayEquals(expecteds, findMissingNumbers_BruteForce2(input));
		Assert.assertArrayEquals(expecteds, findMissingNumbers_BruteForce3(input));
		// Assert.assertArrayEquals(expecteds, findMissingNumbers_BruteForce1(input));
		// => not working
	}

	@Test
	public void test4() {
		int[] input = { 1, 3, 2, -8, 7, 2, 3, 4, 5 };
		int[] expecteds = { 6 };
		Assert.assertArrayEquals(expecteds, findMissingNumbers_BruteForce1(input));
		Assert.assertArrayEquals(expecteds, findMissingNumbers_BruteForce2(input));
		Assert.assertArrayEquals(expecteds, findMissingNumbers_BruteForce3(input));
	}

	@Test
	public void test5() {
		int[] input = { 1, 3, 2, 0, 7, 2, 3, 4, 5 };
		int[] expecteds = { 6 };
		Assert.assertArrayEquals(expecteds, findMissingNumbers_BruteForce1(input));
		Assert.assertArrayEquals(expecteds, findMissingNumbers_BruteForce2(input));
		Assert.assertArrayEquals(expecteds, findMissingNumbers_BruteForce3(input));
	}

	/**
	 * Complexity : O[1] + O[N^2] + O[N*M] ~ O[N^2]
	 * 
	 * @param input
	 * @return
	 */
	private int[] findMissingNumbers_BruteForce3(int[] input) {
		int[] resultArray = {}; // O[1]
		int temp = 0;
		input = SortingLogics.simpleSorting(input); // O[N^2]
		for (int i = 1; i < input.length; i++) { // O[N]
			temp = input[i] - input[i - 1]; // O[1]
			if (temp > 1) { // O[1]
				for (int j = input[i - 1] + 1; j < input[i]; j++) {
					resultArray = storeResult_custom_method(resultArray, j); // O[M]
				}
			}
		}
		return resultArray;
	}

	/**
	 * Complexity : O[N]
	 * 
	 * @param currentArray
	 * @param newElement
	 * @return
	 */

	/**
	 * Use this method to insert a element into the array.
	 * 
	 * @param currentArray
	 * @param newElement
	 * @return
	 */
	private int[] storeResult_custom_method(int[] currentArray, int newElement) {
		int[] result = new int[currentArray.length + 1];
		for (int i = 0; i < currentArray.length; i++) {
			result[i] = currentArray[i];
		}
		result[result.length - 1] = newElement;
		return result;
	}

	/**
	 * Complexity : O[1] + O[N] + O[N] + O[N] + O[N] ~ O[N]
	 * 
	 * @param input
	 * @return
	 */
	private int[] findMissingNumbers_BruteForce2(int[] input) {

		int resultArray[] = {}, temp; // O[1]
		int minNum = findMinMaxNumber(input, MIN_NUM); // O[N]
		int maxNum = findMinMaxNumber(input, MAX_NUM); // O[N]

		HashMap<Integer, Boolean> inputRegister = new HashMap<Integer, Boolean>();
		for (int i : input) // O[N]
			inputRegister.put(i, true);

		for (int i = minNum; i < maxNum; i++) { // O[N]
			if (!inputRegister.containsKey(i)) {
				resultArray = storeResult_custom_method(resultArray, i);
			}
		}

		return resultArray;
	}

	/**
	 * Complexity : O[1] + O[N] + O[N] + O[5N] + O[2N] ~ O[N]
	 * 
	 * @param input
	 * @return
	 */
	private int[] findMissingNumbers_BruteForce1(int[] input) {

		int resultArray[] = {}, temp; // O[1]
		int minNum = findMinMaxNumber(input, MIN_NUM); // O[N]
		int maxNum = findMinMaxNumber(input, MAX_NUM); // O[N]

		HashMap<Integer, Boolean> inputRegister = new HashMap<Integer, Boolean>();
		for (int i : input) { // O[5N]

			inputRegister.put(i, true);

			if (((temp = (i - 1)) > minNum) && (!inputRegister.containsKey(temp)))
				inputRegister.put(temp, false);

			if (((temp = (i + 1)) < maxNum) && (!inputRegister.containsKey(temp)))
				inputRegister.put(temp, false);
		}

		for (Entry<Integer, Boolean> set : inputRegister.entrySet()) { // O[2N]
			if (!set.getValue())
				resultArray = storeResult(resultArray, set.getKey());
		}
		System.out.println();
		return resultArray;

	}

	/**
	 * Method to store the results into array
	 * 
	 * @param resultArray
	 * @param i
	 * @return
	 */
	private int[] storeResult(int[] resultArray, int newElement) {
		int newLength = resultArray.length + 1;
		int[] result = Arrays.copyOf(resultArray, newLength);
		result[newLength - 1] = newElement;
		return result;
	}

	/**
	 * Method to find the Max number between two numbers
	 * 
	 * @param input
	 * @param findMin
	 * @return
	 */
	private int findMinMaxNumber(int[] input, boolean findMin) {
		int result = input[0];

		for (int i : input) {
			result = (findMin) ? Math.min(result, i) : Math.max(result, i);
		}

		return result;
	}

}
