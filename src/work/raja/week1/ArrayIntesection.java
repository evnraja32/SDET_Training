package src.work.raja.week1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ArrayIntesection {

	@Test
	public void test1() {
		int[] input1 = { 1, 2, 3, 4 };
		int[] input2 = { 2, 4, 7, 9, 5, 8, 3 };
		int[] expecteds = { 2, 3, 4 };
		int[] actuals = findArrayIntersections(input1, input2);
		Assert.assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test2() {
		int[] input1 = { 1, 2, 3, 5, 4 };
		int[] input2 = { 2, 4, 7 };
		int[] expecteds = { 2, 4 };
		int[] actuals = findArrayIntersections(input1, input2);
		Assert.assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test3() {
		int[] input1 = { 1 };
		int[] input2 = { 2, 4, 7 };
		int[] expecteds = {};
		int[] actuals = findArrayIntersections(input1, input2);
		Assert.assertArrayEquals(expecteds, actuals);
	}

	private int[] findArrayIntersections(int[] input1, int[] input2) {
		List<Integer> commonElements = new ArrayList<Integer>();

		int[] arrayA = input1, arrayB = input2;
		if (input2.length < input1.length) {
			arrayA = input2;
			arrayB = input1;
		}
		for (int i = 0; i < arrayA.length; i++) {
			if (searchForKeyIn(arrayB, arrayA[i])) {
				commonElements.add(arrayA[i]);
			}
		}

		int[] result = new int[commonElements.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = (int) commonElements.get(i);
		}

		return result;
	}

	private boolean searchForKeyIn(int[] arrayB, int i) {

		for (int ele : arrayB) {
			if (ele == i)
				return true;
		}

		return false;
	}

}
