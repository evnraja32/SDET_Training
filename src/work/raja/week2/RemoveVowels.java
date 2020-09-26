package src.work.raja.week2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class RemoveVowels {

	@Test
	public void test1() {
		String name = "testleaf";
		System.out.println(replaceVowels1(name));
		System.out.println(replaceVowels2(name));
	}

	@Test
	public void test2() {
		String name = "bsg";
		System.out.println(replaceVowels1(name));
		System.out.println(replaceVowels2(name));
	}

	private String replaceVowels3(String name) {
		char[] string = name.toCharArray();

		List<Character> vowelsList = Arrays.asList('a', 'e', 'i', 'o', 'u');
		for (int i = 0; i < string.length; i++) {
			if (vowelsList.contains(string[i])) {
//				string[i] = ;
			}
		}

		return name;
	}

	private String replaceVowels1(String name) {
		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };

		for (char v : vowels) {
			name = name.replaceAll(v + "", "");
		}

		return name;
	}

	private String replaceVowels2(String name) {
		return name.replaceAll("[AEIOUaeiou]", "");
	}

}
