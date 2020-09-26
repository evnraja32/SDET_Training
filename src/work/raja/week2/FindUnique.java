package src.work.raja.week2;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class FindUnique {

	@Test
	public void test() {
		String name = "raja";

		System.out.println(Arrays.toString(findUnique(name)));
	}

	private char[] findUnique(String name) {
		String result = "";
		String temp = "";

		// abcad
		while (name != "") {
			temp = name.replaceAll(name.charAt(0) + "", "");
			if ((name.length() - temp.length()) == 1) {
				result += name.charAt(0);
//				result = Arrays.copyOf(result, result.length + 1);
//				result[result.length - 1] = name.charAt(0);
			}
			name = temp;
		}
		return result.toCharArray();
	}

	@Test
	public void example1() {
		String str = "abcadba";
		System.out.println(removeDuplicates(str));
	}

	private String removeDuplicates(String str) {
		String output = "";
		for (int i = 0; i < str.length(); i++) {
			if (!output.contains(String.valueOf(str.charAt(i)))) {
				output += String.valueOf(str.charAt(i));
			}
		}
		return output;

	}

}
