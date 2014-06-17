/**
 * 
 */
package com.crimezero.superhero.utils;

/**
 * This is utility class which will provide array of all possible alphabets
 * which maps to particular number. For example, 2 maps to {A,B,C} , 3 maps to
 * {D, E, F} etc
 * 
 * @author sushant
 */
public class SuperHeroAppUtils {

	static char[] result = null;

	static {
		result = new char[4];
	}

	/**
	 * Return array of possible character which matches number code. This uses
	 * formula as 3*code + 59 to find character. For example for code 4, above
	 * equation becomes 4*3+59 = 71 which is ascii/decimal code for 'G". If you
	 * add 1 and 2 to it, then you will get 'H' and 'I'. For 7,8,9 there are
	 * special cases, as 7 and 9 corresponds to four letters. For empty code is
	 * '`'
	 * 
	 * @param ch
	 *            Passed mobile code
	 * @return possible characters for passed code number
	 */
	public static char[] getPossibleAlphabates(char ch) {
		int code = Character.getNumericValue(ch);
		char firstChar;
		switch (code) {
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			firstChar = (char) ((code * 3) + 59);
			result[0] = firstChar;
			result[1] = (char) (firstChar + 1);
			result[2] = (char) (firstChar + 2);
			result[3] = '`';
			break;
		case 7:
			firstChar = (char) ((code * 3) + 59);
			result[0] = firstChar;
			result[1] = (char) (firstChar + 1);
			result[2] = (char) (firstChar + 2);
			result[3] = (char) (firstChar + 3);
			break;
		case 8:
			firstChar = (char) ((code * 3) + 59 + 1);
			result[0] = firstChar;
			result[1] = (char) (firstChar + 1);
			result[2] = (char) (firstChar + 2);
			result[3] = '`';
			break;
		case 9:
			firstChar = (char) ((code * 3) + 59 + 1);
			result[0] = firstChar;
			result[1] = (char) (firstChar + 1);
			result[2] = (char) (firstChar + 2);
			result[3] = (char) (firstChar + 3);
		default:
			// TODO invalid code
			return null;
		}
		return result;
	}
}
