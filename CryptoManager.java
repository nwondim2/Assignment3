/*
 * Class: CMSC203 
 * Instructor: Professor Kuijt
 * Description: Displays and allows user to Operate 2 different encryption and decryption methods.
 * Due: 10/20/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Nahom Wondimu
*/



/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		// throw new RuntimeException("method not implemented");
		for(int i = 0; i < plainText.length(); i++) {
			if(plainText.charAt(i) < LOWER_RANGE || plainText.charAt(i) > UPPER_RANGE) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		// throw new RuntimeException("method not implemented");
		char letter;
		String newText = "";
		
		if(!isStringInBounds(plainText)) {
			return "The selected string is not in bounds, Try again.";
		}
		
		for(int i = 0; i < plainText.length(); i++) {
			letter = plainText.charAt(i);
			int letterInt = (int) letter;
			int newValue = ((letterInt + key - LOWER_RANGE) % (RANGE)) + LOWER_RANGE;
			char newChar = (char) newValue;
			newText += newChar;
		}
		return newText;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		// throw new RuntimeException("method not implemented");
		char letter;
		char bLetter;
		String newText = "";
		
		if(!isStringInBounds(plainText)) {
			return "The selected string is not in bounds, Try again.";
		}
		
		for(int i = 0; i < plainText.length(); i++) {
			letter = plainText.charAt(i);
			bLetter = bellasoStr.charAt(i % bellasoStr.length());
			int letterInt = (int) letter;
			int bInt = (int) bLetter;
			int newValue = ((letterInt + bInt - LOWER_RANGE) % (RANGE)) + LOWER_RANGE;
			char newChar = (char) newValue;
			newText += newChar;
		}
		return newText;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		// throw new RuntimeException("method not implemented");
		char letter;
		String newText = "";
		
		for(int i = 0; i < encryptedText.length(); i++) {
			letter = encryptedText.charAt(i);
			
			int letterInt = (int) letter;
			int newValue = ((letterInt - key - LOWER_RANGE) % (RANGE));
			
			
			if (newValue < 0) {
	            newValue += (RANGE);
	        }
			
			
			newValue += LOWER_RANGE;
			char newChar = (char) newValue;
			newText += newChar;
		}
		return newText;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		// throw new RuntimeException("method not implemented");
		char letter;
		char bLetter;
		String newText = "";
		
		for(int i = 0; i < encryptedText.length(); i++) {
			letter = encryptedText.charAt(i);
			bLetter = bellasoStr.charAt(i % bellasoStr.length());
			
			int letterInt = (int) letter;
			int bInt = (int) bLetter;
			
			int newValue = ((letterInt - bInt - LOWER_RANGE) % (RANGE));
			
			
			if (newValue < 0) {
	            newValue += (RANGE);
	        }
			
			
			newValue += LOWER_RANGE;
			char newChar = (char) newValue;
			newText += newChar;
		}
		return newText;
	}
}
