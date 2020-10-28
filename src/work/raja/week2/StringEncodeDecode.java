package src.work.raja.week2;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class StringEncodeDecode {

	@Test
	public void test1() { // working cipher
		String input = "3[a]2[bc]";
		String expected = "aaabcbc";
		String actual = decode(input);
		assertEquals(expected, actual);
	}

	@Test
	public void test2() { // cipher with unequal braces
		String input = "3[[a]2[bc]";
		String expected = null;
		String actual = decode(input);
		assertEquals(expected, actual);
	}

	@Test
	public void test3() { // cipher with no no.of occurrences
		String input = "3[[a]2[bc]]";
		String expected = null;
		String actual = decode(input);
		assertEquals(expected, actual);
	}

	@Test
	public void test4() { // cipher with groups  group
		String input = "3[1[a]2[bc]]";
		String expected = "abcbcabcbcabcbc";
		String actual = decode(input);
		assertEquals(expected, actual);
	}

	@Test
	public void test5() {
		String input = "5[3[1[a]2[bc]]]";
		String expected = "abcbcabcbcabcbcabcbcabcbcabcbcabcbcabcbcabcbcabcbcabcbcabcbcabcbcabcbcabcbc";
		String actual = decode(input);
		assertEquals(expected, actual);
	}

	private String decode(String input) {
		String output = "";
		String temp = "";
		Stack<Character> stack = new Stack<Character>();

		for (char c : input.toCharArray()) {
			try {
				if (c != ']') {
					stack.push(c);
				} else {
					temp = "";
					while ((c = stack.pop()) != '[') {
						temp = c + temp;
					}
					if (temp.length() == 0) { 
						temp = output;
						output = "";
					}
					int len = Integer.parseInt(stack.pop() + "");
					for (int i = 1; i <= len; i++) 
						output += temp;
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
				return null;
			}
		}
		return output;
	}

}
