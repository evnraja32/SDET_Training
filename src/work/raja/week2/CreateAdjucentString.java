package src.work.raja.week2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.junit.Test;

public class CreateAdjucentString {

	@Test
	public void test1() { // simple balanced string
		String input = "aab";
		String expected = "aba";
		assertEquals(expected, process(input));
	}

	@Test
	public void test2() { // simple 2-char balanced string
		String input = "aaaaaabbbbb";
		String expected = "abababababa";
		assertEquals(expected, process(input));
	}

	@Test
	public void test3() { // simple unbalanced string
		String input = "aaab";
		String expected = "";
		assertEquals(expected, process(input));
	}

	@Test()
	public void test4() { // medium complex balanced string
		String input = "aaaaabbbbccc";
		String expected = "abcabcabcaba";
		assertEquals(expected, process(input));
	}

	@Test()
	public void test5() { // medium complex balanced jumbled string
		String input = "abebcbcbacaaea";
		String expected = "abceabceabcaba";
		assertEquals(expected, process(input));
	}

	private String process(String input) {

		String output = "";

		// loop vars
		HashMap<Character, Integer> charStore = new HashMap<Character, Integer>();
		int charIndex = 0; // => pointer last index position of output
		char currentChar; // => current char of input

		// => after loop execution charStore = {a=>2, b=>1}
		for (char c : input.toCharArray())
			charStore.put(c, charStore.getOrDefault(c, 0) + 1);

		do {

			// Iterator for {a, b} => keys of charStore
			Iterator<Character> it = charStore.keySet().iterator();

			// Iterating for each key of charStore
			while (it.hasNext()) {
				currentChar = it.next();

				// if output has value and its value at last index equals current char
				// Eg: in aaab after aba[3] to third index currentChar shouldn't be 'a'
				// if it is a then reduce the counter marking another char was visited
				// this indirectly represents a invalid input and loss of one iteration
				if (output.length() != 0 && output.charAt(charIndex) == currentChar) {
					return "";
				} else {

					// append the current char to output
					output += currentChar;

					// reduce the count of currentChar in charStore (HashMap)
					charStore.put(currentChar, charStore.get(currentChar) - 1);

					// when the all chars visited then currentChar value becomes 0
					// We can remove the char(key, value) from the charStore to reduce the next
					// iteration count
					if (charStore.get(currentChar) == 0)
						charStore.remove(currentChar);

					charIndex = output.length() - 1;
				}
			}

			// As the inner loop follow-ups on keys and values of the charStore.
			// Exit loop when charStore becomes empty
		} while (charStore.size() != 0);
		return output;
	}

	private String process1(String input) {
		String output = "";

		// covert string to List
		ArrayList<String> list = new ArrayList<String>();

		for (char c : input.toCharArray()) {
			list.add(c + "");
		}

		int charIndex = 0;
		int loopIndex = 0;

		output += list.remove(charIndex);
		while (list.size() != 0) {
//			System.out.println(output.charAt(charIndex) + " - " + list.get(loopIndex) + (!(output.charAt(charIndex) + "").equals(list.get(loopIndex))));
			if (!(output.charAt(charIndex) + "").equals(list.get(loopIndex))) {
				output += list.remove(loopIndex);
				loopIndex = 0;
				++charIndex;
				System.out.println(output);
				continue;
			}
			++loopIndex;
			if (loopIndex == list.size())
				return "";
		}

		return output;
	}

}
