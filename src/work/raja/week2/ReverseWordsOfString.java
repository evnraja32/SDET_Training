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

	@Test
	public void test4() { // a 3-line sentence
		String input = "This is the first day\nIn the new office @ chennai\nIt is going to be excited";
		String expected = "sihT si eht tsrif yad\nnI eht wen eciffo @ iannehc\ntI si gniog ot eb deticxe";
		String actual = process(input);
		assertEquals(expected, actual);
	}

	private String process(String input) {
		String output = "";

		// clear trailing spaces
		input = input.trim();

		// initialize loop params
		String tempWord = "";
		int index = 0;
		char currentChar;

		do {
			currentChar = input.charAt(index);

			// if current char is space or End Of String
			if (currentChar == ' ' || currentChar == '\t' || currentChar == '\n') {

				// append temp + space string end of output
				output = output + tempWord + currentChar;
				tempWord = "";
				continue;
			}
			
			// prepend each current char to temp
			tempWord = currentChar + tempWord;

			// end loop when index reach string length
		} while ((++index) < input.length());

		return (output + tempWord);
	}

}
