package src.work.raja.wk2_assignments;

import static org.junit.Assert.*;

import org.junit.Test;

//8) Given 2 Strings with length n and (n+1) respectively. The second String contains all the characters of first but with an extra char. Write the code to find the extra char
//
//Example 1:
//
//Input:
//
//A1 = "Test"
//A2 = "Test$"
//
//Output: '$'
//
//Example 2:
//
//Input:
//
//A1 = "Hello"
//A2 = "lloreH"
//
//Output: 'r'

public class FindExtraChar {

	@Test
	public void test1() {
		String A1 = "Test";
		String A2 = "Test$";
		char expected = '$';
		char actual = findExtraChar1(A1, A2);
		assertEquals(expected, actual);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		String A1 = "Test";
		String A2 = "Test$";
		char expected = '$';
		char actual = findExtraChar1(A1, A2);
		assertEquals(expected, actual);
		assertEquals(expected, findExtraChar2(A1, A2));
	}
	
	private char findExtraChar2(String a1, String a2) {
		char result = 0;
		
		
		
		return 0;
	}

	private char findExtraChar1(String a1, String a2) {
		char result = 0;
		
		if(a1.length() + 1 != a2.length())
			return 0;
		
		result = a2.replaceAll("[" + a1 + "]", "").toCharArray()[0];

		return result;
	}

}
