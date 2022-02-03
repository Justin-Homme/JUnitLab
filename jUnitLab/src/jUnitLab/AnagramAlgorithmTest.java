package jUnitLab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * A test file to ensure AnagramAlgorithm works how it
 * should for each test case
 * @author Justin Homme
 * @version 03/22/21
 *
 */
class AnagramAlgorithmTest {

	@Test
	public void testSimpleMethodKnownAnagrams() {
		assertTrue(AnagramAlgorithm.isAnagramSimple("heart", "hater"));
		assertTrue(AnagramAlgorithm.isAnagramSimple("heart", "heart"));
		assertTrue(AnagramAlgorithm.isAnagramSimple("listen", "silent"));
	}
	
	@Test
	public void testSimpleMethodKnownNonAnagrams() {
		assertFalse(AnagramAlgorithm.isAnagramSimple("Hello", "Goodbye"));
		assertFalse(AnagramAlgorithm.isAnagramSimple("Hello", "Jello"));
		assertFalse(AnagramAlgorithm.isAnagramSimple("Goodboy", "Goodbye"));
	}
	
	@Test
	public void testKnownAnagrams() {
		assertTrue(AnagramAlgorithm.isAnagram("heart", "hater"));
		assertTrue(AnagramAlgorithm.isAnagram("heart", "heart"));
		assertTrue(AnagramAlgorithm.isAnagram("listen", "silent"));
		
		assertTrue(AnagramAlgorithm.isAnagram("", ""));
		
		assertTrue(AnagramAlgorithm.isAnagram("$%#@heart", "$#%@hater"));
		
		//assertTrue(AnagramAlgorithm.isAnagram(null, null));
	}
	
	@Test
	public void testKnownNonAnagrams() {
		assertFalse(AnagramAlgorithm.isAnagram("Hello", "Goodbye"));
		assertFalse(AnagramAlgorithm.isAnagram("Hello", "Jello"));
		assertFalse(AnagramAlgorithm.isAnagram("Goodboy", "Goodbye"));
		//assertFalse(AnagramAlgorithm.isAnagram("Goodbye", "Goodbye"));
		assertFalse(AnagramAlgorithm.isAnagram("aa", "b"));
		
		//assertTrue(AnagramAlgorithm.isAnagram(null, "silent"));
	}
	
	/**
	* A boring, standard anagram detecting algorithm
	     * @param a a String to check
	     * @param b another string to compare to a
	     * @return true if a and b are anagrams, false otherwise
	     */
	    public boolean isAnagramBoring(String a, String b) {
	        if(a == null || b == null) return false;
	        int[] acounts = new int[26];
	        int[] bcounts = new int[26];
	        char[] chars = a.toLowerCase().toCharArray();
	        for(int i = 0; i < a.length(); i++) {
	            if(Character.isLetter(chars[i])) {
	                acounts[chars[i]-'a']++;
	            }
	        }
	        chars = b.toLowerCase().toCharArray();
	        for(int i = 0; i < b.length(); i++) {
	            if(Character.isLetter(chars[i])) {
	                bcounts[chars[i]-'a']++;
	            }
	        }
	        for(int i = 0; i < acounts.length; i++) {
	            if(acounts[i] != bcounts[i]) return false;//extra or missing letters
	        }
	        return true;//all of the counts must have matched if we made it to here
	    }
	    
	    @Test
	    public void testVsBoring() {
	    	assertEquals(isAnagramBoring("heart","hater"), AnagramAlgorithm.isAnagram("heart", "hater"),
	    			"Heart and Hater caused an incorrect answer");
	    	assertEquals(isAnagramBoring("Hello","Goodbye"), AnagramAlgorithm.isAnagram("Hello", "Goodbye"),
	    			"Hello and Goodbye caused an incorrect answer");
	    	assertEquals(isAnagramBoring("listen","silent"), AnagramAlgorithm.isAnagram("listen", "silent"),
	    			"listen and silent caused an incorrect answer");
	    	assertEquals(isAnagramBoring("$%#@heart","$#%@hater"), AnagramAlgorithm.isAnagram("$%#@heart", "$#%@hater"),
	    			"$%#@heart and $#%@hater caused an incorrect answer");
	    	assertEquals(isAnagramBoring("Debit card","Bad credit"), AnagramAlgorithm.isAnagram("Debit card", "Bad credit"),
	    			"Debit card and Bad credit caused an incorrect answer");
	    }
}

