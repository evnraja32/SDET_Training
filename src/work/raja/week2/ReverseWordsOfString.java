package src.work.raja.week2;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseWordsOfString {

	@Test
	public void test1() { // simple string
		String input = "I am doing great";
		String expected = "I ma gniod taerg";
		String actual = process(input);
		assertEquals(expected, actual);
	}

	@Test
	public void test2() { // pallindrome string
		String input = "malayalam madam";
		String expected = "malayalam madam";
		String actual = process(input);
		assertEquals(expected, actual);
	}

	@Test
	public void test3() { // string extra space in the middle
		String input = "I am  doing great";
		String expected = "I ma  gniod taerg";
		String actual = process(input);
		assertEquals(expected, actual);
	}

	private String process(String input) {
		String output = "";

		// clear trailing spaces
		input = input.trim();

		// initialize loop params
		String temp = "";
		int index = 0;
		char currentChar;

		do {
			currentChar = input.charAt(index);

			// prepend each current char to temp
			temp = currentChar + temp;

			// if current char is space or End Of String
			if (currentChar == ' ' || index == (input.length() - 1)) {

				// append temp + space string end of output
				output = output + temp.trim() + ' ';
				temp = "";
			}

			// end loop when index reach string length
		} while ((++index) < input.length());

		return output.trim();
	}

}
