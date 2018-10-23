package com.mitrais.javabootcamp;


/*
 * Given a string, return the character which appears the maximum number of times in the string. The string will contain only ASCII characters. 
 * If there is a tie in the maximum number of times a character appears in the string, 
 * return the character which appears first in the string.
 * For example, given the string text = abbbaacc, both a and b occur 3 times in text. 
 * Since a occurs earlier, a is the answer.
 * 
 * Function Description
 * Complete the function maximumOccurringCharacter in the editor below. The function must return the character which appears first in the string.
 * maximumOccurringCharacter has the following parameter: text: the string to be operated upon
 * 
 * */

class MaximumOccurringCharacter {
	/*
	 * Complete the 'maximumOccurringCharacter' function below. * The function is
	 * expected to return a CHARACTER. The function accepts STRING text as
	 * parameter.
	 */

	public static char maximumOccurringCharacter(String text) { // Write your code here

		int[] count = new int[256];
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			count[ch] += 1;
		}

		int maxcount = -1;
		char longest = 0;
		for (char ch : text.toCharArray()) {
			if (count[ch] > maxcount) {
				maxcount = count[ch];
				longest = ch;
			}

		}

		return longest;
	}
	
	public static void main(String[] args) {

		System.out.println(maximumOccurringCharacter("HelloWorld"));
		System.out.println(maximumOccurringCharacter("HelloWorldo"));
		System.out.println(maximumOccurringCharacter("HelloWorldoo"));
	}
	
}