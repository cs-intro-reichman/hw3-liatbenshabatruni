/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		//System.err.println(str1);
		//System.err.println(str2);
		int counter1 = 0;
		int counter2 = 0;
		for (int i = 0; i < str1.length(); i++) {
			if ((str2.indexOf(str1.charAt(i))!= -1)) {
					//strNew = strNew + str1.charAt(i);
						counter1++;
			}			
		}
		for (int i = 0; i < str2.length(); i++) {
				if ((str1.indexOf(str2.charAt(i))!= -1)) {
						counter2++;
				}
		}
		//System.out.println(counter1);
		//System.out.println(counter2);
		return (counter1 == str1.length())&&(counter2 == str2.length());
}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// first, we'll delete the spaces, ?,!,:
		String strNew = "";
		str = str.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			if (((str.charAt(i)>=48) && (str.charAt(i)<=57))||((str.charAt(i)>=97)&&(str.charAt(i)<=122))||(str.charAt(i)==32))
			{
				strNew = strNew + str.charAt(i);
			}
			
		}
		return strNew;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {	
		int limit = str.length();
		String strNew = "";
		for (int i = 0; i < limit ; i++) {
			int randomChar = (int)(Math.random()*str.length());
			strNew = strNew + str.charAt(randomChar);
			str = str.substring(0, randomChar) + str.substring(randomChar+1);
			
		}
		return strNew;
	}
}
