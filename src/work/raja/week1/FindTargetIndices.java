package src.work.raja.week1;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindTargetIndices {

	@Test
	public void test1() {

		int[] num = { 2, 3, 1, 4, 7, 8 };
		int target = 5;
		int[] actuals = { 0, 1 };
		int[] indices = getSumIndeces(num, target);
		assertArrayEquals(indices, actuals);
	}

	public int[] getSumIndeces(int[] num, int target) {

		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if (num[i] + num[j] == target) {
					return new int[] { i, j };
				}
			}
		}

		throw new RuntimeException("No indices are found");
	}

}
