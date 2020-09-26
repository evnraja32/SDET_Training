package src.work.raja.wk1_assignment;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

import org.junit.Test;

public class Prog7_ArrayCommonElements {

	// 7) Given three integer arrays arr1, arr2 and arr3 sorted in strictly
	// increasing order, return a sorted array of only the integers that appeared in
	// all three arrays.

	// Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
	// Output: [1,5]
	// Explanation: Only 1 and 5 appeared in the three arrays.

	@Test
	public void test1() {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 1, 2, 5, 7, 9 };
		int[] arr3 = { 1, 3, 4, 5, 8 };
		int[] expecteds = { 1, 5 };
		int[] actuals = findCommonArray_hashMethod(arr1, arr2, arr3);
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test2() {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 1, 2, 2, 5, 7, 9 };
		int[] arr3 = { 1, 3, 4, 5, 8 };
		int[] expecteds = { 1, 5 };
		int[] actuals = findCommonArray_hashMethod(arr1, arr2, arr3);
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test3() {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 1, 2, 5, 7, 9, 10 };
		int[] arr3 = { 1, 3, 5, 8 };
		int[] expecteds = { 1, 5 };
		int[] actuals = findCommonArray_hashMethod(arr1, arr2, arr3);
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test4() {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 1, 2, 5, 2, 7, 9, 10 };
		int[] arr3 = { 1, 3, 5, 8 };
		int[] expecteds = { 1, 5 };
		int[] actuals = findCommonArray_hashMethod(arr1, arr2, arr3);
		assertArrayEquals(expecteds, actuals);
	}

	private int[] findCommonArray_hashMethod2(int[] arr1, int[] arr2, int[] arr3) {

		int[] result = {};

		// Initializing 2D array for easy processing
		int[][] input = { arr1, arr2, arr3 };

		// Processing vars
		HashSet<Integer> arrayResigter = new HashSet<Integer>();
		int key = 0, value = 0;

		// Find the sorted property of Arrays - O[N^2]
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length - 1; j++) {
				if (!(input[i][j] < input[i][j + 1]))
					throw new IllegalArgumentException("Invalid Input, input array must be increasing order array !!!");

				if (i == 0)
					arrayResigter.add(key);
				else {
					
				}
			}
		}

		System.out.println("array are sorted");
		return result;
	}

	private int[] findCommonArray_hashMethod(int[] arr1, int[] arr2, int[] arr3) {

		int[] result = {};

		// Initializing 2D array for easy processing
		int[][] input = { arr1, arr2, arr3 };

		// Processing vars
		HashMap<Integer, Integer> arrayResigterMap = new HashMap<Integer, Integer>();
		int key = 0, value = 0;

		// Find the sorted property of Arrays - O[N^2]
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length - 1; j++) {
				if (!(input[i][j] < input[i][j + 1]))
					throw new IllegalArgumentException("Invalid Input, input array must be increasing order array !!!");

				// Check for the presence of key value, then increase the occurence count
				key = input[i][j];
				value = arrayResigterMap.containsKey(key) ? arrayResigterMap.get(key) + 1 : 1;
				arrayResigterMap.put(key, value);
				System.out.println(i + " - " + j + " | " + input[i][j] + " < " + input[i][j + 1] + " - "
						+ arrayResigterMap.get(key));
			}
			int j = input[i].length - 1;
			key = input[i][j];
			value = arrayResigterMap.containsKey(key) ? arrayResigterMap.get(key) + 1 : 1;
			arrayResigterMap.put(key, value);
		}

		Iterator<Entry<Integer, Integer>> it = arrayResigterMap.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Integer, Integer> set = it.next();
			System.out.println(set.getKey() + " - " + set.getValue());
			if (set.getValue() == 3) {
				result = Arrays.copyOf(result, result.length + 1);
				result[result.length - 1] = set.getKey();
			}
		}

		System.out.println("array are sorted");
		return result;
	}

}
