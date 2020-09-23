package src.work.raja;

public abstract class SortingLogics {

	/**
	 * A simple sorting logic implemented as brute force technique
	 * 
	 * Complexity: O[N^2]
	 * 
	 * @param input
	 * @return
	 */
	public static int[] simpleSorting(int[] input) {

		int temp = 0;
		// 8, 1, 3, 2, 9, 2, 3
		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				if (input[i] > input[j]) {
					temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
		}
		return input;
	}

}
