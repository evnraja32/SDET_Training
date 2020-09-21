package src.work.raja.week1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class FindArrayOfSubArrays {

	@Test
	public void test() {
		int[] input = { 1, 7, 4, 3, 1, 2, 1, 5, 1 };
		int desiredSum = 7;
		getSubArrayFor(input, desiredSum);
	}

	private void getSubArrayFor(int[] input, int desiredSum) {

		int sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum = input[i];
			for (int j = i + 1; j < input.length; j++) {
				if (sum > desiredSum) {
					break;
				} else if (sum == desiredSum) {
					System.out.println("Indecies: " + i + " - " + (j - 1));
					break;
				}
				sum += input[j];
			}
		}
	} // end of method

}
