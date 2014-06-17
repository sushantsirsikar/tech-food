/**
 * 
 */
package com.crimezero.superhero.service;

import java.util.Set;

import com.crimezero.superhero.utils.SuperHeroAppUtils;

/**
 * This service matches the code with possible hero names
 * 
 * @author sushant
 */
public class SuperHeroMatcherService {

	private static SuperHeroMatcherService INSTANCE = null;

	private SuperHeroMatcherService() {
	};

	public static SuperHeroMatcherService getCodeMatcherService() {
		if (INSTANCE == null) {
			INSTANCE = new SuperHeroMatcherService();
		}
		return INSTANCE;
	}

	/**
	 * Find matching super hero from set of heroes for given code
	 * 
	 * @param code
	 *            super hero code
	 * @param heroNames
	 *            {@link Set} of possible matching names
	 * @return name of super hero or null if no match found
	 */
	public String matchCode(String code, Set<String> heroNames) {
		char[] codeArray = code.toUpperCase().toCharArray();
		for (String heroName : heroNames) {
			if (findMatchingName(codeArray, 0, heroName)) {
				return heroName;
			}
		}
		return null;
	}

	/**
	 * This method will be called recursively to match code with passed hero
	 * name
	 * 
	 * @param codeArray
	 *            char array of super hero code
	 * @param i
	 *            index which points to current letter under comparison
	 * @param heroName
	 *            hero name that needs to be compare with passed code
	 * @return <code>true</code> if code of index 'i' matches with alphabet at
	 *         index 'i' otherwise <code>false</code>
	 */
	public boolean findMatchingName(char[] codeArray, int i, String heroName) {
		char[] possibleChars = SuperHeroAppUtils
				.getPossibleAlphabates(codeArray[i]);

		if (possibleChars == null) {
			return false;
		}

		for (int j = 0; j < possibleChars.length; j++) {
			if (possibleChars[j] == heroName.charAt(i)) {
				i++;
				if (i == codeArray.length) {
					return true;
				} else if (findMatchingName(codeArray, i, heroName)) {
					return true;
				}
			}
		}
		return false;
	}

}
