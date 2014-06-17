/**
 * 
 */
package com.crimezero.superhero.utils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Utility use for logging using log4j
 * 
 * @author sushant
 */
public class LoggerUtils {
	private static Logger logger = null;

	public static Logger getLogger() {
		if (logger == null) {
			logger = Logger.getLogger("CrimeZeroAppLogger"); //$NON-NLS-1$
		}
		return logger;
	}

	public static void logError(String message) {
		getLogger().log(Level.ERROR, message);
	}

	public static void logInfo(String message) {
		getLogger().info(message);
	}
}
