package src.assignments.week1;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

//5) Find all the missing numbers in the given array

//Input: [4,3,2,7,8,2,3,1]
//Output: [5,6]

public class Prog5_FindAllMissingNumbers {

	final private boolean MIN_NUM = true;
	final private boolean MAX_NUM = false;

	@Test
	public void test() {
		int[] input = { 4, 3, 2, 7, 8, 2, 3, 1 };
		int[] expecteds = { 5, 6 };
		int[] actuals = findMissingNumbers_BruteForce(input);
		Assert.assertArrayEquals(expecteds, actuals);
	}

	private int[] findMissingNumbers_BruteForce(int[] input) {

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

		return resultArray;

		// Complexity : O[1] + O[N] + O[N] + O[5N] + O[2N] ~ O[N]
	}

	private int[] storeResult(int[] resultArray, int i) {
		int newLength = resultArray.length + 1;
		int[] result = Arrays.copyOf(resultArray, newLength);
		result[newLength - 1] = i;
		return result;
	}

	private int findMinMaxNumber(int[] input, boolean findMin) {
		int result = input[0];

		for (int i : input) {
			result = (findMin) ? Math.min(result, i) : Math.max(result, i);
		}

		return result;
	}

}
