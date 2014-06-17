/**
 * 
 */
package com.crimezero.superhero.service;

import com.crimezero.superhero.utils.LoggerUtils;
import com.crimezero.superhero.utils.Messages;

/**
 * This class will parse the user input and validate it.
 * @author sushant
 */
public class InputParser {

	/**
	 * Returns code for super hero.
	 * @param inputStr passed user input. Input should be of the form 0 {super hero code}
	 * @return
	 */
	public static String getSuperHeroCode(String inputStr) {
		if (inputStr == null || inputStr.isEmpty()) {
			LoggerUtils.logError(Messages.getString("InputParser.InvalidInpurErrorMsg")); //$NON-NLS-1$
			return null;
		}

		String[] split = inputStr.split(" "); //$NON-NLS-1$

		if (split.length != 2) {
			LoggerUtils.logError(Messages.getString("InputParser.InvalidInpurErrorMsg")); //$NON-NLS-1$
			return null;
		}

		if (!split[0].equals("0")) { //$NON-NLS-1$
			LoggerUtils.logError(Messages.getString("InputParser.InvalidInputSMSShouldStartWithZeroErrorMsg")); //$NON-NLS-1$
			return null;
		}

		String numberCode = split[1];
		if (numberCode.isEmpty()) {
			LoggerUtils.logError(Messages.getString("InputParser.NoCodeSuppliedErrorMsg")); //$NON-NLS-1$
			return null;
		}

		return numberCode;
	}
}
