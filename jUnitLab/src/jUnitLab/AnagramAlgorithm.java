package jUnitLab;

/**
 * A class for demonstrating unit tests
 * Let's write some JUnit tests to see if isAnagram() is working
 * as advertized
 * @author gosnat
 * @version Spring 2021
 */
public class AnagramAlgorithm {
	
	/**
	 * A bad method that just always returns "true"
	 * @param a a string to compare
	 * @param b another string to compare to a
	 * @return always returns true
	 */
	public static boolean isAnagramSimple(String a, String b) {
		return true;
	}
	
	

	/**
	 * Tests for anagrams, ignoring capitalization, spaces and punctuation.
	 * This can't possibly be a valid algorithm, can it?  Let's test it!
	 * @param a a String to check
	 * @param b another string to compare to a
	 * @return true if a and b are anagrams, false otherwise
	 */
	public static boolean isAnagram(String a, String b) {
		int anum = 1;
		int bnum = 1;
		// calculate our magic number for String a
		char[] chars = a.toLowerCase().toCharArray();
		for (int i = 0; i < a.length(); i++) {
			if (Character.isLetter(chars[i])) {
				anum *= eulerNumber(chars[i] - 'a');
			}
		}
		// calculate our magic number for String b
		chars = b.toLowerCase().toCharArray();
		for (int i = 0; i < b.length(); i++) {
			if (Character.isLetter(chars[i])) {
				bnum *= eulerNumber(chars[i] - 'a');
			}
		}
		return anum == bnum;

	}
	
	/**
	 * Euler's pretty-good-prime-generating polynomial
	 * 
	 * @param n input number
	 * @return the nth euler prime
	 */
	private static int eulerNumber(int n) {
		// TODO we'll talk about exceptions soon, and we
		// should really be throwing an exception for n > 40
		// since that's where this method stops working, but we
		// won't be using inputs past 25 in this program.
		return n * n + n + 41;
	}
	
	
}